
/**
 * Shows a generic appliance with a serial number and price
 */


public abstract class Appliance {
    protected String serialNumber;
    protected double price;
    /**
     * constructor to create an appliance with serial number and price
     * @param serialNumber
     * @param price
     * 
     */
    public Appliance(String serialNumber, double price) {
    	if(!isValid(serialNumber)) {
    		throw new IllegalApplianceException("Invalid serial number: " + serialNumber);
    		//throws an exception if the serial number is invalid
    	}
        this.serialNumber = serialNumber;
        this.price = price;
    }
    //string representation of the appliance
    public abstract String toString();
    
    /**
     * checks if serial number is valid
     * @param serialNumber
     * @return
     */
    public static boolean isValid(String serialNumber) {
    	return serialNumber.matches("[RDM][A-Z0-9]{11}");
    }
}

