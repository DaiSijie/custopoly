/*
 * Gilbert Maystre
 * 04.04.18
 */

package ch.maystre.gilbert.custopoly.graphics.location;

import ch.maystre.gilbert.custopoly.graphics.GraphicalObject;

import java.awt.*;

public abstract class Location extends GraphicalObject {

    // card specifics

    protected final String name;

    private final int rank;

    public Location(String name, int rank, int width, int height){
        super(width, height);
        this.name = name;
        this.rank = rank;
    }

    protected Color getColor(){
        return Color.BLACK;
    }

    // basic, full color, 1, 2, 3, 4, hotel
    protected int getPropertyPrice(int what){
        return 0;
    }

    // simple buy, house, hotel
    protected int getRentPrices(int what){
        return 0;
    }

}
