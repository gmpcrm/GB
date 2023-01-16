public class KidsProduct extends Product {
    private int minAge;
    private boolean hypoallergenic;
  
    public KidsProduct(String name, double price, int quantity, String unit, int minAge, boolean hypoallergenic) {
        super(name, price, quantity, unit);
        this.minAge = minAge;
        this.hypoallergenic = hypoallergenic;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public boolean isHypoallergenic() {
        return hypoallergenic;
    }

    public void setHypoallergenic(boolean hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    @Override
    public String getClassName() {
        return "Детские товары";
    }

    @Override
    public String toString() {
        return String.format("%s, minAge=%d, hypoallergenic=%b", super.toString(), minAge, hypoallergenic);
    }
}
