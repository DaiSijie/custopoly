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

    // region car constants

    private static final int CAR_WIDTH = 300;
    private static final int TOP_TIRE_WIDTH = 45;
    private static final int CURVATURE_WIDTH = 30;

    private static final int ROOF_HEIGHT = 60;
    private static final int BODY_HEIGHT = 67;

    // endregion

    // region lamp constants

    private static final int LAMP_WIDTH = 30;
    private static final int LAMP_HEIGHT = 30;
    private static final int LAMP_MARGIN = 37;

    // endregion

    // region tire constants

    private static final int TIRE_WIDTH = 45;
    private static final int TIRE_HEIGHT = 30;
    private static final int TIRE_MARGIN = 30;

    // endregion

    // region air number constants

    private static final double AIR_BUMPER_X_PERCENTAGE = 0.66;
    private static final int AIR_BUMPER_RADIUS = 9;

    // endregion

    // region window

    private static final int WINDOW_MARGIN = 12;
    private static final Color WINDOW_COLOR = new Color(102, 179, 255);

    // endregion

    private static final int TEXT_HEIGHT = 80;

    private static final int ROTATING_SQUARE_SIZE = 350;

    @Override
    public BufferedImage buildImage() {
        addBorders();

        int totalHeight = ROOF_HEIGHT + BODY_HEIGHT + TIRE_HEIGHT + TEXT_HEIGHT;
        int totalWidth = CAR_WIDTH;
        int deltaX = (ROTATING_SQUARE_SIZE - totalWidth) / 2;
        int deltaY = (ROTATING_SQUARE_SIZE - totalHeight) / 2;

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
        car.translate(deltaX, deltaY);

        /* step 2: create the lamps */
        int lampY = ROOF_HEIGHT + (BODY_HEIGHT - LAMP_HEIGHT)/2 + deltaY;
        Rectangle2D.Double leftLamp = new Rectangle2D.Double(LAMP_MARGIN + deltaX, lampY, LAMP_WIDTH, LAMP_HEIGHT);

        int lamp2X = deltaX + CAR_WIDTH - LAMP_MARGIN - LAMP_WIDTH;
        Rectangle2D.Double rightLamp = new Rectangle2D.Double(lamp2X, lampY, LAMP_WIDTH, LAMP_HEIGHT);

        /* step 3: create the tires */
        int tireY = deltaY + ROOF_HEIGHT + BODY_HEIGHT;
        Rectangle2D.Double leftTire = new Rectangle2D.Double(TIRE_MARGIN + deltaX, tireY, TIRE_WIDTH, TIRE_HEIGHT);

        int tire2X = deltaX + CAR_WIDTH - TIRE_MARGIN - TIRE_WIDTH;
        Rectangle2D.Double rightTire = new Rectangle2D.Double(tire2X, tireY, TIRE_WIDTH, TIRE_HEIGHT);

        /* step 4: create the air bump */
        double cx = deltaX + CAR_WIDTH * AIR_BUMPER_X_PERCENTAGE;
        double cy = deltaY + ROOF_HEIGHT + BODY_HEIGHT + AIR_BUMPER_RADIUS;

        Ellipse2D.Double airBump = new Ellipse2D.Double(cx - AIR_BUMPER_RADIUS, cy - AIR_BUMPER_RADIUS, AIR_BUMPER_RADIUS * 2, AIR_BUMPER_RADIUS * 2);

        /* step 5: create the window */
        int trigonometricFactor = (int) (CURVATURE_WIDTH * WINDOW_MARGIN / (double) ROOF_HEIGHT);
        Polygon window = new Polygon();
        window.addPoint(TOP_TIRE_WIDTH + CURVATURE_WIDTH + WINDOW_MARGIN - trigonometricFactor, WINDOW_MARGIN);
        window.addPoint(CAR_WIDTH - TOP_TIRE_WIDTH - CURVATURE_WIDTH - WINDOW_MARGIN + trigonometricFactor, WINDOW_MARGIN);
        window.addPoint(CAR_WIDTH - TOP_TIRE_WIDTH - WINDOW_MARGIN, ROOF_HEIGHT);
        window.addPoint(TOP_TIRE_WIDTH + WINDOW_MARGIN, ROOF_HEIGHT);
        window.translate(deltaX, deltaY);

        g.rotate(-Math.PI/4, ROTATING_SQUARE_SIZE / 2, ROTATING_SQUARE_SIZE / 2);

        /* step 6: draw car*/
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

        /* step 7: draw text */
        adjustFont(true, FONT_SIZE);
        Rectangle2D.Double textBox = new Rectangle2D.Double(deltaX, deltaY + ROOF_HEIGHT + BODY_HEIGHT + TIRE_HEIGHT, CAR_WIDTH,  TEXT_HEIGHT);
        drawCentered("PARC GRATUIT", textBox);

        return image;
    }

}
