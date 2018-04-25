/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.launcher;

import ch.maystre.gilbert.custopoly.graphics.location.BackCardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.BoardLocation;
import ch.maystre.gilbert.custopoly.graphics.location.FrontCardLocation;
import ch.maystre.gilbert.custopoly.graphics.luckycard.LuckyCard;
import ch.maystre.gilbert.custopoly.graphics.square.FreeParcSquare;
import ch.maystre.gilbert.custopoly.graphics.square.PrisonSquare;
import ch.maystre.gilbert.custopoly.graphics.square.StartSquare;

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

        StartSquare start = new StartSquare();

        PrisonSquare prison = new PrisonSquare();

        FreeParcSquare parc = new FreeParcSquare();

        try {

            ImageIO.write(back.buildImage(), "png", new File(folder + "location_card_back.png"));
            ImageIO.write(front.buildImage(), "png", new File(folder + "location_card_front.png"));
            ImageIO.write(board.buildImage(), "png", new File(folder + "location_board.png"));
            ImageIO.write(lucky.buildImage(), "png", new File(folder + "lucky.png"));
            ImageIO.write(prison.buildImage(), "png", new File(folder + "prison.png"));
            ImageIO.write(parc.buildImage(), "png", new File(folder + "free_parc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
