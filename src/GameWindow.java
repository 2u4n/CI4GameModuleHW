import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow(){
        this.setSize(400,600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.gameCanvas.generateVector();
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.pX = e.getX();
                gameCanvas.pY = e.getY();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.setVisible(true);
    }

    public void gameLoop(){

        while(true){
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 17_000_000){
                this.gameCanvas.run();
                this.gameCanvas.renderAll();
                this.gameCanvas.bounceBack();
                lastTime = currentTime;
            }
        }
    }
}
