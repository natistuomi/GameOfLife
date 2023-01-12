package Model;
import View.*;

public class Model {
    private int height;
    private int width;
    private Cell[][] cell;
    private Cell[][] replicaCell;

    public Model(int height, int width) {
        this.height = height;
        this.width = width;
        cell = new Cell[width][height];
        replicaCell = new Cell[width][height];
    }

    public void update(){
        for(int i = 0; i < width; i++){
            for(int n = 0; n < height; n++){
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
        if(h != 0 && w != width-1 && cell[w+1][h-1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != width-1 && cell[w+1][h].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != width-1 && h != height-1 && cell[w+1][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(h != height-1 && cell[w][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
        if(w != 0 && cell[w-1][h+1].getState() == 1){replicaCell[w][h].addNeighbour();}
    }


    public Shape[] getShapes(){
        Shape[] x = new Shape[2];
        return x;
    }
}
