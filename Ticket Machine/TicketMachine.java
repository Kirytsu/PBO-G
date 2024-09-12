
/**
 * Write a description of class TicketMachine here.
 *
 * @author Nathanael Valen Susilo
 * @version 0.5
 */
public class TicketMachine
{
    // instance variables - replace the example below with your own
    private int price;
    private int balance;
    private int quantity;
    private int priceTotal;
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
            quantity = 1;
            priceTotal = price; // default quantity is 1
            total = 0;
        }
        else {
            throw new IllegalArgumentException(
            "Ticket price must have positive value : " + ticketCost);
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

    public int getRevenue(){
        return total;
    }
    
    public void insertMoney(int amount){
        if (amount > 0){
            balance = balance + amount;
        }
        else {
            System.out.println("Amount cannot be negative : " + amount);
        }
    }

    public void chooseQuantity(int qty){
        quantity = qty;
        priceTotal = price * qty;
    }
    
    public void withdrawBalance(){
        System.out.println("Balance withdrawed : " + balance);
        balance -= balance;
    }

    public void printTicket(){
        if (balance >= priceTotal) {
            System.out.println("######################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("# Valid for : " + (priceTotal/price)+ " usage");
            System.out.println("######################");
            System.out.println();
            
            total = total + priceTotal;
            balance = balance - priceTotal;
            priceTotal = price;
        }
        else {
            System.out.println("You must insert at least : " + 
                            (priceTotal - balance) + " more cents.");
        }
    }
}
