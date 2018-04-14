/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics;

public class Toolbox {

    private Toolbox(){}

    public static String formatAmount(int amount){
        if(amount < 1000)
            return "CHF " + amount;

        int afterThousand = amount / 1000;
        String beforeThousand = "" + (amount - afterThousand * 1000);

        while(beforeThousand.length() < 3)
            beforeThousand = "0" + beforeThousand;

        return "CHF " + afterThousand + "'" + beforeThousand;
    }

}
