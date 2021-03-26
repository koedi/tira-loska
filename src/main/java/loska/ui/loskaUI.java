package loska.ui;

import loska.domain.*;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main UI class
 */

 public class loskaUI extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Main UI method.
     * UI creation and all elements.
     */
    
     @Override
    public void start(Stage stage) {
 
        Maze m = new Maze(7,7);  
        BinaryTree bt = new BinaryTree(m);
        bt.generate();
        
        System.out.print(bt);

        // display first screen
        //stage.show();
 
    }




}