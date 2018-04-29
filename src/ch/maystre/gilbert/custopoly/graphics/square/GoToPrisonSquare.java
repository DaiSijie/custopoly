/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.square;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GoToPrisonSquare extends Square {

    // region drawing constants

    private static final int STOP_SIDE_LENGTH = 50;

    private static final int MARGIN = 7;

    // endregion

    @Override
    public BufferedImage buildImage() {
        addBorders();

        int deltaX = 100;
        int deltaY = 100;

        int trigFactor = (int) (STOP_SIDE_LENGTH / Math.sqrt(2));

        int trigFactor2 = (int) (MARGIN / Math.sqrt(2));

        Polygon outer = new Polygon();
        outer.addPoint(trigFactor, 0);
        outer.addPoint(trigFactor + STOP_SIDE_LENGTH, 0);
        outer.addPoint(2 * trigFactor + STOP_SIDE_LENGTH, trigFactor);
        outer.addPoint(2 * trigFactor + STOP_SIDE_LENGTH, trigFactor + STOP_SIDE_LENGTH);
        outer.addPoint(trigFactor + STOP_SIDE_LENGTH, 2 * trigFactor + STOP_SIDE_LENGTH);
        outer.addPoint(trigFactor, 2 * trigFactor + STOP_SIDE_LENGTH);
        outer.addPoint(0, trigFactor + STOP_SIDE_LENGTH);
        outer.addPoint(0, trigFactor);
        outer.translate(deltaX, deltaY);

        Polygon inner = new Polygon();
        inner.addPoint(trigFactor + trigFactor2, trigFactor2);
        inner.addPoint(trigFactor + STOP_SIDE_LENGTH - trigFactor2, trigFactor2);
        inner.addPoint(2 * trigFactor + STOP_SIDE_LENGTH - trigFactor2, trigFactor + trigFactor2);
        inner.addPoint(2 * trigFactor + STOP_SIDE_LENGTH - trigFactor2, trigFactor + STOP_SIDE_LENGTH - trigFactor2);
        inner.addPoint(trigFactor + STOP_SIDE_LENGTH - trigFactor2, 2 * trigFactor + STOP_SIDE_LENGTH - trigFactor2);
        inner.addPoint(trigFactor + trigFactor2, 2 * trigFactor + STOP_SIDE_LENGTH - trigFactor2);
        inner.addPoint(trigFactor2, trigFactor + STOP_SIDE_LENGTH - trigFactor2);
        inner.addPoint(trigFactor2, trigFactor + trigFactor2);
        inner.translate(deltaX, deltaY);

        g.setColor(Color.RED);
        g.fill(outer);
        g.setColor(Color.WHITE);
        g.fill(inner);




        return image;
    }

}
