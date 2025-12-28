package h1;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j, false);
            }
        }

        for (int i = 0; i < cells.length; i++) {
            if (cells[i].getIndexRow() >= 0 && cells[i].getIndexRow() < gridRows && cells[i].getIndexCol() >= 0 && cells[i].getIndexCol() < gridCols) {
                gridArray[cells[i].getIndexRow()][cells[i].getIndexCol()].setAlive(true);
            }
        }

        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].setAlive(gridArray[i][j].getIsAliveNextGen());
            }
        }

        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }

    }

    public void computeGeneration(int n) {
        for (int i = 1; i <= n; i++) {
            computeNextGen();
        }

    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
}
