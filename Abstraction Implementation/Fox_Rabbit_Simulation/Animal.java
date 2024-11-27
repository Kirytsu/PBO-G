abstract class Animal {
    private boolean alive;
    private Location location;

    public Animal(Location location) {
        this.alive = true;
        this.location = location;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        this.alive = false;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public abstract void act(Field field, java.util.List<Animal> newAnimals);
}
