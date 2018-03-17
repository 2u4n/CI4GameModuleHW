package game.player.playerbullet;

import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.square.Square;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

public class BulletHitSquare {
    public void run(PlayerBullet playerBullet){
        BoxCollider boxCollider = playerBullet.boxCollider;
        Square square = GameObjectManager.instance.checkCollisionSquare(boxCollider);
        if(square != null){
            square.isAlive = false;
            playerBullet.getHitSquare();
        }
    }
}
