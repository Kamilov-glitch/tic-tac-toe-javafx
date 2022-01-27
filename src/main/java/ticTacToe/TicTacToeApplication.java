package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {

    private String whoseTurn;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void init() {
        this.whoseTurn = "X";
    }

    @Override
    public void start(Stage window) {
        GridPane gameGrid = new GridPane();
        BorderPane layout = new BorderPane();
        Label label = new Label("Turn: " + this.whoseTurn);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                gameGrid.add(btn, x, y);
            }
        }
        
        gameGrid.getChildren().forEach((n) -> {
            Button btn = (Button) n;
            btn.setOnMouseClicked((event) -> {
                if (btn.getText().equals(" ")) {

                    if (!checkWin(gameGrid)) {
                        btn.setText(this.whoseTurn);
                    }
                    
                    if (checkWin(gameGrid)) {
                        label.setText("my man, " + this.whoseTurn + " won.");
                        return;
                    }

                    this.whoseTurn = changeTurn();
                    label.setText("Turn: " + this.whoseTurn);
                }
            });
        });

        layout.setTop(label);
        layout.setCenter(gameGrid);

        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();

    }

    public String changeTurn() {
        if (this.whoseTurn.equals("X")) {
            return "0";
        } else {
            return "X";
        }
    }
    
    public boolean checkWin(GridPane layout) {
        // Basically symbols on buttons
        String btn1 = ((Button) layout.getChildren().get(0)).getText();
        String btn2 = ((Button) layout.getChildren().get(1)).getText();
        String btn3 = ((Button) layout.getChildren().get(2)).getText();
        String btn4 = ((Button) layout.getChildren().get(3)).getText();
        String btn5 = ((Button) layout.getChildren().get(4)).getText();
        String btn6 = ((Button) layout.getChildren().get(5)).getText();
        String btn7 = ((Button) layout.getChildren().get(6)).getText();
        String btn8 = ((Button) layout.getChildren().get(7)).getText();
        String btn9 = ((Button) layout.getChildren().get(8)).getText();
        
        // Horizontal matching
        if (btn1.equals(btn2) && btn2.equals(btn3) && btn1.equals(whoseTurn)) {
            return true;
        }
        
        if (btn4.equals(btn5) && btn5.equals(btn6) && btn4.equals(whoseTurn)) {
            return true;
        }
        
        if (btn7.equals(btn8) && btn8.equals(btn9) && btn7.equals(whoseTurn)) {
            return true;
        }
        
        // Diagonal matching
        if (btn1.equals(btn5) && btn5.equals(btn9) && btn1.equals(whoseTurn)) {
            return true;
        }
        
        if (btn3.equals(btn5) && btn5.equals(btn7) && btn3.equals(whoseTurn)) {
            return true;
        }
        
        // Vertical matching
        if (btn1.equals(btn4) && btn4.equals(btn7) && btn1.equals(whoseTurn)) {
            return true;
        }
        
        if (btn2.equals(btn5) && btn5.equals(btn7) && btn2.equals(whoseTurn)) {
            return true;
        }
        
        if (btn3.equals(btn6) && btn6.equals(btn9) && btn3.equals(whoseTurn)) {
            return true;
        }
        
        return false;
    }

}
