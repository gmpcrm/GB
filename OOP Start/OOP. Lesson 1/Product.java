public class Product {
    private String name;
    private double price;
    private int quantity;
    private String unit;

    public Product(String name, double price, int quantity, String unit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getClassName() {
        return "Товар";
    }

    @Override
    public String toString() {
        return String.format("%s: name=%s, price=%.2f, quantity=%d, unit=%s", getClassName(), name, price, quantity, unit);
    }    
}
