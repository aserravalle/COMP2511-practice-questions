package programmingexample3;

import java.awt.Color;

public class ShapeColourAreaVisitor implements ShapeVisitor {
    private Color colour;
    private double totalArea;

    public ShapeColourAreaVisitor(Color colour) {
        this.colour = colour;
    }

    public double getTotalArea() {
        return totalArea;
    }

    @Override
    public void visitCircle(Circle circle) {
        if (circle.getColour().equals(this.colour)) {
            totalArea += circle.area();
        }
        
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (rectangle.getColour().equals(this.colour)) {
            totalArea += rectangle.area();
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (triangle.getColour().equals(this.colour)) {
            totalArea += triangle.area();
        }
    }
}
