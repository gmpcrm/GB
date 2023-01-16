public class Pacifier extends KidsProduct {
    public Pacifier(String name, double price, int quantity, String unit, int minAge, boolean hypoallergenic) {
        super(name, price, quantity, unit, minAge, hypoallergenic);
    }

    @Override
    public String getClassName() {
        return "Соска";
    }
}