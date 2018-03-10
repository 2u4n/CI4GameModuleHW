import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class GameCanvas extends JPanel {

    Player player;
    BufferedImage backBuffered;
    Graphics graphics;

    int countBullet = 0;

    public GameCanvas() {
        this.setUp();
        this.setUpBackBuffered();
        this.setBackground();
        this.setPlayer();
        GameObject.add(new SquareSpawner());
        GameObject.add(new EnemySpawner());
    }

    private void setUp(){
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setUpBackBuffered(){
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setPlayer(){
        this.player = new Player();
        this.player.x = 200;
        this.player.y = 300;
        GameObject.add(this.player);
    }

    private void setBackground(){
        //Phải "try" vì file có thể có 3 trường hợp: path sai, file ko tồn tại, file hỏng. Catch thì nó sẽ nhảy qua và không làm crash
        GameObject.add(new Background());
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll(){
        GameObject.runAll();
    }

    public void renderAll(){
        GameObject.renderAll(this.graphics);
        this.repaint();
    }
}


