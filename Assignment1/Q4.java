import javafx.application.Application;
import javafx.scene.chart.CategoryAxis;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.io.*;

public class Q4 extends Application {

    // Sets up everything in order to create bar graph
    public final NumberAxis yAx = new NumberAxis();
    public final CategoryAxis xAx = new CategoryAxis();
    public final BarChart<String,Number> barChart = new BarChart<>(xAx,yAx);
    public XYChart.Series dataSeries = new XYChart.Series();

    //Sets up the letter array and integer array for ascii values
    public char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public int count[] = new int[256];

    @Override
    public void start(Stage stage) throws Exception {

        // Creates a new stack pane
        StackPane bgPane = new StackPane();

        // Creates a button and text field for the file directory
        Button buttonEval = new Button("View");
        buttonEval.setAlignment(Pos.CENTER);
        TextField dir = new TextField("Enter directory");
        dir.setAlignment(Pos.BOTTOM_CENTER);
        dir.setMaxWidth(200);


        //Sets axis labels and generates the graph
        xAx.setLabel("Alphabet");
        yAx.setLabel("# of Appearances");

        generateGraph();

        //Event handler for either pushing the button or pressing the enter key
        EventHandler<ActionEvent> createGraph = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){

                //Resets the count array after each press
                count = new int[256];

                //Creates a file stream and gets file directory from textfield
                FileInputStream file  = null;
                try {
                    //
                    file = new FileInputStream(dir.getText());
                } catch (FileNotFoundException exception) {
                    exception.printStackTrace();
                }

                //Reader to read the file input from the textfield
                BufferedReader reader = new BufferedReader(new InputStreamReader(file));
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                //Generates the bars of the histogram using the data from the file
                String line1;
                while(line != null){
                    int len = line.length();
                    line1 = line.toLowerCase();
                    for (int i = 0; i < len; i++)
                        count[line1.charAt(i)]++;
                    try {
                        line = reader.readLine();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
                generateGraph();
            }
        };

        //Sets the button press action
        buttonEval.setOnAction(createGraph);
        dir.setOnAction(createGraph);

        //Adds chart data to bar graph
        barChart.getData().addAll(dataSeries);

        //Formats everything for correct output
        VBox vBox = new VBox();
        vBox.getChildren().addAll(dir,buttonEval,barChart);
        bgPane.getChildren().add(vBox);
        Scene scene = new Scene(bgPane, 1000, 600);
        stage.setTitle("Letter Histogram");
        stage.setScene(scene);
        stage.show();
    }
    //Uses the ascii value of each letter and calculates how many times it occurs in the text file
    public void generateGraph(){
        int x = 97;
        for (int i=0; i<alphabet.length; i++){
            // process ascii array element as numbers of letters within the text file
            dataSeries.getData().add(new XYChart.Data(Character.toString(alphabet[i]), count[x]));
            x++;
        }
    }
}

