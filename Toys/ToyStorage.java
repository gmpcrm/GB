import java.util.ArrayList;

public class ToyStorage {
    private ArrayList<Toy> toys;

    public ToyStorage() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void removeToy(Toy toy) {
        toys.remove(toy);
    }
    
    public Toy removeToy(int index) {
        return toys.remove(index);
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }
}
