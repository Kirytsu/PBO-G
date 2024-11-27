import java.util.List;

class Fox extends Animal {
    private static final int MAX_HUNGER = 3; 
    private int hungerLevel;

    public Fox(Location location) {
        super(location);
        this.hungerLevel = 0;
    }

    public void act(Field field, List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = hunt(field);  
            if (newLocation != null) {
                hungerLevel = 0;  
                setLocation(newLocation);  
            } else {
                hungerLevel++;  
                if (hungerLevel >= MAX_HUNGER) {
                    setDead();  
                } else {
                    newLocation = field.freeAdjacentLocation(getLocation());  
                    if (newLocation != null) {
                        setLocation(newLocation);  
                    }
                }
            }
        }
    }

    private Location hunt(Field field) {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        for (Location loc : adjacent) {
            Animal animal = field.getAnimalAt(loc);
            if (animal instanceof Rabbit && animal.isAlive()) {
                animal.setDead(); // Hunt and kill the rabbit
                return loc;
            }
        }
        return null; 
    }
}
