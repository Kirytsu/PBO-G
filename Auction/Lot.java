public class Lot {
    private int number;
    private String description;
    private Bid highestBid;

    public Lot(int number, String description) {
        this.number = number;
        this.description = description;
        this.highestBid = null;  // No bids initially
    }

    public Bid getHighestBid() {
        return highestBid;
    }
    
    // Check the bid 
    public boolean bidFor(Bid bid) {
        if (highestBid == null || bid.getValue() > highestBid.getValue()) {
            highestBid = bid;
            return true; 
        } else {
            return false;
        }
    }
    
    // Get lot number
    public int getNumber() {
        return number;
    }
    
    // Override the default toString method 
    @Override
    public String toString() {
        return "Lot " + number + ": " + description + " (Highest Bid: " +
               (highestBid == null ? "None" : highestBid.getValue() + " by " + highestBid.getBidder().getName()) + ")";
    }
}
