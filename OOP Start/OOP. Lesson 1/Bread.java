import java.time.LocalDate;

public class Bread extends FoodProduct {
    private String flourType;

    public Bread(String name, double price, int quantity, String unit, LocalDate expirationDate, String flourType) {
        super(name, price, quantity, unit, expirationDate);
        this.flourType = flourType;
    }

    public String getFlourType() {
        return flourType;
    }

    public void setFlourType(String flourType) {
        this.flourType = flourType;
    }
    @Override
    public String getClassName() {
        return "Хлеб";
    }

    @Override
    public String toString() {
        return String.format("%s, flour=%s", super.toString(), flourType);
    }
}
