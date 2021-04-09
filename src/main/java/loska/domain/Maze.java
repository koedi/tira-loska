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