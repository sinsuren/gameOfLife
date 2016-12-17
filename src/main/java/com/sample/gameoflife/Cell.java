package com.sample.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surender.s on 15/12/16.
 */
public abstract class Cell {

    protected Location location;

    public Cell(Location location) {
        this.location = location;
    }

    public abstract boolean isAlive();

    public List<Cell> getNeighbours(World world) {
        List<Location> neighbourLocation = this.location.getListOfNeighbour();
        List<Cell> neighbours = new ArrayList<Cell>();

        for(Location location: neighbourLocation) {
            if(location.withIn(world.getMaxRow(), world.getMaxCol())) {
                neighbours.add(world.getCellAt(location.getX(), location.getY()));
            }
        }
        return neighbours;
    }

    public int getLiveNeighbourCount(World world) {
        List<Cell> neighbour = getNeighbours(world);
        int count = 0;
        for(Cell cell: neighbour) {
            if(cell.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public abstract Cell getNextGeneration(World world);
}
