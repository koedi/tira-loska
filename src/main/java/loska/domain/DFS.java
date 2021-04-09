package loska.domain;



public class DFS {

    private Maze maze;      // generated maze
    private MyStack stack;
    private boolean visited[][];

    public DFS(Maze m) {
        this.maze = m;

        this.visited = new boolean[this.maze.getHeight()][this.maze.getWidth()];
        for (int i = 0; i < this.maze.getHeight(); i++) {
            for (int j = 0; j < this.maze.getWidth(); j++) {
                this.visited[i][j] = false;
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

        //Random starting cell
        int rndH = (int) (System.nanoTime() % maze.getOrigHeight() * 2 + 1);
        int rndW = (int) (System.nanoTime() % maze.getOrigWidth() * 2 + 1);
        maze.setCell(rndH, rndW, '@');
        
        dfs(rndH, rndW);
    }

    /**
     * Recursive method for Depth First Search 
     */
    private void dfs(int currentH, int currentW) {

        //mark current cell visited
        visited[currentH][currentW] = true;

        //go through four directions for neighbours in random order
        int[] dirs = {1, 2, 3, 4};
        shuffleArray(dirs);

        for (int i: dirs) {
            switch (i) {
                case 1: // north
                    if (currentH - 2 >= 0 && !visited[currentH - 2][currentW]) {
                        maze.setCell(currentH - 2, currentW, '.');
                        maze.setCell(currentH - 1, currentW, '.');
                        dfs(currentH - 2, currentW);
                    }
                    break;         
                case 2: // east
                if (currentW + 2 < maze.getWidth() && !visited[currentH][currentW + 2]) {
                    maze.setCell(currentH, currentW + 2, '.');
                    maze.setCell(currentH, currentW + 1, '.');
                    dfs(currentH, currentW + 2);
                }
                    break;
                case 3: // south 
                if (currentH + 2 < maze.getHeight() && !visited[currentH + 2][currentW]) {
                    maze.setCell(currentH + 2, currentW, '.');
                    maze.setCell(currentH + 1, currentW, '.');
                    dfs(currentH + 2, currentW);
                }
                    break;
                case 4: // west
                if (currentW - 2 >= 0 && !visited[currentH][currentW - 2]) {
                    maze.setCell(currentH, currentW - 2, '.');
                    maze.setCell(currentH, currentW - 1, '.');
                    dfs(currentH, currentW - 2);
                }
                    break;
            }
        }
        return;
    }


    /**
     * Selects and sets random starting cell to '@'
     */
    private void setRandomStartingCell() {
        int rndY = (int) (System.nanoTime() % maze.getOrigHeight() * 2 + 1);
        int rndX = (int) (System.nanoTime() % maze.getOrigWidth() * 2 + 1);

        maze.setCell(rndX, rndY, '@');
    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int rnd = (int) (System.nanoTime() % array.length);
            if (i == rnd) {
                i++;
            } else {
                int a = array[rnd];
                array[rnd] = array[i];
                array[i] = a;
            }
        }
    }



    @Override
    public String toString() {
        return this.maze.toString();
    }

}