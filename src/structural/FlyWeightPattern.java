package structural;

import java.util.HashMap;
import java.util.Random;

interface Shape {
    void draw();
}

class Circle implements Shape {
    private String color;
    private int x, y, radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle: Color = " + color + ", X = " + x + ", Y = " + y + ", Radius = " + radius);
    }
}

class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating new Circle of color: " + color);
        }
        return circle;
    }
}

public class FlyWeightPattern {
    private static final String[] colors = {"Red", "Green", "Blue", "Yellow", "Black"};

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(colors[random.nextInt(colors.length)]);
            circle.setX(random.nextInt(100));
            circle.setY(random.nextInt(100));
            circle.setRadius(10);
            circle.draw();
        }
    }
}
