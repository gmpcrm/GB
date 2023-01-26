public class Cat extends Pets {
    private boolean hasFur;

    public Cat() {
        super();
    }

    public Cat(int height, int weight, String eyeColor, String name, String breed, boolean vaccines, String furColor, String birthdate, boolean hasFur) {
        super(height, weight, eyeColor, name, breed, vaccines, furColor, birthdate);
        this.hasFur = hasFur;
    }

    public boolean hasFur() {
        return hasFur;
    }

    @Override
    public Animal[] getTestData() {
        return new Animal[] {
            new Cat(30, 5, "Зеленый", "Мурзик", "Сиамский", true, "Белый", "01.01.2010", true),
            new Cat(20, 3, "Голубой", "Барсик", "Британский", true, "Черный", "01.01.2011", true),
            new Cat(25, 4, "Красный", "Мурка", "Русская голубая", true, "Серый", "01.01.2012", true),
        };
    }

    @Override
    protected void fillProperties() {
        super.fillProperties();
        hasFur = InputScanner.getBoolean("Есть шерсть? (true/false): ");
    }
 
    @Override
    public Animal Create() {
        var animal = new Cat();
        animal.fillProperties();
        return animal;
    }

    @Override
    public String getKind() {
        return "Кошка";
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }

    @Override
    public void showAffection() {
        System.out.println("Трется о вашу ногу.");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Есть шерсть: " + hasFur);
    }
}
