public class Stork extends Bird {
    public Stork() {
        super();
    }

    protected Stork(int flightAltitude) {
        super(flightAltitude);
    }

    protected Stork(int height, int weight, String eyeColor, int flightAltitude) {
        super(height, weight, eyeColor, flightAltitude);
    }

    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Stork(50, 2, "Коричневый", 100),
            new Stork(40, 1, "Белый", 80),
            new Stork(30, 1, "Черный", 60),            
        };
    }

    @Override
    public Animal Create() {
        var animal = new Stork();
        animal.fillProperties();
        return animal;
    }
    
    @Override
    public String getKind() {
        return "Аист";
    }

    @Override
    public void makeSound() {
        System.out.println("Кряк-кряк!");
    }
}