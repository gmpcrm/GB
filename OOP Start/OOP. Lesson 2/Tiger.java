public class Tiger extends WildAnimals {

    public Tiger() {
        super();
    }

    public Tiger(int height, int weight, String eyeColor, String habitat, String sightingDate) {
        super(height, weight, eyeColor, habitat, sightingDate);
    }

    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Tiger(70, 90, "Зеленый", "Лес", "01.01.2011"),
            new Tiger(80, 120, "Голубой", "Савана", "01.01.2012"),
            new Tiger(90, 70, "Красный", "Тайга", "01.01.2013"),        
        };
    }

    @Override
    public String getKind() {
        return "Тигр";
    }

    @Override
    public Animal Create() {
        var animal = new Tiger();
        animal.fillProperties();
        return animal;
    }

    @Override
    public void makeSound() {
        System.out.println("Ррррррррр!");
    }    
}
