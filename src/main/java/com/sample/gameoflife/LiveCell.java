package com.sample.gameoflife;

/**
 * Created by surender.s on 17/12/16.
 */
public class LiveCell extends Cell {

    public LiveCell(Location location) {
        super(location);
    }

    public boolean isAlive() {
        return true;
    }

    @Override
    public Cell getNextGeneration(World world) {
        int aliveNeighbourCount = getLiveNeighbourCount(world);

        if(aliveNeighbourCount < 2 || aliveNeighbourCount >3 ) {
            return new DeadCell(location);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "*";
    }
}
