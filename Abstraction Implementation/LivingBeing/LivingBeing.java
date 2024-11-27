abstract class LivingBeing {
    private String name;

    public LivingBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void breathe();

    public abstract void grow();
}

