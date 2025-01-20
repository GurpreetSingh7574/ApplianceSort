public class Microwave extends Appliance {
    private int watts;

    /**
     * create a microwave object with information
     * @param serialNumber serial number of the microwave
     * @param price price of the microwave
     * @param watts the wattage 
     */
    public Microwave(String serialNumber, double price, int watts) {
        super(serialNumber, price);
        this.watts = watts;
    }

    
    public String toString() {
        return "Serial Num : " + serialNumber + ", $ " + price + ", Watts: " + watts;
    }
}
