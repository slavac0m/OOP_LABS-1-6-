package org.example.labWork6_array.panels;

import org.example.Constants.FigureType;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Lab6ArrayControlPanel extends JPanel {
    JComboBox<String> figureType = new JComboBox<>(FigureType.getNames());

    public Lab6ArrayControlPanel(Lab6ArrayFiguresPanel lab6ArrayFiguresPanel) {

        JButton createFigureButton = buildCreateButton(lab6ArrayFiguresPanel);
        JButton moveButton = buildMoveButton(lab6ArrayFiguresPanel);

        JButton visibleChangeButton = buildVisibleChangeButton(lab6ArrayFiguresPanel);
        JButton resizeButton = buildResizeButton(lab6ArrayFiguresPanel);
        JButton rotateEllipseButton = buildRotateEllipse(lab6ArrayFiguresPanel);

        JButton deleteFigureButton = buildDeleteFigures(lab6ArrayFiguresPanel);

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

    private JButton buildMoveButton(Lab6ArrayFiguresPanel figuresPanel) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures(getFiguresTypesSelectedItem()));
        return moveFigureButton;
    }

    private JButton buildVisibleChangeButton(Lab6ArrayFiguresPanel figuresPanel) {
        JButton visibleChangeButton = new JButton("Изменить видимость");
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible(getFiguresTypesSelectedItem()));
        return visibleChangeButton;
    }

    private JButton buildCreateButton(Lab6ArrayFiguresPanel figuresPanel) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList(getFiguresTypesSelectedItem()));
        return createFigureButton;
    }

    private JButton buildResizeButton(Lab6ArrayFiguresPanel figuresPanel) {
        JButton resizeButton = new JButton("Изменить размер");
        resizeButton.addActionListener(e -> figuresPanel.resizeFigures(getFiguresTypesSelectedItem()));
        return resizeButton;
    }

    private JButton buildRotateEllipse(Lab6ArrayFiguresPanel figuresPanel) {
        JButton rotateEllipse = new JButton("Повернуть эллипс");

        rotateEllipse.addActionListener(e -> figuresPanel.rotateEllipse());

        return rotateEllipse;
    }

    private JButton buildDeleteFigures(Lab6ArrayFiguresPanel figuresPanel) {
        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures(getFiguresTypesSelectedItem()));
        return deleteButton;
    }


    public FigureType getFiguresTypesSelectedItem() {
        return FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
    }
}
