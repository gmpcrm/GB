public abstract class Bird extends Animals {
    private int flightAltitude;

    protected Bird() {
        super();
    }

    protected Bird(int flightAltitude) {
        super();
        this.flightAltitude = flightAltitude;
    }

    protected Bird(int height, int weight, String eyeColor, int flightAltitude) {
        super(height, weight, eyeColor);
        this.flightAltitude = flightAltitude;
    }

    @Override
    protected void fillProperties()
    {
        super.fillProperties();
        flightAltitude = InputScanner.getInt("Введите высоту полета: ");
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Высота полета: " + flightAltitude);
    }    

    public void fly() {
        System.out.println("Я лечу на " + flightAltitude + " метрах.");
    }

    @Override
    public void makeSound() {
        System.out.println("Чирик");
    }
}