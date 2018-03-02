import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage square;
    BufferedImage backBuffered;
    Graphics graphics;
    int pX;
    int pY;
    int squareX;
    int squareY;
    int vX;
    int vY;
    boolean hasX = false;
    boolean hasPositive = false;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);
        //Load Images
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        //Draw images
        //Phải "try" vì file có thể có 3 trường hợp: path sai, file ko tồn tại, file hỏng. Catch thì nó sẽ nhảy qua và không làm crash
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //draw shits out
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public boolean yBoundary(){
        if(this.squareY >= 600){
            return true;
        }
        return false;
    }

    public void generateSquares(){
        this.squareX = (int)(Math.random()*400);
        this.squareY = 0;
    }

    //move squares
    public void generateVector(){
        String[] moves = {"vX","vY"};
        int i = (int)(Math.random()*moves.length);
        if(moves[i].equalsIgnoreCase("vx"))
            hasX = true;
        int[] vectors = {5,-5};
        vX = vectors[i];
        vY = vectors[i];
        if(vX > 0 || vY > 0){
            hasPositive = true;
            vX = 5;
            vY = 5;
        }
    }

    //run squares
    public void moveVertically(){
        if (hasX){
            this.squareX += vX;
            this.squareY = 0;
        }
        if (!hasX){
            this.squareY += vY;
            this.squareX = 0;
        }
    }

    public void moveDiagonally(){
        this.squareX += vX;
        this.squareY += vY;
    }

    //bounce back when hit boundaries
    public void bounceBack(){
        if (this.squareX >= 400) vX = -5;
        else if (this.squareX <0) vX = 5;
//        if (this.squareY > 600) vY = -5;
//        if (this.squareY < 0) vY = 5;
    }

    public void renderAll(){
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.square, this.squareX,this.squareY, null);
        this.graphics.drawImage(this.player, this.pX, this.pY, null);
        this.repaint();
    }
}


