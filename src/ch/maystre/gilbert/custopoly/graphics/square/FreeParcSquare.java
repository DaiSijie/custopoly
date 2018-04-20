/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.square;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class FreeParcSquare extends Square {

    private static final int DELTA_X = 100;
    private static final int DELTA_Y = 100;

    // region car constants

    private static final int CAR_WIDTH = 200;
    private static final int TOP_TIRE_WIDTH = 40;
    private static final int CURVATURE_WIDTH = 20;

    private static final int ROOF_HEIGHT = 40;
    private static final int BODY_HEIGHT = 50;

    // endregion

    // region lamp constants

    private static final int LAMP_WIDTH = 20;
    private static final int LAMP_HEIGHT = 20;
    private static final int LAMP_MARGIN = 25;

    // endregion

    // region tire constants

    private static final int TIRE_WIDTH = 30;
    private static final int TIRE_HEIGHT = 20;
    private static final int TIRE_MARGIN = 20;

    // endregion

    // region air number constants

    private static final double AIR_BUMPER_X_PERCENTAGE = 0.66;
    private static final int AIR_BUMPER_RADIUS = 6;

    // endregion

    // region window

    private static final int WINDOW_MARGIN = 7;
    private static final Color WINDOW_COLOR = new Color(102, 179, 255);

    // endregion

    @Override
    public BufferedImage buildImage() {
        addBorders();

        /* step 1: create car polygon */
        Polygon car = new Polygon();
        car.addPoint(0, ROOF_HEIGHT + BODY_HEIGHT);
        car.addPoint(0, ROOF_HEIGHT);
        car.addPoint(TOP_TIRE_WIDTH, ROOF_HEIGHT);
        car.addPoint(TOP_TIRE_WIDTH + CURVATURE_WIDTH, 0);
        car.addPoint(CAR_WIDTH - CURVATURE_WIDTH - TOP_TIRE_WIDTH, 0);
        car.addPoint(CAR_WIDTH - TOP_TIRE_WIDTH, ROOF_HEIGHT);
        car.addPoint(CAR_WIDTH, ROOF_HEIGHT);
        car.addPoint(CAR_WIDTH, ROOF_HEIGHT + BODY_HEIGHT);
        car.translate(DELTA_X, DELTA_Y);

        /* step 2: create the lamps */
        int lampY = ROOF_HEIGHT + (BODY_HEIGHT - LAMP_HEIGHT)/2 + DELTA_X;
        Rectangle2D.Double leftLamp = new Rectangle2D.Double(LAMP_MARGIN + DELTA_X, lampY, LAMP_WIDTH, LAMP_HEIGHT);

        int lamp2X = DELTA_X + CAR_WIDTH - LAMP_MARGIN - LAMP_WIDTH;
        Rectangle2D.Double rightLamp = new Rectangle2D.Double(lamp2X, lampY, LAMP_WIDTH, LAMP_HEIGHT);

        /* step 3: create the tires */
        int tireY = DELTA_Y + ROOF_HEIGHT + BODY_HEIGHT;
        Rectangle2D.Double leftTire = new Rectangle2D.Double(TIRE_MARGIN + DELTA_X, tireY, TIRE_WIDTH, TIRE_HEIGHT);

        int tire2X = DELTA_X + CAR_WIDTH - TIRE_MARGIN - TIRE_WIDTH;
        Rectangle2D.Double rightTire = new Rectangle2D.Double(tire2X, tireY, TIRE_WIDTH, TIRE_HEIGHT);

        /* step 4: create the air bump */
        double cx = DELTA_X + CAR_WIDTH * AIR_BUMPER_X_PERCENTAGE;
        double cy = DELTA_Y + ROOF_HEIGHT + BODY_HEIGHT + AIR_BUMPER_RADIUS;

        Ellipse2D.Double airBump = new Ellipse2D.Double(cx - AIR_BUMPER_RADIUS, cy - AIR_BUMPER_RADIUS, AIR_BUMPER_RADIUS * 2, AIR_BUMPER_RADIUS * 2);

        /* step 5: create the window */
        Polygon window = new Polygon();
        window.addPoint(TOP_TIRE_WIDTH + CURVATURE_WIDTH + WINDOW_MARGIN, WINDOW_MARGIN);
        window.addPoint(CAR_WIDTH - TOP_TIRE_WIDTH - CURVATURE_WIDTH - WINDOW_MARGIN, WINDOW_MARGIN);
        window.addPoint(CAR_WIDTH - TOP_TIRE_WIDTH - WINDOW_MARGIN, ROOF_HEIGHT - WINDOW_MARGIN);
        window.addPoint(TOP_TIRE_WIDTH + WINDOW_MARGIN, ROOF_HEIGHT - WINDOW_MARGIN);
        window.translate(DELTA_X, DELTA_Y);

        /* step 6: draw */
        g.setStroke(new BasicStroke(2));

        g.setColor(Color.GRAY);
        g.fill(leftTire);
        g.fill(rightTire);
        g.setColor(Color.BLACK);
        g.draw(leftTire);
        g.draw(rightTire);

        g.fill(airBump);

        g.setColor(Color.RED);
        g.fill(car);
        g.setColor(Color.BLACK);
        g.draw(car);

        g.setColor(Color.YELLOW);
        g.fill(leftLamp);
        g.fill(rightLamp);
        g.setColor(Color.BLACK);
        g.draw(leftLamp);
        g.draw(rightLamp);

        g.setColor(WINDOW_COLOR);
        g.fill(window);
        g.setColor(Color.BLACK);
        g.draw(window);

        return image;
    }

}
