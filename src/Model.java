public class Model {
    private int height;
    private int width;
    private int[][] cell;

    public Model(int height, int width) {
        this.height = height;
        this.width = width;
        cell = new int[width][height];
    }

    public void update(){}

    public void getShapes(){}
}
