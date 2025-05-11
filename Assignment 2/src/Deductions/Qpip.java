package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Represents the Quebec Parental Insurance Plan (QPIP) deduction.
 * <p>
 * This class calculates the QPIP premium based on the employee's gross salary.
 * The premium is computed at a rate of 0.494% of the gross salary, capped at a maximum premium.
 * </p>
 */
public class Qpip extends Deductions {

	private static final double RATE = 0.00494; // for 0.494%(QPIP) rate
	private static final double MAX_PREMIUM = 494.12;
	private static final double MAX_SALARY = 98000;	
	
	/**
     * Calculates the QPIP premium based on the provided gross salary.
     * <p>
     * If the gross salary is zero, the premium is zero.
     * If the gross salary exceeds or equals the maximum salary threshold, the premium is capped.
     * Otherwise, the premium is calculated by multiplying the gross salary by the rate.
     * </p>
     *
     * @param grossSalary the gross salary amount.
     * @return the calculated QPIP premium.
     */
	@Override
    public double calculateTax(double grossSalary) {
        if (grossSalary == 0) {
            return 0;
        } else if (grossSalary >= MAX_SALARY) {
            return MAX_PREMIUM;
        } else {
            return RATE * grossSalary;
        }
    }
}