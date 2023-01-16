public class ToiletPaper extends HygieneProduct {
    private int layers;

    public ToiletPaper(String name, double price, int quantity, String unit, int quantityInPack, int layers) {
        super(name, price, quantity, unit, quantityInPack);
        this.layers = layers;
    }

    public int getLayers() {
        return layers;
    }

    public void setLayers(int layers) {
        this.layers = layers;
    }

    @Override
    public String getClassName() {
        return "Туалетная бумага";
    }

    @Override
    public String toString() {
        return String.format("%s, layers=%d", super.toString(), layers);
    }
}
