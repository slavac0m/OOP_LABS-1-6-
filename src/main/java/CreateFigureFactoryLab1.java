import org.example.Constants;
import org.example.labWork1.figures.Circle;

import java.awt.*;
import java.util.Random;

public class CreateFigureFactoryLab1 {

    private Random random = new Random();

    public Circle createRandomCircle() {
        int r = random.nextInt(100) + 20;
        int x = random.nextInt(Constants.FRAME_HIGH);
        int y = random.nextInt(Constants.FRAME_WIDTH);

        Color color = Constants.colors[
                random.nextInt(Constants.colors.length)
                ];
        return new Circle(x, y, r, color);
    }

    public Circle[] createRandomArrayCircle() {
        Circle[] circles = new Circle[Constants.COUNT_OF_FIGURES];
        for (int i = 0; i < Constants.COUNT_OF_FIGURES; i++) circles[i] = createRandomCircle();
        return circles;
    }


}
