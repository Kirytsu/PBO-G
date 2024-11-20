public class BusinessTicket extends Ticket {
    public BusinessTicket(String passengerName, String flightNumber, double basePrice) {
        super(passengerName, flightNumber, basePrice);
    }

    @Override
    public double calculateFare() {
        return getBasePrice() * 1.25; 
    }

    @Override
    public String getClassName() {
        return "Business";
    }
    
    @Override
    public String getFacilities() {
        return "Reclining seat, 25kg baggage allowance, meal service";
    }
}
