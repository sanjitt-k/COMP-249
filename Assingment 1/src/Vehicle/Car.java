package Vehicle;

/**
 * Abstract class representing a car.
 * Extends Vehicle and adds the maximum number of passengers.
 */
public abstract class Car extends Vehicle {
	
	private int maxPassengers;
	
	/**
     * Default constructor.
     * Initializes maxPassengers to 0.
     */
	public Car() {
		super();
		this.maxPassengers = 0;
	}
	
	 /**
     * Parameterized constructor.
     * 
     * @param make          the make of the car
     * @param model         the model of the car
     * @param year          the production year of the car
     * @param maxPassengers the maximum number of passengers
     */
	public Car(String make, String model, int year, int maxPassengers) {
		super(make, model, year);
		this.maxPassengers = maxPassengers;
	}
	
	/**
     * Copy constructor.
     * 
     * @param other the car to copy
     */
	public Car(Car other) {
		super(other);
		this.maxPassengers = other.maxPassengers;
	}
	 /**
     * Gets the maximum number of passengers.
     * 
     * @return the maximum passengers
     */
		 public int getMaxPassengers(){
		     return this.maxPassengers;
		 }
		 
		 /**
		     * Gets the maximum number of passengers.
		     * 
		     * @return the maximum passengers
		     */
		 public void setMaxPassengers(int newMaxPassengers){
		     this.maxPassengers = newMaxPassengers;                                                                                                                                                              
		 }
		 
		 /**
		     * Returns a string representation of the car.
		     * 
		     * @return a string describing the car
		     */
		 @Override
		 public boolean equals(Object other) {
			 if(super.equals(other) == false) return false;
			 
			 Car car = (Car) other; //cast truck into the parameter
			 
			 //compare attributes
			 return this.maxPassengers == car.maxPassengers;
			 
		 }
		 
		 /**
		     * Compares this car to another object.
		     * 
		     * @param other the object to compare
		     * @return true if the maximum number of passengers are equal; false otherwise
		     */
		 @Override
		 public String toString() {
			 return (super.toString() + " , Maximum Passengers: " + maxPassengers);
					 
		 }
		 
		 
}
