package fishingame;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Pane pane;

    private void setupButtonInteraction(Button button) {
    ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), button);

    button.setOnMouseEntered(event -> {
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.play();
    });

    button.setOnMouseExited(event -> {
        scaleTransition.setFromX(1.2);
        scaleTransition.setFromY(1.2);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    });
}

    @Override
    public void start(Stage stage) throws IOException {
        Image backgroundImage = new Image("background.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backgroundImageView);
        scene = new Scene(stackPane, 1280, 720);

        Rectangle MenuPrincipal = new Rectangle(100, 100, 640, 360);
        ImagePattern pattern = new ImagePattern(new Image("Tableau.png"));
        MenuPrincipal.setFill(pattern);
        stage.setTitle("Fishing Supremacy");

        

        VBox buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);

        Button ButtonStart = createButton("Start.png");
        Button ButtonExit = createButton("Exit.png");

        setupButtonInteraction(ButtonStart);
        setupButtonInteraction(ButtonExit);

        ButtonStart.setOnAction(event -> {
            MenuPrincipal.setVisible(false);
            buttonBox.setVisible(false);
        });

        ButtonExit.setOnAction(event -> {
            stage.hide();
        });

        buttonBox.getChildren().addAll(ButtonStart, ButtonExit);
        stackPane.getChildren().addAll(MenuPrincipal, buttonBox);



        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        Button button = new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;");

        return button;
    }

    public static void main(String[] args) {
        launch();
    }

}