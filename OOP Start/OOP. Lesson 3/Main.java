public class Main {
    public static void main(String[] args) {
        try {
            ShapeCollection collection = new ShapeCollection();
            collection.addShape(new Triangle(3, 4, 5));
            collection.addShape(new Square(10));                
            collection.addShape(new Rectangle(3, 4));
            collection.addShape(new Circle(5));

            Shape triangle = new Triangle(10, 15, 20);
            collection.addShape(triangle);

            // напечатать периметр и площадь всех фигур
            System.out.println("Периметр всех фигур: " + collection.calculatePerimeter());
            System.out.println("Площадь всех фигур: " + collection.calculateArea());

            // удалить треугольник
            collection.removeShape(triangle);
            
            // удалить фигуру по индексу 2
            collection.removeShape(2);

            // изменить фигуру на индексе 0 на треугольник со сторонами 5, 7, 8 
            collection.changeShape(0, new Triangle(5, 7, 8));

            // отсортировать фигуры по площади
            collection.sortByArea();

            // напечатать информацию о всех фигурах
            collection.printAllShapesInfo();
        } 
        catch (InvalidShapeException e) {
            System.out.println(e.getMessage());
        }
    }
}