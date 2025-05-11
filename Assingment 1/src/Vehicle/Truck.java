package Vehicle;
/**
 * Abstract class representing a truck.
 * Extends Vehicle and adds the maximum weight capacity.
 */
public abstract class Truck extends Vehicle {
	 //declare instance varibles for truck class
	 private double maxWeight;

	 /**
	     * Default constructor.
	     * Initializes maxWeight to 0.
	     */
	 public Truck(){
	     super();
	     this.maxWeight = 0;
	 }

	 /**
	     * Parameterized constructor.
	     * 
	     * @param make      the make of the truck
	     * @param model     the model of the truck
	     * @param year      the production year of the truck
	     * @param maxWeight the maximum weight capacity in kilograms
	     */
	 public Truck(String make, String model, int year, double maxWeight){
	     super(make, model, year);
	     this.maxWeight = maxWeight;
	 }

	 /**
	     * Copy constructor.
	     * 
	     * @param other the truck to copy
	     */
	 public Truck(Truck other){
	     super(other);
	     this.maxWeight = other.maxWeight;
	 }

	 /**
	     * Gets the maximum weight capacity.
	     * 
	     * @return the maximum weight in kilograms
	     */
	 public double getMaxWeight(){
	     return this.maxWeight;
	 }
	 
	 /**
	     * Sets the maximum weight capacity.
	     * 
	     * @param newMaxWeight the new maximum weight in kilograms
	     */
	 public void setMaxWeight(double newMaxWeight){
	     this.maxWeight = newMaxWeight;                                                                                                                                                              
	 }
	 
	 /**
	 * Compares this truck to another object.
	 * 
	 * @param other the object to compare
	 * @return true if the trucks have the same attributes; false otherwise
	 */
	 @Override
	 public boolean equals(Object other) {
		if(super.equals(other) == false) return false;
		 
		 Truck truck = (Truck) other; //cast truck into the parameter
		 
		 //compare attributes
		 return super.equals(truck) && this.maxWeight == truck.maxWeight;
		 
	 }
	 
	 /**
	  * Returns a string representation of the truck.
	  * 
	  * @return a string describing the truck
	  */
	 @Override
	 public String toString() {
		 return (super.toString() + ", Capacity: " + maxWeight);
				 
	 }
	 
	 
	 
	}   
	 
