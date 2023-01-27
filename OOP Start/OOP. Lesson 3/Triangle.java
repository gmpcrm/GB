class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) throws InvalidShapeException {
        if(side1 <= 0 || side2 <= 0 || side3 <= 0) 
            throw new InvalidShapeException("Неправильный ввод: стороны треугольника должны быть положительными числами: " + side1 + ", " + side2 + ", " + side3 + ".");
        
        if(side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new InvalidShapeException("Неправильный ввод: сумма двух сторон треугольника должна быть больше третьей стороны: " + side1 + ", " + side2 + ", " + side3 + ".");

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    String getName() {
        return "Треугольник";
    }

    @Override
    double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}