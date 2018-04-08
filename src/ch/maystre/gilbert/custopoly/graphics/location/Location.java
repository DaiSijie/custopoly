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

    private static final Color[] colors = {new Color(153, 102, 0), new Color(0, 102, 255), new Color(255, 51, 153), new Color(255, 102, 0), new Color(230, 0, 0), new Color(255, 255, 0), new Color(0, 153, 51), new Color(0, 102, 204)};


    public Location(String name, int rank, int width, int height){
        super(width, height);
        this.name = name;
        this.rank = rank;
    }

    protected Color getLocationColor(){
        return colors[rankToGroup(rank)];
    }

    // basic, full color, 1, 2, 3, 4, hotel
    protected int getPropertyPrice(int what){
        return 0;
    }

    // simple buy, house, hotel
    protected int getRentPrices(int what){
        return 0;
    }

    private int rankToGroup(int rank){
        if(rank <= 1)
            return 0;
        return ((rank - 2) / 3) + 1;
    }

}
