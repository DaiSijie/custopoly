/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.launcher;

import ch.maystre.gilbert.custopoly.graphics.location.BoardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.CardLocation;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        String folder = "/Users/gilbert/Programming/java-intelij/custopoly/out/experiments/";
        BoardLocation l = new BoardLocation("Los Etanos", 21);
        try {
            ImageIO.write(l.buildImage(), "png", new File(folder + "board_location.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
