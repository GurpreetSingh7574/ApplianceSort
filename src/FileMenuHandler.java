import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * this class handles actions, like open and quit
 */
public class FileMenuHandler implements ActionListener {
    private ApplianceGUI gui;

    public FileMenuHandler(ApplianceGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if ("Open".equals(command)) {
            gui.openFile(); // load the file
        } else if ("Quit".equals(command)) {
            System.exit(0); // exit the program
        } else if("Search".equals(command)) {
        	gui.searchAppliance(); //be able to search for an appliance
        }
    }
}
