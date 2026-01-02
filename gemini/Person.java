package gemini;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Person extends JButton implements FocusListener {
    int x, y; // 逻辑坐标
    String name;

    public Person(String name, int x, int y, int w, int h, Container c) {
        super(name);
        this.name = name;
        this.x = x;
        this.y = y;
        c.add(this);
        this.addFocusListener(this);
        // 设置在界面上的物理位置（假设每个单元格 50 像素）
        setBounds(x * 50, y * 50, w * 50, h * 50);
    }

    // 获取焦点时改变颜色提示
    public void focusGained(FocusEvent e) {
        setBackground(Color.RED);
    }
    public void focusLost(FocusEvent e) {
        setBackground(Color.LIGHT_GRAY);
    }
}