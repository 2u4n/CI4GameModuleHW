package base;

import game.enemy.Enemy;
import game.player.Player;
import game.square.Square;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {

     public BufferedImage image;
     public Vector2D position;
     public boolean isAlive;

     //construct a vector object with x = 0, y = 0
     public GameObject(){
         this.isAlive = true;
         this.position = new Vector2D();
     }

     public void run() {

     }

     public void render(Graphics graphics) {
         if (this.image != null) {
             graphics.drawImage(this.image, (int)(this.position.x - this.image.getWidth()/2), (int)(this.position.y - this.image.getHeight()/2), null);
         }
     }



}

