package Model;
import View.*;

public class Model {
    private int y;
    private int x;
    private Cell[][] cell;
    private Cell[][] replicaCell;
    private Shape[] living;
    private int count = 0;

    public Model(int y, int x) {
        this.y = y;
        this.x = x;
        cell = new Cell[x][y];
        replicaCell = new Cell[x][y];
    }

    public void update(){
        for(int i = 0; i < x; i++){
            for(int n = 0; n < y; n++){
                checkForNeighbours(i, n);
                replicaCell[i][n].checkState();
                if(replicaCell[i][n].getState() == 1){
                    living[count] = new Point(i, n);
                    count += 1;
                }
            }
        }
        cell = replicaCell;
        count = 0;
    }

    public void checkForNeighbours(int w, int h){
        if(w != 0 && cell[w-1][h].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != 0 && h != 0 && cell[w-1][h-1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(h != 0 && cell[w][h-1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(h != 0 && w != x-1 && cell[w+1][h-1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != x-1 && cell[w+1][h].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != x-1 && h != y-1 && cell[w+1][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(h != y-1 && cell[w][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != 0 && cell[w-1][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
    }


    public Shape[] getShapes() {
        return living;
    }
}
