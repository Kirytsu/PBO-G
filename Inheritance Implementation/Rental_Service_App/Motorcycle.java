public class Motorcycle extends Vehicle {
    private int numWheels;

    public Motorcycle(String brand, String model, int year, int numWheels) {
        super(brand, model, year);
        this.numWheels = numWheels;
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle - Brand: " + brand + ", Model: " 
            + model + ", Year: " + year + ", Wheels: " + numWheels);
    }
}
