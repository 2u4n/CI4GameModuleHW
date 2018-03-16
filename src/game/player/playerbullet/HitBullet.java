package game.player.playerbullet;

import base.GameObject;
import game.square.Square;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

public class HitBullet {
    public void run(PlayerBullet playerBullet){
        BoxCollider boxCollider = playerBullet.boxCollider;
        SquareBullet squareBullet = GameObject.checkCollisionSquareBullet(boxCollider);
        if(squareBullet != null){
            playerBullet.getHitSquareBullet();
        }
    }
}
