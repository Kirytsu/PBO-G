import java.util.List;
import java.util.Random;
import java.util.ArrayList;

class Simulation {
    private Field field;
    private List<Animal> animals;

    public Simulation(int width, int height) {
        field = new Field(width, height);
        animals = new ArrayList<>();
        populateField();
    }

    private void populateField() {
        Random rand = new Random();
        for (int i = 0; i < field.width; i++) {
            for (int j = 0; j < field.height; j++) {
                Location location = new Location(i, j);
                
                // Only place an animal if the location is not already occupied
                if (field.getAnimalAt(location) == null) {
                    if (rand.nextBoolean()) {
                        Rabbit rabbit = new Rabbit(location);
                        animals.add(rabbit);
                        field.placeAnimal(rabbit);
                    } else if (rand.nextBoolean()) {
                        Fox fox = new Fox(location);
                        animals.add(fox);
                        field.placeAnimal(fox);
                    }
                }
            }
        }
    }

    public void simulate(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("Step " + (i + 1));
            field.printField();

            List<Animal> newAnimals = new ArrayList<>();
            for (Animal animal : animals) {
                if (animal.isAlive()) {
                    field.clearLocation(animal.getLocation()); 
                    animal.act(field, newAnimals);
                    if (animal.isAlive()) {
                        field.placeAnimal(animal); 
                    }
                }
            }
            animals.addAll(newAnimals);
            animals.removeIf(animal -> !animal.isAlive());
        }
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation(10, 10);
        sim.simulate(5);
    }
}
