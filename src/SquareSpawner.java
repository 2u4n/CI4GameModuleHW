import java.util.Random;

public class SquareSpawner extends GameObject{
    private int count = 0;
    private Random random = new Random();
    private boolean hitWall = false;

    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 30) {
            Square square = new Square();
            square.x = 0;
            square.dX = 5;
            square.dY = 5;
            GameObject.add(square);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
