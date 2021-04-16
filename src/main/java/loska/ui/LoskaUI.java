package loska.ui;

import loska.domain.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

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
 
        Maze m = new Maze(4, 7);  
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
        
        // Main scene
        //top row for control buttons
        HBox control = new HBox();
        Button btn1 = new Button("eka");
        control.getChildren().add(btn1);

        //maze display box
        Text text = new Text(dfs.toString());
        text.setFont(Font.font("Ubuntu Mono", 20));
        VBox maze = new VBox(text);

        //whole area
        VBox vbox = new VBox(control, maze);
        
        Scene scene = new Scene(vbox, 800,600);
        stage.setScene(scene);
        stage.setTitle("Maze generator - BT + DFS");


        stage.show();

        //System.exit(0);
    }
}