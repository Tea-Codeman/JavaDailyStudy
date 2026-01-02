package com.itheima;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
    private static final String imagePath = "Java/stone-maze/src/image/";
    private int[][] imageData = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 0 }
    };

    public MainFrame() {
        // 初始化窗口
        initFrame();
        initImage();
        this.setVisible(true);
    }

    public void initFrame() {
        this.setTitle("石子迷宫");
        this.setSize(425, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }

    public void initImage() {
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                String imageName = imageData[i][j] + ".png";
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imagePath + imageName));
                label.setBounds(j * 100, i * 100, 100, 100);
                this.add(label);
            }
        }
    }
}
