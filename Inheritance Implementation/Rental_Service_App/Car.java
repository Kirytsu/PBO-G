public class Car extends Vehicle {
    private int numWheels;

    public Car(String brand, String model, int year, int numWheels) {
        super(brand, model, year);
        this.numWheels = numWheels;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car - Brand: " + brand + ", Model: " + model + ", Year: "
            + year + ", Wheels: " + numWheels);
    }
}
