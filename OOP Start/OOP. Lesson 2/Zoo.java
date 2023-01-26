import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Zoo {
    private Animal[] animals;
    
    public Zoo() {
        animals = new Animal[10];
    }

    public void makeNewZoo(){
        List<Animal> world = new ArrayList<>();
        for (Animal animal : AnimalFactory.getAnimals()) {
            world.addAll(Arrays.asList(animal.getTestData()));
        }

        Collections.shuffle(world);
        for (int i = 0; i < animals.length; i++) {
            animals[i] = world.get(i);
        }        
    }

    public void insertAnimal(int idx, Animal animal) {
        if (idx < 0 || idx > animals.length - 1) {
            System.out.println("Неверный индекс");
            return;
        }

        for (int i = animals.length - 1; i > idx; i--) {
            animals[i] = animals[i-1];
        }

        animals[idx] = animal;
        System.out.println("Животное добавлено");
    }

    boolean validateAnimalIndex(int idx) {
        if (idx > animals.length - 1 || idx < 0 || animals[idx] == null) {
            System.out.println("Животное не найдено");
            return false;
        }

        return true;
    }

    public void removeAnimal(int idx) {
        if (validateAnimalIndex(idx))
        {
            for (int i = idx; i < animals.length - 1; i++) {
                animals[i] = animals[i + 1];
            }

            animals[animals.length - 1] = null;
            System.out.println("Животное удалено");
        }
    }    
    
    public void printAnimals() {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                System.out.println("Номер животного: " + i);
                printAnimal(i);
                return;
            }
        }

        System.out.println("В зоопарке нет животных");
    }

    public void printAnimal(int idx) {
        if (validateAnimalIndex(idx))
        {
            animals[idx].printInfo();
        }
    }

    public void makeAnimalsSound() {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                makeAnimalSound(i);
                return;
            }
        }

        System.out.println("В зоопарке нет животных");
    }

    public void makeAnimalSound(int idx) {
        if (validateAnimalIndex(idx))
        {
            animals[idx].makeSound();
        }
    }
}