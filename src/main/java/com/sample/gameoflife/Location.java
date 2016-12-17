package com.sample.gameoflife;

import java.util.Arrays;
import java.util.*;
/**
 * Created by surender.s on 15/12/16.
 */
public class Location {

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Location> getListOfNeighbour() {
        return Arrays.asList( topLeft(), top(), topRight(),
                left(), right(),
                botLeft(), bottom(), bottomRight()
        );
    }

    private Location topLeft() {
        return new Location(x-1, y-1);
    }

    private Location topRight() {
        return new Location(x-1,y+1);
    }

    private Location top() {
        return new Location(x-1,y);
    }

    private Location left() {
        return new Location(x,y-1);
    }

    private Location right() {
        return new Location(x,y+1);
    }

    private Location botLeft() {
        return new Location(x+1,y-1);
    }

    private Location bottom() {
        return new Location(x+1,y);
    }

    private Location bottomRight() {
        return new Location(x+1,y+1);
    }

    public boolean withIn(int maxRow, int maxCol) {

        return x >= 0 && x < maxRow && y >= 0 && y < maxCol;

    }

    int x;
    int y;

}
