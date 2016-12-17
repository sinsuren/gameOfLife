package com.sample.gameoflife;

/**
 * Create your version of a world based on the seed pattern passed into the class.
 */
public class World {
    private int maxRow;
    private int maxCol;
    private Cell[][] cells;

    public World(String[] seedPattern) {
        this.maxRow = seedPattern.length;
        this.maxCol = seedPattern[0].length();
        this.cells = new Cell[maxRow][maxCol];

        int i = 0;
        for(String row: seedPattern) {
            int j = 0;
            for(char c : row.toCharArray()) {
                Location location = new Location(i, j);
                this.cells[i][j] = (c == '.' ? new DeadCell(location) : new LiveCell(location));
                j++;
            }
            i++;
        }
    }

    public void tick() {
        Cell[][] nextCells = new Cell[maxRow][maxCol];
        for(int i = 0; i < maxRow; i++) {
            for(int j = 0; j < maxCol; j++) {
                nextCells[i][j] = cells[i][j].getNextGeneration(this);
            }
        }
        this.cells = nextCells;
    }

    public Cell getCellAt(int row, int col) {
        return cells[row][col];
    }

    public String[] getPattern() {
        String[] pattern = new String[maxRow];
        for (int i = 0; i < maxRow; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < maxCol; j++) {
                row.append(this.cells[i][j].toString());
            }
            row.append("\n");
            pattern[i] = row.toString();
        }
        return pattern;
    }

    public boolean isAliveAt(int row, int col) {
        return this.cells[row][col].isAlive();
    }


    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public int getLiveNeighbourCount(int x, int y) {
        Cell cell = this.cells[x][y];
        return cell.getLiveNeighbourCount(this);
    }
}
