package game.enemy.bullet;

import base.FrameCounter;
import base.GameObject;
import game.enemy.Enemy;
import game.player.Player;
import game.square.bullet.SquareBullet;

public class EnemyShoot extends GameObject {
    private FrameCounter frameCounter = new FrameCounter(10);
    Player player = new Player();


    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            SquareBullet squareBullet = new SquareBullet();
            squareBullet.position.set(enemy.position);
            squareBullet.velocity.set(getPlayer().position.subtract(squareBullet.position).normalize());
//            System.out.println(getPlayer().position.getX() + "," + getPlayer().position.getY() + "," + squareBullet.position.getX() + "," + squareBullet.position.getY());
            GameObject.add(squareBullet);
        }
    }
}
