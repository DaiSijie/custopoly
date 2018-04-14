/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.boardmisc;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static ch.maystre.gilbert.custopoly.graphics.Toolbox.formatAmount;

public class StartSquare extends Square {

    // region drawing constants

    private static final int START_HEIGHT = 70;
    private static final int START_WIDTH = 150;

    private static final int TEXT_HEIGHT = 100;
    private static final int TEXT_WIDTH = 300;

    //endregion

    @Override
    public BufferedImage buildImage() {

        /* 1: background */
        g.setColor(Color.BLACK);
        g.fill(new Rectangle2D.Double(0, 0, HALF_THICKNESS, HEIGHT));
        g.fill(new Rectangle2D.Double(0, 0, WIDTH, HALF_THICKNESS));

        /* 2: rotated text */
        double textBoxHeight = START_HEIGHT + TEXT_HEIGHT;
        double centerDist = (START_WIDTH + textBoxHeight) / (2 * Math.sqrt(2));

        Rectangle2D.Double startBox = new Rectangle2D.Double(centerDist - START_WIDTH / 2, centerDist - textBoxHeight / 2, START_WIDTH, START_HEIGHT);
        Rectangle2D.Double textBox = new Rectangle2D.Double(centerDist - TEXT_WIDTH / 2, startBox.y + startBox.height, TEXT_WIDTH, TEXT_HEIGHT);

        AffineTransform original = g.getTransform();

        g.rotate(-Math.PI / 4, centerDist, centerDist);
        g.setColor(Color.BLACK);
        adjustFont(true, FONT_SIZE);
        drawCentered("START", startBox);
        adjustFont(false, 26);
        drawLinesSmart("Prélève\\n" + formatAmount(4000) + "\\nde salaire en passant", textBox);

        g.setTransform(original);

        /* 3: arrow */

        return image;
    }

}
