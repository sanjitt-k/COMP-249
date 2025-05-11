package Vehicle;

import java.util.Scanner;
import Client.Client;

/**
 * Class to manage leasing operations.
 * Contains methods to lease, return, and display lease records.
 */
public class LeaseManager {
    
    // Create a Lease class for the vehicle values along with methods
    public static class Lease {
        private Client client;
        private Vehicle vehicle;
        
        
        /**
         * Constructor for Lease.
         * 
         * @param client  the client leasing the vehicle
         * @param vehicle the vehicle being leased
         */
        public Lease(Client client, Vehicle vehicle) {
            this.client = client;
            this.vehicle = vehicle;
        }
       
        /**
         * Gets the client associated with the lease.
         * 
         * @return the client
         */
        public Client getClient() {
            return client;
        }
        
        /**
         * Gets the vehicle associated with the lease.
         * 
         * @return the vehicle
         */
        public Vehicle getVehicle() {
            return vehicle;
        }
        
        /**
         * Returns a string representation of the lease record.
         * 
         * @return a string describing the lease
         */
        @Override
        public String toString() {
            return "Lease Record:\n" + client.toString() + "\n" + vehicle.toString();
        }
    }
    
    /**
     * Leases a vehicle to a client.
     * 
     * @param keyboard       A Scanner for user input.
     * @param clientCount   The current number of clients.
     * @param vehicleList   An array of Vehicle objects.
     * @param vehicleCount  The current number of vehicles.
     * @param leaseList     An array of Lease objects (fixed-size).
     * @param leaseCount    A one-element int array holding the current number of leases.
     * @param MAX_LEASES    The maximum number of leases allowed.
     */
    public static void leaseVehicle(Scanner keyboard, Client[] clientList, int clientCount,
                                    Vehicle[] vehicleList, int vehicleCount,
                                    Lease[] leaseList, int[] leaseCount, int MAX_LEASES) {
        // Check if there is room for a new lease
        if (leaseCount[0] >= MAX_LEASES) {
            System.out.println("No more leases can be added (lease list is full).");
            return;
        }
        
        // List available clients
        System.out.println("\n--- List of Clients ---");
        for (int i = 0; i < clientCount; i++) {
            System.out.println(clientList[i]);
        }
        
        System.out.print("Enter the Client ID to lease a vehicle to: ");
        int clientId = keyboard.nextInt();
        keyboard.nextLine(); // consume newline
        
        Client selectedClient = null;
        for (int i = 0; i < clientCount; i++) {
            if (clientList[i].getClientId() == clientId) {
                selectedClient = clientList[i];
                break;
            }
        }
        if (selectedClient == null) {
            System.out.println("No client found with ID " + clientId);
            return;
        }
        
        // List available vehicles
        System.out.println("\n--- List of Vehicles ---");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(vehicleList[i]);
        }
        
        System.out.print("Enter the Plate Number of the vehicle to lease: ");
        String plateNumber = keyboard.nextLine();
        
        Vehicle selectedVehicle = null;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicleList[i].getPlateNumber().equalsIgnoreCase(plateNumber)) {
            	selectedVehicle = vehicleList[i];
                break;
            }
        }
        if (selectedVehicle == null) {
            System.out.println("No vehicle found with Plate Number " + plateNumber);
            return;
        }
        
        // Check if the vehicle is already leased
        for (int i = 0; i < leaseCount[0]; i++) {
            if (leaseList[i].getVehicle().getPlateNumber().equalsIgnoreCase(plateNumber)) {
                System.out.println("This vehicle is already leased.");
                return;
            }
        }
        
        // Create the new lease record and add it to the leaseList array
        Lease newLease = new Lease(selectedClient, selectedVehicle);
        leaseList[leaseCount[0]] = newLease;
        leaseCount[0]++;
        
        System.out.println("Vehicle leased successfully!");
        System.out.println(newLease);
    }
    /**
     * Returns a vehicle from a client.
     * This method prompts the user for the Plate Number of the vehicle being returned,
     * then searches the lease records for that vehicle. If found, the lease record is removed,
     * the array elements are shifted, and the lease count is decremented.
     *
     * @param keyboard    A Scanner instance for user input.
     * @param leaseList  Fixed-size array of Lease objects.
     * @param leaseCount A one-element array holding the current number of leases.
     */
    public static void returnVehicle(Scanner keyboard, Lease[] leaseList, int[] leaseCount) {
        if (leaseCount[0] == 0) {
            System.out.println("No vehicles are currently leased.");
            return;
        }
        
        // List all leased vehicles
        System.out.println("\n--- List of Leased Vehicles ---");
        for (int i = 0; i < leaseCount[0]; i++) {
            System.out.println(leaseList[i]);
        }
        
        // Prompt for the plate number of the vehicle to return
        System.out.print("Enter the Plate Number of the vehicle to return: ");
        String plate = keyboard.nextLine();
        
        // Search for the lease record with the matching vehicle plate number
        int indexToDelete = -1;
        for (int i = 0; i < leaseCount[0]; i++) {
            if (leaseList[i].getVehicle().getPlateNumber().equalsIgnoreCase(plate)) {
                indexToDelete = i;
                break;
            }
        }
        
        if (indexToDelete == -1) {
            System.out.println("No leased vehicle found with Plate Number " + plate);
            return;
        }
        
        // Shift the array elements to remove the lease record
        for (int i = indexToDelete; i < leaseCount[0] - 1; i++) {
            leaseList[i] = leaseList[i + 1];
        }
        leaseList[leaseCount[0] - 1] = null;
        leaseCount[0]--;
        
        System.out.println("Vehicle returned successfully.");
    }
    /**
     * Shows all vehicles leased by a specific client.
     * The user selects a client by entering their Client ID.
     * The method then searches the lease records and displays the vehicles leased by that client.
     *
     * @param keyboard    A Scanner instance for user input.
     * @param leaseList  Fixed-size array of Lease objects.
     * @param leaseCount A one-element array holding the current number of leases.
     * @param clientList Array of clients.
     * @param clientCount Current number of clients.
     */
    public static void LeasedVehiclesByClient(Scanner keyboard, Lease[] leaseList, int[] leaseCount, 
                                                  Client[] clientList, int clientCount) {
        if (leaseCount[0] == 0) {
            System.out.println("No vehicles are currently leased.");
            return;
        }

        // Display all clients
        System.out.println("\n--- List of Clients ---");
        for (int i = 0; i < clientCount; i++) {
            System.out.println(clientList[i]);
        }

        // Prompt user to enter a Client ID
        System.out.print("Enter the Client ID to view leased vehicles: ");
        int clientId = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline

        Client selectedClient = null;
        for (int i = 0; i < clientCount; i++) {
            if (clientList[i].getClientId() == clientId) {
                selectedClient = clientList[i];
                break;
            }
        }

        if (selectedClient == null) {
            System.out.println("No client found with ID " + clientId);
            return;
        }

        // Check for vehicles leased by this client
        boolean found = false;
        System.out.println("\nVehicles leased by " + selectedClient.getName() + ":");
        for (int i = 0; i < leaseCount[0]; i++) {
            if (leaseList[i].getClient().getClientId() == clientId) {
                System.out.println(leaseList[i].getVehicle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("This client has not leased any vehicles.");
        }
    }

    /**
     * Shows all leased vehicles along with their corresponding clients.
     * 
     * @param leaseList  Fixed-size array of Lease objects.
     * @param leaseCount A one-element array holding the current number of leases.
     */
    public static void AllLeasedVehicles(Lease[] leaseList, int[] leaseCount) {
        if (leaseCount[0] == 0) {
            System.out.println("No vehicles are currently leased.");
            return;
        }

        System.out.println("\n--- All Leased Vehicles ---");
        for (int i = 0; i < leaseCount[0]; i++) {
            System.out.println(leaseList[i]);
        }
    }
    
    
}