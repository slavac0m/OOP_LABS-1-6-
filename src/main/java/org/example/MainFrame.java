package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Constants.FRAME_HIGH;
import static org.example.Constants.FRAME_WIDTH;

public class MainFrame extends JFrame {
    public MainFrame(String labVariant, JPanel figuresPanel, JPanel controlPanel) throws HeadlessException {
        setTitle("Лабораторная работа №"+labVariant);
        setSize(FRAME_WIDTH,FRAME_HIGH);
        setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(figuresPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }
}
