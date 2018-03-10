import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareBullet extends GameObject{
    public int dX;
    public int dY;

    public SquareBullet(){
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
    }

    @Override
    public void run(){
        super.run();
        this.x += this.dX;
        this.y += this.dY;
    }
}
