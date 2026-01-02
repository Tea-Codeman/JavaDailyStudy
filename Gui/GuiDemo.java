package Java.Gui;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GuiDemo {

    public static void main(String[] args) {
        //快速入门GUI编程，用Swing来实现GUI
        
        //AI帮我写一个简单的GUI程序
        //创建一个窗口
        JFrame window = new JFrame("GUI Demo");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //创建一个按钮
        JButton button = new JButton("Click me!");
        
        //将按钮添加到窗口
        window.getContentPane().add(button);
        
        //设置窗口可见
        window.pack();
        window.setVisible(true);
        
    }

}
