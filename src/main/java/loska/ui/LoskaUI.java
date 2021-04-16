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
import javafx.geometry.Insets;



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
        HBox control = createTopRow();
        
        //maze display box
        VBox mazeDisplay = createMazeDisplay(dfs);

        //whole area
        VBox root = new VBox(control, mazeDisplay);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Maze generator - BT + DFS");


        stage.show();

        //System.exit(0);
    }


    public HBox createTopRow() {
        HBox control = new HBox(4);
        Button btn1 = new Button("BT");
        Button btn2 = new Button("DFS");
        Text text1 = new Text("height");
        Text text2 = new Text("width");
        TextField height = new TextField("7");
        TextField width = new TextField("7");

        height.setPrefWidth(50);
        width.setPrefWidth(50);

        control.getChildren().add(btn1);
        control.getChildren().add(btn2);
        control.getChildren().add(text1);
        control.getChildren().add(text2);
        control.getChildren().add(height);
        control.getChildren().add(width);

        control.setPadding(new Insets(50, 50, 50, 50));
        control.setSpacing(10);

        return control;
    }

    public VBox createMazeDisplay(DFS dfs) {
        Text text = new Text(dfs.toString());
        //Text text = new Text("Here be maze");
        text.setFont(Font.font("Ubuntu Mono", 20));

        VBox mazeDisplay = new VBox(text);
        mazeDisplay.setSpacing(20);
        mazeDisplay.setAlignment(Pos.CENTER);

        String cssLayout = 
            "-fx-background-color: lightyellow;" +
            "-fx-border-color: red;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n" +
            "-fx-border-style: dashed;\n";

        mazeDisplay.setStyle(cssLayout);

        mazeDisplay.setPrefWidth(580);
        mazeDisplay.setPrefHeight(680);

        return mazeDisplay;
    }

    //updates mazeDisplay node contents
    public void updateMazeDisplay() {

    }

}