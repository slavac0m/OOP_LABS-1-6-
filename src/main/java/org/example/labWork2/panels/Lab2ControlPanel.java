package org.example.labWork2.panels;

import javax.swing.*;
import java.util.Objects;

public class Lab2ControlPanel extends JPanel {

    public Lab2ControlPanel(Lab2FiguresPanel lab2FiguresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Окружность", "Прямоугольник", "Треугольник", "Линия", "Кольцо"});

        JButton moveButton = createMoveButton(lab2FiguresPanel, arrayMode, figureType);
        JButton createFigureButton = buildCreateButton(lab2FiguresPanel, arrayMode, figureType);
        JButton changeFigureButton = buildChangeFigureButton(lab2FiguresPanel, arrayMode, figureType);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> deleteFigures(lab2FiguresPanel, arrayMode, figureType));

        JButton deleteAllFigureButton = new JButton("Удалить");
        deleteAllFigureButton.addActionListener(e -> lab2FiguresPanel.clearFrame());

        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);
    }

    private void deleteFigures(Lab2FiguresPanel lab2FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

        if (arrayMode.isSelected()) {
            switch (selectedFigure) {
                case "Окружность" -> lab2FiguresPanel.deleteCircleList();
                case "Прямоугольник" -> lab2FiguresPanel.deleteRectangleList();
                case "Треугольник" -> lab2FiguresPanel.deleteTriangleList();
                case "Линия" -> lab2FiguresPanel.deleteLineList();
                case "Кольцо" -> lab2FiguresPanel.deleteRingList();
            }
        } else {
            switch (selectedFigure) {
                case "Окружность" -> lab2FiguresPanel.deleteCircle();
                case "Прямоугольник" -> lab2FiguresPanel.deleteRectangle();
                case "Треугольник" -> lab2FiguresPanel.deleteTriangle();
                case "Линия" -> lab2FiguresPanel.deleteLine();
                case "Кольцо" -> lab2FiguresPanel.deleteRing();
            }
        }
    }

    private JButton buildCreateButton(Lab2FiguresPanel lab2FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();
            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab2FiguresPanel.addCircleList();
                    case "Прямоугольник" -> lab2FiguresPanel.addRectangleList();
                    case "Треугольник" -> lab2FiguresPanel.addTriangleList();
                    case "Линия" -> lab2FiguresPanel.addLineList();
                    case "Кольцо" -> lab2FiguresPanel.addRingList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab2FiguresPanel.addOneCircle();
                    case "Прямоугольник" -> lab2FiguresPanel.addOneRectangle();
                    case "Треугольник" -> lab2FiguresPanel.addOneTriangle();
                    case "Линия" -> lab2FiguresPanel.addOneLine();
                    case "Кольцо" -> lab2FiguresPanel.addOneRing();
                }
            }
        });
        return createFigureButton;
    }

    private JButton buildChangeFigureButton(Lab2FiguresPanel lab2FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton changeFigureButton = new JButton("Изменить");
        changeFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab2FiguresPanel.changeCircleList();
                    case "Прямоугольник" -> lab2FiguresPanel.changeRectangleList();
                    case "Треугольник" -> lab2FiguresPanel.changeTriangleList();
                    case "Линия" -> lab2FiguresPanel.changeLineList();
                    case "Кольцо" -> lab2FiguresPanel.changeRingList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab2FiguresPanel.changeCircle();
                    case "Прямоугольник" -> lab2FiguresPanel.changeRectangle();
                    case "Треугольник" -> lab2FiguresPanel.changeTriangle();
                    case "Линия" -> lab2FiguresPanel.changeLine();
                    case "Кольцо" -> lab2FiguresPanel.changeRing();
                }
            }
        });
        return changeFigureButton;


    }

    private JButton createMoveButton(Lab2FiguresPanel lab2FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> {
            if (arrayMode.isSelected()) {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab2FiguresPanel.moveCircleList();
                    case "Прямоугольник" -> lab2FiguresPanel.moveRectangleList();
                    case "Треугольник" -> lab2FiguresPanel.moveTriangleList();
                    case "Линия" -> lab2FiguresPanel.moveLineList();
                    case "Кольцо" -> lab2FiguresPanel.moveRingList();
                }
            } else {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab2FiguresPanel.moveCircle();
                    case "Прямоугольник" -> lab2FiguresPanel.moveRectangle();
                    case "Треугольник" -> lab2FiguresPanel.moveTriangle();
                    case "Линия" -> lab2FiguresPanel.moveLine();
                    case "Кольцо" -> lab2FiguresPanel.moveRing();
                }
            }
        });

        return moveFigureButton;
    }
}
