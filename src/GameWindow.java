import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow(){
        this.setUp();
        this.setGameCanvas();
        this.mouseListen();
    }

    private void setUp(){
        this.setSize(400,600);
        this.setVisible(true);
    }

    private void setGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void mouseListen(){
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() < 320 && e.getY() < 520){
                    gameCanvas.player.x = e.getX();
                    gameCanvas.player.y = e.getY();
                }
                if (e.getX() >= 320){
                    gameCanvas.player.x = 320;
                    gameCanvas.player.y = e.getY();
                }
                if (e.getY() >= 520){
                    gameCanvas.player.x = e.getX();
                    gameCanvas.player.y = 520;
                }
                if (e.getX() >= 320 && e.getY() >= 520){
                    gameCanvas.player.x = 320;
                    gameCanvas.player.y = 520;
                }
            }
        });
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
//                this.gameCanvas.moveVertically();
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
//                this.gameCanvas.bounceBack();
                lastTime = currentTime;
//                if (this.gameCanvas.yBoundary())this.gameCanvas.generateSquares();
            }
        }
    }
}
