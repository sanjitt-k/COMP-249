package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Represents the Provincial Income Tax deduction.
 * <p>
 * This class calculates the Provincial Income Tax based on the employee's gross salary using tiered tax brackets.
 * Different rates are applied to portions of the salary within specific income ranges.
 * </p>
 */
public class ProvincialTax extends Deductions {

	/**
     * Calculates the Provincial Income Tax based on the provided gross salary.
     * <p>
     * The tax is computed by applying the corresponding rate for each income bracket in a descending manner.
     * </p>
     *
     * @param grossSalary the gross salary amount.
     * @return the calculated Provincial Income Tax.
     */
	@Override
	public double calculateTax(double grossSalary) {
		double tax = 0;
		
		if(grossSalary > 129590) {
			tax += (grossSalary - 129590)*0.2575;
			grossSalary = 129590;
		}
		if (grossSalary > 106495) {
			tax += (grossSalary - 106495)*0.24;
			grossSalary = 106495;
		}
		if (grossSalary > 53255) {
			tax += (grossSalary - 53255)*0.19;
			grossSalary = 53255;
		}
		if (grossSalary > 18571) {
			tax += (grossSalary -18571)*0.14;
		}
		return tax;
	}
	
}
