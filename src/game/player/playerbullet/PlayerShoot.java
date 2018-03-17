package game.player.playerbullet;

import base.GameObject;
import base.GameObjectManager;
import game.player.Player;

public class PlayerShoot {
    private int count = 0;

    public void run(Player player) {
        if (this.count >= 30) {
            PlayerBullet playerBullet = new PlayerBullet();
            playerBullet.position.set(player.position);
            playerBullet.velocity.set(0, -4);
            GameObjectManager.instance.add(playerBullet);
            this.count = 0;
        }
        else{
            this.count += 1;
        }
    }
}
