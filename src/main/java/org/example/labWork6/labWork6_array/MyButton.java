package org.example.labWork6.labWork6_array;


import org.example.labWork6.labWork6_array.panels.Lab6ArrayControlPanel;

public class MyButton extends javax.swing.JButton {
    public MyButton(String text, Lab6ArrayControlPanel controlPanel) {
        super(text);
        addActionListener(e -> {
            controlPanel.requestFocus();
        });
    }
}
