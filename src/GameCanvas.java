import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage background;
    Player player;
    Vector<Bullet> bulletVector;
    Vector<SquareBullet> squareBulletVector;
    MediumSquare mediumSquare;
    Vector<SmallSquare> smallSquareVector;
    BufferedImage backBuffered;
    Graphics graphics;
    int countSquare;
    boolean mediumSquareBottomCheck = false;

    public GameCanvas() {
        this.setUp();
        this.setUpBackBuffered();
        this.setBackground();
        this.setPlayer();
        this.setMediumSquare();
        this.bulletVector = new Vector<>();
        this.squareBulletVector = new Vector<>();
        this.smallSquareVector = new Vector<>();
//        this.mediumSquareVector = new Vector<>();
    }

    private void setUpBackBuffered(){
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setUp(){
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setBackground(){
        //Phải "try" vì file có thể có 3 trường hợp: path sai, file ko tồn tại, file hỏng. Catch thì nó sẽ nhảy qua và không làm crash
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayer(){
        try {
            this.player = new Player(ImageIO.read(new File("resources/player/straight.png")),0,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //draw shits out
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll(){
        this.generateSquare();
        this.generateBullet();
        this.generateSquareBullet();
        this.mediumSquare.run();
        this.squareRun();
        this.bulletShoot();
        this.squareBulletShoot();
//        randomX = (int)(Math.random()*400);
    }

    public void generateSquare(){
        if(this.countSquare >= 30){
            try {
                SmallSquare smallSquare = new SmallSquare(ImageIO.read(new File("resources/square/enemy_square_small.png")),(int)(Math.random()*400),0, 0,5);
                this.smallSquareVector.add(smallSquare);
                this.countSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            this.countSquare += 1;
        }
    }

    private void setMediumSquare(){
        try {
            this.mediumSquare = new MediumSquare(ImageIO.read(new File("resources/square/enemy_square_medium.png")), 10,0, 0,1);
//               this.mediumSquareVector.add(mediumSquare);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void squareRun(){
        this.smallSquareVector.forEach(smallSquare -> smallSquare.run());
//        this.mediumSquareVector.forEach(mediumSquare -> mediumSquare.run());
    }

    public void generateBullet(){
        if(this.countSquare >= 30){
            try {
                Bullet bullet = new Bullet(ImageIO.read(new File("resources/player/player_bullet.png")),player.x + 20,player.y, 0,-5);
                this.bulletVector.add(bullet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            this.countSquare += 1;
        }
    }

    public void generateSquareBullet(){
        if(this.countSquare >= 30){
            try {
                SquareBullet squareBullet = new SquareBullet(ImageIO.read(new File("resources/square/enemy_square_bullet.png")),mediumSquare.x + 15,mediumSquare.y ,0,10);
                this.squareBulletVector.add(squareBullet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            this.countSquare += 1;
        }
    }

    private void bulletShoot(){
        this.bulletVector.forEach(bullet -> bullet.shoot());
    }
//
    private void squareBulletShoot(){
        this.squareBulletVector.forEach(squareBullet -> squareBullet.shoot());
    }

    public void renderAll(){
        this.graphics.drawImage(this.background, 0, 0, null);
        this.smallSquareVector.forEach(smallSquare -> smallSquare.render(graphics));
        this.mediumSquare.render(graphics);
        this.squareBulletVector.forEach(squareBullet -> squareBullet.render(graphics));
        this.bulletVector.forEach(bullet -> bullet.render(graphics));
        this.player.render(graphics);
        this.repaint();
    }
}


