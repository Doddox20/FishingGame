package fishingame;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

    protected Image spriteSheet;
    protected ImageView sprite;
    protected int positionX;
    protected int positionY;
    protected int speed;
    protected int width;
    protected int height;

    public int getPositionX(){
        return positionX;
    }
    public int getPositionY(){
        return positionY;
    }
    public int getSpeed() {
        return speed;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void setPositionX(int positionX){
        sprite.setTranslateX(positionX);
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        sprite.setTranslateY(positionY);
        this.positionY = positionY;
    }

    public Player(int speed) {
        spriteSheet = new Image("hamecon.png");
        sprite = new ImageView(spriteSheet);
        sprite.setVisible(false);
        sprite.setTranslateX(16);
        sprite.setTranslateY(180);
        this.speed = speed;
        this.width = 50;
        this.height = 150;
    }

    

    public void update(EventHandler eventHandler){
    }
    
    public Bounds getBounds() {
        return sprite.getBoundsInParent();
    }
}
