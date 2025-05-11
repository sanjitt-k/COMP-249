package ExceptionHandling;
//--------------------------------------------------------------------
//Assignment 2
//Question: MinimumWageException
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------
/**
 * Custom exception to indicate that an employee's wage is below the legal minimum.
 * This exception is thrown when an employee's hourly wage is less than the required minimum wage.
 */
public class MinimumWageException extends Exception{

	
	 /**
     * Default constructor that sets a predefined error message.
     */
	public MinimumWageException() {
		super("Error: invalid input for minimum wage, line cannot be parsed and will be skipped");
	}
	
	/**
     * Constructor that accepts a custom error message.
     * 
     * @param message Custom error message.
     */

	public MinimumWageException(String message) {
		super(message);
	}
	
	  /**
     * Constructor that builds an error message based on the employee's details.
     * 
     * @param firstName Employee's first name.
     * @param lastName  Employee's last name.
     * @param wage      The invalid hourly wage.
     */
	public MinimumWageException(String firstName, String lastName, double wage) {
		super("Error: Employee " + firstName + " " + lastName + " has an invalid wage of $" + wage);
	}
}
