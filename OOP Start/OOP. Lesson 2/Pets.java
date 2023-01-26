public abstract class Pets extends Animals implements Pet {
    protected String name;
    protected String breed;
    protected boolean vaccines;
    protected String furColor;
    protected String birthdate;

    protected Pets() {
        super();
    }

    protected Pets(int height, int weight, String eyeColor, String name, String breed, boolean vaccines, String furColor, String birthdate) {
        super(height, weight, eyeColor);
        this.name = name;
        this.breed = breed;
        this.vaccines = vaccines;
        this.furColor = furColor;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean hasVaccines() {
        return vaccines;
    }

    public void setVaccines(boolean vaccines) {
        this.vaccines = vaccines;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public abstract void makeSound();

    @Override
    protected void fillProperties()
    {
        super.fillProperties();
        setName(InputScanner.getString("Введите имя: "));
        setBreed(InputScanner.getString("Введите породу: "));
        setFurColor(InputScanner.getString("Введите цвет шерсти: "));
        setBirthdate(InputScanner.getString("Введите дату рождения: "));
        setVaccines(InputScanner.getBoolean("Есть ли вакцины? (true/false): "));
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Имя: " + name);
        System.out.println("Порода: " + breed);
        System.out.println("Есть вакцины: " + vaccines);
        System.out.println("Цвет шерсти: " + furColor);
        System.out.println("Дата рождения: " + birthdate);
    }

    public abstract void showAffection();
}
