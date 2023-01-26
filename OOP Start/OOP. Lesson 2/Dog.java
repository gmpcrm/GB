public class Dog extends Pets {
    private boolean trained;
    
    public Dog() {
        super();
    }
    
    public Dog(int height, int weight, String eyeColor, String name, String breed, boolean vaccines, String furColor, String birthdate, boolean trained) {
        super(height, weight, eyeColor, name, breed, vaccines, furColor, birthdate);
        this.trained = trained;
    }
    
    public boolean isTrained() {
        return trained;
    }

    public void train() {
        this.trained = true;
    }    

    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Dog(50, 10, "Карий", "Бобик", "Овчарка", true, "Черный", "01.01.2010", true),
            new Dog(40, 8, "Голубой", "Шарик", "Дворняга", true, "Белый", "01.01.2011", false),
            new Dog(30, 6, "Серый", "Тузик", "Дворняга", true, "Серый", "01.01.2012", true),
        };
    }

    @Override
    protected void fillProperties() {
        super.fillProperties();
        trained = InputScanner.getBoolean("Приучена? (true/false): ");
    }

    @Override
    public Animal Create() {
        var animal = new Dog();
        animal.fillProperties();
        return animal;
    }

    @Override
    public String getKind() {
        return "Собака";
    }

    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
    
    @Override
    public void showAffection() {
        System.out.println("Машет хвостом и дает лапу вам в руку.");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Наличие дрессировки: " + trained);
    }
}

    