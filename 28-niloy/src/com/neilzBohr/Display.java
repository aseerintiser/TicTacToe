package com.neilzBohr;

import javax.swing.*;

public class Display {
    JPanel jPanel;

    public Display(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    void show() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(jPanel);
        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
    }
}
