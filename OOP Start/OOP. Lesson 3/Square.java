class Square extends Shape {
    private double side;

    Square(double side) throws InvalidShapeException {
        if(side <= 0)
            throw new InvalidShapeException("Неправильный ввод: сторона квадрата должна быть положительным числом: " + side + ".");
        
        this.side = side;
    }

    @Override
    String getName() {
        return "Квадрат";
    }

    @Override
    double getPerimeter() {
        return 4 * side;
    }

    @Override
    double getArea() {
        return side * side;
    }
}