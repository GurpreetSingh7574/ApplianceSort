import java.util.*;

public class SortedApplianceList {
	//TreeMap for storing the appliances
    private TreeMap<String, Appliance> refrigerators;
    private TreeMap<String, Appliance> dishwashers;
    private TreeMap<String, Appliance> microwaves;

    /**
     * constructor to initialize tree maps
     */
    public SortedApplianceList() {
        this.refrigerators = new TreeMap<>(Comparator.naturalOrder());
        this.dishwashers = new TreeMap<>(Comparator.naturalOrder());
        this.microwaves = new TreeMap<>(Comparator.naturalOrder());
    }

    /**
     * add an appliance to the appropriate tree map
     * @param appliance
     */
    public void add(Appliance appliance) {
    	//check the type of appliance
        if (appliance instanceof Refrigerator) {
            refrigerators.put(appliance.serialNumber, appliance);//add refrigerator
        } else if (appliance instanceof Dishwasher) {
            dishwashers.put(appliance.serialNumber, appliance);//add dishwasher
        } else if (appliance instanceof Microwave) {
            microwaves.put(appliance.serialNumber, appliance); //add microwave
        }
    }
    
    public TreeMap<String, Appliance> getRefrigerators() {
        return refrigerators; //tree map of refrigerators 
    }

    public TreeMap<String, Appliance> getDishwashers() {
        return dishwashers; //tree map of dishwasher
    }

    public TreeMap<String, Appliance> getMicrowaves() {
        return microwaves; //tree map of microwave
    }
}
