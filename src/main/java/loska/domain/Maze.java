package loska.domain;


public class Maze {
    private int[][] cells;
    private int height;
    private int width;

    public Maze(int height, int width) {

        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Invalid height or width");
        }

        this.height = height;
        this.width  = width;
        this.cells = new int[height][width];

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                this.cells[h][w] = 1;
            }
        }
    }



    //Getters
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     * Adds wall to direction d (0=north, 1=west) from coordinate(h,w)
     */
    public void addPath(int h, int w, int d) {
 
        //System.out.printf("%d %d %d\n", h, w, d);

        if (d == 0) {
            checkNorth(h, w);
        } else {
            checkWest(h, w);
        }
    }

    public void checkNorth(int h, int w) {
        if (h == 0 && w == 0) {      //If first cell
            this.cells[h][w] = 0;
        } else if (h == 0) {         //If at top row, only possible direction is west
            checkWest(h, w);
        } else {
            this.cells[h - 1][w] = 0;
        }
    }

    public void checkWest(int h, int w) {
        if (h == 0 && w == 0) {     //If first cell
            this.cells[h][w] = 0;
        } else if (w == 0) {        //If at left column, only possible direction is north
            checkNorth(h, w);
        } else {
            this.cells[h][w - 1] = 0;
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                sb.append(this.cells[h][w]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}