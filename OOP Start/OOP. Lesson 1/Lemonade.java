import java.time.LocalDate;

public class Lemonade extends Beverage {
    public Lemonade(String name, double price, int quantity, String unit, LocalDate expirationDate, double volume) {
        super(name, price, quantity, unit, expirationDate, volume);
    }

    @Override
    public String getClassName() {
        return "Лимонад";
    }
}
