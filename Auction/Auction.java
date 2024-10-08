import java.util.ArrayList;

public class Auction {
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered into this auction.
    private int nextLotNumber;

    public Auction() {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is successful or not.
     * @param lotNumber The number of the lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
    Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
                if(successful) {
                System.out.println("The bid for lot number " +
                lotNumber + " was successful.");
                
            }
            else {
                // Report which bid is higher.               
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                " already has a bid of: " +
                highestBid.getValue());
                
                }
        }
    }

    /**
     * Return the lot with the given number. Return null if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     * @return The selected Lot, or null if the lot does not exist.
     */
    public Lot getLot(int lotNumber) {
        if (lotNumber >= 1 && lotNumber < nextLotNumber) {
            Lot selectedLot = lots.get(lotNumber - 1);
            // Confidence check to make sure we have the right lot.
            if (selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " +
                        selectedLot.getNumber() + " was returned instead of " +
                        lotNumber);
                return null;
            }
            return selectedLot;
        } else {
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }
    }
}
