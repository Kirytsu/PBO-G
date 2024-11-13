public class Bicycle extends Vehicle {
    private String bicycleType;

    public Bicycle(String brand, String model, int year, String bicycleType) {
        super(brand, model, year);
        this.bicycleType = bicycleType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bicycle - Brand: " + brand + ", Model: " 
            + model + ", Year: " + year + ", Type: " + bicycleType);
    }
}
