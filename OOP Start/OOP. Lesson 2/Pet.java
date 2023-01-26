public interface Pet extends Animal {
    String getName();
    void setName(String name);
    
    String getBreed();
    void setBreed(String breed);
    
    boolean hasVaccines();
    void setVaccines(boolean vaccines);
    
    String getFurColor();
    void setFurColor(String furColor);
    
    String getBirthdate();
    void setBirthdate(String birthdate);
    
    void showAffection();
}
