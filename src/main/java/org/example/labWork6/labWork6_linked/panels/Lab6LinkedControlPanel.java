package org.example.labWork6.labWork6_linked.panels;

import org.example.labWork6.labWork6_linked.MyButton;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lab6LinkedControlPanel extends JPanel {

    public Lab6LinkedControlPanel(Lab6LinkedFiguresPanel lab6LinkedFiguresPanel) {

        MyButton createFigureButton = buildCreateButton(lab6LinkedFiguresPanel);
        MyButton moveButton = buildMoveButton(lab6LinkedFiguresPanel);

        MyButton visibleChangeButton = buildVisibleChangeButton(lab6LinkedFiguresPanel);
        MyButton deleteFigureButton = buildDeleteFigures(lab6LinkedFiguresPanel);

        JButton moveToOnePoint = new JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> lab6LinkedFiguresPanel.moveToObePoint());


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
                lab6LinkedFiguresPanel.moveFigures( diffX, diffY);
            }
        });
    }

    private MyButton buildMoveButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton moveFigureButton = new MyButton("Переместить", this);
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures());
        return moveFigureButton;
    }

    private MyButton buildVisibleChangeButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton visibleChangeButton = new MyButton("Изменить видимость", this);
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible());
        return visibleChangeButton;
    }

    private MyButton buildCreateButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton createFigureButton = new MyButton("Создать", this);
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList());
        return createFigureButton;
    }

   

    private MyButton buildDeleteFigures(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton deleteButton = new MyButton("Удалить", this);
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures());
        return deleteButton;
    }


   
}
