import java.time.LocalDate;

public class Eggs extends FoodProduct {
    private int quantityInPack;

    public Eggs(String name, double price, int quantity, String unit, LocalDate expirationDate, int quantityInPack) {
        super(name, price, quantity, unit, expirationDate);
        this.quantityInPack = quantityInPack;
    }

    public int getQuantityInPack() {
        return quantityInPack;
    }

    public void setQuantityInPack(int quantityInPack) {
        this.quantityInPack = quantityInPack;
    }

    @Override
    public String getClassName() {
        return "Яйца";
    }

    @Override
    public String toString() {
        return String.format("%s, quantityInPack=%d", super.toString(), quantityInPack);
    }
}
