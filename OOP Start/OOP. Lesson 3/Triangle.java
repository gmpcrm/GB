class Triangle extends PolygonalShape {
    public Triangle(double side1, double side2, double side3) throws InvalidShapeException {
        super(new double[]{side1, side2, side3});
        
        if(side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new InvalidShapeException("Неправильный ввод: сумма двух сторон треугольника должна быть больше третьей стороны: " + side1 + ", " + side2 + ", " + side3 + ".");
    }

    @Override
    String getName() {
        return "Треугольник";
    }

    @Override
    double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
}