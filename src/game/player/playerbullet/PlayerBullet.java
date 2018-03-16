package game.player.playerbullet;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import utils.Utils;

public class PlayerBullet extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;
    private HitEnemy hitEnemy;
    private HitBullet hitBullet;

    public PlayerBullet(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.hitSquare = new HitSquare();
        this.hitEnemy = new HitEnemy();
        this.hitBullet = new HitBullet();
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position); //put hit box on bullet
        this.hitSquare.run(this);
        this.hitEnemy.run(this);
        this.hitBullet.run(this);
    }

    public void getHitSquare() {
        System.out.println("Hit Square");
    }

    public void getHitEnemy() {
        System.out.println("Hit Enemy");
    }

    public void getHitSquareBullet() {
        System.out.println("Hit Enemy Bullet");
    }
}
