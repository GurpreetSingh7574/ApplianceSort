public class ProjectMain {
    public static void main(String[] args) {
    	//create a new sorted appliance list
        SortedApplianceList applianceList = new SortedApplianceList();
        //initialize and display the GUI
        new ApplianceGUI(applianceList);
    }
}
