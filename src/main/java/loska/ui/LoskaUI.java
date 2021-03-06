package loska.ui;

import loska.domain.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
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
        Button btn1 = new Button("BT"); 
        Button btn2 = new Button("DFS");
        TextField height = new TextField("7");
        TextField width = new TextField("7");
        Label label = new Label("");

        // Create top row for control buttons
        GridPane control = createTopRow(btn1, btn2, height, width, label);
        
        // Create maze display box
        VBox mazeDisplay = createMazeDisplay();

        // Setup GUI layout
        VBox root = new VBox(control, mazeDisplay);
        Scene scene = new Scene(root, 800, 600);    
        stage.setScene(scene);
        stage.setTitle("Maze generator - BT + DFS");

        stage.show();

        // Button actions
        btn1.setOnAction(e -> {
            Maze m = new Maze(Integer.parseInt(height.getText()), Integer.parseInt(width.getText()));
            BinaryTree bt = new BinaryTree(m);
            bt.generate();
            updateMazeDisplay(bt, mazeDisplay);           

            setLabelText(m.checkMaze(), label);
        });
 
        btn2.setOnAction(e -> {
            Maze m = new Maze(Integer.parseInt(height.getText()), Integer.parseInt(width.getText()));
            DFS dfs = new DFS(m);
            dfs.generate();
            updateMazeDisplay(dfs, mazeDisplay);           

            setLabelText(m.checkMaze(), label);
        }); 

        addTextBoxListeners(height, width);
    }

    /**
     * Adds real time input validation to height and width textboxes
     * @param height allowed values [1, 100]
     * @param width  allowed values [1, 100]
     */
    private void addTextBoxListeners(TextField height, TextField width) {
        // real time input validation
        height.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                height.setText("1");
            } else if (!newValue.equals("") && Integer.parseInt(newValue) > 100) {
                height.setText("100");
            } else if (!newValue.equals("") && Integer.parseInt(newValue) < 1) {
                height.setText("1");
            } else if (newValue.equals("")) {
                height.setText("1");
            }            
        });
        width.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                width.setText("1");
            } else if (!newValue.equals("") && Integer.parseInt(newValue) > 100) {
                width.setText("100");
            } else if (!newValue.equals("") && Integer.parseInt(newValue) < 1) {
                width.setText("1");
            } else if (newValue.equals("")) {
                width.setText("1");
            }
        });
    }

    private void setLabelText(boolean b, Label l) {
        if (b) {
            l.setText("Maze OK");
            l.setStyle("-fx-text-fill: green;");
        } else {
            l.setText("Maze NOK");
            l.setStyle("-fx-text-fill: red;");
        }
    }

    public GridPane createTopRow(Button btn1, Button btn2, TextField height, TextField width, Label label) {
        GridPane control = new GridPane();
        Text text1 = new Text("height");
        Text text2 = new Text("width");

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
        control.add(label, 9, 0, 2, 2);

        control.setPadding(new Insets(50, 50, 50, 50));
        control.setAlignment(Pos.CENTER);

        control.setHgap(10);
        control.setVgap(10);

        //label.setStyle("-fx-border-color: black;");
        label.setPadding(new Insets(5, 5, 5, 5));
        label.setMinWidth(80);
        label.setAlignment(Pos.CENTER);

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