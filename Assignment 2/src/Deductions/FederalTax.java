package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Represents the Federal Income Tax deduction.
 * <p>
 * This class calculates the Federal Income Tax based on the employee's gross salary using progressive tax brackets.
 * The calculation applies different rates to portions of the salary that fall within specified brackets.
 * </p>
 */
public class FederalTax extends Deductions{

	 /**
     * Calculates the Federal Income Tax based on the provided gross salary.
     * <p>
     * The tax is calculated progressively starting from the highest bracket and working downwards.
     * </p>
     *
     * @param grossSalary the gross salary amount.
     * @return the calculated Federal Income Tax.
     */
	@Override
	public double calculateTax(double grossSalary) {
		
		double tax = 0; //keep track of the tax throughout the brackets
		
		if(grossSalary > 253414) {
			tax += (grossSalary-253414)*0.33;
			grossSalary = 253414;
		}
		if(grossSalary > 177882) {
			tax += (grossSalary-177882)*0.29;
			grossSalary = 177882;
		}
		if (grossSalary > 114750) {
			tax += (grossSalary-114750)*0.26;
			grossSalary = 114750;
		}
		if (grossSalary >57375) {
			tax += (grossSalary-57375)*0.205;
			grossSalary = 57375;
		}
		if (grossSalary >16128) {//when greater or equal to 16129 
			tax += (grossSalary-16128)*0.15;
		}
		return tax;
	}
}
