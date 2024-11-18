package org.example;

import org.example.labWork1.panels.Lab1ControlPanel;
import org.example.labWork1.panels.Lab1FiguresPanel;
import org.example.labWork2.panels.Lab2ControlPanel;
import org.example.labWork2.panels.Lab2FiguresPanel;
import org.example.labWork3.panels.Lab3ControlPanel;
import org.example.labWork3.panels.Lab3FiguresPanel;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String choice = getChoice();
        MainFrame mainFrame;
        switch (choice) {
            case "1" -> {
                Lab1FiguresPanel f = new Lab1FiguresPanel();
                mainFrame = new MainFrame(choice, f, new Lab1ControlPanel(f));
                mainFrame.setVisible(true);
            }
            case "2" -> {
                Lab2FiguresPanel panel = new Lab2FiguresPanel();
                mainFrame = new MainFrame(choice, panel, new Lab2ControlPanel(panel));
                mainFrame.setVisible(true);
            }
            case "3" -> {
                Lab3FiguresPanel panel = new Lab3FiguresPanel();
                mainFrame = new MainFrame(choice, panel, new Lab3ControlPanel(panel));
                mainFrame.setVisible(true);
            }
            case "4" -> {
            }
            case "5" -> {
            }
            case "6" -> {
            }
        }
    }

    private static boolean isValidInput(String s) {
        Pattern pattern = Pattern.compile("^[0-5]|^6-[1-2]$");
        return pattern.matcher(s).find();
    }

    private static String getChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!isValidInput(choice)) {
            System.out.println("Введите номер лабораторной работы:\n" +
                    "[1] Лабораторная работа №1\n" +
                    "[2] Лабораторная работа №2\n" +
                    "[3] Лабораторная работа №3\n" +
                    "[4] Лабораторная работа №4\n" +
                    "[5] Лабораторная работа №5\n" +
                    "[6] Лабораторная работа №6-1\n" +
                    "[7] Лабораторная работа №6-2\n" +
                    "[0] Выход\n");
            choice = scanner.nextLine();
        }
        return choice;
    }
}