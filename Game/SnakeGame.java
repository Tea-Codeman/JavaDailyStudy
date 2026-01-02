package Java.Game;
import javax.swing.JFrame;
public class SnakeGame extends JFrame {
    
    public SnakeGame() {
        this.add(new GamePanel());
        this.setTitle("Java 贪吃蛇");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null); // 居中显示
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}

