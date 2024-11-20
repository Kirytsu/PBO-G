import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        double basePrice = 500000;
        
        tickets.add(new EconomyTicket("John Doe", "FL123", basePrice));
        tickets.add(new BusinessTicket("Jane Doe", "FL123", basePrice));
        tickets.add(new FirstClassTicket("Ellen Doe", "FL124", basePrice));

        System.out.println("\n================================= Flight Reservation System =================================");
        for (Ticket ticket : tickets) {
            ticket.displayTicketInfo();
        }
    }
}
