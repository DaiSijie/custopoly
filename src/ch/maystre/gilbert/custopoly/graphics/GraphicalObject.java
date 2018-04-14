/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class GraphicalObject {

    private static Font boldFont;
    private static Font regularFont;

    protected final BufferedImage image;
    protected final Graphics2D g;

    public GraphicalObject(int width, int height){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = getGraphics();
        adjustFont(true, 13f);
    }

    private Graphics2D getGraphics(){
        Graphics2D toReturn = image.createGraphics();

        // set rendering hints
        toReturn.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        toReturn.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        return toReturn;
    }

    /**
     * Adjusts the font in monopoly style
     */
    protected void adjustFont(boolean bold, float size){
        if(boldFont == null || regularFont == null){
            try {
                InputStream stream = new FileInputStream("/Users/gilbert/Programming/java-intelij/custopoly/res/fonts/kabel.ttf");
                boldFont = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(13f);
                stream.close();
                stream = new FileInputStream("/Users/gilbert/Programming/java-intelij/custopoly/res/fonts/Monopoly Regular.ttf");
                regularFont = new Font("Arial", Font.PLAIN, 13);;
                stream.close();
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }

        Font toPut = (bold ? boldFont : regularFont).deriveFont(size);
        g.setFont(toPut);
    }


    public abstract BufferedImage buildImage();

    protected void drawCentered(String text, Rectangle2D box) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        double x = box.getX() + (box.getWidth() - metrics.stringWidth(text)) / 2;
        double y = box.getY() + ((box.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(text, (int) x, (int) y);
    }

    protected void drawLeft(String text, Rectangle2D box){
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        double x = box.getX();
        double y = box.getY() + ((box.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(text, (int) x, (int) y);
    }

    protected void drawRight(String text, Rectangle2D box){
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        double x = box.getX() + box.getWidth() - metrics.stringWidth(text);
        double y = box.getY() + ((box.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(text, (int) x, (int) y);
    }

    protected void drawLinesCentered(String[] lines, Rectangle2D box){
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        // compute total height
        double totalHeight = (metrics.getHeight()) * lines.length;
        double y = box.getY() + (box.getHeight() - totalHeight) / 2.;

        for(String line : lines){
            double x = box.getX() + (box.getWidth() - metrics.stringWidth(line)) / 2;
            g.drawString(line, (int) x, (int) (y + metrics.getAscent()));
            y += metrics.getHeight();
        }

    }

    /**
     * Draw a text smartly. If the text contains "\n" then lines will be split accordingly.
     * Else, lines will be split greedily to match the width.
     *
     * @param text The text
     * @param box The bound within which to print
     */
    protected void drawLinesSmart(String text, Rectangle2D box){
        String[] linesToDraw;

        if(text.contains("\\n"))
            linesToDraw = text.split("\\n");
        else{
            FontMetrics metrics = g.getFontMetrics(g.getFont());

            // greedily conquer
            String[] words = text.split(" ");
            ArrayList<String> lines = new ArrayList<>();

            String currentLine = "";
            for(String word : words){
                int potentialWidth = metrics.stringWidth(currentLine + " " + word);
                if(potentialWidth < box.getWidth()){
                    currentLine += " " + word;
                }
                else{ // close the bag!
                    lines.add(currentLine);
                    currentLine = word;
                }
            }

            lines.add(currentLine);
            linesToDraw = lines.toArray(new String[lines.size()]);
        }

        drawLinesCentered(linesToDraw, box);
    }

}
