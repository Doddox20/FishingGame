package fishingame;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
    private Player player;
    private EventHandler eventHandler;

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
<<<<<<< HEAD
        Image backgroundImage = new Image("Plan.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setViewport(new Rectangle2D(0, 0, 1080, 720));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backgroundImageView);
        scene = new Scene(stackPane, 1080, 720);
=======
        Image backgroundImage = new Image("background.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setViewport(new Rectangle2D(0, 0, 1024, 720));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(backgroundImageView);
        scene = new Scene(stackPane, 1024, 720);
>>>>>>> 8c608bdb8bd89696339b854ff97bcfbbe46cd71f

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

        this.player = new Player(5);
        stackPane.getChildren().add(player.sprite);
        this.eventHandler = new EventHandler(this, player);

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

        eventHandler.pollEvents(scene);
    }

    private Button createButton(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        Button button = new Button();
        button.setGraphic(imageView);
        button.setStyle("-fx-background-color: transparent;");

        return button;
    }

    public void handleKeyPressed(KeyCode keycode){
        switch(keycode) {
            case ESCAPE:
                MenuPrincipal.setVisible(true);
                buttonBox.setVisible(true);
                labelStartClick.toBack();
                break;
            case Q:
                player.setPositionX(player.getPositionX() - player.getSpeed());
                break;
            case D:
                player.setPositionX(player.getPositionX() + player.getSpeed());
                break;
            case SPACE:
                AnimationTimer timer = new AnimationTimer() {
                    public void handle(long now) {
                        player.setPositionY(player.getPositionY() + 1);
                    }
                };
                timer.start();
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void update() {
        player.update(eventHandler);
    }

}
