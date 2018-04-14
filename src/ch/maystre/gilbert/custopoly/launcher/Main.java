/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.launcher;

import ch.maystre.gilbert.custopoly.graphics.location.BackCardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.BoardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.FrontCardLocation;
import ch.maystre.gilbert.custopoly.graphics.luckycard.LuckyCard;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
        String folder = "/Users/gilbert/Programming/java-intelij/custopoly/out/experiments/";

        String locationName = "RENENS\\nL'ETANG";
        int locationRank = 21;

        String chanceText = "Tu es libre de sortir de prison sans payer d'amende. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.";

        BackCardLocation back = new BackCardLocation(locationName, locationRank);
        FrontCardLocation front = new FrontCardLocation(locationName, locationRank);
        BoardLocation board = new BoardLocation(locationName, locationRank);

        LuckyCard lucky = new LuckyCard(LuckyCard.LuckyCardType.CHANCE, chanceText);

        try {
            ImageIO.write(back.buildImage(), "png", new File(folder + "location_card_back.png"));
            ImageIO.write(front.buildImage(), "png", new File(folder + "location_card_front.png"));
            ImageIO.write(board.buildImage(), "png", new File(folder + "location_board.png"));
            ImageIO.write(lucky.buildImage(), "png", new File(folder + "lucky.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
