package Payroll;
//--------------------------------------------------------------------
//Assignment 2
//Question: Employee
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------
/**
 * Represents an employee with an ID, first name, last name, hours worked, hourly wage, 
 * and calculated gross salary. The gross salary is computed as (hoursWorked * wage * 52).
 */
public class Employee {

	//instance variables
	private long iD;
	private String firstName;
	private String lastName;
	private double hoursWorked;
	private double wage;
	private double grossSalary;
	
	
	 /**
     * Default constructor that initializes an employee with default values.
     */
	public Employee() {
		this.iD = 0L;
		this.firstName = "UnknownFirstName";
		this.lastName = "UnknownLastName";
		this.hoursWorked = 0.0;
		this.wage = 0.0;
		this.grossSalary = 0.0;
	}
	
	/**
     * Parameterized constructor to initialize an employee with specified values.
     * 
     * @param iD          The employee's ID.
     * @param firstName   The employee's first name.
     * @param lastName    The employee's last name.
     * @param hoursWorked The number of hours worked per week.
     * @param wage        The hourly wage.
     */
	public Employee(long iD, String firstName, String lastName,
					double hoursWorked, double wage) {
		
		this.iD = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		this.wage = wage;
		this.grossSalary = hoursWorked*wage*52;
	}
	
	 /**
     * Copy constructor.
     * 
     * @param other The Employee object to copy.
     */
	public Employee(Employee other) {
		this.iD = other.iD;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.hoursWorked = other.hoursWorked;
		this.wage = other.wage;
		this.grossSalary = other.grossSalary;
	}

	/**
     * @return the employee's ID.
     */
	public long getID() {
		return iD;
	}
	 /**
     * Sets the employee's first name.
     * 
     * @param employeeFirstName The employee's first name.
     */
	public String getFirstName() {
		return firstName;
	}
	 /**
     * Sets the employee's last name.
     * 
     * @param employeeLastName The employee's last name.
     */
	public String getLastName() {
		return lastName;
	}
	/**
     * Sets the number of hours worked per week.
     * 
     * @param hoursWorked The hours worked.
     */
	public double getHoursWorked() {
		return hoursWorked;
	}
	/**
     * @return the hourly wage.
     */
	public double getWage() {
		return wage;
	}
	 /**
     * @return the calculated gross salary.
     */
	public double getGrossSalary() {
		return grossSalary;
	}

	/**
     * Sets the employee's ID.
     * 
     * @param employeeNumber The employee's ID.
     */
	public void setID(long employeeNumber) {
		this.iD = employeeNumber;
	}
	 /**
     * Sets the employee's first name.
     * 
     * @param employeeFirstName The employee's first name.
     */
	public void setFirstName(String employeeFirstName) {
		this.firstName = employeeFirstName;
	}
	 /**
     * Sets the employee's last name.
     * 
     * @param employeeLastName The employee's last name.
     */
	public void setLastName(String employeeLastName) {
		this.lastName = employeeLastName;
	}
	/**
     * Sets the number of hours worked per week.
     * 
     * @param hoursWorked The hours worked.
     */
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	 /**
     * Sets the hourly wage.
     * 
     * @param wage The hourly wage.
     */
	public void setWage(double wage) {
		this.wage = wage;
	}
	
    /**
     * Returns a string representation of the employee.
     * 
     * @return A formatted string containing employee details.
     */
    @Override
	public String toString() {
	    return "Employee Number: " + iD + ", Name: " + firstName + " " + lastName +
	           ", Hours Worked: " + hoursWorked + ", Wage: $" + wage + ", Gross Salary: $ " + grossSalary;
	}
	
	
	
}
