class Square extends Rectangle {
    Square(double side) throws InvalidShapeException {
        super(side, side);
    }

    @Override
    String getName() {
        return "Квадрат";
    }
}