package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Represents the Quebec Pension Plan (QPP) deduction.
 * <p>
 * This class calculates the QPP premium based on the employee's gross salary.
 * The premium is computed at a rate of 10.8% of the gross salary, up to a maximum premium cap.
 * </p>
 */
public class Qpp extends Deductions{

	private static final double RATE = 0.108;
	private static final double MAX_PREMIUM = 7700.40;
	private static final double MAX_SALARY = 71300;
	
	 /**
     * Calculates the QPP premium based on the provided gross salary.
     * <p>
     * If the gross salary is zero, the premium is zero.
     * If the gross salary exceeds or equals the maximum salary threshold, the premium is capped.
     * Otherwise, the premium is calculated by multiplying the gross salary by the rate.
     * </p>
     *
     * @param grossSalary the gross salary amount.
     * @return the calculated QPP premium.
     */
    @Override
	public double calculateTax(double grossSalary) {
		if(grossSalary ==0) {
			return 0;
		}
		else if(grossSalary>= MAX_SALARY) {
			return MAX_PREMIUM;
		}
		else {
			return grossSalary*RATE;
		}
	}
}
