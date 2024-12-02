package org.example.labWork6.labWork6_linked;


import org.example.labWork6.labWork6_linked.panels.Lab6LinkedControlPanel;

public class MyButton extends javax.swing.JButton {
    public MyButton(String text, Lab6LinkedControlPanel controlPanel) {
        super(text);
        addActionListener(e -> {
            controlPanel.requestFocus();
        });
    }
}
