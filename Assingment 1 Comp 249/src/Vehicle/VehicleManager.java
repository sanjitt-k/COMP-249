package Vehicle;

import java.util.Scanner;

/**
 * Class that manages vehicle operations such as adding, deleting, updating,
 * listing, and additional operations.
 */

public class VehicleManager {
	
	  /**
     * Adds a vehicle based on user input.
     * 
     * @return the new Vehicle object, or null if an invalid choice was made
     */
	
	 public static Vehicle addVehicle() {
	        Scanner keyboard = new Scanner(System.in);

	        System.out.println("Select vehicle type to add:");
	        System.out.println("1. Gasoline Car");
	        System.out.println("2. Electric Car");
	        System.out.println("3. Diesel Truck");
	        System.out.println("4. Electric Truck");
	        System.out.print("Enter choice: ");

	        int choice = keyboard.nextInt();
	        keyboard.nextLine(); // Consume newline

	        System.out.print("Enter Make: ");
	        String make = keyboard.nextLine();

	        System.out.print("Enter Model: ");
	        String model = keyboard.nextLine();

	        System.out.print("Enter Year: ");
	        int year = keyboard.nextInt();

	        Vehicle newVehicle = null;

	        switch (choice) {
	            case 1:
	                System.out.print("Enter Max Passengers: ");
	                int maxPassengers = keyboard.nextInt();
	                newVehicle = new GasolineCar(make, model, year, maxPassengers);
	                break;

	            case 2:
	                System.out.print("Enter Max Passengers: ");
	                maxPassengers = keyboard.nextInt();
	                System.out.print("Enter Max Autonomy (km): ");
	                double maxAutonomy = keyboard.nextDouble();
	                newVehicle = new ElectricCar(make, model, year, maxPassengers, maxAutonomy);
	                break;

	           
	            case 3:  // Add Diesel Truck
	            	 System.out.print("Enter Max Weight (kg): ");
	                 double maxWeight = keyboard.nextDouble();
	                 System.out.print("Enter Fuel Capacity (liters): ");
	                 double fuelCapacity = keyboard.nextDouble();
	                 newVehicle = new DieselTruck(make, model, year, maxWeight, fuelCapacity);
	                 break;	                

	            case 4:
	                System.out.print("Enter Max Weight (kg): ");
	                maxWeight = keyboard.nextDouble();
	                System.out.print("Enter Max Autonomy (km): ");
	                maxAutonomy = keyboard.nextDouble();
	                newVehicle = new ElectricTruck(make, model, year, maxWeight, maxAutonomy);
	                break;

	            default:
	                System.out.println("Invalid choice! Returning null.");
	                keyboard.close();
	                return null;
	                
	        }
	       

	        System.out.println("Vehicle added successfully!");
	       
	        return newVehicle;
	       
	       
	    }
	
	//method to delete a vehicle
	 
	public static boolean deleteVehicle(Vehicle[] vehicleList, int vehicleCount) {
        if (vehicleCount == 0) {
            System.out.println("No vehicles available to delete.");
            return false;
        }

        Scanner keyboard = new Scanner(System.in);

        // Display all vehicles with indexes
        System.out.println("\n--- List of Vehicles ---");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.println((i + 1) + ". " + vehicleList[i]);
        }

        System.out.print("Enter the number of the vehicle to delete: ");
        int index = keyboard.nextInt();
        keyboard.nextLine();

        if (index < 1 || index > vehicleCount) {
            System.out.println("Invalid selection. Please try again.");
            return false;
        }

        // Shift elements to remove the deleted vehicle
        for (int i = index - 1; i < vehicleCount - 1; i++) {
            vehicleList[i] = vehicleList[i + 1];
        }
        vehicleList[vehicleCount - 1] = null; // Clear last element

        System.out.println("Vehicle deleted successfully!");
        return true;
    }
	
	//update vehicle information
	public static void updateVehicle(Scanner keyboard, Vehicle[] vehicleList, int vehicleCount) {
	    if (vehicleCount == 0) {
	        System.out.println("No vehicles available to update.");
	        return;
	    }

	    System.out.println("\n--- List of Vehicles ---");
	    for (int i = 0; i < vehicleCount; i++) {
	        System.out.println((i + 1) + ". " + vehicleList[i]);
	    }

	    System.out.print("Enter the number of the vehicle to update: ");
	    int index = keyboard.nextInt();
	    keyboard.nextLine(); // consume newline

	    if (index < 1 || index > vehicleCount) {
	        System.out.println("Invalid selection. Please try again.");
	        return;
	    }

	    Vehicle vehicle = vehicleList[index - 1];
	    System.out.println("\nUpdating vehicle: " + vehicle);

	    // Update common attributes by asking the user if they want to update each field
	    System.out.print("Do you want to update the Make? (y/n): ");
	    String answer = keyboard.nextLine();
	    if (answer.equalsIgnoreCase("y")) {
	        System.out.print("Enter new Make: ");
	        String newMake = keyboard.nextLine();
	        vehicle.setMake(newMake);
	    }

	    System.out.print("Do you want to update the Model? (y/n): ");
	    answer = keyboard.nextLine();
	    if (answer.equalsIgnoreCase("y")) {
	        System.out.print("Enter new Model: ");
	        String newModel = keyboard.nextLine();
	        vehicle.setModel(newModel);
	    }

	    System.out.print("Do you want to update the Year? (y/n): ");
	    answer = keyboard.nextLine();
	    if (answer.equalsIgnoreCase("y")) {
	        System.out.print("Enter new Year: ");
	        int newYear = keyboard.nextInt();
	        keyboard.nextLine(); // consume newline
	        vehicle.setYear(newYear);
	    }

	    // Type-specific updates:
	    if (vehicle instanceof GasolineCar) {
	        GasolineCar car = (GasolineCar) vehicle;
	        System.out.print("Do you want to update Max Passengers? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Passengers: ");
	            int newMaxPassengers = keyboard.nextInt();
	            keyboard.nextLine(); // consume newline
	            car.setMaxPassengers(newMaxPassengers);
	        }
	    } else if (vehicle instanceof ElectricCar) {
	        ElectricCar car = (ElectricCar) vehicle;
	        System.out.print("Do you want to update Max Passengers? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Passengers: ");
	            int newMaxPassengers = keyboard.nextInt();
	            keyboard.nextLine();
	            car.setMaxPassengers(newMaxPassengers);
	        }
	        System.out.print("Do you want to update Max Autonomy? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Autonomy (km): ");
	            double newMaxAutonomy = keyboard.nextDouble();
	            keyboard.nextLine();
	            car.setMaxAutonomy(newMaxAutonomy);
	        }
	    } else if (vehicle instanceof DieselTruck) {
	        DieselTruck truck = (DieselTruck) vehicle;
	        System.out.print("Do you want to update Max Weight? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Weight (kg): ");
	            double newMaxWeight = keyboard.nextDouble();
	            keyboard.nextLine();
	            truck.setMaxWeight(newMaxWeight);
	        }
	        System.out.print("Do you want to update Fuel Capacity? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Fuel Capacity (liters): ");
	            double newFuelCapacity = keyboard.nextDouble();
	            keyboard.nextLine();
	            truck.setFuelCapacity(newFuelCapacity);
	        }
	    } else if (vehicle instanceof ElectricTruck) {
	        ElectricTruck truck = (ElectricTruck) vehicle;
	        System.out.print("Do you want to update Max Weight? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Weight (kg): ");
	            double newMaxWeight = keyboard.nextDouble();
	            keyboard.nextLine();
	            truck.setMaxWeight(newMaxWeight);
	        }
	        System.out.print("Do you want to update Max Autonomy? (y/n): ");
	        answer = keyboard.nextLine();
	        if (answer.equalsIgnoreCase("y")) {
	            System.out.print("Enter new Max Autonomy (km): ");
	            double newMaxAutonomy = keyboard.nextDouble();
	            keyboard.nextLine();
	            truck.setMaxAutonomy(newMaxAutonomy);
	        }
	    }

	    System.out.println("Vehicle updated successfully!");
	    keyboard.close();//avoid leaks
	}
	
	  /**
     * Lists all vehicles by category.
     * 
     * @param vehicleList array of Vehicle objects
     * @param vehicleCount current number of vehicles
     */
	public static void listVehiclesByCategory(Vehicle[] vehicleList, int vehicleCount) {
        System.out.println("\n--- Vehicles by Category ---");

        // Gasoline Cars
        System.out.println("\nGasoline Cars:");
        boolean found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicleList[i] instanceof GasolineCar) {
                System.out.println(vehicleList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Gasoline Cars found.");
        }

        // Electric Cars
        System.out.println("\nElectric Cars:");
        found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicleList[i] instanceof ElectricCar) {
                System.out.println(vehicleList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Electric Cars found.");
        }

        // Diesel Trucks
        System.out.println("\nDiesel Trucks:");
        found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicleList[i] instanceof DieselTruck) {
                System.out.println(vehicleList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Diesel Trucks found.");
        }

        // Electric Trucks
        System.out.println("\nElectric Trucks:");
        found = false;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicleList[i] instanceof ElectricTruck) {
                System.out.println(vehicleList[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Electric Trucks found.");
        }
        
    }
    /**
     * Finds the diesel truck with the largest capacity.
     * 
     * @param dieselTrucks an array of DieselTruck objects
     * @param count        the number of diesel trucks in the array
     * @return the DieselTruck with the largest capacity, or null if none are available
     */
	// Additional method finds the diesel truck with the largest capacity (maxWeight)
    public static DieselTruck getLargestTruck(DieselTruck[] dieselTrucks, int count) {
        if (count == 0) {
            System.out.println("No diesel trucks available.");
            return null;
        }
        DieselTruck largest = dieselTrucks[0];
        for (int i = 1; i < count; i++) {
            if (dieselTrucks[i].getMaxWeight() > largest.getMaxWeight()) {
                largest = dieselTrucks[i];
            }
        }
        return largest;
    }
    
 // Additional method creates a deep copy of an array of electric trucks
    /**
     * Creates a deep copy of an array of electric trucks.
     * 
     * @param electricTrucks an array of ElectricTruck objects
     * @param count          the number of electric trucks in the array
     * @return a new array containing deep copies of the electric trucks
     */
    public static ElectricTruck[] copyVehicles(ElectricTruck[] electricTrucks, int count) {
        ElectricTruck[] copy = new ElectricTruck[count];
        for (int i = 0; i < count; i++) {
            copy[i] = new ElectricTruck(electricTrucks[i]);
        }
        return copy;
      
    }
    
	
}
