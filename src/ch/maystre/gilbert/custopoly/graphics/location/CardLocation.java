/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * A class that represents locations (e.g. Zurich Paradeplatz) on cards
 */
public class CardLocation extends Location {

    // drawing constants

    private static final int WIDTH = 300;

    private static final int HEIGHT = 450;

    private static final int OUTER_MARGIN = 10;

    private static final int INNER_MARGIN = 10;

    // title

    private static final int OVER_TITLE_HEIGHT = 30;

    private static final int TITLE_MARGIN = 3;

    private static final int TITLE_HEIGHT = 30;

    // rent prices

    private static final int USUAL_RENT_HEIGHT = 30;

    private static final int PROPERTY_RENT_HEIGHT = 23;

    // copyright box

    private static final int COPYRIGHT_WIDTH = 100;

    private static final int COPYRIGHT_HEIGHT = 15;

    private static final int COPYRIGHT_BOTTOM_DIST = 3;

    public CardLocation(String name, int rank){
        super(name, rank, WIDTH, HEIGHT);
    }

    @Override
    public BufferedImage buildImage() {
        /* 1: background */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        /* 2: borders */
        g.setColor(Color.BLACK);
        Rectangle2D.Double borderBox = new Rectangle2D.Double(OUTER_MARGIN, OUTER_MARGIN, WIDTH - 2 * OUTER_MARGIN, HEIGHT - 2 * OUTER_MARGIN);
        g.draw(borderBox);

        /* 3: title */
        int totMargin = OUTER_MARGIN + INNER_MARGIN;
        Rectangle2D.Double titleBox = new Rectangle2D.Double(totMargin, totMargin, WIDTH - 2 * totMargin, OVER_TITLE_HEIGHT + 2 * TITLE_HEIGHT + TITLE_MARGIN);
        g.setColor(Color.GREEN);
        g.fill(titleBox);
        g.setColor(Color.BLACK);
        g.draw(titleBox);

        Rectangle2D.Double t1Box = new Rectangle2D.Double(titleBox.x, titleBox.y, titleBox.width, OVER_TITLE_HEIGHT);
        adjustFont(false, 18);
        drawCentered("Titre de propriété", t1Box);


        Rectangle2D.Double t2Box = new Rectangle2D.Double(titleBox.x, titleBox.y + OVER_TITLE_HEIGHT + TITLE_MARGIN, titleBox.width, TITLE_HEIGHT);
        adjustFont(true, 24);
        drawCentered("AVENUE", t2Box);

        Rectangle2D.Double t3Box = new Rectangle2D.Double(titleBox.x, titleBox.y + OVER_TITLE_HEIGHT + TITLE_MARGIN + TITLE_HEIGHT, titleBox.width, TITLE_HEIGHT);
        drawCentered("DU CHATEAU", t3Box);

        /* 4 : property rent */
        double startY = titleBox.y + titleBox.height + 10;
        double startX = titleBox.x;

        Rectangle2D.Double normalRentBox = new Rectangle2D.Double(startX, startY, titleBox.width, USUAL_RENT_HEIGHT);
        adjustFont(true, 14f);
        drawCentered("LOYER 8$", normalRentBox);

        adjustFont(false, 14f);
        for(int i = 1; i < 6; i++){
            Rectangle2D.Double box = new Rectangle2D.Double(startX, startY + USUAL_RENT_HEIGHT + (i-1) * PROPERTY_RENT_HEIGHT, titleBox.width, PROPERTY_RENT_HEIGHT);
            if(i == 5)
                drawLeft("Avec hôtel", box);
            else
                drawLeft("Avec " + i + " maison" + (i == 1? "" : "s"), box);
            drawRight((20 * i) + "$", box);
        }

        /* 5: copyright text */
        double copyrightStartX = (WIDTH - COPYRIGHT_WIDTH) / 2.;
        double copyrightStartY = HEIGHT - COPYRIGHT_HEIGHT - COPYRIGHT_BOTTOM_DIST;
        Rectangle2D.Double copyrightBox = new Rectangle2D.Double(copyrightStartX, copyrightStartY, COPYRIGHT_WIDTH, COPYRIGHT_HEIGHT);
        g.setColor(Color.WHITE);
        g.fill(copyrightBox);
        g.setColor(Color.BLACK);
        adjustFont(true, 8f);
        drawCentered("Copyright G.M 2018", copyrightBox);

        return image;
    }


}
