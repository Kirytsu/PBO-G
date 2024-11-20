public class FirstClassTicket extends Ticket {
    public FirstClassTicket(String passengerName, String flightNumber, double basePrice) {
        super(passengerName, flightNumber, basePrice);
    }

    @Override
    public double calculateFare() {
        return getBasePrice() * 1.5; 
    }

    @Override
    public String getClassName() {
        return "First Class";
    }
    
    @Override
    public String getFacilities() {
        return "Luxury seat, 40kg baggage allowance, gourmet meal service, lounge access";
    }
}
