public class Wolf extends WildAnimals {
    private boolean alpha;
    
    public Wolf() {
        super();
    }
    
    public Wolf(int height, int weight, String eyeColor, String habitat, String sightingDate, boolean alpha) {
        super(height, weight, eyeColor, habitat, sightingDate);
        this.alpha = alpha;
    }
    
    public boolean isAlpha() {
        return alpha;
    }
    
    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Wolf(100, 50, "Карие", "Лес", "01.01.2020", true),
            new Wolf(80, 40, "Карие", "Лес", "01.03.2021", false),
            new Wolf(90, 45, "Карие", "Лес", "01.04.2022", false),
        };
    }

    @Override
    protected void fillProperties() {
        super.fillProperties();
        alpha = InputScanner.getBoolean("Является ли волк вожаком стаи (true/false):");
    }
    
    @Override
    public Animal Create() {
        var animal = new Wolf();
        animal.fillProperties();
        return animal;
    }

    @Override
    public String getKind() {
        return "Волк";
    }

    @Override
    public void makeSound() {
        System.out.println("Ау-ау-ау!");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Вожак стаи: " + alpha);
    }
}