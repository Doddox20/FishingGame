package fishingame;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class EventHandler {

    protected App app;

    public EventHandler(App app){
        this.app = app;
    }
    
    public void pollEvents(Scene scene){
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                app.handleKeyPressed("ESCAPE");
            }
        });
    }
}
