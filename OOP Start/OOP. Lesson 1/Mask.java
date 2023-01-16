public class Mask extends HygieneProduct {
    public Mask(String name, double price, int quantity, String unit, int quantityInPack) {
        super(name, price, quantity, unit, quantityInPack);
    }

    @Override
    public String getClassName() {
        return "Маска";
    }
}
