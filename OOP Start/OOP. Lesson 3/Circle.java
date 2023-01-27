class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws InvalidShapeException {
        if(radius <= 0)
            throw new InvalidShapeException("Неправильный ввод: радиус должен быть положительным числом: " + radius + ".");

        this.radius = radius;
    }

    @Override
    String getName() {
        return "Круг";
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}