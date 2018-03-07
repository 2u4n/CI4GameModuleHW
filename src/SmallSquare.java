import java.awt.*;
import java.awt.image.BufferedImage;

public class SmallSquare {
    public BufferedImage image;
    public int x;
    public int y;
    public int dX;
    public int dY;

    public SmallSquare(BufferedImage image, int x, int y, int dX, int dY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.dX = dX;
        this.dY = dY;
    }

    public void run(){
        this.x += this.dX;
        this.y += this.dY;
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}





