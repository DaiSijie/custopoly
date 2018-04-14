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

        int beforeThousand = amount % 1000;
        int afterThousand = amount - beforeThousand;
        return "CHF " + afterThousand + "'" + beforeThousand;
    }
}
