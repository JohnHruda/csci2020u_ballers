import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;

public class Q2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Sets up the gridpane for the text fields
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(5);
        pane.setHgap(5);

        //All of the text fields for input
        TextField investment = new TextField();
        pane.add(new Label("Investment Amount:"), 0, 0);
        pane.add(investment, 1, 0);

        TextField years = new TextField();
        pane.add(new Label("Years:"), 0, 1);
        pane.add(years, 1, 1);

        TextField interest = new TextField();
        pane.add(new Label("Annual Interest Rate:"), 0, 2);
        pane.add(interest, 1, 2);

        TextField futVal = new TextField();
        pane.add(new Label("Future Value:"), 0, 3);
        pane.add(futVal, 1, 3);

        //The button field for calculation
        Button btAdd = new Button("Calculate");
        pane.add(btAdd, 1, 4);


        GridPane.setHalignment(btAdd, HPos.RIGHT);
        // action event for computing the calculation
        EventHandler<ActionEvent> eventAdd = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //From provided formula
                double invest = Double.parseDouble(investment.getText());
                double inter = Double.parseDouble(interest.getText());
                double y = Double.parseDouble(years.getText());
                double output = invest * Math.pow(1 + (inter/100), y);
                futVal.setText(Double.toString(output));
            }
        };



        // Adds everything to the scene
        btAdd.setOnAction(eventAdd);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ShowGridPane");
        primaryStage.show();
    }
}