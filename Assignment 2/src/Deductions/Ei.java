package Deductions;
//--------------------------------------------------------------------
//Assignment 2
//Question: Deductions Calculation
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Represents the Employment Insurance (EI) deduction.
 * <p>
 * This class calculates the EI premium based on the employee's gross salary.
 * The premium is calculated at a rate of 1.64% per $100 of gross salary, with a maximum premium cap.
 * </p>
 */
public class Ei extends Deductions {
	
	private double eIDeductions;
	private static final double maxPremium =65700; 
	private static final double RATE = 1.64;//rate of ei in percentage
	
	 /**
     * Calculates the EI premium based on the provided gross salary.
     * <p>
     * If the gross salary is zero, the premium is zero.
     * If the gross salary meets or exceeds the specified threshold, the premium is capped at $1077.48.
     * Otherwise, the premium is computed based on the number of complete $100 increments in the gross salary.
     * </p>
     *
     * @param grossSalary the gross salary amount.
     * @return the calculated EI premium.
     */
	@Override
	public double calculateTax(double grossSalary) {
		
		if(grossSalary == 0) {
			eIDeductions=0;
		}
		else if(grossSalary >=maxPremium) {
			eIDeductions= 1077.48;
		}
		else {
			int hundreds =(int) (grossSalary/100.0);// 1.64% for every 100$
			eIDeductions = (hundreds*RATE);//calculates the ei premium
		}
		
		return eIDeductions;
		
	}

}
