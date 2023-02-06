abstract class PolygonalShape extends BaseShape {
    protected double sides[];

    public PolygonalShape(double shapes[]) throws InvalidShapeException {
        if (shapes != null){
            if (shapes.length == 0)
                throw new InvalidShapeException("Неправильный ввод: фигура не может быть пустой.");

            for (double shape : shapes){
                    if (shape <= 0) 
                        throw new InvalidShapeException("Неправильный ввод: сторона фигуры не может быть отрицательной или равной нулю: " + shape + ".");
                }
        }

        this.sides = shapes;
    }

    public double getPerimeter(){
        double perimeter = 0;
        for (double shape : sides)
            perimeter += shape;
        
            return perimeter;
    }
}