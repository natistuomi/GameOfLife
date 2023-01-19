package Model;
import View.*;

public class Model {
    private int y;
    private int x;
    private Cell[][] cell;
    private Cell[][] replicaCell;
    private Point[] living;
    private int count = 0;

    public Model(int y, int x) {
        this.y = y;
        this.x = x;
        cell = new Cell[x][y];
        setGrid();
        replicaCell = new Cell[x][y];
    }

    public void setGrid(){
        for(int i = 0; i < x; i++){
            for(int n = 0; n < y; n++){
                cell[i][n] = new Cell();
            }
        }
        cell[0][1].setState();
        cell[0][2].setState();
        cell[1][1].setState();
        cell[2][1].setState();
        living = new Point[4];
        living[0] = new Point(0,1);
        living[0] = new Point(0,2);
        living[0] = new Point(1,1);
        living[0] = new Point(2,1);
    }

    public void update(){
        for(int i = 0; i < x; i++){
            for(int n = 0; n < y; n++){
                checkForNeighbours(i, n);
                replicaCell[i][n].checkState();
                if(replicaCell[i][n].getState() == 1){
                    count += 1;
                }
            }
        }
        living = new Point[count];
        int c = 0;
        for(int i = 0; i < x; i++){
            for(int n = 0; n < y; n++){
                if(replicaCell[i][n].getState() == 1){
                    living[c] = new Point(i, n);
                    c += 1;
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
