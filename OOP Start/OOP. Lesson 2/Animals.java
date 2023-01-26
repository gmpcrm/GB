public abstract class Animals implements Animal{
    protected int height;
    protected int weight;
    protected String eyeColor;

    protected Animals() {
    }

    protected Animals(int height, int weight, String eyeColor) {
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
    }

    protected void fillProperties(){
        setHeight(InputScanner.getInt("Введите рост: "));
        setWeight(InputScanner.getInt("Введите вес: "));
        setEyeColor(InputScanner.getString("Введите цвет глаз: "));
    }
    
    @Override
    public int getHeight() {
        return height;
    }
    
    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getWeight() {
        return weight;
    }
    
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public String getEyeColor() {
        return eyeColor;
    }
    
    @Override
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Вид: " + getKind());
        System.out.println("Рост: " + height);
        System.out.println("Вес: " + weight);
        System.out.println("Цвет глаз: " + eyeColor);
    }    
}
