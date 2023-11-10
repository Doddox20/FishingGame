package fishingame;

import javafx.scene.Scene;

public class EventHandler {

    protected App app;
    protected Meduse meduse;

    public EventHandler(App app, Meduse meduse){
        this.meduse = meduse;
        this.app = app;
    }
    
    public void pollEvents(Scene scene){
        scene.setOnKeyPressed(event -> {
            app.handleKeyPressed(event.getText());
        });
        scene.setOnKeyReleased(event -> {
            app.handleKeyReleased(event.getText());
        });
    }
}
