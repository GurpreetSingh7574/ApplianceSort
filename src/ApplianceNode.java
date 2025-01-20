public class ApplianceNode {
    protected Appliance data;
    protected ApplianceNode next;

    //constructor to create a new node 
    public ApplianceNode(Appliance data) {
        this.data = data;
        this.next = null;
    }
}
