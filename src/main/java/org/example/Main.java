package org.example;

import org.example.labWork1.panels.ControlPanel;
import org.example.labWork1.panels.FiguresPanel;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String choice = getChoice();
        MainFrame mainFrame;
        switch (choice){
            case "1" ->{
                FiguresPanel f = new FiguresPanel();
                mainFrame = new MainFrame(choice, f, new ControlPanel(f));
                mainFrame.setVisible(true);
            }
            case "2" ->{}
            case "3" ->{}
            case "4" ->{}
            case "5" ->{}
            case "6" ->{}
            case "7" ->{}
            case "8" ->{}
        }
    }

    public static boolean isValidInput(String s) {
        Pattern pattern = Pattern.compile("^[0-7]$");
        return pattern.matcher(s).find();
    }

    public static String getChoice() {
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