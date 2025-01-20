# Appliance Management System

## Overview
A Java-based application designed to manage a collection of appliances, such as refrigerators, dishwashers, and microwaves. 
The system allows users to load appliance data from a file, display categorized information, and perform searches based on specific criteria. 
Appliances are organized using a `TreeMap` for efficient storage and retrieval.

## Features
- **File Handling**: Load appliance data from a file and categorize them by type.
- **Data Validation**: Ensures appliances have valid serial numbers and attributes.
- **Dynamic GUI**: Displays categorized appliances in a user-friendly graphical interface.
- **Search Functionality**: Search appliances by type and maximum price.
- **Sorted Storage**: Uses a `TreeMap` to store and sort appliances by serial number.

## Project Structure
- **Appliance.java**: Abstract base class representing a generic appliance with a serial number and price.
- **Refrigerator.java**: Subclass of `Appliance` representing refrigerators with an additional cubic feet attribute.
- **Dishwasher.java**: Subclass of `Appliance` representing dishwashers with an under-counter flag.
- **Microwave.java**: Subclass of `Appliance` representing microwaves with wattage information.
- **ApplianceNode.java**: Represents a node in a linked list, containing an `Appliance` object and a reference to the next node.
- **ApplianceList.java**: Abstract class providing the structure for linked lists of appliances, including methods for appending appliances.
- **SortedApplianceList.java**: Manages categorized appliances (refrigerators, dishwashers, microwaves) using `TreeMap`.
- **ApplianceGUI.java**: Main GUI class that displays appliance categories and their details. Supports file loading and searching.
- **FileMenuHandler.java**: Handles file menu actions such as opening a file, searching, and quitting the application.
- **IllegalApplianceException.java**: Custom exception for handling invalid appliance data.
- **ProjectMain.java**: Entry point of the application. Initializes the GUI with an empty sorted appliance list.

## Setup
### Prerequisites
- Java 8 or later
- An IDE such as IntelliJ IDEA, Eclipse, or any Java-compatible IDE

### Steps to Run
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Open the project in your IDE.
3. Compile the project.
4. Run the `ProjectMain` class to start the application.
