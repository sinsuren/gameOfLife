package com.sample.gameoflife;

/**
 * Created by surender.s on 17/12/16.
 */
public class DeadCell extends Cell {

    public DeadCell(Location location) {
        super(location);
    }

    public boolean isAlive() {
        return false;
    }

    public Cell getNextGeneration(World world) {
        int liveNeighbourCount = getLiveNeighbourCount(world);

        if(liveNeighbourCount == 3) {
            return new LiveCell(location);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return ".";
    }
}
