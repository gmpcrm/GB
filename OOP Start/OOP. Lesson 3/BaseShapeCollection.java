import java.util.ArrayList;
import java.util.List;

class BaseShapeCollection {
    private List<BaseShape> shapes = new ArrayList<>();
    
    public void addShape(BaseShape shape) {
        shapes.add(shape);
    }
    
    public void removeShape(BaseShape shape) {
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
    
    public void changeShape(int index, BaseShape shape) {
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
        for (BaseShape shape : shapes) {
            System.out.println("Фигура: " + shape.getName());
            if (shape instanceof PolygonalShape){
                PolygonalShape polygonalShape = (PolygonalShape)shape;
                System.out.println("Периметр: " + polygonalShape.getPerimeter());
            }
            else if (shape instanceof Circle){
                Circle circle = (Circle)shape;
                System.out.println("Длина окружности: " + circle.getCircleLength());
            }

            System.out.println("Площадь: " + shape.getArea());
        }
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (BaseShape shape : shapes) {
            if (shape instanceof PolygonalShape){
                PolygonalShape polygonalShape = (PolygonalShape)shape;
                perimeter += polygonalShape.getPerimeter();
            }
        }

        return perimeter;
    }

    public double calculateArea() {
        double area = 0;
        for (BaseShape shape : shapes) {
            area += shape.getArea();
        }

        return area;
    }
}