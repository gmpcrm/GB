class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) throws InvalidShapeException {
        if(length <= 0 || width <= 0)
            throw new InvalidShapeException("Неправильный ввод: длина и ширина должны быть положительными числами: " + length + ", " + width + ".");
        
        this.length = length;
        this.width = width;
    }

    @Override
    String getName() {
        return "Прямоугольник";
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    double getArea() {
        return length * width;
    }
}