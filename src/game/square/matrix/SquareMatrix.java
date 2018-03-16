package game.square.matrix;

import base.GameObject;
import base.Vector2D;
import game.square.Square;

import java.util.Vector;

public class SquareMatrix extends GameObject {

    private Vector<Square> squares = new Vector<>();
    public Vector2D velocity = new Vector2D();
    private int count = 0;

    public void create(){
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                Square square = new Square();
                square.position.set(this.position.add(j * (20 + 20), i * (20 + 20)));
                square.velocity.set(this.velocity);
                this.squares.add(square);
                GameObject.add(square);
            }
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.position.x <= 0) {
            //delay cho nó ko đập lại rồi cho nó rơi xuống
            if(this.count >= 10){
                this.count = 0;
                this.velocity.set(3, 0);
            }else{
                this.velocity.set(0, 3);
                this.count += 1;
            }
        }
        if ( this.position.x >= (400 - 5*20 - 4*20)){
            if(this.count >= 10){
                this.count = 0;
                this.velocity.set(-3, 0);
            }else{
                this.velocity.set(0, 3);
                this.count += 1;
            }
        }
        this.position.addUp(this.velocity);
        this.squares.forEach(square -> square.velocity.set(velocity));
    }
}
