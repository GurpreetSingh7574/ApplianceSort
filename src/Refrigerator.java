public class Refrigerator extends Appliance {
    private double cubicFeet;
    
    /**
     * Contructor to create a refrigerator object
     * @param serialNumber
     * @param price 
     * @param cubicFeet
     */
    public Refrigerator(String serialNumber, double price, double cubicFeet) {
        super(serialNumber, price);
        this.cubicFeet = cubicFeet;
    }

    
    public String toString() {
        return "Serial Num : " + serialNumber + ", $" + price + ", FT: " + cubicFeet;
    }
}
