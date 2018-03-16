package game.player.playerbullet;

import base.GameObject;
import game.enemy.Enemy;
import game.square.Square;
import physics.BoxCollider;

public class HitEnemy {
    public void run(PlayerBullet playerBullet){
        BoxCollider boxCollider = playerBullet.boxCollider;
        Enemy enemy = GameObject.checkCollisionEnemy(boxCollider);
        if(enemy != null){
            playerBullet.getHitEnemy();
        }
    }
}
