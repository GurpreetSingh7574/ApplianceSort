public abstract class ApplianceList {
    protected ApplianceNode first;
    protected ApplianceNode last;
    protected int length;

    //constructor to initialize an empty list appliances
    public ApplianceList() {
        first = new ApplianceNode(null); // dummy head node
        last = first;
        length = 0;
    }
   
    public void append(Appliance d) {
        ApplianceNode n = new ApplianceNode(d);
        last.next = n;
        last = n;
        length++;
    }
}
