public interface Animal {
    String getKind();
    Animal Create();
    Animal[] getTestData();

    int getHeight();
    void setHeight(int height);
    
    int getWeight();
    void setWeight(int weight);
    
    String getEyeColor();
    void setEyeColor(String color);
    
    void makeSound();
    void printInfo();
}
