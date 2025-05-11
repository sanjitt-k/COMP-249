package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Abstract base class representing a deduction applied to an employee's gross salary.
 * <p>
 * Subclasses must implement the {@link #calculateTax(double)} method to calculate the
 * appropriate deduction amount based on the gross salary.
 * </p>
 */
public abstract class Deductions {
	
	/**
     * Constructs a new Deductions object.
     */
	public Deductions() {
		
	}
	
	 /**
     * Calculates the deduction amount based on the provided gross salary.
     *
     * @param grossSalary the gross salary amount from which the deduction is computed.
     * @return the calculated deduction amount.
     */
	public abstract double calculateTax(double grossSalary);
}
