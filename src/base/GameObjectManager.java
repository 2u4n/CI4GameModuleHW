package base;

import game.enemy.Enemy;
import game.player.Player;
import game.square.Square;
import game.square.bullet.SquareBullet;
import physics.BoxCollider;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {

    //instance is the object manager we can use anywhere and it's the only one
    public static GameObjectManager instance = new GameObjectManager();

    //Must only have one object manager
    //Therefore, we use Singleton

    //only construct it within the class
    private GameObjectManager(){
    }


    //manage game object
    private Vector<GameObject> vector = new Vector<>();
    private Vector<GameObject> temp = new Vector<>();

    public void runAll() {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.vector.addAll(temp);
        this.temp.clear();
    }

    public void renderAll(Graphics graphics) {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    //instance of checks for CLASS in a VECTOR, is a boolean
    //static = no need for object to work
    //filter is a loop and then states its condition after

    public Player getPlayer(){
        //this method goes through a vector and check for what we're looking for
        return (Player)
                this.vector.stream()//if we use filter or findfirst then we must use stream()
                        .filter(gameObject -> gameObject instanceof Player) //check for all conditions, actually just true or false
                        .findFirst() //get the first element
                        .orElse //if theres none then return null
                        (null);
    }

    public Square checkCollisionSquare(BoxCollider other){
        return (Square)
                this.vector.stream()
                        .filter(gameObject -> gameObject.isAlive)//check only alive squares
                        .filter(gameObject -> gameObject instanceof Square) //get all squares
                        .filter(gameObject -> {
                            BoxCollider boxCollider = ((Square) gameObject).boxCollider; //get box collider
                            return boxCollider.checkCollider(other); //get squares that are overlapping
                        })
                        .findFirst()
                        .orElse(null);
    }

    public Enemy checkCollisionEnemy(BoxCollider other2){
        return (Enemy)
                this.vector.stream()
                        .filter(gameObject -> gameObject.isAlive)//check only alive squares
                        .filter(gameObject -> gameObject instanceof Enemy) //get all squares
                        .filter(gameObject -> {
                            BoxCollider boxCollider = ((Enemy) gameObject).boxCollider; //get box collider
                            return boxCollider.checkCollider(other2); //get squares that are overlapping
                        })
                        .findFirst()
                        .orElse(null);
    }

    public SquareBullet checkCollisionSquareBullet(BoxCollider other){
        return (SquareBullet)
                this.vector.stream()
                        .filter(gameObject -> gameObject.isAlive)
                        .filter(gameObject -> gameObject instanceof SquareBullet) //get all squares
                        .filter((GameObject gameObject) -> {
                            BoxCollider boxCollider = ((SquareBullet) gameObject).boxCollider; //get box collider
                            return boxCollider.checkCollider(other); //get squares that are overlapping
                        })
                        .findFirst()
                        .orElse(null);
    }

    public void add(GameObject gameObject) {
        this.temp.add(gameObject);
    }
}
