import java.time.LocalDate;

public class Milk extends Beverage {
    private double fatPercentage;

    public Milk(String name, double price, int quantity, String unit, LocalDate expirationDate, double volume, double fatPercentage) {
        super(name, price, quantity, unit, expirationDate, volume);
        this.fatPercentage = fatPercentage;
    }

    public double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    @Override
    public String getClassName() {
        return "Молоко";
    }

    @Override
    public String toString() {
        return String.format("%s, fatPercentage=%.2f", super.toString(), fatPercentage);
    }
}
