/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.square;

import ch.maystre.gilbert.custopoly.graphics.GraphicalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * This class represents squares
 */
public abstract class Square extends GraphicalObject {

    protected static final int WIDTH = 450;

    protected static final int HEIGHT = 450;

    protected static final int HALF_THICKNESS = 3;

    protected static final int FONT_SIZE = 40;

    public Square() {
        super(WIDTH, HEIGHT);
    }

    protected void addBorders(){
        g.setColor(Color.BLACK);
        g.fill(new Rectangle2D.Double(0, 0, HALF_THICKNESS, HEIGHT));
        g.fill(new Rectangle2D.Double(0, 0, WIDTH, HALF_THICKNESS));
    }

}
