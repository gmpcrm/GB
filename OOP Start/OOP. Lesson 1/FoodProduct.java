import java.time.LocalDate;

public class FoodProduct extends Product {
    private LocalDate expirationDate;

    public FoodProduct(String name, double price, int quantity, String unit, LocalDate expirationDate) {
        super(name, price, quantity, unit);
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String getClassName() {
        return "Продукты питания";
    }

    @Override
    public String toString() {
        return String.format("%s, expirationDate=%tF", super.toString(), expirationDate);
    }
}