import base.GameObject;
import game.background.Background;
import game.enemy.bullet.EnemySpawner;
import game.player.Player;
import game.square.circle.SquareCircle;
import game.square.matrix.SquareMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
        this.setUpSquareMatrix();
        this.setUpSquareCircle();
//        base.GameObject.add(new game.square.SquareSpawner());
        GameObject.add(new EnemySpawner());

    }

    private void setUp(){
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setUpSquareCircle(){
        SquareCircle squareCircle = new SquareCircle();
        squareCircle.position.set(100,100);
        squareCircle.create();
        GameObject.add(squareCircle);
    }

    private void setUpSquareMatrix(){
        SquareMatrix squareMatrix = new SquareMatrix();
        squareMatrix.position.set(20,20);
        squareMatrix.velocity.set(3,0);
        squareMatrix.create();
        GameObject.add(squareMatrix);
    }

    private void setUpBackBuffered(){
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setPlayer(){
        this.player = new Player();
        this.player.position.set(200,300);
        GameObject.add(this.player);
    }

    private void setBackground(){
        //Phải "try" vì file có thể có 3 trường hợp: path sai, file ko tồn tại, file hỏng. Catch thì nó sẽ nhảy qua và không làm crash
        Background background = new Background();
        background.position.set(200,300);
        GameObject.add(background);
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


