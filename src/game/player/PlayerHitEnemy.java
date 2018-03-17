package game.player;

import base.GameObject;
import base.GameObjectManager;
import game.enemy.Enemy;
import game.player.playerbullet.PlayerBullet;
import physics.BoxCollider;

public class PlayerHitEnemy {
    public void run(Player player){
        BoxCollider boxCollider = player.boxCollider;
        Enemy enemy = GameObjectManager.instance.checkCollisionEnemy(boxCollider);
        if(enemy != null){
            enemy.isAlive = false;
            player.getHitEnemy();
        }
    }
}
