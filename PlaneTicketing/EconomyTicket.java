public class EconomyTicket extends Ticket {
    public EconomyTicket(String passengerName, String flightNumber, double basePrice) {
        super(passengerName, flightNumber, basePrice);
    }

    @Override
    public double calculateFare() {
        return getBasePrice() * 0.9; 
    }

    @Override
    public String getClassName() {
        return "Economy";
    }
    
    @Override
    public String getFacilities() {
        return "Standard seat, 15kg baggage allowance";
    }
}
