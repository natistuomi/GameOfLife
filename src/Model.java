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

    }

    public void getShapes(){}
}
