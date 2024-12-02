package org.example.labWork6.labWork6_array.panels;

import org.example.Constants.FigureType;
import org.example.labWork6.labWork6_array.MyButton;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Lab6ArrayControlPanel extends JPanel {
    JComboBox<String> figureType = new JComboBox<>(FigureType.getNames());

    public Lab6ArrayControlPanel(Lab6ArrayFiguresPanel lab6ArrayFiguresPanel) {
        figureType.addActionListener(e -> this.requestFocus());

        MyButton createFigureButton = buildCreateButton(lab6ArrayFiguresPanel);
        MyButton moveButton = buildMoveButton(lab6ArrayFiguresPanel);

        MyButton visibleChangeButton = buildVisibleChangeButton(lab6ArrayFiguresPanel);
        MyButton resizeButton = buildResizeButton(lab6ArrayFiguresPanel);
        MyButton rotateEllipseButton = buildRotateEllipse(lab6ArrayFiguresPanel);

        MyButton deleteFigureButton = buildDeleteFigures(lab6ArrayFiguresPanel);

        JButton moveToOnePoint = new JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> lab6ArrayFiguresPanel.moveToObePoint(getFiguresTypesSelectedItem()));

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
                lab6ArrayFiguresPanel.moveFigures(getFiguresTypesSelectedItem(), diffX, diffY);
            }
        });
    }

    private MyButton buildMoveButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton moveFigureButton = new MyButton("Переместить", this);
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures(getFiguresTypesSelectedItem()));
        return moveFigureButton;
    }

    private MyButton buildVisibleChangeButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton visibleChangeButton = new MyButton("Изменить видимость", this);
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible(getFiguresTypesSelectedItem()));
        return visibleChangeButton;
    }

    private MyButton buildCreateButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton createFigureButton = new MyButton("Создать", this);
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList(getFiguresTypesSelectedItem()));
        return createFigureButton;
    }

    private MyButton buildResizeButton(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton resizeButton = new MyButton("Изменить размер", this);
        resizeButton.addActionListener(e -> figuresPanel.resizeFigures(getFiguresTypesSelectedItem()));
        return resizeButton;
    }

    private MyButton buildRotateEllipse(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton rotateEllipse = new MyButton("Повернуть эллипс", this);

        rotateEllipse.addActionListener(e -> figuresPanel.rotateEllipse());

        return rotateEllipse;
    }

    private MyButton buildDeleteFigures(Lab6ArrayFiguresPanel figuresPanel) {
        MyButton deleteButton = new MyButton("Удалить", this);
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures(getFiguresTypesSelectedItem()));
        return deleteButton;
    }


    public FigureType getFiguresTypesSelectedItem() {
        return FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
    }
}
