package game.player.playerbullet;

import base.GameObject;
import base.Vector2D;
import physics.BoxCollider;
import utils.Utils;

public class PlayerBullet extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitSquare hitSquare;

    public PlayerBullet(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
        this.hitSquare = new HitSquare();
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position); //put hit box on bullet
        this.hitSquare.run(this);
    }

    public void getHit() {
        System.out.println("Hit");
    }
}
