public class Diaper extends HygieneProduct {
    private String size;
    private double minWeight;
    private double maxWeight;
    private String type;

    public Diaper(String name, double price, int quantity, String unit, int quantityInPack, String size, double minWeight, double maxWeight, String type) {
        super(name, price, quantity, unit, quantityInPack);
        this.size = size;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getClassName() {
        return "Подгузник";
    }

    @Override
    public String toString() {
        return String.format("%s, size=%s, minWeight=%.2f, maxWeight=%.2f, type=%s", super.toString(), size, minWeight, maxWeight, type);
    }
}