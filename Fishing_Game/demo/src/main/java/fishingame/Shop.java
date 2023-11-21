package fishingame;

import javafx.scene.control.Label;

public class Shop {
    private Player player;
    private Label moneyCount;
    protected int playerSpeedUpgradeCost = 75;

    public Shop(Player player, Label moneyCount) {
        this.player = player;
        this.moneyCount = moneyCount;
    }

    public void upgradePlayerSpeed() {
        if (App.banque >= playerSpeedUpgradeCost) {
            App.banque -= playerSpeedUpgradeCost;
            moneyCount.setText("Sousous: " + App.banque);


            player.increaseSpeed();
            playerSpeedUpgradeCost *= 2; 
        }
    }

    public void upgradePlayerHorizontal() {
        player.horizontal = true;
    }
}
