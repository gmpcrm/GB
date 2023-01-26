public class Chicken extends Bird {
    public Chicken() {
        super();
    }

    protected Chicken(int flightAltitude) {
        super(flightAltitude);
    }

    protected Chicken(int height, int weight, String eyeColor, int flightAltitude) {
        super(height, weight, eyeColor, flightAltitude);
    }

    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Chicken(50, 2, "Коричневый", 100),
            new Chicken(40, 1, "Серый", 80),
            new Chicken(30, 1, "Красный", 60),
            };
    }   

    @Override
    public Animal Create() {
        var animal = new Chicken();
        animal.fillProperties();
        return animal;
    }

    @Override
    public String getKind() {
        return "Курица";
    } 

    @Override
    public void makeSound() {
        System.out.println("Ко-ко-ко!");
    }
}