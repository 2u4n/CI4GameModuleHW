package game.player.playerbullet;

import base.GameObject;
import game.player.Player;

public class PlayerShoot {
    private int count = 0;

    public void run(Player player) {
        if (this.count >= 100) {
            PlayerBullet playerBullet = new PlayerBullet();
            playerBullet.position.set(player.position);
            playerBullet.velocity.set(0, -4);
            GameObject.add(playerBullet);
        }
        else{
            this.count += 1;
        }
    }
}
