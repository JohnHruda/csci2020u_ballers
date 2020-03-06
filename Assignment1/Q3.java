import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Q3 extends Application{
    public void start(Stage stage) throws Exception {

        //create a the window to open when running
        Pane window = new Pane();
        window.setPrefSize(300, 300);

        //Creates the bigger circle that the points are on
        Circle circle = new Circle(150,150,120);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.WHITE);

        //Creates each of the three points that lie on the circle
        Circle point1 = new Circle(150,30,5);
        point1.setStroke(Color.BLACK);
        point1.setFill(Color.RED);

        Circle point2 = new Circle(30,150,5);
        point2.setStroke(Color.BLACK);
        point2.setFill(Color.RED);

        Circle point3 = new Circle(270,150,5);
        point3.setStroke(Color.BLACK);
        point3.setFill(Color.RED);

        //Creates the lines that connect the dots
        Line line1 = new Line(150,30,30,150);
        line1.setStroke(Color.BLACK);
        Line line2 = new Line(30,150,270,150);
        line2.setStroke(Color.BLACK);
        Line line3 = new Line(270,150,150,30);
        line3.setStroke(Color.BLACK);

        //Creates the text to display each of the angles
        Text angle1 = new Text(140,50,calculateAngle(line2, line1, line3));
        Text angle2 = new Text(20,170,calculateAngle(line3, line1, line2));
        Text angle3 = new Text(260,170,calculateAngle(line1, line2, line3));

        //Everything created above is added to the panel
        window.getChildren().add(circle);

        window.getChildren().add(line1);
        window.getChildren().add(line2);
        window.getChildren().add(line3);

        window.getChildren().add(angle1);
        window.getChildren().add(angle2);
        window.getChildren().add(angle3);
        window.getChildren().add(point1);
        window.getChildren().add(point2);
        window.getChildren().add(point3);

        //Events for dragging the dots around
        point1.setOnMouseDragged(e ->{
            double xline = e.getX()-150;
            double yline = e.getY()-150;
            double hypline = Math.sqrt(Math.pow(xline,2)+Math.pow(yline,2));

            xline=((xline/hypline)*120)+150;
            xline=((yline/hypline)*120)+150;

            point1.setCenterX(xline);
            point1.setCenterY(yline);
            line1.setStartX(xline);
            line1.setStartY(yline);
            line3.setEndX(xline);
            line3.setEndY(yline);
            angle1.setX(xline-10);
            angle1.setY(yline+20);
            angle1.setText(calculateAngle(line2, line1, line3));
            angle2.setText(calculateAngle(line3, line1, line2));
            angle3.setText(calculateAngle(line1, line2, line3));
        });
        point2.setOnMouseDragged(e ->{
            double xline = e.getX()-150;
            double yline = e.getY()-150;
            double hypline = Math.sqrt(Math.pow(xline,2)+Math.pow(yline,2));

            xline=((xline/hypline)*120)+150;
            yline=((yline/hypline)*120)+150;

            point2.setCenterX(xline);
            point2.setCenterY(yline);
            line2.setStartX(xline);
            line2.setStartY(yline);
            line1.setEndX(xline);
            line1.setEndY(yline);
            angle2.setX(xline-10);
            angle2.setY(yline+20);
            angle1.setText(calculateAngle(line2, line1, line3));
            angle2.setText(calculateAngle(line3, line1, line2));
            angle3.setText(calculateAngle(line1, line2, line3));
        });
        point3.setOnMouseDragged(e ->{
            double xline = e.getX()-150;
            double yline = e.getY()-150;
            double hypline = Math.sqrt(Math.pow(xline,2)+Math.pow(yline,2));

            xline=((xline/hypline)*120)+150;
            yline=((yline/hypline)*120)+150;

            point3.setCenterX(xline);
            point3.setCenterY(yline);
            line3.setStartX(xline);
            line3.setStartY(yline);
            line2.setEndX(xline);
            line2.setEndY(yline);
            angle3.setX(xline-10);
            angle3.setY(yline+20);
            angle1.setText(calculateAngle(line2, line1, line3));
            angle2.setText(calculateAngle(line3, line1, line2));
            angle3.setText(calculateAngle(line1, line2, line3));
        });

        //Used to create the scene using the pane window
        Scene scene = new Scene(window);
        stage.setTitle("Dragging Points on a Circle");

        stage.setScene(scene);

        stage.show();
    }
    //Seperate function in order to calculate the angle between 2 of the lines
    public String calculateAngle(Line l1, Line l2, Line l3){
        double x1 = l1.getEndX()-l1.getStartX();
        double y1 = l1.getEndY()-l1.getStartY();
        double hyp1 = Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2));

        double x2 = l2.getEndX()-l2.getStartX();
        double y2 = l2.getEndY()-l2.getStartY();
        double hyp2 = Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2));

        double x3 = l3.getEndX()-l3.getStartX();
        double y3 = l3.getEndY()-l3.getStartY();
        double hyp3 = Math.sqrt(Math.pow(x3,2)+Math.pow(y3,2));
        double ans = Math.acos((Math.pow(hyp1,2)-Math.pow(hyp2,2)-Math.pow(hyp3,2))/(-2*hyp2*hyp3));
        ans = Math.toDegrees(ans);
        return String.valueOf(Math.round(ans));
    }
}