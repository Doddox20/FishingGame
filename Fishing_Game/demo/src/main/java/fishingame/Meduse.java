package fishingame;

public class Meduse extends Fish{

    public Meduse(int positionX, int positionY){
        super("meduse.png", positionX, positionY, 5, 1);
        this.Reward = 1;
        this.height = 300;
        this.width = 80;
    }

    @Override
    public void swimming(){
        if (this.getPositionX() < 0) {
            this.setPositionX(this.getPositionX() + getSpeed());
        }
        else {
            this.setPositionX(this.getPositionX() - getSpeed());
        }
    }
    @Override
    public void update(EventHandler eventHandler){   
    }

}