package game.player.playerbullet;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import utils.Utils;

public class PlayerBullet extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private BulletHitSquare bulletHitSquare;
    private BulletHitEnemy bulletHitEnemy;
    private BulletHitBullet bulletHitBullet;

    public PlayerBullet(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.bulletHitSquare = new BulletHitSquare();
        this.bulletHitEnemy = new BulletHitEnemy();
        this.bulletHitBullet = new BulletHitBullet();
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position); //put hit box on bullet
        this.bulletHitSquare.run(this);
        this.bulletHitEnemy.run(this);
        this.bulletHitBullet.run(this);
    }

    public void getHitSquare() {
        System.out.println("Bullet Hit Square");
    }

    public void getHitEnemy() {
        System.out.println("Bullet Hit Enemy");
    }

    public void getHitSquareBullet() {
        System.out.println("Bullet Hit Enemy Bullet");
    }
}
