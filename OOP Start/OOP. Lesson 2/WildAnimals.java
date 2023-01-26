public abstract class WildAnimals extends Animals implements WildAnimal {
    protected String habitat;
    protected String sightingDate;

    public WildAnimals() {
        super();
    }
    
    public WildAnimals(int height, int weight, String eyeColor, String habitat, String sightingDate) {
        super(height, weight, eyeColor);
        this.habitat = habitat;
        this.sightingDate = sightingDate;
    }

    protected void fillProperties() {
        super.fillProperties();
        setHabitat(InputScanner.getString("Введите место обитания:"));
        setSightingDate(InputScanner.getString("Введите дату когда видели в последний раз:"));
    }

    @Override
    public String getHabitat() {
        return habitat;
    }

    @Override
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String getSightingDate() {
        return sightingDate;
    }

    @Override
    public void setSightingDate(String sightingDate) {
        this.sightingDate = sightingDate;
    }

    @Override
    public abstract void makeSound();

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Место обитания: " + habitat);
        System.out.println("Дата наблюдения: " + sightingDate);
    }
}
