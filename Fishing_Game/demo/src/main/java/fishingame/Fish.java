package fishingame;

import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public abstract class Fish {

    protected Image spriteSheet;
    protected ImageView sprite;
    protected String filepath;
    protected int positionX;
    protected int positionY;
    protected int speed;
    protected int value;
    protected AnimationTimer timer;
    protected int Reward;
    protected int width;
    protected int height;

    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
    }
    public int getSpeed(){
        return speed;
    }

    public int getReward() {
        return Reward;
    }
    public void setPositionX(int positionX){
        sprite.setTranslateX(positionX);
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        sprite.setTranslateY(positionY);
        this.positionY = positionY;
    }

    public Fish(String filepath, int positionX, int positionY, int speed, int value) {
        spriteSheet = new Image(filepath);
        sprite = new ImageView(spriteSheet);
        sprite.setTranslateX(positionX);
        sprite.setTranslateY(positionY);
        this.speed = speed;
        this.value = value;
        sprite.setUserData(this);
        timer = new AnimationTimer() {
            public void handle(long now){
                swimming();
            }
        };
    }

    public void handleKeyPressed(KeyCode keycode){
        switch(keycode) {
            case SPACE:
                System.out.println("Timer is running!");
                timer.start();
                break;
            case ESCAPE:
                System.out.println("Timer stopped!");
                timer.stop();
                break;
        }
    }
    public Bounds getBounds() {
        return sprite.getBoundsInParent();
    }
    

    public abstract void swimming();

    public int getWidth(){
        return width;
    }

    public  int getHeight(){
        return height;
    }

    

    public void update(EventHandler eventHandler) {
        swimming();
    }
    
}