import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;
    public String name;

    public GameWindow(){
        this.setUp();
        this.setGameCanvas();
        this.mouseMotionListener();
        this.setVisible(true);
    }

    private void setUp(){
        this.setSize(400,600);
    }

    private void setGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void listener() {
        this.mouseMotionListener();
        this.windowListener();
    }

    private void mouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() < (400 - 40) && e.getY() < (600 - 40)) {
                    gameCanvas.player.x = e.getX();
                    gameCanvas.player.y = e.getY();
                }
                if (e.getX() >= (400 - 40)) {
                    gameCanvas.player.x = (400 - 40);
                    gameCanvas.player.y = e.getY();
                }
                if (e.getY() >= (600 - 40)) {
                    gameCanvas.player.x = e.getX();
                    gameCanvas.player.y = (600 - 40);
                }
                if (e.getX() >= (400 - 40) && e.getY() >= (600 - 40)) {
                    gameCanvas.player.x = (400 - 40);
                    gameCanvas.player.y = (600 - 40);
                }
            }
        });
    }

    private void windowListener(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
