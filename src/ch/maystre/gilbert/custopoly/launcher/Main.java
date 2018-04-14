/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.launcher;

import ch.maystre.gilbert.custopoly.graphics.location.BackCardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.BoardLocation;
import ch.maystre.gilbert.custopoly.graphics.luckycard.LuckyCard;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        String folder = "/Users/gilbert/Programming/java-intelij/custopoly/out/experiments/";
        LuckyCard l = new LuckyCard(LuckyCard.LuckyCardType.CHANCE, "Tu es libre de sortir de prison sans payer d'amende. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.");
        try {
            ImageIO.write(l.buildImage(), "png", new File(folder + "lucky.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
