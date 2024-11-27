class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " breathes through lungs and air sacs.");
    }

    @Override
    public void grow() {
        System.out.println(getName() + " grows from a hatchling to an adult bird.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " flies gracefully in the sky.");
    }

    public void sing() {
        System.out.println(getName() + " sings beautiful songs.");
    }
}