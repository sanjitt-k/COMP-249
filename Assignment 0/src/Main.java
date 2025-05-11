//-------------------------------------------------------------
// Assignment 0
// Question: Part 2
// Written by: Sanjitt Kanagalingam 40313831
//-------------------------------------------------------------
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		/*This part of the program will allow the user to access, view and modify books
		*that have been stored through a menu that will allow the user to pick the desired 
		* options.
		*/
		
		//declare scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Display welcome message
		System.out.println("Welcome to the Bookstore tracker");
		
		//Prompt max number of books
		System.out.print("Enter maximum number of books that your bookstore can contain: ");
		int maxBooks = keyboard.nextInt();
		Book[] inventory = new Book[maxBooks];
		
		
		//create switch and while loop for the main menu
		int choice = 0;
		final String PASSWORD = "249";
		int passwordProtection = 4;//allow the user to a maximum of 12 attempts
		do {
			System.out.println("What do you want to do? \n" +
							   "\t 1. \t Enter new books (password required)\n" +
					   		   "\t 2. \t Change information of a book (password required)\n" +
							   "\t 3. \t Display all books by a specific author\n" +
					   		   "\t 4. \t Display all books under a certain a price.\n" +
							   "\t 5. \t Quit\n" +
					   		   "Please enter your choice> ");
			
			choice = keyboard.nextInt();
           

			//switch menu
			switch (choice) {
				
			//Option 1
				case 1:
					//Prompt the user to enter the password
					int tries = 3;//tries for each loop
					String passwordInput;
					
					while (tries>0) {
						System.out.print("Enter your password(" + tries + " tries remaining): ");
						passwordInput = keyboard.next();
			            System.out.println();

						if(passwordInput.equals(PASSWORD)) {
							System.out.print("Correct password, how many books would you like to add: ");
							int addBooks = keyboard.nextInt();
							keyboard.nextLine();
							
                            // Check if there is enough space in the inventory
							if(inventory.length - Book.findNumberOfCreatedBooks()  >= addBooks) {
								
								// Loop to add books
								for(int i = 0; i<addBooks; i++) {
									System.out.println("Enter information for book " + Book.findNumberOfCreatedBooks()+": ");
									System.out.print("Title: ");
									String title = keyboard.nextLine();
									System.out.print("Author: ");
									String author = keyboard.nextLine();
									System.out.print("ISBN: ");
									long ISBN = keyboard.nextLong();
									System.out.print("Price: ");
									double price = keyboard.nextDouble();
									keyboard.nextLine();
									
									//Store information of the book
									inventory[Book.findNumberOfCreatedBooks()] = new Book(title, author, ISBN, price);
								
								}
								System.out.println("Book successfully added. Remaining space: " + (inventory.length - Book.findNumberOfCreatedBooks()));			    	
							} else {
								System.out.println("Unsuccessful, remaining inventory space: " + (inventory.length - Book.findNumberOfCreatedBooks()));
							}
							break; //exit password loop 
						}
						
						//if the user inputs and incorrect password
						else {
							tries--;
							if (tries >0) {
								System.out.println("Incorrect, you have " + tries + "remaining.");		
							} else {
								passwordProtection--;
								}
							System.out.println("Attempts exceeded returning to main menu");
							}
						break;//exit to menu
						
						}
				case 2: 
					
					tries = 3;
					System.out.println("Enter your password(" + tries + " tries remaining): ");
					while(tries>0) {
						
						passwordInput = keyboard.next();
						System.out.println();
						
						if(passwordInput.equals(PASSWORD)) {
							System.out.println("Correct password");
							int specificBook;
							
							while(true) {
								System.out.print("Enter the index of the book you wish to update: ");
								specificBook = keyboard.nextInt();
								
								if(specificBook <0 || specificBook >= (Book.findNumberOfCreatedBooks()-1)|| inventory[specificBook]== null) {
									System.out.println("No book found at the given index");
									System.out.print("\t 1. Re-enter another book \n" +
													 "\t 2. Quit and go back to main menu." +
												     "Enter your choice > ");
									int secondChoice = keyboard.nextInt();
									if(secondChoice == 2) {
										break;
									}																		
								} else {
									System.out.println("Book # " + specificBook);
									System.out.println("Author: " + inventory[specificBook].getAuthor());
									System.out.println("Title: " + inventory[specificBook].getTitle());
									System.out.println("ISBN: " + inventory[specificBook].getIsbn() + "#");
									System.out.println("Price: $" + inventory[specificBook].getPrice());
									break;
								}
							}
							
							if(specificBook < 0 || specificBook >=(Book.findNumberOfCreatedBooks()-1)|| inventory[specificBook]== null){
								break;
							}
							
							int choice2;
							do {
								System.out.println("What information would you like to change?");
								System.out.print("\t 1.\t author\n" +
												 "\t 2.\t title\n" +
												 "\t 3.\t ISBN\n" +
												 "\t 4.\t price\n" +
												 "\t 5.\t Quit\n" +
												 "Enter your choice> ");
								while (true) {
									choice2 =keyboard.nextInt();
									if(choice2 >=1 && choice2 <= 5) {
										break;
									}
									System.out.println("Invalid choice. Please try again");
								}
								switch(choice2) {
									case 1: 
										System.out.print("New author: ");
										String newAuthor = keyboard.next();
										inventory[specificBook].setAuthor(newAuthor);
										break;
									
									case 2:
										System.out.print("New title: ");
										String newTitle = keyboard.next();
										inventory[specificBook].setTitle(newTitle);
										break;
									
									case 3: 
										System.out.print("New ISBN: ");
										long newIsbn = keyboard.nextLong();
										inventory[specificBook].setIsbn(newIsbn);
										break;
									
									case 4:
										System.out.print("New price: ");
										double newPrice = keyboard.nextDouble();
										inventory[specificBook].setPrice(newPrice);
										break;
										
									case 5:
										System.out.println("Leaving update menu.");
										break;
									
								}
								//Display the updated info of the book
								System.out.println("\nUpdated Book information");
								System.out.println("Book # " + specificBook);
								System.out.println("Author: " + inventory[specificBook].getAuthor());
								System.out.println("Title: " + inventory[specificBook].getTitle());
								System.out.println("ISBN: " + inventory[specificBook].getIsbn());
								System.out.println("Price: $" +inventory[specificBook].getPrice());
							} while (choice2 !=5);
							break;
						} else {
							tries--;
							if(tries>0) {
								System.out.println("Enter your password(" + tries + " tries remaining): ");
							} else {
								System.out.println("Attempts exceeded returning to main menu");
							}
						}
						
					}
					break;
					
				case 3:
					 // Option 3: Display all books by a specific author
					System.out.print("Enter author name: ");
					String authorSearch = keyboard.next();
					boolean found = false;
					
					//for loop to find books by author
					for (int i=0; i<(Book.findNumberOfCreatedBooks()); i++ ) {
						if (inventory[i].getAuthor().equalsIgnoreCase(authorSearch)) {
							System.out.println("Books by " +authorSearch + " : ");
							System.out.print(inventory[i].toString());
							System.out.println();
							found = true;
						}
					}
					if (!found) {
						System.out.println("No books by " + authorSearch + " found in inventory.");
					}
					break;
					
				case 4: 
					//Search by price(price limit)
					System.out.print("Enter the price: ");
					double priceSearch = keyboard.nextDouble();
					boolean foundPrice =false;
				
					for (int i =0; i <(Book.findNumberOfCreatedBooks()); i++ ) {
						if (inventory[i].getPrice() < priceSearch ) {
							System.out.println(inventory[i].toString());
							foundPrice =true;
						}
					}
					
					if(!foundPrice) {
						System.out.println("No books found below $" + priceSearch);
					}
					break;
					
				case 5:
					 // Option 5: Quit the program
					break;
				
				default:
					System.out.println("Invalid choice. Enter a number between 1 and 5");
			
					}
			// Check for suspicious activity and terminate if necessary
			if (passwordProtection <=0) {
				System.out.println("Program detected suspicious activities and will terminate immediately!");
				
			}
				
			} while (choice !=5 && passwordProtection >0);
		System.out.println("\n Thank you for using our service, Goodbye!");
		keyboard.close();
		}
	}


