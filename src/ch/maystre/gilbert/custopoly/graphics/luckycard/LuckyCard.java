/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.luckycard;

import ch.maystre.gilbert.custopoly.graphics.GraphicalObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static ch.maystre.gilbert.custopoly.graphics.luckycard.LuckyCard.LuckyCardType.CHANCE;

public class LuckyCard extends GraphicalObject {

    private static final int WIDTH = 450;
    private static final int HEIGHT = 300;

    private static final int OUTTER_MARGIN = 10;
    private static final int INNER_MARGIN = 30;

    private static final int TITLE_HEIGHT = 80;

    private static final int COPYRIGHT_START_MARGIN = 20;
    private static final int COPYRIGHT_HEIGHT = 20;
    private static final int COPYRIGHT_WIDTH = 110;

    private LuckyCardType type;
    private String text;

    public LuckyCard(LuckyCardType type, String text){
        super(WIDTH, HEIGHT);
        this.type = type;
        this.text = text;
    }

    @Override
    public BufferedImage buildImage() {
        /* 1: background */
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        Rectangle2D.Double bounds = new Rectangle2D.Double(OUTTER_MARGIN, OUTTER_MARGIN, WIDTH - 2 * OUTTER_MARGIN, HEIGHT - 2 * OUTTER_MARGIN);
        g.setColor(Color.BLACK);
        g.draw(bounds);
        int topY = OUTTER_MARGIN;

        /* 2: title */
        adjustFont(true, 28);
        Rectangle2D.Double titleBox = new Rectangle2D.Double(OUTTER_MARGIN, topY, WIDTH - 2 * OUTTER_MARGIN, TITLE_HEIGHT);
        drawCentered(type == CHANCE ? "CHANCE" : "CHANCELLERIE", titleBox);
        topY += TITLE_HEIGHT;

        /* 3: text */
        int height = HEIGHT - OUTTER_MARGIN - INNER_MARGIN - topY;
        Rectangle2D.Double textBox = new Rectangle2D.Double(OUTTER_MARGIN + INNER_MARGIN, topY, WIDTH - 2 * (OUTTER_MARGIN + INNER_MARGIN), height);
        adjustFont(false, 16);
        drawLinesSmart(text, textBox);

        /* 4: copyright */
        Rectangle2D.Double copyrightBox = new Rectangle2D.Double(OUTTER_MARGIN + COPYRIGHT_START_MARGIN, HEIGHT - 2 * OUTTER_MARGIN, COPYRIGHT_WIDTH, 2 * OUTTER_MARGIN);
        g.setColor(Color.WHITE);
        g.fill(copyrightBox);
        g.setColor(Color.BLACK);
        adjustFont(true, 8);
        drawCentered("COPYRIGHT G.M. 2018", copyrightBox);

        return image;
    }

    public enum LuckyCardType{
        CHANCE, PAY
    }


}
