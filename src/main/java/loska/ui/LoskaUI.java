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
        System.out.print(bt);

        System.out.print("\n\n----------------------\n\n\n");

        m = new Maze(7, 7);
        DFS dfs = new DFS(m);
        dfs.generate();
        System.out.println(dfs);
        
        // display first screen
        //stage.show();
        System.exit(0);
    }


        /*
        MyStack stack = new MyStack(3);
        Cell c1 = new Cell(1, 1);
        Cell c2 = new Cell(2, 2);
        Cell c3 = new Cell(3, 3);
        Cell c4 = new Cell(4, 4);

        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        */



}