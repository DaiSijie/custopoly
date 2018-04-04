/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class GraphicalObject {

    protected final BufferedImage image;
    protected final Graphics2D g;

    public GraphicalObject(int width, int height){
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
    }

    public abstract BufferedImage buildImage();

    protected void drawCentered(Graphics2D g, String text, Rectangle2D box) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        double x = box.getX() + (box.getWidth() - metrics.stringWidth(text)) / 2;
        double y = box.getY() + ((box.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g.drawString(text, (int) x, (int) y);
    }

}
