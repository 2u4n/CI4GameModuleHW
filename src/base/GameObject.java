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

     private static Vector<GameObject> vector = new Vector<>();
     private static Vector<GameObject> temp = new Vector<>();

     public static void runAll() {
         vector
                 .stream()
                 .filter(gameObject -> gameObject.isAlive)
                 .forEach(gameObject -> gameObject.run());
         vector.addAll(temp);
         temp.clear();
     }

     //construct a vector object with x = 0, y = 0
     public GameObject(){
         this.isAlive = true;
         this.position = new Vector2D();
     }

     public static void renderAll(Graphics graphics) {
         vector
                 .stream()
                 .filter(gameObject -> gameObject.isAlive)
                 .forEach(gameObject -> gameObject.render(graphics));
     }

     public static void add(GameObject gameObject) {
         temp.add(gameObject);
     }

     public void run() {

     }

     public void render(Graphics graphics) {
         if (this.image != null) {
             graphics.drawImage(this.image, (int)(this.position.x - this.image.getWidth()/2), (int)(this.position.y - this.image.getHeight()/2), null);
         }
     }

     //instance of checks for CLASS in a VECTOR, is a boolean
    //static = no need for object to work
    //filter is a loop and then states its condition after
     public static Player getPlayer(){
         //this method goes through a vector and check for what we're looking for
         return (Player)
                 vector.stream()//if we use filter or findfirst then we must use stream()
                         .filter(gameObject -> gameObject instanceof Player) //check for all conditions, actually just true or false
                         .findFirst() //get the first element
                         .orElse //if theres none then return null
                                 (null);
     }

     public static Square checkCollisionSquare(BoxCollider other){
         return (Square)
                 vector.stream()
                         .filter(gameObject -> gameObject.isAlive)//check only alive squares
                         .filter(gameObject -> gameObject instanceof Square) //get all squares
                         .filter(gameObject -> {
                             BoxCollider boxCollider = ((Square) gameObject).boxCollider; //get box collider
                             return boxCollider.checkCollider(other); //get squares that are overlapping
                         })
                         .findFirst()
                         .orElse(null);
     }

    public static Enemy checkCollisionEnemy(BoxCollider other2){
        return (Enemy)
                vector.stream()
                        .filter(gameObject -> gameObject.isAlive)//check only alive squares
                        .filter(gameObject -> gameObject instanceof Enemy) //get all squares
                        .filter(gameObject -> {
                            BoxCollider boxCollider = ((Enemy) gameObject).boxCollider; //get box collider
                            return boxCollider.checkCollider(other2); //get squares that are overlapping
                        })
                        .findFirst()
                        .orElse(null);
    }

//    public static SquareBullet checkCollisionSquareBullet(BoxCollider other){
//        return (SquareBullet)
//                vector.stream()
//                        .filter(gameObject -> gameObject instanceof SquareBullet) //get all squares
//                        .filter((GameObject gameObject) -> {
//                            BoxCollider boxCollider = ((Enemy) gameObject).boxCollider; //get box collider
//                            return boxCollider.checkCollider(other); //get squares that are overlapping
//                        })
//                        .findFirst()
//                        .orElse(null);
//    }
}

