/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class that represents locations (e.g. Zurich Paradeplatz) on the game board
 */
public class BoardLocation extends Location {

    // region drawing constants

    private static int WIDTH = 50;

    private static int HEIGHT = 100;

    // endregion

    public BoardLocation(String name, int rank){
        super(name, rank, WIDTH, HEIGHT);
    }

    @Override
    public BufferedImage buildImage() {
        g.setColor(Color.RED);
        g.drawRect(0, 0, 10, 10);
        return image;
    }

}
