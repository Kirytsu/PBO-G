class FloweringPlant extends Plant {
    public FloweringPlant(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " breathes through stomata.");
    }

    @Override
    public void grow() {
        System.out.println(getName() + " grows and blooms beautiful flowers.");
    }

    @Override
    public void photosynthesize() {
        System.out.println(getName() + " converts sunlight into energy through photosynthesis.");
    }

    public void bloom() {
        System.out.println(getName() + " blooms with vibrant flowers.");
    }
}