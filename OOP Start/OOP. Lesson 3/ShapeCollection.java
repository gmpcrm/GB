import java.util.ArrayList;
import java.util.List;

class ShapeCollection {
    private List<Shape> shapes = new ArrayList<>();
    
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    public void removeShape(Shape shape) {
        try {
            shapes.remove(shape);
        }
        catch (Exception e) {
            System.out.println("Фигура не найдена.");
        }
    }

    public void removeShape(int index) {
        try {
            shapes.remove(index);
        }
        catch (Exception e) {
            System.out.println("Фигура не найдена.");
        }
    }
    
    public void changeShape(int index, Shape shape) {
        try {
            shapes.set(index, shape);
        }
        catch (Exception e) {
            System.out.println("Фигура не найдена.");
        }
    }
    
    public void sortByArea() {
        shapes.sort((s1, s2) -> (int)(s1.getArea() - s2.getArea()));
    }

    public void printAllShapesInfo() {
        for (Shape shape : shapes) {
            System.out.println("Фигура: " + shape.getName());
            System.out.println("Периметр: " + shape.getPerimeter());
            System.out.println("Площадь: " + shape.getArea());
        }
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (Shape shape : shapes) {
            perimeter += shape.getPerimeter();
        }

        return perimeter;
    }

    public double calculateArea() {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.getArea();
        }

        return area;
    }
}