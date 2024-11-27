import java.util.List;
import java.util.ArrayList;

class Field {
    private Animal[][] field;
    int width, height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new Animal[width][height];
    }

    public Animal getAnimalAt(Location location) {
        return field[location.getX()][location.getY()];
    }

    public void placeAnimal(Animal animal) {
        field[animal.getLocation().getX()][animal.getLocation().getY()] = animal;
    }

    public void clearLocation(Location location) {
        field[location.getX()][location.getY()] = null;
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        if (x > 0) locations.add(new Location(x - 1, y));
        if (x < width - 1) locations.add(new Location(x + 1, y));
        if (y > 0) locations.add(new Location(x, y - 1));
        if (y < height - 1) locations.add(new Location(x, y + 1));
        return locations;
    }

    public Location freeAdjacentLocation(Location location) {
        for (Location loc : adjacentLocations(location)) {
            if (getAnimalAt(loc) == null) {
                return loc;
            }
        }
        return null;
    }

    public void printField() {
        int foxCount = 0;
        int rabbitCount = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Animal animal = field[x][y];
                if (animal instanceof Fox) {
                    System.out.print("F ");
                    foxCount++;
                } else if (animal instanceof Rabbit) {
                    System.out.print("R ");
                    rabbitCount++;
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Remaining Foxes   : " + foxCount);
        System.out.println("Remaining Rabbits : " + rabbitCount);
        System.out.println();
    }
}
