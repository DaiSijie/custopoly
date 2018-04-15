/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.square;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static ch.maystre.gilbert.custopoly.graphics.Toolbox.formatAmount;

public class StartSquare extends Square {

    // region drawing constants

    private static final int START_HEIGHT = 70;
    private static final int START_WIDTH = 150;

    private static final int TEXT_HEIGHT = 100;
    private static final int TEXT_WIDTH = 300;

    private static final int MARGIN_BOTTOM_ARROW = 50;

    //endregion

    @Override
    public BufferedImage buildImage() {

        /* 1: background */
        addBorders();

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

        /* 3: arrow */
        Polygon arrow = new Polygon();
        arrow.addPoint(60, 80);
        arrow.addPoint(0, 40);
        arrow.addPoint(60, 0);
        arrow.addPoint(60, 30);
        arrow.addPoint(240, 30);
        arrow.addPoint(260, 0);
        arrow.addPoint(320, 0);
        arrow.addPoint(300, 40);
        arrow.addPoint(320, 80);
        arrow.addPoint(260, 80);
        arrow.addPoint(240, 50);
        arrow.addPoint(60,50);

        Rectangle2D bounds = arrow.getBounds2D();
        double topY = HEIGHT - bounds.getHeight() - MARGIN_BOTTOM_ARROW;
        double topX = (WIDTH - bounds.getWidth()) / 2;
        arrow.translate((int) topX, (int) topY);

        g.setTransform(original);
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.fill(arrow);
        g.setColor(Color.BLACK);
        g.draw(arrow);

        return image;
    }

}
