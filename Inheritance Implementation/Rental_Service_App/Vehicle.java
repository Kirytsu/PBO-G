public abstract class Vehicle {
    protected String brand;  
    protected String model;
    protected int year;
    protected String status;  
    protected String renterName;  

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = "Available";  
        this.renterName = null;  
    }

    public abstract void displayInfo();

    public String getStatus() {
        return status;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
}
