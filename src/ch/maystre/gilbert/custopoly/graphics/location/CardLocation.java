/*
 * Gilbert Maystre
 * 14.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

public abstract class CardLocation extends Location{

    protected static final int WIDTH = 300;

    protected static final int HEIGHT = 450;

    public CardLocation(String name, int rank){
        super(name, rank, WIDTH, HEIGHT);
    }



}
