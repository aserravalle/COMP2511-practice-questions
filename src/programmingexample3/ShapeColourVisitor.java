package programmingexample3;

import java.awt.Color;

public class ShapeColourVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        circle.setColour(Color.red);
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        rectangle.setColour(Color.green);
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        triangle.setColour(Color.blue);
    }
}
