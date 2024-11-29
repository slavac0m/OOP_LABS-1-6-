package org.example.labWork5.panels;

import org.example.Constants.FigureType;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Lab5ControlPanel extends JPanel {
    JComboBox<String> figureType = new JComboBox<>(FigureType.getNames());

    public Lab5ControlPanel(Lab5FiguresPanel lab5FiguresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");


        JButton visibleChangeButton = null; //buildVisibleChangeButton();
        JButton resizeButton = null; //buildResizeButton();

        JButton moveButton = buildMoveButton(lab5FiguresPanel);
        JButton createFigureButton = buildCreateButton(lab5FiguresPanel);
        JButton changeFigureButton = buildResizeButton(lab5FiguresPanel);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> buildDeleteFigures(lab5FiguresPanel));

        JButton deleteAllFigureButton = new JButton("Удалить");
        deleteAllFigureButton.addActionListener(e -> lab5FiguresPanel.clearFrame());

        javax.swing.JButton moveToOnePoint = new javax.swing.JButton("Переместить в одну точку");
        moveToOnePoint.addActionListener(e -> {
//            figuresPanel.moveToObePoint(getFiguresTypesSelectedItem());
        });


        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);

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

    private JButton buildMoveButton(Lab5FiguresPanel figuresPanel) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> figuresPanel.moveFigures(getFiguresTypesSelectedItem()));
        return moveFigureButton;
    }

    private JButton buildVisibleChangeButton(Lab5FiguresPanel figuresPanel){
        JButton visibleChangeButton = new JButton("Change Visibility");
        visibleChangeButton.addActionListener(e -> figuresPanel.changeFiguresVisible(getFiguresTypesSelectedItem()));
        return visibleChangeButton;
    }

    private JButton buildCreateButton(Lab5FiguresPanel figuresPanel) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> figuresPanel.createFiguresList());
        return createFigureButton;
    }
    private JButton buildResizeButton(Lab5FiguresPanel figuresPanel) {
        JButton resizeButton = new JButton("Изменить размер");
        resizeButton.addActionListener(e -> {});
//                figuresPanel.resizeFigures(figuresTypes.getSelectedItem().toString()));
        return resizeButton;
    }

    private JButton buildRotateEllipse(Lab5FiguresPanel figuresPanel) {
        JButton rotateEllipse = new JButton("Повернуть эллипс");

        rotateEllipse.addActionListener(e -> {});
//        figuresPanel.rotateEllipse());

        return rotateEllipse;
    }
    private JButton buildDeleteFigures(Lab5FiguresPanel figuresPanel) {
        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(e -> figuresPanel.deleteFigures(getFiguresTypesSelectedItem()));
        return deleteButton;
    }


    public FigureType getFiguresTypesSelectedItem() {
        return FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
    }
}
