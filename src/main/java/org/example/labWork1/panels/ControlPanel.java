package org.example.labWork1.panels;

import javax.swing.*;
import java.util.Objects;

public class ControlPanel extends JPanel{

    public ControlPanel(FiguresPanel figuresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Окружность", "Прямоугольник", "Треугольник", "Линия"});

        JButton moveButton = createMoveButton(figuresPanel, arrayMode, figureType);
        JButton createFigureButton = buildCreateButton(figuresPanel, arrayMode, figureType);
        JButton changeFigureButton = buildChangeFigureButton(figuresPanel, arrayMode, figureType);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> deleteFigures(figuresPanel, arrayMode, figureType));

        JButton deleteAllFigureButton = new JButton("Удалить");
        deleteAllFigureButton.addActionListener(e -> figuresPanel.clearFrame());

        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);
    }

    private void deleteFigures(FiguresPanel figuresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

        if (arrayMode.isSelected()) {
            switch (selectedFigure) {
                case "Окружность" -> figuresPanel.deleteCircles();
                case "Прямоугольник" -> figuresPanel.deleteRectangles();
//                    case "Треугольник" -> figuresPanel.addTriangleList();
//                    case "Линия" -> figuresPanel.addLineList();
            }
        } else {
            switch (selectedFigure) {
                case "Окружность" -> figuresPanel.deleteCircle();
                case "Прямоугольник" -> figuresPanel.deleteRectangles();
//                    case "Треугольник" -> figuresPanel.addOneTriangle();
//                    case "Линия" -> figuresPanel.addOneLine();
            }
        }
    }

    private JButton buildCreateButton(FiguresPanel figuresPanel,  JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> figuresPanel.addCircleList();
                    case "Прямоугольник" -> figuresPanel.addRectangleList();
//                    case "Треугольник" -> figuresPanel.addTriangleList();
//                    case "Линия" -> figuresPanel.addLineList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> figuresPanel.addOneCircle();
                    case "Прямоугольник" -> figuresPanel.addOneRectangle();
//                    case "Треугольник" -> figuresPanel.addOneTriangle();
//                    case "Линия" -> figuresPanel.addOneLine();
                }
            }
        });
        return createFigureButton;
    }

    private JButton buildChangeFigureButton(FiguresPanel figuresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton changeFigureButton = new JButton("Change");
        changeFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> figuresPanel.changeCircleList();
                    case "Прямоугольник" -> figuresPanel.changeRectangleList();
//                    case "Треугольник" -> figuresPanel.changeTriangleList();
//                    case "Линия" -> figuresPanel.changeLineList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> figuresPanel.changeCircle();
                    case "Прямоугольник" -> figuresPanel.changeRectangle();
//                    case "Треугольник" -> figuresPanel.changeTriangle();
//                    case "Линия" -> figuresPanel.changeLine();
                }
            }
        });
        return changeFigureButton;


    }

    private JButton createMoveButton(FiguresPanel figuresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> {
            if (arrayMode.isSelected()) {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> figuresPanel.moveCircle();
                    case "Прямоугольник" -> figuresPanel.moveRectangle();
//                    case "Треугольник" -> figuresPanel.moveTriangle();
//                    case "Линия" -> figuresPanel.moveLine();
                }
            } else {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> figuresPanel.moveCircleList();
                    case "Прямоугольник" -> figuresPanel.moveRectangleList();
//                    case "Треугольник" -> figuresPanel.movePentagonList();
//                    case "Линия" -> figuresPanel.changeLine();
                }
            }
        });

        return moveFigureButton;
    }
}
