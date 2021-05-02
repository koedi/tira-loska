package loska.domain;


public class Maze {
    private char[][] cells;
    private int height;
    private int width;
    private int origHeight;
    private int origWidth;

    /**
     * Maze constructor.
     * @param height maze height
     * @param width  maze width
     * 
     * Walls are inserted around and between, hence size is (2n+1)x(2n+1)
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

        //Init all cells to '#'
        for (int h = 0; h < this.height; h++) {
            for (int w = 0; w < this.width; w++) {
                this.cells[h][w] = '#';
            }
        }
    }

    /** 
     * Checks if maze has been generated correctly i.e. all cells are connected  
     * Uses DFS to traverse whole maze. Compares visited cells to the total cell number (height x width)
     */
    public boolean checkMaze() {
        boolean[][] visited = new boolean[this.getHeight()][this.getWidth()];
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                visited[i][j] = false;
            }
        }

        //Traverse maze
        this.setCell(1, 1, '.');
        this.setCell(this.getHeight() - 2, this.getWidth() - 2, '.');
        dfsTraverse(1, 1, visited);

        //Check "true" count
        int count = 0;
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (visited[i][j] == true) {
                    count++;
                }
            }
        }

        // Check if all were visited
        if (count != this.getOrigHeight() *  this.getOrigWidth()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Traverse maze using Depth-First Search
     * @param currentH h position
     * @param currentW w position
     * @param visited tracks visited cells
     */
    private void dfsTraverse(int currentH, int currentW, boolean[][] visited) {
        //mark current cell visited
        visited[currentH][currentW] = true;

        // north
        if (currentH - 2 >= 0 && !visited[currentH - 2][currentW]) {
            if ((this.getCell(currentH - 1, currentW) == '.') && (this.getCell(currentH - 2, currentW) == '.')) {
                dfsTraverse(currentH - 2, currentW, visited);
            }  
        }
        // east
        if (currentW + 2 < this.getWidth() && !visited[currentH][currentW + 2]) {
            if ((this.getCell(currentH , currentW + 1) == '.') && (this.getCell(currentH , currentW + 2) == '.')) {
                dfsTraverse(currentH, currentW + 2, visited);
            }
        }        
        // south 
        if (currentH + 2 < this.getHeight() && !visited[currentH + 2][currentW]) {
            if ((this.getCell(currentH + 1, currentW) == '.') && (this.getCell(currentH + 2, currentW) == '.')) {
                dfsTraverse(currentH + 2, currentW, visited);
            }  
        }
        // west
        if (currentW - 2 >= 0 && !visited[currentH][currentW - 2]) {
            if ((this.getCell(currentH , currentW - 1) == '.') && (this.getCell(currentH , currentW - 2) == '.')) {
                dfsTraverse(currentH, currentW - 2, visited);
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
     * @return unscaled width
     */
    public int getOrigWidth() {
        return this.origWidth;
    }

    /**
     *  @return unscaled height
     */
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
            if (h < this.height - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}