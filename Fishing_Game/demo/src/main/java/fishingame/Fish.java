package fishingame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Fish {

    protected Image spriteSheet;
    protected ImageView sprite;
    protected String filepath;
    protected int positionX;
    protected int positionY;
    protected int speed;
    protected int value;

    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
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
    }



    public abstract void update(EventHandler eventHandler);
}