import java.time.LocalDate;

public class Beverage extends FoodProduct {
    private double volume;

    public Beverage(String name, double price, int quantity, String unit, LocalDate expirationDate, double volume) {
        super(name, price, quantity, unit, expirationDate);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getClassName() {
        return "Напитки";
    }

    @Override
    public String toString() {
        return String.format("%s, volume=%.2f", super.toString(), volume);
    }
}
