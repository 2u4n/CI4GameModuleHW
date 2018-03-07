import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    int x;
    int y;
    int dX;
    int dY;
    public BufferedImage image;

    public Bullet(BufferedImage image,int x, int y, int dX, int dY){
        this.image = image;
        this.x = x;
        this.y = y;
        this.dX = dX;
        this.dY = dY;
    }

    public void shoot(){
        this.x += this.dX;
        this.y += this.dY;
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x, this.y, null);
    }
}
