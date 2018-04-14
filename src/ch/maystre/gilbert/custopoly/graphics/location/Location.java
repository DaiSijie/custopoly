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

    private static final Color[] COLORS = {new Color(153, 102, 0), new Color(0, 102, 255), new Color(255, 51, 153), new Color(255, 102, 0), new Color(230, 0, 0), new Color(255, 255, 0), new Color(0, 153, 51), new Color(0, 102, 204)};

    private static final int[][] PRICES = { // location price | house price | basic rent | full color rent | 1...5 house rent
            {1200, 1000, 40, 80, 200, 600, 1800, 3200, 5000},            // rank 0
            {1200, 1000, 80, 160, 400, 1200, 3600, 6400, 9000},          // rank 1
            {2000, 1000, 120, 240, 600, 1800, 5400, 8000, 11000},        // rank 2
            {2000, 1000, 120, 240, 600, 1800, 5400, 8000, 11000},        // rank 3
            {2400, 1000, 160, 320, 800, 2000, 6000, 9000, 12000},        // rank 4
            {2800, 2000, 200, 400, 1000, 3000, 9000, 125000, 15000},     // rank 5
            {2800, 2000, 200, 400, 1000, 3000, 9000, 125000, 15000},     // rank 6
            {3200, 2000, 240, 480, 1200, 3600, 10000, 140000, 18000},    // rank 7
            {3600, 2000, 280, 560, 1400, 4000, 11000, 15000, 19000},     // rank 8
            {3600, 2000, 280, 560, 1400, 4000, 11000, 15000, 19000},     // rank 9
            {4000, 2000, 320, 640, 1600, 4400, 12000, 16000, 20000},     // rank 10
            {4400, 3000, 360, 720, 1800, 5000, 14000, 17500, 21000},     // rank 11
            {4400, 3000, 360, 720, 1800, 5000, 14000, 17500, 21000},     // rank 12
            {4800, 3000, 400, 800, 2000, 6000, 15000, 18500, 22000},     // rank 13
            {5200, 3000, 440, 880, 2200, 6600, 16000, 19500, 23000},     // rank 14
            {5200, 3000, 440, 880, 2200, 6600, 16000, 19500, 23000},     // rank 15
            {5600, 3000, 480, 960, 2400, 7200, 17000, 20500, 24000},     // rank 16
            {6000, 4000, 520, 1040, 2600, 7800, 18000, 22000, 25500},    // rank 17
            {6000, 4000, 520, 1040, 2600, 7800, 18000, 22000, 25500},    // rank 18
            {6400, 4000, 560, 1120, 3000, 9000, 20000, 24000, 28000},    // rank 19
            {7000, 4000, 700, 1400, 3500, 10000, 22000, 26000, 30000},   // rank 20
            {8000, 4000, 1000, 2000, 4000, 12000, 28000, 34000, 40000}}; // rank 21

    public Location(String name, int rank, int width, int height){
        super(width, height);
        this.name = name;
        this.rank = rank;
    }

    protected Color getLocationColor(){
        return COLORS[rankToGroup(rank)];
    }

    // region buying location prices

    protected int getLocationBuyPrice(){
        return PRICES[rank][0];
    }

    protected int getHouseBuyPrice(){
        return PRICES[rank][1];
    }

    protected int getMortgagePrice(){
        return getLocationBuyPrice() / 2;
    }

    // endregion

    // region rent prices

    protected int getBasicRentPrice(){
        return PRICES[rank][2];
    }

    protected int getFullColorRentPrice(){
        return PRICES[rank][3];
    }

    /**
     * @param numberOfHouses 5 houses = 1 hotel
     */
    protected int getHouseRentPrice(int numberOfHouses){
        return PRICES[rank][3 + numberOfHouses];
    }

    // endregion

    private int rankToGroup(int rank){
        if(rank <= 1)
            return 0;
        return ((rank - 2) / 3) + 1;
    }

}
