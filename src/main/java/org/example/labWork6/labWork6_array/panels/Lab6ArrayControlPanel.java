package org.example.labWork6.labWork6_array.panels;

import org.example.labWork6.labWork6_array.MyButton;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lab6ArrayControlPanel extends JPanel {
    public Lab6ArrayControlPanel(Lab6ArrayFiguresPanel lab6ArrayFiguresPanel) {

        MyButton createFigureButton = buildCreateButton(lab6ArrayFiguresPanel);
        MyButton moveButton = buildMoveButton(lab6ArrayFiguresPanel);

        MyButton visibleChangeButton = buildVisibleChangeButton(lab6ArrayFiguresPanel);

        MyButton deleteFigureButton = buildDeleteFigures(lab6ArrayFiguresPanel);

        JButton moveToOnePoint = new JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> lab6ArrayFiguresPanel.moveToObePoint());

        add(visibleChangeButton);
        add(moveButton);
        add(createFigureButton);
        add(moveToOnePoint);
        add(deleteFigureButton);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int diffX = 0, diffY = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> diffY = -10;
                    case KeyEvent.VK_DOWN -> diffY = 10;
                    case KeyEvent.VK_LEFT -> diffX = -10;
                    case KeyEvent.VK_RIGHT -> diffX = 10;
                }
                lab6ArrayFiguresPanel.moveFigures(diffX, diffY);
            }
        });
    }

    private MyButton buildMoveButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton moveFigureButton = new MyButton("Переместить", this);
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures());
        return moveFigureButton;
    }

    private MyButton buildVisibleChangeButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton visibleChangeButton = new MyButton("Изменить видимость", this);
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible());
        return visibleChangeButton;
    }

    private MyButton buildCreateButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton createFigureButton = new MyButton("Создать", this);
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList());
        return createFigureButton;
    }


    private MyButton buildDeleteFigures(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton deleteButton = new MyButton("Удалить", this);
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures());
        return deleteButton;
    }

}
