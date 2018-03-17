package game.player;

import base.GameObject;
import base.GameObjectManager;
import game.player.playerbullet.PlayerBullet;
import game.square.Square;
import physics.BoxCollider;

public class PlayerHitSquare {
    public void run(Player player){
        BoxCollider boxCollider = player.boxCollider;
        Square square = GameObjectManager.instance.checkCollisionSquare(boxCollider);
        if(square != null){
            square.isAlive = false;
            player.getHitSquare();
        }
    }
}
