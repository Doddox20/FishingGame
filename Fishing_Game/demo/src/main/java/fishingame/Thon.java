package fishingame;

public class Thon extends Fish{

    public Thon(int positionX, int positionY){
        super("Thon.png", positionX, positionY, 5, 25);
        this.Reward = 10;
    }

    @Override
    public void update(EventHandler eventHandler){   
    }

    @Override
    public void swimming() {
        
        if (this.getPositionX() < 0) {
            this.setPositionX(this.getPositionX() + getSpeed());
        }
        else {
            this.setPositionX(this.getPositionX() - getSpeed());
        }
    }
}
