package Vehicle;
/**
 * Class representing a diesel truck.
 * Extends Truck and adds fuel capacity.
 */
public class DieselTruck extends Truck{

	private double fuelCapacity;
	private static int nextTruck = 1001;
	 /**
     * Default constructor.
     * Initializes fuelCapacity to 0.
     */
	public DieselTruck() {
		super();
		this.fuelCapacity = 0.0;
	}
	
    /**
     * Generates the plate number for a diesel truck.
     * 
     * @return the generated plate number (e.g., "DT1001")
     */
	protected String generatePlateNumber() {
		return "DT" + nextTruck++;
	}
	
	  /**
     * Parameterized constructor.
     * 
     * @param make         the make of the truck
     * @param model        the model of the truck
     * @param year         the production year
     * @param maxWeight    the maximum weight capacity
     * @param fuelCapacity the fuel tank capacity in liters
     */
	public DieselTruck(String make, String model, int year, double maxWeight, double fuelCapacity ) {
		super(make, model, year, maxWeight);
		this.fuelCapacity = fuelCapacity;
		this.plateNumber = generatePlateNumber();
	}
	
	/**
     * Copy constructor.
     * 
     * @param other the DieselTruck to copy
     */
	public DieselTruck(DieselTruck other) {
		super(other);
		this.fuelCapacity = other.fuelCapacity;
		this.plateNumber = generatePlateNumber();
	}
	
    /**
     * Gets the fuel capacity.
     * 
     * @return the fuel capacity in liters
     */
	public double getFuelCapacity() {
		return fuelCapacity;
	}
	
	/**
     * Sets the fuel capacity.
     * 
     * @param fuelCapacity the new fuel capacity in liters
     */
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	

    /**
     * Returns a string representation of the diesel truck.
     * 
     * @return a string describing the diesel truck
     */
	@Override
	public String toString() {
		return super.toString() +  ", Fuel Capacity: " + fuelCapacity;
	}
	

    /**
     * Compares this diesel truck to another object.
     * 
     * @param other the object to compare
     * @return true if the diesel trucks have the same fuel capacity; false otherwise
     */
	@Override
	public boolean equals(Object other) {
		if(super.equals(other)== false) return false;
		
		DieselTruck dieselTruck = (DieselTruck) other;
		
		return this.fuelCapacity == dieselTruck.fuelCapacity;
	}
	
	
}
