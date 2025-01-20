import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ApplianceGUI {
    private JFrame frame;
    private JPanel refrigeratorPanel;
    private JPanel dishwasherPanel;
    private JPanel microwavePanel;
    private SortedApplianceList list;

    // constructor to initialize the GUI with the list of appliances
    public ApplianceGUI(SortedApplianceList list) {
    	this.list=list;
        frame = new JFrame("Appliance List"); //set the title
        frame.setLayout(new GridLayout(1, 3)); // 1 row, 3 columns

        //refrigerator panel
        refrigeratorPanel = new JPanel();
        refrigeratorPanel.setLayout(new BoxLayout(refrigeratorPanel, BoxLayout.Y_AXIS));
        refrigeratorPanel.add(new JLabel("Refrigerator", JLabel.CENTER));

        //dishwasher panel
        dishwasherPanel = new JPanel();
        dishwasherPanel.setLayout(new BoxLayout(dishwasherPanel, BoxLayout.Y_AXIS));
        dishwasherPanel.add(new JLabel("Dishwasher", JLabel.CENTER));

        //microwave panel
        microwavePanel = new JPanel();
        microwavePanel.setLayout(new BoxLayout(microwavePanel, BoxLayout.Y_AXIS));
        microwavePanel.add(new JLabel("Microwave", JLabel.CENTER));

        setupMenu();

        frame.add(refrigeratorPanel);
        frame.add(dishwasherPanel);
        frame.add(microwavePanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1000);
        frame.setVisible(true);
    }

    /**
     * fill the panels with the data, from the tree map in the sorted appliance list.
     * @param list 
     */
    private void fillPanels() {
    	//refrigerator
        refrigeratorPanel.removeAll();
        Iterator<Map.Entry<String, Appliance>> refIterator = list.getRefrigerators().entrySet().iterator();
        while (refIterator.hasNext()) {
        	//iterate over the refrigerators
            Map.Entry<String, Appliance> entry = refIterator.next();
            refrigeratorPanel.add(new JLabel(entry.getValue().toString()));
        }
        //dishwasher
        dishwasherPanel.removeAll();
        Iterator<Map.Entry<String, Appliance>> dishIterator = list.getDishwashers().entrySet().iterator();
        while (dishIterator.hasNext()) {
            //iterate over the dishwashers
        	Map.Entry<String, Appliance> entry = dishIterator.next();
            dishwasherPanel.add(new JLabel(entry.getValue().toString()));
        }
        //microwave
        microwavePanel.removeAll();
        Iterator<Map.Entry<String, Appliance>> microIterator = list.getMicrowaves().entrySet().iterator();
        while (microIterator.hasNext()) {
        	//iterate over the microwaves
            Map.Entry<String, Appliance> entry = microIterator.next();
            microwavePanel.add(new JLabel(entry.getValue().toString()));
        }
    }

    /**
     * set up the menu bar with options to open, quit , or search.
     */
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        //create options for open and quit
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem quitItem = new JMenuItem("Quit");
        JMenuItem searchItem = new JMenuItem("Search");

        //add action listener to menu items
        FileMenuHandler menuHandler = new FileMenuHandler(this);
        openItem.addActionListener(menuHandler);
        quitItem.addActionListener(menuHandler);
        searchItem.addActionListener(menuHandler);

        fileMenu.add(openItem);
        fileMenu.add(searchItem);
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);

        //set the menu bar on the frame
        frame.setJMenuBar(menuBar);
    }

    //open the file and read the file 
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                SortedApplianceList newList = new SortedApplianceList(); 
                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        String[] parts = line.split(",");
                        String serialNumber = parts[0];
                        double price = Double.parseDouble(parts[1]);
                        if (serialNumber.startsWith("R")) {
                            double cubicFeet = Double.parseDouble(parts[2]);
                            newList.add(new Refrigerator(serialNumber, price, cubicFeet));
                        } else if (serialNumber.startsWith("D")) {
                            boolean underCounter = parts[2].equalsIgnoreCase("Y");
                            newList.add(new Dishwasher(serialNumber, price, underCounter));
                        } else if (serialNumber.startsWith("M")) {
                            int watts = Integer.parseInt(parts[2]);
                            newList.add(new Microwave(serialNumber, price, watts));
                        }
                    } catch (IllegalApplianceException e) {
                        System.out.println(e.getMessage());
                    }
                }
                this.list = newList;
                fillPanels();
                frame.revalidate();
                frame.repaint();
            } catch (IOException e) {
                e.printStackTrace(); //handle file reading error
            }
        }
    }
    /**
     * Prompts the user to search for appliances by type and price 
     */
    public void searchAppliance() {
        String input = JOptionPane.showInputDialog(frame, "Enter criteria (R/D/M,price):");
        if (input != null) {
            String[] parts = input.split(",");
            if (parts.length != 2 || (!parts[0].equalsIgnoreCase("R") && !parts[0].equalsIgnoreCase("D") && !parts[0].equalsIgnoreCase("M"))) {
                JOptionPane.showMessageDialog(frame, "Invalid format. Use R/D/M,price.");
                return;
            }
            char type = parts[0].toUpperCase().charAt(0);
            double maxPrice;
            try {
                maxPrice = Double.parseDouble(parts[1]);
                TreeMap<String, Appliance> selectedMap; {
                switch (type) {
                	case 'R'://if R, do the following
                		selectedMap = list.getRefrigerators();
                		break;
                	case 'D': //if D, do the following
                		selectedMap = list.getDishwashers();
                		break;
                	case 'M': //if M, do the following
                		selectedMap = list.getMicrowaves();
                		break;
                	default:
                		selectedMap = null;
            }
                }
                

                if (selectedMap != null) {
                	//Iterate over the map and display matching appliances.
                    Iterator<Map.Entry<String, Appliance>> iterator = selectedMap.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Appliance> entry = iterator.next();
                        if (entry.getValue().price <= maxPrice) {
                            System.out.println(entry.getValue());
                        }
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid price format.");
            }
        }
    }
}