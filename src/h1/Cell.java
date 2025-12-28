package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public void countLivingNeighbors(Cell[][] gridArray){
       int count = 0;
       for(int i = -1; i <= 1; i++){
           for(int j = -1; j <= 1; j++){
               int row = this.indexRow + i;
               int col = this.indexCol + j;

               if(row == this.indexRow && col == this.indexCol){
                   continue;
               }

               if (row >= 0 && row < gridArray.length && col >= 0 && col < gridArray[0].length){
                   if(gridArray[row][col].getAlive()){
                       count++;
                   }
               }
           }
       }
       numLivingNeighbors = count;
       decideNextStatus();
    }

    public void decideNextStatus(){
        if(this.alive){
            if (numLivingNeighbors == 2 || numLivingNeighbors == 3){
            this.isAliveNextGen = true;
            } else {
                this.isAliveNextGen = false;
            }
        } else {
            if (numLivingNeighbors == 3) {
                this.isAliveNextGen = true;
            } else {
                this.isAliveNextGen = false;
            }
        }
    }


    public int getIndexRow(){
        return indexRow;
    }
    public void setIndexRow(int indexRow){
        this.indexRow = indexRow;
    }

    public int getIndexCol(){
        return indexCol;
    }
    public void setIndexCol(int indexCol){
        this.indexCol = indexCol;
    }

    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public int getNumLivingNeighbors(){
        return numLivingNeighbors;
    }
    public void setNumLivingNeighbors(int numLivingNeighbors){
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean getIsAliveNextGen(){
        return isAliveNextGen;
    }
    public void setIsAliveNextGen(boolean isAliveNextGen){
        this.isAliveNextGen = isAliveNextGen;
    }
}
