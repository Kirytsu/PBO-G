public class ParkingTicketMachine
{
    private long balance;
    private long ticketPrice;
    private long ticketTime;
    
    public ParkingTicketMachine(long price)
    {
        this.ticketPrice = price;
        this.balance = 0;
        this.ticketTime = 0;
    }
    
    public void insertMoney(long money)
    {
        this.balance += money;    
    }
    
    public void issueTicket()
    {
        long totalPrice = ticketPrice * ticketTime;
        if (ticketTime == 0){
            System.out.println("Tolong masukkan waktu parkir");
        }
        
        else if (totalPrice > balance)
        {
            System.out.println("Saldo anda tidak cukup");
        }
        
        else 
        {
            System.out.println("##########################");
            System.out.println("###### Tiket Parkir ######");
            System.out.println("Waktu parkir : " + ticketTime + " jam");
            System.out.println("Harga        : Rp. " + totalPrice);
            System.out.println("##########################");
            this.ticketTime = 0;
            this.balance -= totalPrice;
        }
    }
    
    public void retrieveBalance()
    {
        System.out.println("Saldo dikembalikan sebesar Rp. " + balance);
        balance = 0;
    }
    
    public void setTimePurchase(long time)
    {
        this.ticketTime = time;
    }
    
    public long getTimePurchased()
    {
        return ticketTime;
    }
    
    public long getBalance()
    {
        return balance;
    }
    
    public long getPrice()
    {
        return ticketPrice;
    }
    
}
