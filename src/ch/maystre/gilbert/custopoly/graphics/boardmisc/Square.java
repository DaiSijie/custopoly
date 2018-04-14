/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.boardmisc;

import ch.maystre.gilbert.custopoly.graphics.GraphicalObject;

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

}
