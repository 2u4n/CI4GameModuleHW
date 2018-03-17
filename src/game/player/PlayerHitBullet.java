package game.player;

import base.GameObject;
import base.GameObjectManager;
import game.player.playerbullet.PlayerBullet;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

public class PlayerHitBullet {
    public void run(Player player){
        BoxCollider boxCollider = player.boxCollider;
        SquareBullet squareBullet = GameObjectManager.instance.checkCollisionSquareBullet(boxCollider);
        if(squareBullet != null){
            squareBullet.isAlive = false;
            player.getHitSquareBullet();
        }
    }
}
