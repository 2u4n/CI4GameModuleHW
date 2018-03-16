package game.player.playerbullet;

import base.GameObject;
import game.enemy.Enemy;
import game.square.Square;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

public class HitSquare {
    public void run(PlayerBullet playerBullet){
        BoxCollider boxCollider = playerBullet.boxCollider;
        Square square = GameObject.checkCollisionSquare(boxCollider);
        if(square != null){
            playerBullet.getHitSquare();
        }
    }
}