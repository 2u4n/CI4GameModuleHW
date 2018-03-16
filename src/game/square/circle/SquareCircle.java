package game.square.circle;

import base.GameObject;
import base.Vector2D;
import game.square.Square;

import java.util.Vector;

public class SquareCircle extends GameObject {
    private Vector<Square> squares = new Vector<>();
    public Vector2D velocity = new Vector2D();
    private int count = 0;

    public SquareCircle(){

    }

    public void create(){
        for (double angle = 0.0; angle < 360.0 ; angle += 360.0/15) {
            Square square = new Square();
            //below is the OG vector
            Vector2D vector2D = new Vector2D(0, 80);
            Vector2D rotate = vector2D.rotate(angle);
            //change the vector position below
            square.position.set(rotate).addUp(100,100);
            square.velocity.set(this.velocity);
            this.squares.add(square);
            GameObject.add(square);
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.position.x <= 100) {
            this.count = 0;
            this.velocity.set(1, 1);
        }
        if (this.position.x >= (400 - 100)) {
            this.count = 0;
            this.velocity.set(-1, 1);
        }
        this.position.addUp(this.velocity);
        this.squares.forEach(square -> square.velocity.set(velocity));
    }
}
