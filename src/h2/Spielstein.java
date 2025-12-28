package h2;
import java.lang.Object;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        currentRow = indexRow;
        currentCol = indexCol;
        this.brett = brett;
    }

    private boolean movesOut() {
        char d = brett.getBrett()[currentRow][currentCol].getDirection();
        if (d == 'U' && currentRow == 0) {
            return true;
        } else if (d == 'D' && currentRow == (brett.getDim() - 1)){
            return true;
        } else if (d == 'L' && currentCol == 0) {
            return true;
        } else if (d == 'R' && currentCol == brett.getDim() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void go(int n){
        for(int i = 1; i <= n; i++){
            char d = brett.getBrett()[currentRow][currentCol].getDirection();
            if(!brett.getBrett()[currentRow][currentCol].getBoese() && !movesOut()){
                if (d == 'U'){
                    currentRow--;
                } else if (d == 'D'){
                    currentRow++;
                } else if (d == 'L'){
                    currentCol--;
                } else if (d == 'R'){
                    currentCol++;
                }
            }
        }
    }


    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }
}
