/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static ch.maystre.gilbert.custopoly.graphics.Toolbox.formatAmount;

/**
 * A class that represents locations (e.g. Zurich Paradeplatz) on the game board
 */
public class BoardLocation extends Location {

    // region drawing constants

    private static final int WIDTH = 300;

    private static final int HEIGHT = 450;

    private static final int HALF_THICKNESS = 3;

    private static final int COLOR_HEIGHT = 90;

    private static final int TITLE_HEIGHT = 150;

    private static final int PRICE_HEIGHT = 100;

    // endregion

    public BoardLocation(String name, int rank){
        super(name, rank, WIDTH, HEIGHT);
    }

    @Override
    public BufferedImage buildImage() {
        g.setColor(getLocationColor());
        g.fillRect(0, 0, WIDTH, COLOR_HEIGHT);

        /* step 1: draw grid */
        g.setColor(Color.BLACK);
        Rectangle2D.Double top = new Rectangle2D.Double(0, 0, WIDTH, 2 * HALF_THICKNESS);
        g.fill(top);
        Rectangle2D.Double bottom = new Rectangle2D.Double(0, HEIGHT - 2 * HALF_THICKNESS, WIDTH, 2 * HALF_THICKNESS);
        g.fill(bottom);
        Rectangle2D.Double left = new Rectangle2D.Double(0, 0, HALF_THICKNESS, HEIGHT);
        g.fill(left);
        Rectangle2D.Double right = new Rectangle2D.Double(WIDTH - HALF_THICKNESS, 0, HALF_THICKNESS, HEIGHT);
        g.fill(right);
        Rectangle2D.Double center = new Rectangle2D.Double(0, COLOR_HEIGHT, WIDTH, 2 * HALF_THICKNESS);
        g.fill(center);

        /* step 2: draw infos */
        adjustFont(true, 30);
        Rectangle2D.Double titleBox = new Rectangle2D.Double(0, COLOR_HEIGHT + 2 * HALF_THICKNESS, WIDTH, TITLE_HEIGHT);
        drawLinesSmart(name, titleBox);

        /* step 3: draw price */
        Rectangle2D.Double priceBox = new Rectangle2D.Double(0, HEIGHT - PRICE_HEIGHT, WIDTH, PRICE_HEIGHT);
        drawCentered(formatAmount(getLocationBuyPrice()), priceBox);

        return image;
    }

}
