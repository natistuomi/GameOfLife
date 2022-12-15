package Model;

public class Cell {
    private int state = 0;
    private int livingNeighbours = 0;

    public Cell() {
    }

    public void addNeighbour(){livingNeighbours += 1;}

    public void setNeighbour(){livingNeighbours = 0;}

    public int getState() {return state;}

    public int getLivingNeighbours() {return livingNeighbours;}

    public void checkState(){
        if(state == 0 && livingNeighbours == 3){state = 1;}
        else if(state == 1 && livingNeighbours < 4 && livingNeighbours > 1){}
        else{state = 0;}
        livingNeighbours = 0;
    }
}
