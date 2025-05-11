package Client;

import java.util.Scanner;

public class ClientManager {
	
	 /**
     * Prompts the user for the client's name and address, creates a new Client object,
     * and returns it. 
     * 
     * @param keyboard A Scanner instance for user input.
     * @return A new Client object created from user input.
     */

    public static Client addClient(Scanner keyboard) { // add client method 
        System.out.print("Enter client's name: ");
        String name = keyboard.nextLine();

        System.out.print("Enter client's address: ");
        String address = keyboard.nextLine();
        Client newClient = new Client(name, address);
        
        System.out.println("Client added successfully!");
        System.out.println(newClient);
        return newClient;
    }
    
    /**
     * Allows the user to edit an existing client's name and address by client ID.
     *
     * @param keyboard     A Scanner instance for user input.
     * @param clientList  An array of Client objects.
     * @param clientCount The current number of clients in the array.
     */
    public static void editClient(Scanner keyboard, Client[] clientList, int clientCount) {
        if (clientCount == 0) {
            System.out.println("No clients available to edit.");
            return;
        }
        
        // Display the list of clients with their client IDs
        System.out.println("\n--- List of Clients ---");
        for (int i = 0; i < clientCount; i++) {
            System.out.println(clientList[i]);
        }
        
        // Prompt the user to enter the client ID
        System.out.print("Enter the Client ID you wish to edit: ");
        int clientId = keyboard.nextInt();
        keyboard.nextLine(); // Consume the newline
        
        // Search for the client with the entered clientId
        Client selectedClient = null;
        for (int i = 0; i < clientCount; i++) {
            if (clientList[i].getClientId() == clientId) {
                selectedClient = clientList[i];
                break;
            }
        }
        
        if (selectedClient == null) {
            System.out.println("No client found with that ID.");
            return;
        }
        
        System.out.println("Editing client: " + selectedClient);
        
     // Ask the user if they want to update the client's name
        System.out.print("Do you want to update the client's name? (y/n): ");
        String response = keyboard.nextLine();
        
        if (response.equalsIgnoreCase("y")) {
            System.out.print("Enter new name: ");
            String newName = keyboard.nextLine();
            selectedClient.setName(newName);
        }
        
        // Ask the user if they want to update the client's address
        System.out.print("Do you want to update the client's address? (y/n): ");
        response = keyboard.nextLine(); //consume new line
        
        if (response.equalsIgnoreCase("y")) {
            System.out.print("Enter new address: ");
            String newAddress = keyboard.nextLine();
            selectedClient.setAdress(newAddress);
        }
        
        System.out.println("Client updated successfully!");
        System.out.println("Updated client details: ");
        System.out.println(selectedClient);
    }
    
    /**
     *Deletes a client based on client ID.
     *
     * @param keybooard     A Scanner instance for user input.
     * @param clientList  The array of Client objects.
     * @param clientCount The current number of clients stored in the array.
     * @return true if a client was deleted; false otherwise.
     */
    public static boolean deleteClient(Scanner keybooard, Client[] clientList, int clientCount) {
        if (clientCount == 0) {
            System.out.println("No clients available to delete.");
            return false;
        }
        
        // Display all clients
        System.out.println("\n--- List of Clients ---");
        for (int i = 0; i < clientCount; i++) {
            System.out.println(clientList[i]);
        }
        
        // Prompt user for Client ID to delete
        System.out.print("Enter the Client ID you wish to delete: ");
        int id = keybooard.nextInt();
        keybooard.nextLine(); // Consume the newline
        
        // Search for the client with the matching ID
        int indexToDelete = -1;
        for (int i = 0; i < clientCount; i++) {
            if (clientList[i].getClientId() == id) {
                indexToDelete = i;
                break;
            }
        }
        
        if (indexToDelete == -1) {
            System.out.println("No client found with ID " + id + ".");
            return false;
        }
        
        // Shift remaining elements to fill the gap
        for (int i = indexToDelete; i < clientCount - 1; i++) {
            clientList[i] = clientList[i + 1];
        }
        clientList[clientCount - 1] = null; // Clear the last element
        
        System.out.println("Client deleted successfully.");
        return true;
    }

}
