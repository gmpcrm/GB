import java.util.Arrays;
import java.util.stream.Collectors;

class AnimalFactory {
    private static final Animal[] animals = {
        new Cat(),
        new Chicken(),
        new Dog(),
        new Stork(),
        new Wolf(),
        new Tiger()
    };

    public static Animal[] getAnimals() {
        return animals;
    }
    
    public static Animal createAnimal(String kind) {
        for (Animal animal : animals) {
            if (animal.getKind().equals(kind)) {
                return animal.Create();
            }
        }
        
        return null;
    }

    public static String getAvailableAnimals() {
        return Arrays.stream(animals).
            map(Animal::getKind).
            collect(Collectors.joining(","));
    }
}
