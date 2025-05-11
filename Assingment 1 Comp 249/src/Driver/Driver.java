package Driver;
//--------------------------------------------------------
//Assignment 1
//Question: Part 3 (Driver)
//Written by: Sanjitt Kanagalingam (4031831) 
//Due date: 10/02/2025
//--------------------------------------------------------
import java.util.Scanner;

import Client.Client;
import Client.ClientManager;
import Vehicle.LeaseManager;
import Vehicle.Vehicle;
import Vehicle.VehicleManager;
import Vehicle.DieselTruck;
import Vehicle.ElectricTruck;
import Vehicle.GasolineCar;
import Vehicle.ElectricCar;
/*
 * RoyalRentals is a vehicle rental management system for the RoyalRentals company.
 * The program manages a fleet of vehicles (electric trucks, diesel trucks, electric cars, and gasoline cars),
 * client records, and leasing operations (leasing and returning vehicles).
 * The system offers both a menu-driven interface and a predefined testing scenario.
 */

/**
 * The main driver class for RoyalRentals.
 * Provides both a menu-driven interface and a predefined scenario for testing.
 */

public class Driver {
	// Constants for maximum numbers
    private static final int MAX_CLIENTS = 50;
    private static final int MAX_VEHICLES = 100;
    private static final int MAX_LEASES = 100;
    
    // Fixed-size arrays
    private static Client[] clientList = new Client[MAX_CLIENTS];
    private static int clientCount = 0;
    
    private static Vehicle[] vehicleList = new Vehicle[MAX_VEHICLES];
    private static int vehicleCount = 0;
    
    private static LeaseManager.Lease[] leaseList = new LeaseManager.Lease[MAX_LEASES];
    // Using a one-element array to hold the lease count so it can be updated inside methods
    private static int[] leaseCount = {0};
    

    /**
     * Main method.
     * 
     * @param args command-line arguments (not used)
     */
 
	public static void main(String[] args) {
		
		//declare scanner
		Scanner keyboard = new Scanner(System.in);
		int mainChoice;
		
		//Welcome message 
		System.out.println("----------------------------------------------------------------------------------------------------\n" + 
						   "                                      Welcome to RoyalRentals!                       \n"+
						   "                                   Designed by:Sanjitt Kanagalingam                \n" +
						   "----------------------------------------------------------------------------------------------------");
		 // Ask the user whether to run the menu or the predefined scenario
        System.out.println("Select an option:");
        System.out.println("1. Menu-Driven Interface");
        System.out.println("2. Predefined Scenario (for testing purposes)");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = keyboard.nextInt();
        keyboard.nextLine(); // Consume newline
        if (choice == 2) {
            runPredefinedScenario();
            
        } else {          
            
		//Main menu
		do {
			System.out.println("\nMain Menu:");
            System.out.println("    1. Vehicle Management");
            System.out.println("    2. Client Management");
            System.out.println("    3. Leasing Operations");
            System.out.println("    4. Additional Operations");
            System.out.println("    5. Exit Program");
            System.out.print("Enter your choice: ");
            mainChoice = keyboard.nextInt();
            keyboard.nextLine(); // consume newline
		
		//Switch for main menu options
			switch(mainChoice) {
				case 1: 
					vehicleMenu(keyboard);
					break;
				case 2: clientMenu(keyboard);
					break;
				case 3:
					leaseMenu(keyboard);
					break;
				case 4: additionalOperations(keyboard);
					break;
				 case 5:
                     System.out.println("Exiting program... Goodbye!");
                     break;
				
			}	
		
		} while (mainChoice != 5);
        }
	}
	 /**
     * Displays and processes the vehicle management menu.
     * 
     * @param keyboard the Scanner for input
     */
	//vehicle menu add the scanner as parameter to take in user input
	public static void vehicleMenu(Scanner keyboard) {
		int vehicleChoice;
		//print the vehicle menu
		do {
			System.out.println("Vehicle Management: ");
			System.out.println("    1. Add a Vehicle \n" +
							   "    2. Delete a vehicle \n" + 
							   "    3. Update vehicle information \n" +
							   "    4. List all vehicles by category(electctric truck, diesel trucks, etc.)\n" +
							   "    5. Return to Main Menu");
			System.out.print("Enter your choice:");
			
			vehicleChoice = keyboard.nextInt();
			keyboard.nextLine();//consume line
			
			//switch for vehicle
			switch(vehicleChoice){
				case 1:
					if (vehicleCount < MAX_VEHICLES) {
                        Vehicle newVehicle = VehicleManager.addVehicle();
                        if (newVehicle != null) {
                            vehicleList[vehicleCount++] = newVehicle;
                            System.out.println("Vehicle successfully added!");
                        } else {
                            System.out.println("Failed to add vehicle.");
                        }
                    } else {
                        System.out.println("Cannot add more vehicles. Maximum capacity reached.");
                    }
                    break;
				case 2: 
					 boolean deleted = VehicleManager.deleteVehicle(vehicleList, vehicleCount);
	                    if (deleted) {
	                        vehicleCount--; // Decrease count after deletion
	                        System.out.println("Vehicle successfully deleted!");
	                    } else {
	                        System.out.println("Vehicle not found or deletion failed.");
	                    }
	                    break;
				 case 3:
	                    VehicleManager.updateVehicle(keyboard, vehicleList, vehicleCount);
	                    break;
				 case 4:
					    VehicleManager.listVehiclesByCategory(vehicleList, vehicleCount);
					    break;
				 case 5: 
					 System.out.println("Returning to main menu...");
					 break;
				 default:
					 System.out.println("Invalid input, must enter a number between 1 and 5");
			}
		} while (vehicleChoice!= 5);
	}
	
    /**
     * Displays and processes the client management menu.
     * 
     * @param keyboard the Scanner for input
     */
	public static void clientMenu(Scanner keyboard) {
		int clientChoice;
		
		//do while loop that will show the menu until user exits
		 do {
	            System.out.println("\n--- Client Management ---");
	            System.out.println("1. Add a client");
	            System.out.println("2. Edit a client");
	            System.out.println("3. Delete a client");
	            System.out.println("4. Return to Main Menu");
	            System.out.print("Enter your choice: ");
	            
	            clientChoice = keyboard.nextInt();
	            keyboard.nextLine(); // Consume newline
	            
	            switch (clientChoice) {
	                case 1:
	                    if (clientCount < MAX_CLIENTS) {
	                        Client newClient = ClientManager.addClient(keyboard);
	                        clientList[clientCount++] = newClient;
	                    } else {
	                        System.out.println("Client list is full.");
	                    }
	                    break;
	                case 2: 
	                	 ClientManager.editClient(keyboard, clientList, clientCount);
	                     break;
	                case 3:
	                	if (ClientManager.deleteClient(keyboard, clientList, clientCount)) {
	                        clientCount--;  // Decrement count if deletion succeeded if false it stays the same
	                    }
	                    break;
	                case 4:
	                    System.out.println("Returning to Main Menu...");
	                    break;
	                default:
	                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
	            }
	        } while (clientChoice != 4);
	       
	}
    /**
     * Displays and processes the leasing operations menu.
     * 
     * @param keyboard the Scanner for input
     */
	 private static void leaseMenu(Scanner keyboard) {
	        int leaseChoice;
	        do {
	            System.out.println("\n--- Leasing Operations ---");
	            System.out.println("1. Lease a vehicle to a client");
	            // Additional options such as Return a vehicle, Show leased vehicles, etc.
	            System.out.println("2. Return a vehicle ");
	            System.out.println("3. Show all vehicles leased by a client");
	            System.out.println("4. Show all leased vehicles");
	            System.out.println("5. Return to Main Menu");
	            System.out.print("Enter your choice: ");
	            
	            leaseChoice = keyboard.nextInt();
	            keyboard.nextLine(); // consume newline
	            
	            switch (leaseChoice) {
	                case 1:
	                    // Call the lease vehicle method
	                    LeaseManager.leaseVehicle(keyboard, clientList, clientCount,
	                                                vehicleList, vehicleCount,
	                                                leaseList, leaseCount, MAX_LEASES);
	                    break;
	                case 2:
	                	LeaseManager.returnVehicle(keyboard, leaseList, leaseCount);
	                	break;
	                case 3:
	                    LeaseManager.LeasedVehiclesByClient(keyboard, leaseList, leaseCount, clientList, clientCount);
	                    break;
	                case 4:
	                    LeaseManager.AllLeasedVehicles(leaseList, leaseCount);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        } while (leaseChoice != 5);
	 }
	 		/**
	 		 * Displays and processes the additional operations menu.
	 		 * Includes displaying the diesel truck with the largest capacity and copying the electric truck array.
	 		 * 
	 		 * @param keyboard the Scanner for input
	 		 */
	        // Additional operations menu – displays the largest diesel truck and creates a copy of the electric truck array
	        public static void additionalOperations(Scanner keyboard) {
	            int addChoice;
	            do {
	                System.out.println("\n--- Additional Operations ---");
	                System.out.println("1. Display the Diesel Truck with the Largest Capacity");
	                System.out.println("2. Create a Copy of the Electric Trucks Array");
	                System.out.println("3. Return to Main Menu");
	                System.out.print("Enter your choice: ");
	                addChoice = keyboard.nextInt();
	                keyboard.nextLine(); // consume newline
	                
	                switch(addChoice) {
	                    case 1:
	                        // Filter diesel trucks from vehicleList
	                        DieselTruck[] dieselTrucks = new DieselTruck[vehicleCount];
	                        int dieselCount = 0;
	                        for (int i = 0; i < vehicleCount; i++) {
	                            if (vehicleList[i] instanceof DieselTruck) {
	                                dieselTrucks[dieselCount++] = (DieselTruck) vehicleList[i];
	                            }
	                        }
	                        if (dieselCount == 0) {
	                            System.out.println("No diesel trucks available.");
	                        } else {
	                            DieselTruck largest = VehicleManager.getLargestTruck(dieselTrucks, dieselCount);
	                            System.out.println("Diesel Truck with the Largest Capacity:");
	                            System.out.println(largest);
	                        }
	                        break;
	                    case 2:
	                        // Filter electric trucks from vehicleList
	                        ElectricTruck[] electricTrucks = new ElectricTruck[vehicleCount];
	                        int electricCount = 0;
	                        for (int i = 0; i < vehicleCount; i++) {
	                            if (vehicleList[i] instanceof ElectricTruck) {
	                                electricTrucks[electricCount++] = (ElectricTruck) vehicleList[i];
	                            }
	                        }
	                        if (electricCount == 0) {
	                            System.out.println("No electric trucks available.");
	                        } else {
	                            ElectricTruck[] copy = VehicleManager.copyVehicles(electricTrucks, electricCount);
	                            System.out.println("Copied Electric Trucks Array:");
	                            for (int i = 0; i < electricCount; i++) {
	                                System.out.println(copy[i]);
	                            }
	                        }
	                        break;
	                    case 3:
	                        System.out.println("Returning to Main Menu...");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            } while (addChoice != 3);
	            
	        }
	        /**
	         * Runs a predefined scenario for testing purposes.
	         * Creates sample vehicles and clients, displays their information,
	         * tests the equals() method, and demonstrates additional operations.
	         */
	        // Predefined scenario for testing
	        public static void runPredefinedScenario() {
	            System.out.println("\n--- Running Predefined Scenario ---");
	            
	            // Create vehicles
	            DieselTruck dt1 = new DieselTruck("Ford", "F-150", 2020, 5000, 150);
	            DieselTruck dt2 = new DieselTruck("Chevy", "Silverado", 2021, 6000, 200);
	            DieselTruck dt3 = new DieselTruck("RAM", "2500", 2019, 5500, 180);

	            ElectricTruck et1 = new ElectricTruck("Tesla", "Semi", 2022, 7000, 400);
	            ElectricTruck et2 = new ElectricTruck("Nikola", "Tre", 2021, 6500, 350);
	            ElectricTruck et3 = new ElectricTruck("Volvo", "Electric", 2023, 6800, 380);

	            GasolineCar gc1 = new GasolineCar("Toyota", "Camry", 2020, 5);
	            GasolineCar gc2 = new GasolineCar("Honda", "Civic", 2019, 5);
	            GasolineCar gc3 = new GasolineCar("Ford", "Focus", 2021, 5);

	            ElectricCar ec1 = new ElectricCar("Tesla", "Model 3", 2021, 5, 350);
	            ElectricCar ec2 = new ElectricCar("Nissan", "Leaf", 2020, 5, 250);
	            ElectricCar ec3 = new ElectricCar("Chevrolet", "Bolt", 2022, 5, 300);

	            // Create clients
	            Client client1 = new Client("Alice", "123 Main St");
	            Client client2 = new Client("Bob", "456 Elm St");
	            Client client3 = new Client("Charlie", "789 Oak St");

	            // Display vehicle information
	            System.out.println("\nVehicles Created:");
	            System.out.println(dt1);
	            System.out.println(dt2);
	            System.out.println(dt3);
	            System.out.println(et1);
	            System.out.println(et2);
	            System.out.println(et3);
	            System.out.println(gc1);
	            System.out.println(gc2);
	            System.out.println(gc3);
	            System.out.println(ec1);
	            System.out.println(ec2);
	            System.out.println(ec3);

	            // Display client information
	            System.out.println("\nClients Created:");
	            System.out.println(client1);
	            System.out.println(client2);
	            System.out.println(client3);

	            // Test equals method
	            System.out.println("\nTesting equals() Method:");
	            // Different classes comparison 
	            System.out.println("DieselTruck dt1 and GasolineCar gc1: " + dt1.equals(gc1));
	            // Same class but different values 
	            System.out.println("ElectricTruck et1 and et2: " + et1.equals(et2));
	            // Same class with identical values 
	            GasolineCar gc1Copy = new GasolineCar(gc1);
	            System.out.println("GasolineCar gc1 and gc1Copy: " + gc1.equals(gc1Copy));

	            // Create arrays for each type and for all vehicles
	            DieselTruck[] dieselArray = {dt1, dt2, dt3};
	            ElectricTruck[] electricArray = {et1, et2, et3};
	            GasolineCar[] gasolineArray = {gc1, gc2, gc3};
	            ElectricCar[] electricCarArray = {ec1, ec2, ec3};
	            Vehicle[] allVehicles = {dt1, dt2, dt3, et1, et2, et3, gc1, gc2, gc3, ec1, ec2, ec3};

	            // Call getLargestTruck() and display the result
	            DieselTruck largestDiesel = VehicleManager.getLargestTruck(dieselArray, dieselArray.length);
	            System.out.println("\nThe Diesel Truck with the Largest Capacity:");
	            System.out.println(largestDiesel);

	            // Call copyVehicles() on electric truck array and display the copied array
	            ElectricTruck[] electricCopy = VehicleManager.copyVehicles(electricArray, electricArray.length);
	            System.out.println("\nCopied Electric Trucks Array:");
	            for (ElectricTruck et : electricCopy) {
	                System.out.println(et);
	            }
	            
	            System.out.println("\n--- Predefined Scenario Complete ---");
	            
	    }
	 
	        
	
}


