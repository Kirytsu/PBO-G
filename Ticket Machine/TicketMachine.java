
/**
 * Write a description of class TicketMachine here.
 *
 * @author Nathanael Valen Susilo
 * @version 0.1
 */
public class TicketMachine
{
    // instance variables - replace the example below with your own
    private int price;
    private int balance;
    private int total;
    
    /**
     * Constructor for objects of class TicketMachine
     */
    public TicketMachine(int ticketCost)
    {
        // initialise instance variables
        if (ticketCost > 0){
            price = ticketCost;
            balance = 0;
            total = 0;
        }
        else {
            System.out.println ("Ticket price cannot be negative : " 
                                + ticketCost); 
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getPrice(){
        return price;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void insertMoney(int amount){
        if (amount > 0){
            balance = balance + amount;
        }
        else {
            System.out.println("Amount cannot be negative : " + amount);
        }
    }
    
    public void printTicket(){
        if (balance >= price) {
            System.out.println("######################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("######################");
            System.out.println();
            
            total = total + price;
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least : " + 
                            (price - balance) + " more cents.");
        }
    }
}
