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
     * 3) Connect with cell in selected directions 
     */
    public void generate() {
        for (int h = 0; h < maze.getHeight() / 2; h++) {
            for (int w = 0; w < maze.getWidth() / 2; w++) {
                int rnd = (int) (System.nanoTime() % 2);
                maze.addPath(2 * h + 1, 2 * w + 1, rnd);
            }
        }

        //Set marks for start and goal
        maze.setCell(1, 1, '@');
        maze.setCell(maze.getHeight() - 2, maze.getWidth() - 2, '!');
    }


    public String toString() {
        return this.maze.toString();
    }


}