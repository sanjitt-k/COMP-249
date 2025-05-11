package Payroll;

import ExceptionHandling.MinimumWageException;
import java.io.*;
//--------------------------------------------------------------------
//Assignment 2
//Question: Payroll processing file
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * Processes the payroll file for iDroid Solutions.
 * Reads employee data from a payroll file, validates the input,
 * and writes error lines and a formatted payroll report to separate files.
 */
public class PayrollIFileProcessing{

	//instance varaibles
	private static int errorLines =0;
	private static int totalLines = 0;
	private static boolean errorMessage = false;
	
	
	/**
     * Main method that drives the payroll file processing.
     *
     * @param args Command line arguments.
     * @throws Exception If an error occurs during file processing.
     */
	public static void main(String[] args) throws Exception {
		
		//create an object of type employee manager to call the method
		EmployeeManager manager = new EmployeeManager();
		
		System.out.println("Welcome do IDroid Solutions presented to you by Sanjitt Kanagalingam");
		System.out.println(">Opening file...");
		System.out.println(">Reading file...");
		
		//count the number of lines in the file
		BufferedReader counterReader = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Desktop\\payroll.txt"));
		while(counterReader.readLine() != null) {
			totalLines++;
		}
		counterReader.close();
		
		//file input
		String employee = "";
		BufferedReader in = null;
		PrintWriter out = null;
		PrintWriter report = null;
		
		 // Initialize file readers and writers for the payroll, error, and report files.
		try {
		in = new BufferedReader(new FileReader("C:\\Users\\user\\OneDrive\\Desktop\\payroll.txt"));
		out = new PrintWriter ( new BufferedWriter( 
									new PrintWriter("payrollError.txt")));
		report = new PrintWriter (new BufferedWriter( 
										new PrintWriter("payrollReport.txt")));
		}
		//parsing information from file
		
		catch (FileNotFoundException e) {
			System.err.println("Error: file was not found");
			System.err.println("or could not be opened/created");
			System.exit(0);
		}
		
		   // Process each line from the payroll file.
		while ((employee= in.readLine()) != null) {
			String delims = "[ ]";	//splits the string into seperate tokens
			String[] tokenizer = employee.split(delims); //store the split parts into a tokenizer array
			
			try {
			long iD = Long.parseLong(tokenizer[0]);
			String firstName = tokenizer[1];
			String lastName = tokenizer[2];
			double hoursWorked = Double.parseDouble(tokenizer[3]);
			double wage = Double.parseDouble(tokenizer[4]);
			
			// Validate the wage against the minimum legal wage.
			if(wage<15.75) {
				throw new MinimumWageException(firstName, lastName, wage);
			}
			
			//add employee to manager(this code is only reached with valid input)
			manager.initializeEmployees(iD, firstName, lastName, hoursWorked, wage);
		}
			
			catch (MinimumWageException e){
				if(errorMessage == false) {
					System.out.println(">Error lines found in file payroll");
					errorMessage = true;
				}
				System.err.println(employee);
				errorLines++;
				out.println(employee);

			}
			catch (NumberFormatException e) {
				if(errorMessage == false) {
					System.out.println(">Error lines found in file payroll");
					errorMessage = true;
				}
				System.err.println(employee);
				errorLines++;
				out.println(employee);
			}
			
			
		}
		in.close();
		out.close();
		
		System.out.println("\n>" + totalLines + " lines read from file payroll");
		System.out.println(">" + errorLines + " lines written to error file");
		System.out.println(">Calculating deductions");
		System.out.println(">Writing report file");
		
		
		System.out.println("  			iDroid Solutions									");		
		System.out.println(" 			----------------    								");
		System.out.println(manager.showEmployeeReport());
		System.out.println("......	..........   .........    .........	.........    .........");
		 
		report.println("  				iDroid Solutions									");		
		report.println(" 				----------------    								");
		report.println(manager.showEmployeeReport());
		report.println("......	..........   .........    .........	.........    .........");
		
		report.close();
		
		System.out.println("End of program");
	}
}
	
		
		