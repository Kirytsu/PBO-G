abstract class Ticket {
    private String passengerName;
    private String flightNumber;
    private double basePrice;

    public Ticket(String passengerName, String flightNumber, double basePrice) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.basePrice = basePrice;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Abstract method 
    public abstract double calculateFare();

    public abstract String getClassName();
    
    public abstract String getFacilities();

    public void displayTicketInfo() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Class         : " + getClassName());
        System.out.println("Facilities    : " + getFacilities());
        System.out.printf("Base Fare     : Rp %.2f%n", basePrice);
        System.out.printf("Final Fare    : Rp %.2f%n", calculateFare());
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
