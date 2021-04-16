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
import javafx.scene.control.TextField;
import javafx.geometry.Pos;

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
        HBox control = new HBox(4);
        Button btn1 = new Button("BT");
        Button btn2 = new Button("DFS");
        TextField height = new TextField("7");
        TextField width = new TextField("7");
        control.getChildren().add(btn1);
        control.getChildren().add(btn2);
        control.getChildren().add(height);
        control.getChildren().add(width);

        //maze display box
        Text text = new Text(dfs.toString());
        text.setFont(Font.font("Ubuntu Mono", 20));
        VBox mazeDisplay = new VBox(text);
        mazeDisplay.setSpacing(20);
        mazeDisplay.setAlignment(Pos.CENTER);

        //whole area
        VBox root = new VBox(control, mazeDisplay);
        

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Maze generator - BT + DFS");


        stage.show();

        //System.exit(0);
    }
}