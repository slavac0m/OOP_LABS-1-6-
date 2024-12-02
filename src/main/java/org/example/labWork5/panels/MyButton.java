package org.example.labWork5.panels;


public class MyButton extends javax.swing.JButton {
    public MyButton(String text, Lab5ControlPanel controlPanel) {
        super(text);
        addActionListener(e -> {
            controlPanel.requestFocus();
        });
    }
}
