package org.example.labWork6.labWork6_linked;

import org.example.labWork6.figures.TFigure;

@FunctionalInterface
public interface Process {
    void process(TFigure figure);
}