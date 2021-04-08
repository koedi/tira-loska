package loska.domain;


public class Maze {
    private char[][] cells;
    private int height;
    private int width;
    private int origHeight;
    private int origWidth;

    /**
     * Maze constructor.
     * @param height, @param width. Walls are inserted around and between, hence size is (2n+1)x(2n+1)
     * 
     * For example 3x3 increases to 7x7
     * #######
     * #@....#
     * ###.#.#
     * #...#!#
     * #######
     */


    public Maze(int height, int width) {

        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Invalid height or width");
        }

        this.origHeight = height;
        this.origWidth = width;

        this.height = 2 * height + 1;
        this.width  = 2 * width + 1;
        this.cells = new char[this.height][this.width];

        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                this.cells[h][w] = '#';
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

    public int getOrigWidth() {
        return this.origWidth;
    }

    public int getOrigHeight() {
        return this.origHeight;
    }

    public char getCell(int h, int w) {
        return this.cells[h][w];
    }

    //Setters
    public void setCell(int h, int w, char c) {
        this.cells[h][w] = c;
    }



    // MOVE NEXT THREE METHODS TO BINARY TREE!
    /**
     * Adds path to direction d (0=north, 1=west) from coordinate(h,w)
     */
    public void addPath(int h, int w, int d) {
        if (d == 0) {
            checkNorth(h, w);
        } else {
            checkWest(h, w);
        }
    }

    public void checkNorth(int h, int w) {
        /**if (h == 1 && w == 1) {      //If first cell
            this.cells[h][w] = '@';
        } else */if (h == 1) {         //If at top row, only possible direction is west
            checkWest(h, w);
        } /*else if ((h == this.height - 2) && (w == this.width - 2)) {
            this.cells[h][w] = '!';
            this.cells[h - 1][w] = '.';
        } */else {
            this.cells[h][w] = '.';
            this.cells[h - 1][w] = '.';
        }
    }

    public void checkWest(int h, int w) {
        if (h == 1 && w == 1) {     //If first cell
            //prevents infinite loop in first cell (1,1)
        } else if (w == 1) {        //If at left column, only possible direction is north
            checkNorth(h, w);
        } /*else if ((h == this.height - 2) && (w == this.width - 2)) {
            this.cells[h][w] = '!';
            this.cells[h][w - 1] = '.';
        } */else {
            this.cells[h][w] = '.';
            this.cells[h][w - 1] = '.';
        }
    }







    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                sb.append(this.cells[h][w]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}