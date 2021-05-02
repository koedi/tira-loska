package loska.domain;


public class BinaryTree {
    private Maze maze;


    public BinaryTree(Maze m) {
        this.maze = m;
    }

    /**
     * Binary tree maze is created in three steps
     * 1) For each cell in the grid
     * 2) Select direction randomly (north / west)
     * 3) Connect with cell in selected direction
     */
    public void generate() {

        //Generation loop
        for (int h = 0; h < maze.getHeight() / 2; h++) {
            for (int w = 0; w < maze.getWidth() / 2; w++) {
                int rnd = (int) (System.nanoTime() % 2);
                addPath(2 * h + 1, 2 * w + 1, rnd);
            }
        }

        //Set marks for start and goal
        maze.setCell(1, 1, '@');
        maze.setCell(maze.getHeight() - 2, maze.getWidth() - 2, '!');
    }
    
    /**
     * Connects two cells between selected direction (north / west)
     * @param h h-coordinate for the cell to be connected
     * @param w w-coordinate for the cell to be connected
     * @param d direction (north=0, west=1)
     */
    public void addPath(int h, int w, int d) {
        if (d == 0) {
            checkNorth(h, w);
        } else {
            checkWest(h, w);
        }
    }

    /**
     * Connect cell to the north. If at top row, try to check if west if ok.
     * @param h h-coordinate for the cell to be connected
     * @param w w-coordinate for the cell to be connected
     */
    public void checkNorth(int h, int w) {
        if (h == 1) {         //If at top row, only possible direction is west
            checkWest(h, w);
        } else {
            maze.setCell(h, w, '.');
            maze.setCell(h - 1, w, '.');
        }
    }

    /**
     * Connect cell to the west. If at top row, try to check if north if ok.
     * @param h h-coordinate for the cell to be connected
     * @param w w-coordinate for the cell to be connected
     */
    public void checkWest(int h, int w) {
        if (h == 1 && w == 1) {     //If first cell (1,1), prevent infinite loop
            return;                 
        } else if (w == 1) {        //If at left column, only possible direction is north
            checkNorth(h, w);
        } else {
            maze.setCell(h, w, '.');
            maze.setCell(h, w - 1, '.');
        }
    }

    @Override
    public String toString() {
        return this.maze.toString();
    }


}