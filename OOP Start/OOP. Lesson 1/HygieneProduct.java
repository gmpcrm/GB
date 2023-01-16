public class HygieneProduct extends Product {
    private int quantityInPack;

    public HygieneProduct(String name, double price, int quantity, String unit, int quantityInPack) {
        super(name, price, quantity, unit);
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
        return "Товары гигиены";
    }

    @Override
    public String toString() {
        return String.format("%s, quantityInPack=%d", super.toString(), quantityInPack);
    }
}
