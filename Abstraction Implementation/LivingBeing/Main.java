public class Main {
    public static void main(String[] args) {
        // Instances of each subclasses
        Human programmer = new Programmer("Bob");
        Animal bird = new Bird("Sparrow");
        Plant floweringPlant = new FloweringPlant("Rose");

        System.out.println("Human - Programmer:");
        programmer.breathe();
        programmer.grow();
        programmer.speak();
        ((Programmer) programmer).code();

        System.out.println("\nAnimal - Bird:");
        bird.breathe();
        bird.grow();
        bird.move();
        ((Bird) bird).sing();

        System.out.println("\nPlant - FloweringPlant:");
        floweringPlant.breathe();
        floweringPlant.grow();
        floweringPlant.photosynthesize();
        ((FloweringPlant) floweringPlant).bloom();
    }
}