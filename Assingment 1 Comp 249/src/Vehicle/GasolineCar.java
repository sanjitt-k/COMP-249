package Vehicle;
/**
 * Class representing a gasoline car.
 * Extends Car.
 */
public class GasolineCar extends Car {
	
	private static int nextGasCar=1001;
	
	 /**
     * Default constructor.
     */
	public GasolineCar() {
		super();	
	}
	
	/**
     * Generates the plate number for a gasoline car.
     * 
     * @return the generated plate number (e.g., "GC1001")
     */
	protected String generatePlateNumber() {
		return "GC" + nextGasCar++;
	}
	/**
     * Parameterized constructor.
     * 
     * @param make          the make of the car
     * @param model         the model of the car
     * @param year          the production year
     * @param maxPassengers the maximum number of passengers
     */
	public GasolineCar(String make, String model, int year, int maxPassengers) {
		super(make,model,year,maxPassengers);
		this.plateNumber = generatePlateNumber();
	}
	
	/**
     * Copy constructor.
     * 
     * @param other the GasolineCar to copy
     */
	public GasolineCar(GasolineCar other) {
		super(other);
		this.plateNumber = generatePlateNumber();
	}

	
	
}
