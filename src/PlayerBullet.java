import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    int dX;
    int dY;

    public PlayerBullet(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
    }

    @Override
    public void run(){
        super.run();
        this.x += this.dX;
        this.y += this.dY;
    }
}
