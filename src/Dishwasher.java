public class Dishwasher extends Appliance {
    private boolean underCounter;

    /**
     * constructor to create a object 
     * @param serialNumber serial number of the dishwasher
     * @param price price of the dishwasher
     * @param underCounter boolean deciding whether if its underCounter
     */
    public Dishwasher(String serialNumber, double price, boolean underCounter) {
        super(serialNumber, price);
        this.underCounter = underCounter;
    }

    
    public String toString() {
        return "Serial Num: " + serialNumber + ", $" + price + ", Undercounter: " + (underCounter ? "Yes" : "No");
        
    }
}
