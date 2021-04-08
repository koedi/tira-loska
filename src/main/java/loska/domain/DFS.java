package loska.domain;



public class DFS {

    private Maze maze;      // generated maze
    private Maze visited;   // track visited cells
    private MyStack stack;

    public DFS(Maze m) {
        this.maze = m;

        this.visited = new Maze(m.getOrigHeight(), m.getOrigWidth());
        for (int i = 0; i < this.visited.getHeight(); i++) {
            for (int j = 0; j < this.visited.getWidth(); j++) {
                this.visited.setCell(i, j, '0');
            }
        } 

    }


    /**
     * Depth First Search maze generator works following:
     * - Choose a random starting cell and add it to the stack
     * - While there is a cell in the stack
     * 1) Pop cell from the stack
     * 2) Connect and visit all available neighbours (bottom, left, right, top)
     * 3) Randomly select one to be on top and push it to the stack
     */

    public void generate() {

        //Starting cell
        int rndH = (int) (System.nanoTime() % maze.getOrigHeight() * 2 + 1);
        int rndW = (int) (System.nanoTime() % maze.getOrigWidth() * 2 + 1);

        maze.setCell(rndW, rndW, '@');

        //m


    }


    /**
     * Selects and sets random starting cell to '@'
     */
    private void setRandomStartingCell() {
        int rndH = (int) (System.nanoTime() % maze.getOrigHeight() * 2 + 1);
        int rndW = (int) (System.nanoTime() % maze.getOrigWidth() * 2 + 1);

        maze.setCell(rndW, rndW, '@');
    }



    @Override
    public String toString() {
        return this.maze.toString();
    }

}