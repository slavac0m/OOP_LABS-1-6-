package org.example.labWork3.panels;

import javax.swing.*;
import java.util.Objects;

public class Lab3ControlPanel extends JPanel {

    public Lab3ControlPanel(Lab3FiguresPanel lab3FiguresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");
        JComboBox<String> figureType = new JComboBox<>(new String[]{"Окружность","Эллипс", "Четырехугольник","Прямоугольник", "Ромб", "Трапеция"});

        JButton moveButton = createMoveButton(lab3FiguresPanel, arrayMode, figureType);
        JButton createFigureButton = buildCreateButton(lab3FiguresPanel, arrayMode, figureType);
        JButton changeFigureButton = buildChangeFigureButton(lab3FiguresPanel, arrayMode, figureType);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> deleteFigures(lab3FiguresPanel, arrayMode, figureType));

        JButton deleteAllFigureButton = new JButton("Удалить");
        deleteAllFigureButton.addActionListener(e -> lab3FiguresPanel.clearFrame());

        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);
    }

    private void deleteFigures(Lab3FiguresPanel lab3FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

        if (arrayMode.isSelected()) {
            switch (selectedFigure) {
                case "Окружность" -> lab3FiguresPanel.deleteCircleList();
                case "Эллипс" -> lab3FiguresPanel.deleteEllipseList();
                case "Четырехугольник" -> lab3FiguresPanel.deleteQuadrangleList();
                case "Прямоугольник" -> lab3FiguresPanel.deleteRectangleList();
                case "Ромб" -> lab3FiguresPanel.deleteRhombusList();
                case "Трапеция" -> lab3FiguresPanel.deleteTrapezoidList();
            }
        } else {
            switch (selectedFigure) {
                case "Окружность" -> lab3FiguresPanel.deleteCircle();
                case "Эллипс" -> lab3FiguresPanel.deleteEllipse();
                case "Четырехугольник" -> lab3FiguresPanel.deleteQuadrangle();
                case "Прямоугольник" -> lab3FiguresPanel.deleteRectangle();
                case "Ромб" -> lab3FiguresPanel.deleteRhombus();
                case "Трапеция" -> lab3FiguresPanel.deleteTrapezoid();
            }
        }
    }

    private JButton buildCreateButton(Lab3FiguresPanel lab3FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();
            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab3FiguresPanel.addCircleList();
                    case "Эллипс" -> lab3FiguresPanel.addEllipseList();
                    case "Четырехугольник" -> lab3FiguresPanel.addQuadrangleList();
                    case "Прямоугольник" -> lab3FiguresPanel.addRectangleList();
                    case "Ромб" -> lab3FiguresPanel.addRhombusList();
                    case "Трапеция" -> lab3FiguresPanel.addTrapezoidList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab3FiguresPanel.addOneCircle();
                    case "Эллипс" -> lab3FiguresPanel.addOneEllipse();
                    case "Четырехугольник" -> lab3FiguresPanel.addOneQuadrangle();
                    case "Прямоугольник" -> lab3FiguresPanel.addOneRectangle();
                    case "Ромб" -> lab3FiguresPanel.addOneRhombus();
                    case "Трапеция" -> lab3FiguresPanel.addOneTrapezoid();
                }
            }
        });
        return createFigureButton;
    }

    private JButton buildChangeFigureButton(Lab3FiguresPanel lab3FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton changeFigureButton = new JButton("Изменить");
        changeFigureButton.addActionListener(e -> {
            String selectedFigure = Objects.requireNonNull(figureType.getSelectedItem()).toString();

            if (arrayMode.isSelected()) {
                switch (selectedFigure) {
                    case "Окружность" -> lab3FiguresPanel.changeCircleList();
                    case "Эллипс" -> lab3FiguresPanel.changeEllipseList();
                    case "Четырехугольник" -> lab3FiguresPanel.changeQuadrangleList();
                    case "Прямоугольник" -> lab3FiguresPanel.changeRectangleList();
                    case "Ромб" -> lab3FiguresPanel.changeRhombusList();
                    case "Трапеция" -> lab3FiguresPanel.changeTrapezoidList();
                }
            } else {
                switch (selectedFigure) {
                    case "Окружность" -> lab3FiguresPanel.changeCircle();
                    case "Эллипс" -> lab3FiguresPanel.changeEllipse();
                    case "Четырехугольник" -> lab3FiguresPanel.changeQuadrangle();
                    case "Прямоугольник" -> lab3FiguresPanel.changeRectangle();
                    case "Ромб" -> lab3FiguresPanel.changeRhombus();
                    case "Трапеция" -> lab3FiguresPanel.changeTrapezoid();
                }
            }
        });
        return changeFigureButton;
    }

    private JButton createMoveButton(Lab3FiguresPanel lab3FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> {
            if (arrayMode.isSelected()) {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab3FiguresPanel.moveCircleList();
                    case "Эллипс" -> lab3FiguresPanel.moveEllipseList();
                    case "Четырехугольник" -> lab3FiguresPanel.moveQuadrangleList();
                    case "Прямоугольник" -> lab3FiguresPanel.moveRectangleList();
                    case "Ромб" -> lab3FiguresPanel.moveRhombusList();
                    case "Трапеция" -> lab3FiguresPanel.moveTrapezoidList();
                }
            } else {
                switch (Objects.requireNonNull(figureType.getSelectedItem()).toString()) {
                    case "Окружность" -> lab3FiguresPanel.moveCircle();
                    case "Эллипс" -> lab3FiguresPanel.moveEllipse();
                    case "Четырехугольник" -> lab3FiguresPanel.moveQuadrangle();
                    case "Прямоугольник" -> lab3FiguresPanel.moveRectangle();
                    case "Ромб" -> lab3FiguresPanel.moveRhombus();
                    case "Трапеция" -> lab3FiguresPanel.moveTrapezoid();
                }
            }
        });

        return moveFigureButton;
    }
}
