class Rectangle extends PolygonalShape {
    public Rectangle(double length, double width) throws InvalidShapeException {
        super(new double[] { length, width, length, width });
    }

    @Override
    String getName() {
        return "Прямоугольник";
    }

    @Override
    double getArea() {
        return sides[0] * sides[1];
    }
}