package Vehicle;
/**
 * Class representing an electric truck.
 * Extends Truck and adds maximum autonomy range.
 */
public class ElectricTruck extends Truck {

	private double maxAutonomy;
	private static int nextETruck =1001;
	
	/**
     * Default constructor.
     * Initializes maxAutonomy to 0.
     */
	public ElectricTruck() {
		super();
		this.maxAutonomy = 0.0;
	}
	
	 /**
     * Generates the plate number for an electric truck.
     * 
     * @return the generated plate number (e.g., "ET1001")
     */
	protected String generatePlateNumber() {
		return "ET" + nextETruck++;
	}
	
	 /**
     * Parameterized constructor.
     * 
     * @param make        the make of the truck
     * @param model       the model of the truck
     * @param year        the production year
     * @param maxWeight   the maximum weight capacity
     * @param maxAutonomy the maximum autonomy range in kilometers
     */
	public ElectricTruck(String make, String model, int year, double maxWeight, double maxAutonomy) {
		super(make,model,year,maxWeight);
		this.maxAutonomy = maxAutonomy;
		this.plateNumber = generatePlateNumber();
	}
	
	 /**
     * Copy constructor.
     * 
     * @param other the ElectricTruck to copy
     */
	public ElectricTruck(ElectricTruck other) {
		super(other);
		this.maxAutonomy = other.maxAutonomy;
		this.plateNumber = generatePlateNumber();
	}
	
	/**
     * Gets the maximum autonomy range.
     * 
     * @return the autonomy range in kilometers
     */
	public double getMaxAutonomy() {
		return maxAutonomy;
	}
	 /**
     * Sets the maximum autonomy range.
     * 
     * @param maxAutonomy the new autonomy range in kilometers
     */
	public void setMaxAutonomy(double maxAutonomy) {
		this.maxAutonomy = maxAutonomy;
	}
	
    /**
     * Returns a string representation of the electric truck.
     * 
     * @return a string describing the electric truck
     */
	@Override
	public String toString() {
		return super.toString() + " , Maximum Autonomy Range(Kilometers): " + maxAutonomy;
	}
	
    /**
     * Compares this electric truck to another object.
     * 
     * @param other the object to compare
     * @return true if the autonomy ranges are equal; false otherwise
     */
	@Override
	public boolean equals(Object other) {
		if(super.equals(other)==false) return false;
		
		ElectricTruck electricTruck = (ElectricTruck) other;
		
		return (this.maxAutonomy == electricTruck.maxAutonomy);
	}
	
	
	

}
