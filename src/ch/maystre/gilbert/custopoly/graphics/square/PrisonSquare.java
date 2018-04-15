/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.square;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class PrisonSquare extends Square{

    private static final Color POLY_ORANGE = new Color(255, 130, 0);

    private static final int ORANGE_SQUARE_SIZE = 350;

    private static final int PRISON_SIZE = 180;

    private static final int IN_PRISON_WIDTH = 50;
    private static final int IN_PRISON_HEIGHT = 80;

    @Override
    public BufferedImage buildImage() {

        /* 1: background */
        g.setColor(POLY_ORANGE);
        g.fillRect(0, 0, ORANGE_SQUARE_SIZE, ORANGE_SQUARE_SIZE);
        addBorders();
        g.fillRect(ORANGE_SQUARE_SIZE, 0, 2 * HALF_THICKNESS, ORANGE_SQUARE_SIZE + 2 * HALF_THICKNESS);
        g.fillRect(0, ORANGE_SQUARE_SIZE, ORANGE_SQUARE_SIZE + 2 * HALF_THICKNESS, 2 * HALF_THICKNESS);

        /* 2: simple visit text */
        Rectangle2D.Double titleBox = new Rectangle2D.Double(0, ORANGE_SQUARE_SIZE, WIDTH, HEIGHT - ORANGE_SQUARE_SIZE);
        adjustFont(true, FONT_SIZE);
        drawCentered("SIMPLE VISITE", titleBox);

        /* 3: prison picture */
        g.rotate(-Math.PI/4, ORANGE_SQUARE_SIZE / 2, ORANGE_SQUARE_SIZE / 2);

        int topX = (ORANGE_SQUARE_SIZE - PRISON_SIZE) / 2;
        int topY = (ORANGE_SQUARE_SIZE - PRISON_SIZE - IN_PRISON_HEIGHT)/2;

        /*
        Polygon floor = new Polygon();
        floor.addPoint(0, PRISON_SIZE);
        floor.addPoint(PRISON_SIZE, PRISON_SIZE);
        floor.addPoint(PRISON_SIZE, (int) (0.2 * PRISON_SIZE));
        floor.translate(topX, topY);
        g.setColor(Color.LIGHT_GRAY);
        g.fill(floor);

        Polygon wall = new Polygon();
        wall.addPoint(0, 0);
        wall.addPoint(PRISON_SIZE, 0);
        wall.addPoint(PRISON_SIZE, (int) (0.2 * PRISON_SIZE));
        wall.addPoint(0, PRISON_SIZE);
        wall.translate(topX, topY);
        g.setColor(Color.DARK_GRAY);
        g.fill(wall);
        */

        Rectangle2D.Double prison = new Rectangle2D.Double(topX, topY, PRISON_SIZE, PRISON_SIZE);
        g.setColor(Color.WHITE);
        g.fill(prison);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4));
        g.draw(prison);
        g.setStroke(new BasicStroke(3));

        int spacing = PRISON_SIZE / 4;
        for(int i = 1; i < 4; i++){
            g.drawLine(topX + spacing * i, topY, topX + spacing * i, topY + PRISON_SIZE);
        }

        /* 4: prison text */
        topX = (ORANGE_SQUARE_SIZE - IN_PRISON_WIDTH) / 2;
        topY += PRISON_SIZE;

        Rectangle2D.Double textBox = new Rectangle2D.Double(topX, topY, IN_PRISON_WIDTH, IN_PRISON_HEIGHT);
        adjustFont(true, 28);
        drawLinesSmart("EN\\nPRISON", textBox);

        return image;
    }

}
