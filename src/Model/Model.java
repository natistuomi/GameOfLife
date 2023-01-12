package Model;
import View.*;

public class Model {
    private int y;
    private int x;
    private Cell[][] cell;
    private Cell[][] replicaCell;

    public Model(int y, int width) {
        this.y = y;
        this.x = width;
        cell = new Cell[width][y];
        replicaCell = new Cell[width][y];
    }

    public void update(){
        for(int i = 0; i < x; i++){
            for(int n = 0; n < y; n++){
                checkForNeighbours(i, n);
                replicaCell[i][n].checkState();
            }
        }
        cell = replicaCell;
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


    public Shape[] getShapes(){

    }
}
