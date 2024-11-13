import java.util.ArrayList;
import java.util.List;
public class RentalSystem {
    private List<Vehicle> vehicleList;
    
    public RentalSystem() {
        vehicleList = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void rentVehicle(Vehicle vehicle, String renterName) {
        if (vehicle.getStatus().equals("Available")) {
            vehicle.setStatus("Rented");
            vehicle.setRenterName(renterName);
            System.out.println(vehicle.getClass().getSimpleName() + " (" + vehicle.brand + " " + vehicle.model + 
                ") has been rented to " + renterName);
        } else {
            System.out.println(vehicle.getClass().getSimpleName() + " (" + vehicle.brand + " " + vehicle.model + 
                ") is already rented.");
        }
        System.out.println("");
    }

    public void returnVehicle(Vehicle vehicle) {
        if (vehicle.getStatus().equals("Rented")) {
            System.out.println(vehicle.getClass().getSimpleName() + " (" + vehicle.brand + " " + vehicle.model + 
                ") has been returned by " + vehicle.getRenterName());
            vehicle.setStatus("Available");
            vehicle.setRenterName(null);
        } else {
            System.out.println(vehicle.getClass().getSimpleName() + " (" + vehicle.brand + " " + vehicle.model + 
                ") is already available.");
        }
        System.out.println("");
    }

    public void displayAllVehicles() {
        System.out.println("============================= All Vehicles =============================");
        for (Vehicle vehicle : vehicleList) {
            System.out.println("");
            vehicle.displayInfo();
            displayStatus(vehicle);
            System.out.println("========================================================================");
        }
        System.out.println("");
    }

    public void displayStatus(Vehicle vehicle) {
        String status = vehicle.getStatus();
        System.out.println("Status: " + status);
        if (status.equals("Rented")) {
            System.out.println("Rented by: " + vehicle.getRenterName());
        }
    }
}
