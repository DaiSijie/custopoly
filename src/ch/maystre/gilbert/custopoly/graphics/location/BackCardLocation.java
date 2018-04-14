/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static ch.maystre.gilbert.custopoly.graphics.Toolbox.formatAmount;

public class BackCardLocation extends CardLocation {

    private static final Color POLY_RED = new Color(255, 51, 51);

    private static final int OUTTER_MARGIN = 15;

    private static final int TITLE_HEIGHT = 150;

    private static final int LOCATION_HEIGHT = 80;

    private static final int HYPOTHEQUE_HEIGHT = 40;

    private static final int HYPOTHEQUE_INSTRUCTION_HEIGHT = 80;

    private static final int INNER_MARGIN = 5;

    private static final int COPYRIGHT_HEIGHT = 20;

    private static final int COPYRIGHT_WIDTH = 110;

    public BackCardLocation(String name, int rank){
        super(name, rank);
    }

    @Override
    public BufferedImage buildImage() {
        /* 1: background */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(POLY_RED);
        g.fillRect(OUTTER_MARGIN, OUTTER_MARGIN, WIDTH - 2 * OUTTER_MARGIN, HEIGHT - 2 * OUTTER_MARGIN);
        int topY = OUTTER_MARGIN;

        /* 2: title */
        g.setColor(Color.WHITE);
        adjustFont(true, 26);
        Rectangle2D.Double titleBox = new Rectangle2D.Double(OUTTER_MARGIN, topY, WIDTH - 2 * OUTTER_MARGIN, TITLE_HEIGHT);
        drawCentered("HYPOTHEQUE", titleBox);
        topY += TITLE_HEIGHT;

        /* 3: location name */
        g.setStroke(new BasicStroke(2));
        g.drawLine(OUTTER_MARGIN, topY, WIDTH - OUTTER_MARGIN, topY);
        Rectangle2D.Double locationBox = new Rectangle2D.Double(OUTTER_MARGIN, topY, WIDTH - 2 * OUTTER_MARGIN, LOCATION_HEIGHT);
        adjustFont(true, 18);
        drawLinesSmart(name, locationBox);
        topY += LOCATION_HEIGHT;
        g.drawLine(OUTTER_MARGIN, topY, WIDTH - OUTTER_MARGIN, topY);

        /* 4: mortgage value */
        Rectangle2D.Double mortgageBox = new Rectangle2D.Double(OUTTER_MARGIN + INNER_MARGIN, topY, WIDTH - 2 * (OUTTER_MARGIN +  INNER_MARGIN), HYPOTHEQUE_HEIGHT);
        adjustFont(true, 13);
        drawLeft("VALEUR HYPOTHEQUE", mortgageBox);
        drawRight(formatAmount(getMortgagePrice()), mortgageBox);
        topY += HYPOTHEQUE_HEIGHT;

        /* 5: instructions */
        adjustFont(false, 14);
        Rectangle2D.Double instructionBox = new Rectangle2D.Double(OUTTER_MARGIN + INNER_MARGIN, topY, WIDTH - 2 * (OUTTER_MARGIN + INNER_MARGIN), HYPOTHEQUE_INSTRUCTION_HEIGHT);
        drawLinesCentered(new String[]{"En cas d'hypothèque, cette", "carte doit être retournée", "avec ce côté sur le dessus"}, instructionBox);

        /* 6: copyright */
        adjustFont(true, 8);
        Rectangle2D.Double copyrightBox = new Rectangle2D.Double(OUTTER_MARGIN, HEIGHT - OUTTER_MARGIN - COPYRIGHT_HEIGHT, COPYRIGHT_WIDTH, COPYRIGHT_HEIGHT);
        drawCentered("Copyright G.M. 2018", copyrightBox);

        return image;
    }
}
