import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public Toy drawToy() {
        int totalWeight = toys.stream().mapToInt(Toy::getWeight).sum();
        int randomNumber = new Random().nextInt(totalWeight);
        int accumulatedWeight = 0;

        for (Toy toy : toys) {
            accumulatedWeight += toy.getWeight();
            if (randomNumber < accumulatedWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                }
            }
        }

        return null;
    }

    public void writeToyToFile(Toy toy) {
        try (FileWriter fileWriter = new FileWriter(toy.getName() + ".txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Name: " + toy.getName());
            printWriter.println("Quantity: " + toy.getQuantity());
            printWriter.println("Weight: " + toy.getWeight());
        } catch (IOException e) {
            System.out.println("Error writing toy data to file: " + e.getMessage());
        }
    }
}

