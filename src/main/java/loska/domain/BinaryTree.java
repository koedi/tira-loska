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
    
    public void addPath(int h, int w, int d) {
        if (d == 0) {
            checkNorth(h, w);
        } else {
            checkWest(h, w);
        }
    }

    public void checkNorth(int h, int w) {
        if (h == 1) {         //If at top row, only possible direction is west
            checkWest(h, w);
        } else {
            maze.setCell(h, w, '.');
            maze.setCell(h - 1, w, '.');
        }
    }

    public void checkWest(int h, int w) {
        if (h == 1 && w == 1) {     //If first cell
            return;                 //prevents infinite loop in first cell (1,1)
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