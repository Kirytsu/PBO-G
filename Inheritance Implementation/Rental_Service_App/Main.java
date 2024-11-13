public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        Car car1 = new Car("Toyota", "Avanza", 2020, 4);
        Motorcycle motorcycle1 = new Motorcycle("Yamaha", "R15", 2021, 2);
        Bicycle bicycle1 = new Bicycle("Merida", "Crossway 100", 2023, "Hybrid");

        rentalSystem.addVehicle(car1);
        rentalSystem.addVehicle(motorcycle1);
        rentalSystem.addVehicle(bicycle1);

        rentalSystem.displayAllVehicles();

        rentalSystem.rentVehicle(car1, "Alice");
        rentalSystem.rentVehicle(motorcycle1, "Bob");

        rentalSystem.displayAllVehicles();

        rentalSystem.returnVehicle(car1);
        rentalSystem.returnVehicle(bicycle1);

        rentalSystem.displayAllVehicles();
    }
}
