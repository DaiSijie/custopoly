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

    private static final int WIDTH = 100;

    private static final int HEIGHT = 150;

    private static final int OUTER_MARGIN = 5;

    private static final int INNER_MARGIN = 3;

    private static final int TITLE_HEIGHT = 30;

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
        g.drawLine(OUTER_MARGIN, OUTER_MARGIN, OUTER_MARGIN, HEIGHT - OUTER_MARGIN);
        g.drawLine(OUTER_MARGIN, OUTER_MARGIN, WIDTH - OUTER_MARGIN, OUTER_MARGIN);
        g.drawLine(WIDTH - OUTER_MARGIN, OUTER_MARGIN, WIDTH - OUTER_MARGIN, HEIGHT - OUTER_MARGIN);

        /* 3: title */
        int totMargin = OUTER_MARGIN + INNER_MARGIN;
        Rectangle2D.Double titleBox = new Rectangle2D.Double(totMargin, totMargin, WIDTH - 2 * totMargin, TITLE_HEIGHT);
        g.setColor(Color.GREEN);
        g.fill(titleBox);
        g.setColor(Color.BLACK);
        drawCentered(g, name, titleBox);

        return image;
    }


}
