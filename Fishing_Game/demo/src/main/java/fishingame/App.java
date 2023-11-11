package fishingame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private Rectangle MenuPrincipal;
    private VBox buttonBox;
    private Label labelStartClick;

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
        Image backgroundImage = new Image("Plan.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setViewport(new Rectangle2D(0, 0, 1080, 720));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backgroundImageView);
        scene = new Scene(stackPane, 1080, 720);

        MenuPrincipal = new Rectangle(100, 100, 640, 360);
        ImagePattern pattern = new ImagePattern(new Image("Tableau.png"));
        MenuPrincipal.setFill(pattern);
        stage.setTitle("Fishing Supremacy");

        buttonBox = new VBox(20);
        buttonBox.setAlignment(Pos.CENTER);

        Button ButtonStart = createButton("Start.png");
        Button ButtonExit = createButton("Exit.png");

        setupButtonInteraction(ButtonStart);
        setupButtonInteraction(ButtonExit);

        labelStartClick = new Label("Press SPACE to Fish !");
        labelStartClick.setStyle("-fx-font-size: 50; -fx-text-fill: Black; -fx-font-weight: bold;");

        labelStartClick.setVisible(false);

        ButtonStart.setOnAction(event -> {
            MenuPrincipal.setVisible(false);
            buttonBox.setVisible(false);
            labelStartClick.toFront();
            labelStartClick.setVisible(true);

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(labelStartClick.visibleProperty(), false)),
                    new KeyFrame(Duration.seconds(1), new KeyValue(labelStartClick.visibleProperty(), true))
            );
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        });

        ButtonExit.setOnAction(event -> {
            stage.hide();
        });

        buttonBox.getChildren().addAll(ButtonStart, ButtonExit);
        stackPane.getChildren().addAll(MenuPrincipal, buttonBox, labelStartClick);

        stage.setScene(scene);
        stage.show();
        new EventHandler(this).pollEvents(scene);
    }

    public void handleKeyPressed(String text) {
        if ("ESCAPE".equals(text)) {
            MenuPrincipal.setVisible(true);
            buttonBox.setVisible(true);
            labelStartClick.toBack();
        }
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
