import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class MediumSquare extends JPanel {
    public BufferedImage image;
//    public BufferedImage image2;
    public int x;
    public int y;
    public int dX;
    public int dY;
    public int countSquare;
//    Vector<SquareBullet> squareBulletVector;
//    private int countSquare;

    public MediumSquare(BufferedImage image, int x, int y, int dX, int dY) {
        this.image = image;
//        this.image2 = image2;
        this.x = x;
        this.y = y;
        this.dX = dX;
        this.dY = dY;
//        this.squareBulletVector = new Vector<>();
//        this.generateBullet();
    }

    public void run(){
        this.x += this.dX;
        this.y += this.dY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

//    public void shoot(){
//        this.squareBulletVector.forEach(squareBullet -> squareBullet.shoot());
//    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, null);
//        graphics.drawImage(this.image2, this.x, this.y += 5, null);
    }

}





