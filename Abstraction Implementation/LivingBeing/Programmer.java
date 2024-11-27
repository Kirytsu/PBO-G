class Programmer extends Human {
    public Programmer(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " breathes through lungs.");
    }

    @Override
    public void grow() {
        System.out.println(getName() + " grows through education and life experiences.");
    }

    @Override
    public void speak() {
        System.out.println(getName() + " speaks in multiple programming languages.");
    }

    public void code() {
        System.out.println(getName() + " writes clean and efficient code.");
    }
}