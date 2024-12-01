package org.example.labWork4.panels;

import org.example.Constants.FigureType;

import javax.swing.*;
import java.util.Objects;

public class Lab4ControlPanel extends JPanel {

    public Lab4ControlPanel(Lab4FiguresPanel lab4FiguresPanel) {
        JCheckBox arrayMode = new JCheckBox("Режим работы с массивами");
        JComboBox<String> figureType = new JComboBox<>(new String[]{"CIRCLE", "ELLIPSE","QUADRANGLE","RECTANGLE","RHOMBUS","TRAPEZOID"});

        JButton moveButton = createMoveButton(lab4FiguresPanel, arrayMode, figureType);
        JButton createFigureButton = buildCreateButton(lab4FiguresPanel, arrayMode, figureType);
        JButton changeFigureButton = buildChangeFigureButton(lab4FiguresPanel, arrayMode, figureType);

        JButton deleteFigureButton = new JButton("Удалить фигуру");
        deleteFigureButton.addActionListener(e -> deleteFigures(lab4FiguresPanel, arrayMode, figureType));

        JButton deleteAllFigureButton = new JButton("Удалить");
        deleteAllFigureButton.addActionListener(e -> lab4FiguresPanel.clearFrame());

        add(figureType);
        add(arrayMode);
        add(moveButton);
        add(createFigureButton);
        add(changeFigureButton);
        add(deleteFigureButton);
        add(deleteAllFigureButton);
    }

    private void deleteFigures(Lab4FiguresPanel lab4FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        FigureType selectedFigure = FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
        if (!arrayMode.isSelected()) lab4FiguresPanel.deleteOneFigure(selectedFigure);
        else lab4FiguresPanel.deleteArrayFigure(selectedFigure);
    }

    private JButton buildCreateButton(Lab4FiguresPanel lab4FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton createFigureButton = new JButton("Создать");
        createFigureButton.addActionListener(e -> {
            FigureType selectedFigure = FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());

            if (!arrayMode.isSelected()) lab4FiguresPanel.addOneFigure(selectedFigure);
            else lab4FiguresPanel.addArrayFigures(selectedFigure);
        });
        return createFigureButton;
    }

    private JButton buildChangeFigureButton(Lab4FiguresPanel lab4FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton changeFigureButton = new JButton("Изменить");
        changeFigureButton.addActionListener(e -> {
            FigureType selectedFigure = FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());

            if (arrayMode.isSelected()) lab4FiguresPanel.changeArrayFigures(selectedFigure);
            else lab4FiguresPanel.changeOneFigure(selectedFigure);
        });
        return changeFigureButton;
    }

    private JButton createMoveButton(Lab4FiguresPanel lab4FiguresPanel, JCheckBox arrayMode, JComboBox<String> figureType) {
        JButton moveFigureButton = new JButton("Переместить");
        moveFigureButton.addActionListener(e -> {
            FigureType selectedFigure = FigureType.valueOf(Objects.requireNonNull(figureType.getSelectedItem()).toString());
            if (arrayMode.isSelected()) lab4FiguresPanel.moveArrayFigure(selectedFigure);
            else lab4FiguresPanel.moveOneFigure(selectedFigure);
        });

        return moveFigureButton;
    }
}
