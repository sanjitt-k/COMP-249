package Vehicle;

//--------------------------------------------------------
//Assignment 1
//Question: Part II
//Written by: Sanjitt Kanagalingam (4031831) 
//Due date: 10/02/2025
//--------------------------------------------------------
/**
 * Abstract class representing a generic vehicle.
 * Contains attributes common to all vehicles such as plate number, make, model, and year.
 */
public abstract class Vehicle {

 //declare instance variables
 protected String plateNumber;
 private String make;
 private String model;
 private int year;
 static int count=0;

 /**
  * Default constructor.
  * Initializes the vehicle with default values.
  */
 public Vehicle() {
 this.plateNumber = "UknownPlateNumer";// + (count +1000);
 this.make = "unknowMake";
 this.model = "unknowModel";
 this.year = 0;
 }

 /**
  * Parameterized constructor.
  * 
  * @param make  the make of the vehicle
  * @param model the model of the vehicle
  * @param year  the production year of the vehicle
  */
 public Vehicle(String make, String model, int year) {
 this.make = make;
 this.model = model;
 this.year = year;
 }

 /**
  * Copy constructor.
  * Creates a new Vehicle object as a copy of the given vehicle (except for the plate number).
  * 
  * @param other the vehicle to copy
  */
 public Vehicle(Vehicle other){
     //this.plateNumber = other.plateNumber; (note: this should be assigned automatically to the next available vehicule)
     
     this.make = other.make;
     this.model = other.model;
     this.year = other.year;
 }
 
 /**
  * Abstract method to generate the plate number.
  * Must be implemented by subclasses.
  * 
  * @return the generated plate number as a String
  */
 protected abstract String generatePlateNumber();

 /**
  * Gets the plate number of the vehicle.
  * 
  * @return the plate number
  */
 public String getPlateNumber() {
     return this.plateNumber;
 }
 
 /**
  * Gets the make of the vehicle.
  * 
  * @return the make
  */
 public String getMake() {
     return this.make;
 }
 
 /**
  * Sets the make of the vehicle.
  * 
  * @param newMake the new make
  */
 public void setMake(String newMake){
     this.make = newMake;
 }
 /**
  * Gets the model of the vehicle.
  * 
  * @return the model
  */
 public String getModel() {
     return this.model;
 }
 
 /**
  * Sets the model of the vehicle.
  * 
  * @param newModel the new model
  */
 public void setModel(String newModel){
     this.model = newModel;
 }
 
 /**
  * Gets the production year of the vehicle.
  * 
  * @return the production year
  */
 public int getYear(){
     return this.year;
 }
 
 /**
  * Sets the production year of the vehicle.
  * 
  * @param newYear the new production year
  */
 public void setYear(int newYear){
     this.year = newYear;
 }

 /**
  * Returns a String representation of the vehicle.
  * 
  * @return a string describing the vehicle
  */
 public String toString(){
     return "Plate Number: " + plateNumber + ", Make: " + make +
            " , Model: " + model + " , Year: " + year;
 }

 /**
  * Compares this vehicle to another object.
  * Ignores the plate number.
  * 
  * @param other the object to compare
  * @return true if the vehicles have the same make, model, and year; false otherwise
  */
 public boolean equals(Object other){
    if (this == other) return true;
    if (other == null || other.getClass() != this.getClass()) return false;
    Vehicle vehicle = (Vehicle) other;
    return (this.make.equalsIgnoreCase(vehicle.make) &&
            this.model.equalsIgnoreCase(vehicle.model) &&
            this.year == vehicle.year);
 }

}
