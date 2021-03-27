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
        for (int h = 0; h < maze.getHeight(); h++) {
            for (int w = 0; w < maze.getWidth(); w++) {
                int rnd = (int) (System.nanoTime() % 2);
                maze.addPath(h, w, rnd);
            }
        }


    }


    public String toString() {
        return this.maze.toString();
    }


}