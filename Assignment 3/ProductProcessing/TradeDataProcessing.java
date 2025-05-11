package ProductProcessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//--------------------------------------------------------------------
//Assignment 3
//Question: TradeDataProcessing/Part 1
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * The  TradeDataProcessing class reads trade data from a file, applies tariffs based on
 * the product's country and category, sorts the products alphabetically by name, and writes the
 * updated data to an output file.
 * 
 * This class fulfills Part 1 of the COMP 249 Assignment 3 requirements using File I/O and ArrayList.
 * 
 * Input file: TradeData.txt  
 * Output file: UpdatedTradeData.txt
 * 
 * @author 
 */
public class TradeDataProcessing {

	 /**
     * The entry point of the program.
     * <p>
     * Reads the trade data, processes tariffs, sorts products, and writes output to a file.
     * </p>
     *
     * @param args the command-line arguments (not used)
     */
	public static void main(String[] args) {
		
		System.out.println("================================================================");
		System.out.println("Welcome Trade Data Processor (Written by Sanjitt Kanagalingam)");
		System.out.println("================================================================");
		
		String product = "";
		ArrayList<Product> products = new ArrayList<>();
		Scanner in = null;
		
		try {
			
		File file = new File("TradeData.txt");
		in = new Scanner(file);
		
		while(in.hasNextLine()) {
			product = in.nextLine();
			String [] a = product.split(",");
			
			if(a.length==4) {
				String productName = a[0];
				String country = a[1];
				String category = a[2];
				double price = Double.parseDouble(a[3]);
				
				Product p= new Product(productName, country, category, price);
				
				products.add(p);
			} else {
				System.err.println("Skipping line: invalid data or empty line");
			}
		}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: Error");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.err.println("Error parsing price to double.");
		    e.printStackTrace();
		}catch (Exception e) {
			System.err.println("Unexpected error occurred.");
		    e.printStackTrace();
		}
		in.close();
		
		
		//call the methods
		applyTariffs(products);
		sortProducts(products);
		writeToFile(products);	
		
		System.out.println("Tariffs applied and updated in UpdatedTradeData.txt");

	}
	  /**
     * Applies tariff adjustments to the list of products based on the country of origin
     * and product category using predefined rules.
     *
     * @param products the list of products to be adjusted
     */
	public static void applyTariffs(ArrayList<Product>products) {
		
		for(int i=0; i<products.size();i++) {
			if(products.get(i).getCountry().equalsIgnoreCase("china")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.25);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("usa") && products.get(i).getCategory().equalsIgnoreCase("electronics")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.10);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("japan") && products.get(i).getCategory().equalsIgnoreCase("automobile")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.15);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("india") && products.get(i).getCategory().equalsIgnoreCase("agriculture")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.05);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("south korea") && products.get(i).getCategory().equalsIgnoreCase("electronics")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.08);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("saudi arabia") && products.get(i).getCategory().equalsIgnoreCase("energy")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.12);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("germany") && products.get(i).getCategory().equalsIgnoreCase("manufacturing")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.06);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("bangladesh") && products.get(i).getCategory().equalsIgnoreCase("textile")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.04);
			}
			if(products.get(i).getCountry().equalsIgnoreCase("brazil") && products.get(i).getCategory().equalsIgnoreCase("agriculture")) {
				products.get(i).setPrice(products.get(i).getPrice()*1.09);
			}
			
		}
	}
	
	  /**
     * Sorts the products alphabetically by product name.
     *
     * @param products the list of products to be sorted
     */
	public static void sortProducts(ArrayList<Product>products) {
		
		products.sort((a,b) -> { 
			return a.getProductName().compareTo(b.getProductName()); 
			} );
	}

    /**
     * Writes the list of updated products to a file named {@code UpdatedTradeData.txt}.
     * Each product is written on a new line in the same format as the input file.
     *
     * @param products the list of products to be written
     */
	public static void  writeToFile(ArrayList<Product>products) {
		
		PrintWriter out = null;
		try { 
			out = new PrintWriter(new FileWriter("UpdatedTradeData.txt"));
			
			for(int i=0;i<products.size();i++) {
				out.println(products.get(i).toString());
				System.out.println(products.get(i).toString());
			}
			
		} catch(IOException e) {
			System.err.println("Error unable to create or access UpdatedTradeData.txt file");
		} finally {
			if(out != null) {
				out.close();
			} else {
				System.exit(0);
			}
		}
	}
	
}
