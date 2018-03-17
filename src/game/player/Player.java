package game.player;

import base.GameObject;
import game.player.playerbullet.BulletHitBullet;
import game.player.playerbullet.BulletHitEnemy;
import game.player.playerbullet.BulletHitSquare;
import game.player.playerbullet.PlayerShoot;
import input.MouseMotionInput;
import physics.BoxCollider;
import utils.Utils;

public class Player extends GameObject {

    private PlayerShoot playerShoot;

    public BoxCollider boxCollider;
    private PlayerHitSquare hitSquare;
    private PlayerHitEnemy hitEnemy;
    private PlayerHitBullet hitBullet;


    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(40,40);
        this.hitSquare = new PlayerHitSquare();
        this.hitEnemy = new PlayerHitEnemy();
        this.hitBullet = new PlayerHitBullet();
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        this.position.set(MouseMotionInput.instance.position);//fix the conditions that limit the player
        this.boxCollider.position.set(this.position); //put hit box on bullet
        this.hitSquare.run(this);
        this.hitEnemy.run(this);
        this.hitBullet.run(this);
    }

    public void getHitSquare() {
        System.out.println("Player Hit Square");
    }

    public void getHitEnemy() {
        System.out.println("Player Hit Enemy");
    }

    public void getHitSquareBullet() {
        System.out.println("Player Hit Enemy Bullet");
    }
}
