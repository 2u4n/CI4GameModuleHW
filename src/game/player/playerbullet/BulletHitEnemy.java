package game.player.playerbullet;

import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.square.Square;
import physics.BoxCollider;

public class BulletHitEnemy {
    public void run(PlayerBullet playerBullet){
        BoxCollider boxCollider = playerBullet.boxCollider;
        Enemy enemy = GameObjectManager.instance.checkCollisionEnemy(boxCollider);
        if(enemy != null){
            enemy.isAlive = false;
            playerBullet.getHitEnemy();
        }
    }
}
