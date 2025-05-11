package Payroll;

import Deductions.Deductions;
import Deductions.Ei;
import Deductions.FederalTax;
import Deductions.ProvincialTax;
import Deductions.Qpip;
import Deductions.Qpp;

//--------------------------------------------------------------------
//Assignment 2
//Question: Employee
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Manages an array of Employee objects.
 * Provides methods to initialize employees, calculate payroll deductions,
 * and generate a formatted payroll report.
 */
public class EmployeeManager {
	
	//declare instance variables
	private final int MAX_EMPLOYEES = 1000;// set a constant for array size
	private Employee[] employees = new Employee[MAX_EMPLOYEES];//array to store employees
	private int employeeCount = 0;//keeps track of the number of employees
	
	 /**
     * Default constructor for EmployeeManager.
     */
	public EmployeeManager() {
		
	}
	
	/**
     * Initializes an employee with the provided details and adds it to the employee array.
     * 
     * @param iD          The employee's ID.
     * @param firstName   The employee's first name.
     * @param lastName    The employee's last name.
     * @param hoursWorked The number of hours worked per week.
     * @param wage        The hourly wage.
     */
	public void initializeEmployees(long iD, String firstName, String lastName,
									double hoursWorked, double wage)  {
		if (employeeCount >= MAX_EMPLOYEES) {
			return;
		}
		
		//initialize the array and store employee in next available slot
		employees[employeeCount] = new Employee(iD, firstName, lastName, hoursWorked, wage);
		employeeCount++;
	}
	
	 /**
     * Displays all stored employees to the console.
     * If there are no employees, a message is printed.
     */
	public void showEmployees() {
		if(employeeCount ==0) {
			System.out.println("No employees to display.");
			return;
		}
		
		for(int i =0; i<employeeCount; i++) {
			System.out.println(employees[i]);
		
		}
	}
	
	 /**
     * Calculates the total deductions from the gross salary using various deduction types.
     * 
     * @param grossSalary The gross salary of an employee.
     * @return The total deductions, rounded to two decimal places.
     */
	public double calculateDeductions(double grossSalary) {
		double deductions = 0;
		
		Deductions eI = new Ei();
		deductions += eI.calculateTax(grossSalary);
		
		Deductions federalTax = new FederalTax();
		deductions += federalTax.calculateTax(grossSalary);
		
		Deductions provincialTax = new ProvincialTax();
		deductions += provincialTax.calculateTax(grossSalary);
		
		Deductions qPIP = new Qpip();
		deductions += qPIP.calculateTax(grossSalary);
		
		Deductions qPP = new Qpp();
		deductions += qPP.calculateTax(grossSalary);
		
		deductions = Math.round(deductions*100.0)/100.0;
				
		return deductions;
	}
	
	  /**
     * Generates and returns a formatted payroll report including headers and employee details.
     * 
     * @return A string representing the complete payroll report.
     */
	public String showEmployeeReport() {
	    StringBuilder s = new StringBuilder();

	    if (employeeCount == 0) {
	        return "No employees to show";
	    }

	    // Header
	    s.append(String.format("%-10s %-10s %-12s %-12s %-12s %-12s%n", 
	        "ID", "First", "Last", "Gross Pay", "Deductions", "Net Pay"));

	    // Employee Details
	    for (int i = 0; i < employeeCount; i++) {
	        long id = employees[i].getID();
	        String first = employees[i].getFirstName();
	        String last = employees[i].getLastName();
	        double gross = employees[i].getGrossSalary();
	        double deductions = calculateDeductions(gross);
	        double net = Math.round((gross - deductions) * 100.0) / 100.0;

	        s.append(String.format("%-10d %-10s %-12s %-12.2f %-12.2f %-12.2f%n", 
	            id, first, last, gross, deductions, net));
	    }

	    return s.toString();
	}

	
}


