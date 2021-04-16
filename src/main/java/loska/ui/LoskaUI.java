package loska.ui;

import loska.domain.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
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
 
        Maze m;
        Button btn1 = new Button("BT"); 
        Button btn2 = new Button("DFS");

        m = new Maze(10, 10);  
        BinaryTree bt = new BinaryTree(m);
        bt.generate();
        //System.out.println("Binary Tree");
        //System.out.print(bt);

        System.out.print("\n\n");

        m = new Maze(10, 10);
        DFS dfs = new DFS(m);
        dfs.generate();
        //System.out.println("Depth-First Search");
        //System.out.println(dfs);
 


        // Main scene
        //top row for control buttons
        GridPane control = createTopRow(btn1, btn2);
        
        //maze display box
        VBox mazeDisplay = createMazeDisplay();

        //whole area
        VBox root = new VBox(control, mazeDisplay);
        Scene scene = new Scene(root, 800, 600);    
        stage.setScene(scene);
        stage.setTitle("Maze generator - BT + DFS");

        stage.show();

        btn1.setOnAction(e -> {
            updateMazeDisplay(bt, mazeDisplay);           
        });
 
        btn2.setOnAction(e -> {
            updateMazeDisplay(dfs, mazeDisplay);           
        });

        //updateMazeDisplay(bt, mazeDisplay);

        //System.exit(0);
    }


    public GridPane createTopRow(Button btn1, Button btn2) {
        GridPane control = new GridPane();
        //btn1 = new Button("BT");
        //btn2 = new Button("DFS");
        Text text1 = new Text("height");
        Text text2 = new Text("width");
        TextField height = new TextField("7");
        TextField width = new TextField("7");

        btn1.setMinWidth(50);
        btn2.setMinWidth(50);

        height.setPrefWidth(50);
        width.setPrefWidth(50);

        control.add(text1, 0, 0, 1, 1);
        control.add(text2, 0, 1, 1, 1);
        control.add(height, 1, 0, 1, 1);
        control.add(width,  1, 1, 1, 1);
        control.add(btn1, 3, 0, 2, 2);
        control.add(btn2, 5, 0, 2, 2);

        control.setPadding(new Insets(50, 50, 50, 50));
        control.setAlignment(Pos.CENTER);

        control.setHgap(10);
        control.setVgap(10);

        return control;
    }

    public VBox createMazeDisplay() {
        Text text = new Text("Here be maze");
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
    public void updateMazeDisplay(Object t, VBox vb) {
        Text text = new Text(t.toString());
        text.setFont(Font.font("Ubuntu Mono", 20));

        vb.getChildren().clear();
        vb.getChildren().add(text);
    }


}