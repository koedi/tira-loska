package loska.ui;

import loska.domain.*;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main UI class
 */

public class LoskaUI extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Main UI method.
     * UI creation and all elements.
     */
    
    @Override
    public void start(Stage stage) {
 
        Maze m = new Maze(7, 7);  
        BinaryTree bt = new BinaryTree(m);
        bt.generate();
        System.out.println("Binary Tree");
        System.out.print(bt);

        System.out.print("\n\n");

        m = new Maze(7, 7);
        DFS dfs = new DFS(m);
        dfs.generate();
        System.out.println("Depth-First Search");
        System.out.println(dfs);
        
        // display first screen
        //stage.show();
        System.exit(0);
    }
}