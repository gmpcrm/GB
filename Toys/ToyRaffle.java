import java.util.ArrayList;
import java.util.Random;

public class ToyRaffle {
    private ArrayList<Toy> toys;

    public ToyRaffle(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public Toy getRandomToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = new Random().nextDouble() * totalWeight;
        double cumulativeWeight = 0.0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null;
    }
}
