package org.example.labWork6.labWork6_linked.panels;

import org.example.Constants.FigureType;
import org.example.labWork6.labWork6_linked.MyButton;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Lab6LinkedControlPanel extends JPanel {
    JComboBox<String> figureType = new JComboBox<>(FigureType.getNames());

    public Lab6LinkedControlPanel(Lab6LinkedFiguresPanel lab6LinkedFiguresPanel) {
        figureType.addActionListener(e -> this.requestFocus());
        
        MyButton createFigureButton = buildCreateButton(lab6LinkedFiguresPanel);
        MyButton moveButton = buildMoveButton(lab6LinkedFiguresPanel);

        MyButton visibleChangeButton = buildVisibleChangeButton(lab6LinkedFiguresPanel);
        MyButton resizeButton = buildResizeButton(lab6LinkedFiguresPanel);
        MyButton rotateEllipseButton = buildRotateEllipse(lab6LinkedFiguresPanel);


        MyButton deleteFigureButton = buildDeleteFigures(lab6LinkedFiguresPanel);

        JButton moveToOnePoint = new JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> lab6LinkedFiguresPanel.moveToObePoint(getFiguresTypesSelectedItem()));


        add(figureType);
        add(visibleChangeButton);
        add(moveButton);
        add(createFigureButton);
        add(resizeButton);
        add(rotateEllipseButton);
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
                lab6LinkedFiguresPanel.moveFigures(getFiguresTypesSelectedItem(), diffX, diffY);
            }
        });
    }

    private MyButton buildMoveButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton moveFigureButton = new MyButton("Переместить", this);
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures(getFiguresTypesSelectedItem()));
        return moveFigureButton;
    }

    private MyButton buildVisibleChangeButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton visibleChangeButton = new MyButton("Изменить видимость", this);
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible(getFiguresTypesSelectedItem()));
        return visibleChangeButton;
    }

    private MyButton buildCreateButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton createFigureButton = new MyButton("Создать", this);
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList(getFiguresTypesSelectedItem()));
        return createFigureButton;
    }

    private MyButton buildResizeButton(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton resizeButton = new MyButton("Изменить размер", this);
        resizeButton.addActionListener(e -> figuresPanel.resizeFigures(getFiguresTypesSelectedItem()));
        return resizeButton;
    }

    private MyButton buildRotateEllipse(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton rotateEllipse = new MyButton("Повернуть эллипс", this);

        rotateEllipse.addActionListener(e -> figuresPanel.rotateEllipse());

        return rotateEllipse;
    }

    private MyButton buildDeleteFigures(Lab6LinkedFiguresPanel figuresPanel) {
        MyButton deleteButton = new MyButton("Удалить", this);
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures(getFiguresTypesSelectedItem()));
        return deleteButton;
    }


    public FigureType getFiguresTypesSelectedItem() {
        return FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
    }
}
