package org.example.labWork1.panels;

import javax.swing.*;
import java.util.Objects;

public class Lab1ControlPanel extends JPanel {

    public Lab1ControlPanel(Lab1FiguresPanel lab1FiguresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Окружность", "Прямоугольник", "Треугольник", "Линия"});

        JButton moveButton = createMoveButton(lab1FiguresPanel, arrayMode, figureType);
        JButton createFigureButton = buildCreateButton(lab1FiguresPanel, arrayMode, figureType);
        JButton changeFigureButton = buildChangeFigureButton(lab1FiguresPanel, arrayMode, figureType);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> deleteFigures(lab1FiguresPanel, arrayMode, figureType));

        JButton deleteAllFigureButton = new JButton("Удалить всё");
        deleteAllFigureButton.addActionListener(e -> lab1FiguresPanel.clearFrame());

        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);
    }

    private void deleteFigures(Lab1FiguresPanel lab1FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

        if (arrayMode.isSelected()) {
            switch (selectedFigure) {
                case "Окружность" -> lab1FiguresPanel.deleteCircleList();
                case "Прямоугольник" -> lab1FiguresPanel.deleteRectangleList();
                case "Треугольник" -> lab1FiguresPanel.deleteTriangleList();
                case "Линия" -> lab1FiguresPanel.deleteLineList();
            }
        } else {
            switch (selectedFigure) {
                case "Окружность" -> lab1FiguresPanel.deleteCircle();
                case "Прямоугольник" -> lab1FiguresPanel.deleteRectangle();
                case "Треугольник" -> lab1FiguresPanel.deleteTriangle();
                case "Линия" -> lab1FiguresPanel.deleteLine();
            }
        }
    }

    private JButton buildCreateButton(Lab1FiguresPanel lab1FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab1FiguresPanel.addCircleList();
                    case "Прямоугольник" -> lab1FiguresPanel.addRectangleList();
                    case "Треугольник" -> lab1FiguresPanel.addTriangleList();
                    case "Линия" -> lab1FiguresPanel.addLineList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab1FiguresPanel.addOneCircle();
                    case "Прямоугольник" -> lab1FiguresPanel.addOneRectangle();
                    case "Треугольник" -> lab1FiguresPanel.addOneTriangle();
                    case "Линия" -> lab1FiguresPanel.addOneLine();
                }
            }
        });
        return createFigureButton;
    }

    private JButton buildChangeFigureButton(Lab1FiguresPanel lab1FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton changeFigureButton = new JButton("Изменить");
        changeFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab1FiguresPanel.changeCircleList();
                    case "Прямоугольник" -> lab1FiguresPanel.changeRectangleList();
                    case "Треугольник" -> lab1FiguresPanel.changeTriangleList();
                    case "Линия" -> lab1FiguresPanel.changeLineList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab1FiguresPanel.changeCircle();
                    case "Прямоугольник" -> lab1FiguresPanel.changeRectangle();
                    case "Треугольник" -> lab1FiguresPanel.rotateTriangle();
                    case "Линия" -> lab1FiguresPanel.changeLine();
                }
            }
        });
        return changeFigureButton;


    }

    private JButton createMoveButton(Lab1FiguresPanel lab1FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> {
            if (arrayMode.isSelected()) {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab1FiguresPanel.moveCircleList();
                    case "Прямоугольник" -> lab1FiguresPanel.moveRectangleList();
                    case "Треугольник" -> lab1FiguresPanel.moveTriangleList();
                    case "Линия" -> lab1FiguresPanel.moveLineList();
                }
            } else {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab1FiguresPanel.moveCircle();
                    case "Прямоугольник" -> lab1FiguresPanel.moveRectangle();
                    case "Треугольник" -> lab1FiguresPanel.moveTriangle();
                    case "Линия" -> lab1FiguresPanel.moveLine();
                }
            }
        });

        return moveFigureButton;
    }
}
