package LinkedLists;
import java.util.ArrayList;
import java.util.Scanner;

import LinkedLists.TariffList.TariffNode;

import java.io.*;
//--------------------------------------------------------------------
//Assignment 3
//Question: Part2
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------


public class TradeManager {

	public static void main(String[] args) {
		
	TariffList list1 = new TariffList();
	TariffList list2 = new TariffList();
	
	
	
	Scanner in =null;
	String s;
	
	try {
		in = new Scanner (new File("Tariffs.txt"));
		
	} catch(IOException e) {
		System.err.println("Failed to open Tariffs.txt");
	    e.printStackTrace();
	}
	while(in.hasNextLine()) {
		s = in.nextLine();
		String [] strings = s.split(" ");
	try {
		String destination = strings[0];
		String origin = strings[1];
		String category= strings[2];
		double minTariff= Double.parseDouble(strings[3]);
		
		Tariff t = new Tariff(destination, origin,category,minTariff);
		
		if(list1.contains(origin, destination, category)) {
			System.out.println("Duplicate found skipping line: " + s);
		} else {
			list1.addToStart(t);
		}
		
	} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
		System.err.println("Error invalidd number format, skipping line:" + s);
		
	}
	}
	in.close();
	
	Scanner req;
	try {
	    req = new Scanner(new File("TradeRequests.txt")); // <-- this line was missing
	} catch (IOException e) {
	    System.err.println("Failed to open TradeRequests.txt");
	    e.printStackTrace();
	    return;
	}
	ArrayList<String> tradeRequests = new ArrayList<>();
	while (req.hasNextLine()) {
	    tradeRequests.add(req.nextLine());
	}
	req.close();
	
	
	for (int i = 0; i < tradeRequests.size(); i++) {
	    String request = tradeRequests.get(i);
	    String[] parts = request.split(" ");
	    try {
	        String requestID = parts[0];
	        String origin = parts[1];
	        String destination = parts[2];
	        String category = parts[3];
	        double tradeValue = Double.parseDouble(parts[4]);
	        double proposedTariff = Double.parseDouble(parts[5]);

	        TariffNode match = list1.find(origin, destination, category);
	        if (match != null) {
	            double minTariff = match.getTariff().getMinimumTariff();
	            String result = list1.evaluateTrade(requestID, proposedTariff, minTariff, tradeValue);
	            System.out.println(result);
	        } else {
	        	System.out.println(requestID + " - No matching tariff found.");
	        }

	    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
	        System.err.println("Invalid trade request, skipping: " + request);
	    }
	}
	
	Scanner keyboard = new Scanner(System.in);
	System.out.println("\n--- Manual Tariff Search ---");
	System.out.print("How many searches would you like to do? ");
	int searchCount = Integer.parseInt(keyboard.nextLine());

	for (int i = 0; i < searchCount; i++) { 
	    
	    System.out.print("\nEnter origin country: ");
	    String origin = keyboard.nextLine().trim();
	   
	    System.out.print("Enter destination country: ");
	    String destination = keyboard.nextLine().trim();

	    System.out.print("Enter product category: ");
	    String category = keyboard.nextLine().trim();

	    TariffNode match = list1.find(origin, destination, category);

	    if (match != null) {
	        System.out.println("Tariff found: " + match.getTariff());
	    } else {
	        System.out.println("No matching tariff found.");
	    }
	}

	keyboard.close();


	System.out.println("\n--- TESTING METHODS AND CONSTRUCTORS ---");
	 // Create a TariffList and add some sample tariffs.
    TariffList testList = new TariffList();
    //initialize as tariff(destination,origin,category, mintariff)
    Tariff tariffA = new Tariff("China", "USA", "Electronics", 25.0); 
    Tariff tariffB = new Tariff("USA", "Germany", "Automobiles", 10.0); 
    Tariff tariffC = new Tariff("USA", "India", "Agriculture", 5.0); 
    Tariff tariffD = new Tariff("Canada", "Brazil", "Agriculture", 9.0);
    testList.addToStart(tariffA);
    testList.addToStart(tariffB);
    testList.addToStart(tariffC);
    
    System.out.println("Initial TariffList:");
    printList(testList);
    
    System.out.println("\n--- Testing deleteFromStart() ---");
    // deleteFromStart removes the head; here tariffC (the most recent added) should be removed.
    testList.deleteFromStart();
    printList(testList);
    
    System.out.println("\n--- Testing insertAtIndex() ---");
    // Insert tariffD at index 1.
    testList.insertAtIndex(tariffC, 1);
    printList(testList);
    
    // Test replaceAtIndex: Replace the tariff at index 1 with tariffD.
    System.out.println("\n--- Testing replaceAtIndex ---");
    testList.replaceAtIndex(tariffD, 1);
    printList(testList);
    
    // Test find: search for a tariff that exists.
    System.out.println("\n--- Testing find ---");
    // Looking for (India, USA, Agriculture)
    TariffList.TariffNode foundNode = testList.find("Germany", "USA", "Automobiles");
    if (foundNode != null) {
        System.out.println("Found tariff: " + foundNode.getTariff());
    } else {
        System.out.println("Tariff not found.");
    }
    
    // Test contains: existing and non-existing cases.
    System.out.println("\n--- Testing contains ---");
    boolean containsCase1 = testList.contains("USA", "China", "Electronics");
    boolean containsCase2 = testList.contains("France", "Germany", "Manufacturing");
    System.out.println("Contains (USA, China, Electronics): " + containsCase1);
    System.out.println("Contains (France, Germany, Manufacturing): " + containsCase2);
    
    // Test the copy constructor and equals method.
    System.out.println("\n--- Testing copy constructor and equals ---");
    TariffList copiedList = new TariffList(testList);
    System.out.println("List equals its copy? " + testList.equals(copiedList));
    // Modify the copied list to see if they differ.
    copiedList.deleteFromIndex(0);
    System.out.println("After deleting element from copy, lists equal? " + testList.equals(copiedList));
    
    // Test TariffNode clone method.
    System.out.println("\n--- Testing TariffNode clone ---");
    TariffList.TariffNode originalNode = testList.getHead();
    TariffList.TariffNode clonedNode = originalNode.clone();
    System.out.println("Original node tariff: " + originalNode.getTariff());
    System.out.println("Cloned node tariff: " + clonedNode.getTariff());
    System.out.println("Nodes are equal? " + originalNode.equals(clonedNode));

    System.out.println("\n--- Testing TariffNode Copy Constructor and clone() ---");
    // Create a TariffNode using the parameterized constructor.
    TariffList.TariffNode paramNode = list2.new TariffNode(tariffA, null);
    // Test copy constructor.
    TariffList.TariffNode copyNode = list2.new TariffNode(paramNode);
    // Test clone method.
    TariffList.TariffNode cloneNode = paramNode.clone();
    System.out.println("Parameter Node: " + paramNode.getTariff());
    System.out.println("Copy Node:      " + copyNode.getTariff());
    System.out.println("Clone Node:     " + cloneNode.getTariff());
    if (paramNode.equals(copyNode)) {
        System.out.println("TariffNode copy constructor works correctly.");
    } else {
        System.out.println("TariffNode copy constructor has issues.");
    }
    if (paramNode.equals(cloneNode)) {
        System.out.println("TariffNode clone() method works correctly.");
    } else {
        System.out.println("TariffNode clone() method has issues.");
    }
	
}
	
// Helper method to print the TariffList.
private static void printList(TariffList list) {
    System.out.println("List size: " + list.getSize());
    TariffList.TariffNode current = list.getHead();
    int index = 0;
    while (current != null) {
        System.out.println("Index " + index + ": " + current.getTariff());
        current = current.getNext();
        index++;
    }
}	
	
}
