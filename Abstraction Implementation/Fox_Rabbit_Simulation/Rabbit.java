class Rabbit extends Animal {
    public Rabbit(Location location) {
        super(location);
    }

    @Override
    public void act(Field field, java.util.List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = field.freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }
}
