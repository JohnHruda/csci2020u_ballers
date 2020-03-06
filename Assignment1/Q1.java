import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Q1 extends Application {

    //Simple method for returning a random number within a certain range
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Creates the three images
        Image image1;
        Image image2;
        Image image3;
        //Checks to make sure the images are not the same, so the same card isn't drawn
        do {
            image1 = new Image(new FileInputStream("C:\\Users\\johnn\\Documents\\School\\Second Year\\Software Systems\\Cards\\Cards\\" + String.valueOf(getRandomNumberInRange(1, 54)) + ".png"));
            image2 = new Image(new FileInputStream("C:\\Users\\johnn\\Documents\\School\\Second Year\\Software Systems\\Cards\\Cards\\" + String.valueOf(getRandomNumberInRange(1, 54)) + ".png"));
            image3 = new Image(new FileInputStream("C:\\Users\\johnn\\Documents\\School\\Second Year\\Software Systems\\Cards\\Cards\\" + String.valueOf(getRandomNumberInRange(1, 54)) + ".png"));

        } while (String.valueOf(image1) == String.valueOf(image2) && String.valueOf(image1) == String.valueOf(image3) && String.valueOf(image2) == String.valueOf(image3));

        //Sets the imageview and details for each of the 3 images
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(50);
        imageView1.setY(25);
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(150);

        ImageView imageView2 = new ImageView(image2);
        imageView1.setX(200);
        imageView1.setY(25);
        imageView1.setFitHeight(150);
        imageView1.setFitWidth(150);

        ImageView imageView3 = new ImageView(image3);
        imageView3.setX(350);
        imageView3.setY(25);
        imageView3.setFitHeight(150);
        imageView3.setFitWidth(150);

        imageView1.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);
        imageView3.setPreserveRatio(true);

        //Puts everything into a group and adds it to the scene to display
        Group root = new Group(imageView1, imageView2, imageView3);
        Scene scene = new Scene(root, 600, 200);
        stage.setTitle("Displaying 3 Random Cards");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]) {
        launch(args);
    }
}