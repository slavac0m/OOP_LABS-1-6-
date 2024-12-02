package org.example.labWork5.panels;

import org.example.Constants.FigureType;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Lab5ControlPanel extends JPanel {
    JComboBox<String> figureType = new JComboBox<>(FigureType.getNames());

    public Lab5ControlPanel(Lab5FiguresPanel lab5FiguresPanel) {
        figureType.addActionListener(e -> this.requestFocus());

        MyButton createFigureButton = buildCreateButton(lab5FiguresPanel);
        MyButton moveButton = buildMoveButton(lab5FiguresPanel);

        MyButton visibleChangeButton = buildVisibleChangeButton(lab5FiguresPanel);
        MyButton resizeButton = buildResizeButton(lab5FiguresPanel);
        MyButton rotateEllipseButton = buildRotateEllipse(lab5FiguresPanel);


        MyButton deleteFigureButton = buildDeleteFigures(lab5FiguresPanel);

        JButton moveToOnePoint = new JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> lab5FiguresPanel.moveToObePoint(getFiguresTypesSelectedItem()));


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
                lab5FiguresPanel.moveFigures(getFiguresTypesSelectedItem(), diffX, diffY);
            }
        });
    }

    private MyButton buildMoveButton(Lab5FiguresPanel figuresPanel) {
        MyButton moveFigureButton = new MyButton("Переместить", this);
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures(getFiguresTypesSelectedItem()));
        return moveFigureButton;
    }

    private MyButton buildVisibleChangeButton(Lab5FiguresPanel figuresPanel) {
        MyButton visibleChangeButton = new MyButton("Изменить видимость", this);
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible(getFiguresTypesSelectedItem()));
        return visibleChangeButton;
    }

    private MyButton buildCreateButton(Lab5FiguresPanel figuresPanel) {
        MyButton createFigureButton = new MyButton("Создать", this);
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList(getFiguresTypesSelectedItem()));
        return createFigureButton;
    }

    private MyButton buildResizeButton(Lab5FiguresPanel figuresPanel) {
        MyButton resizeButton = new MyButton("Изменить размер", this);
        resizeButton.addActionListener(e -> figuresPanel.resizeFigures(getFiguresTypesSelectedItem()));
        return resizeButton;
    }

    private MyButton buildRotateEllipse(Lab5FiguresPanel figuresPanel) {
        MyButton rotateEllipse = new MyButton("Повернуть эллипс", this);

        rotateEllipse.addActionListener(e -> figuresPanel.rotateEllipse());

        return rotateEllipse;
    }

    private MyButton buildDeleteFigures(Lab5FiguresPanel figuresPanel) {
        MyButton deleteButton = new MyButton("Удалить", this);
        deleteButton.addActionListener(e -> requestFocus());
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures(getFiguresTypesSelectedItem()));
        return deleteButton;
    }


    public FigureType getFiguresTypesSelectedItem() {
        return FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
    }
}
