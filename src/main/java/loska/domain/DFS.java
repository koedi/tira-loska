package loska.domain;



public class DFS {

    private Maze maze;                 // generated maze
    private boolean visited[][];       // tracks visited cells

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
     * 1) Choose a random starting cell and set as current
     * 2) For current cell, go through all four directions in random order and
     * 2.1) Check if neighbour is not visited (and within maze boundaries)
     * 2.2) Connect, set as new current and jump to 2) 
     * 3) When all cells are visited, i.e. recursion has ended, set start and goal
     */

    public void generate() {

        //Random starting cell
        int rndH = (int) (System.nanoTime() % maze.getOrigHeight() * 2 + 1);
        int rndW = (int) (System.nanoTime() % maze.getOrigWidth() * 2 + 1);

        //Recursion method
        maze.setCell(rndH, rndW, '.');
        dfs(rndH, rndW);

        //Set start and goal
        maze.setCell(1, 1, '@');
        maze.setCell(maze.getHeight() - 2, maze.getWidth() - 2, '!');
    }

    /** 
     * Recursive method for Depth First Search
     * @param currentH h-coordinate for current cell
     * @param currentW w-coordinate for current cell
     */
    private void dfs(int currentH, int currentW) {

        //mark current cell visited
        visited[currentH][currentW] = true;

        //go through four directions of neighbours in random order
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
     * Shuffles an int array
     * @param array integer array to be shuffled
     */
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