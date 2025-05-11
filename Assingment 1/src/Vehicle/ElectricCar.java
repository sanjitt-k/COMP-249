package Vehicle;
/**
 * Class representing an electric car.
 * Extends Car and adds maximum autonomy range.
 */
public class ElectricCar extends Car {
	private double maxAutonomy;
	private static int nextECar =1001;
	
	
    /**
     * Default constructor.
     * Initializes maxAutonomy to 0.
     */
	public ElectricCar() {
		super();
		this.maxAutonomy = 0.0;
	}
	
    /**
     * Generates the plate number for an electric car.
     * 
     * @return the generated plate number (e.g., "EC1001")
     */
	protected String generatePlateNumber() {
		return "EC" + nextECar++;
	}
	
	
    /**
     * Parameterized constructor.
     * 
     * @param make          the make of the car
     * @param model         the model of the car
     * @param year          the production year
     * @param maxPassengers the maximum number of passengers
     * @param maxAutonomy   the maximum autonomy range in kilometers
     */
	public ElectricCar(String make, String model, int year, int maxPassengers, double maxAutonomy) {
		super(make,model,year,maxPassengers);
		this.maxAutonomy = maxAutonomy;
		this.plateNumber = generatePlateNumber();
	}
	
    /**
     * Copy constructor.
     * 
     * @param other the ElectricCar to copy
     */
	public ElectricCar(ElectricCar other) {
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
     * Returns a string representation of the electric car.
     * 
     * @return a string describing the electric car
     */
	@Override
	public String toString() {
		return super.toString() + " , Maximum Autonomy Range(kilometers): "+ maxAutonomy;
	}
	
    /**
     * Compares this electric car to another object.
     * 
     * @param other the object to compare
     * @return true if the autonomy ranges are equal; false otherwise
     */
    @Override
	public boolean equals(Object other) {
		if(super.equals(other)==false) return false;
		ElectricCar electricCar = (ElectricCar) other;		
		return (this.maxAutonomy == electricCar.maxAutonomy);
	}
	
	
	
	
}
