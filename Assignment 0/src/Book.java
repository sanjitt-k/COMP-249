//-------------------------------------------------------------
// Assignment 0
// Question: Part I
// Written by: Sanjitt Kanagalingam 40313831
//-------------------------------------------------------------

/**
 * The Book class represents a book in a bookstore inventory.
 * It stores information about the book's title, author, ISBN, and price.
 * It also provides methods to access and modify this information, as well as
 * utility methods to compare books and display their details.
 */
public class Book {
	
	//declare the instance variables for object book
	private String title;       // Title of the book
    private String author;      // Author of the book
    private long ISBN;          // ISBN number of the book
    private double price;       // Price of the book
    private static int countBook = 0; // Static counter to track the number of books created
	
    /**
     * Default constructor for the Book class.
     * Initializes the book with empty title, empty author, ISBN as 0, and price as 0.0.
     * Increments the count of books created.
     */
	public Book () {
		this.title= "";
		this.author="";
		this.ISBN = 0;
		this.price = 0.0;
		countBook++;
	}
	
	
	/**
     * Parameterized constructor for the Book class.
     * Initializes the book with the provided title, author, ISBN, and price.
     * Increments the count of books created.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     * @param ISBN   The ISBN number of the book.
     * @param price  The price of the book.
     */
	public Book (String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = title;
		this.ISBN = ISBN;
		this.price = price;
		countBook++;
	}
	
	/**
     * Copy constructor for the Book class.
     * Initializes a new book with the same attributes as the provided book.
     * Increments the count of books created.
     *
     * @param otherBook The book to copy.
     */
	public Book(Book otherBook) {
		this.title = otherBook.title;
		this.author = otherBook.author;
		this.ISBN = otherBook.ISBN;
		this.price = otherBook.price;
		countBook++;
	}
	
	/**
     * Returns the title of the book.
     * @return The title of the book.
     */
	public String getTitle() {
		return title;
	}
	 /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
	public String getAuthor() {
		return author;
	}
	 /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
	public long getIsbn() {
		return ISBN;
	}
	 /**
     * Returns the price of the book.
     *
     * @return The price of the book.
     */
	public double getPrice() {
		return price;
	}
	
	 /**
     * Sets the title of the book.
     *
     * @param newTitle The new title of the book.
     */
	
	//Create Mutator methods
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	/**
     * Sets the author of the book.
     *
     * @param newAuthor The new author of the book.
     */
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	/**
     * Sets the ISBN of the book.
     *
     * @param newISBN The new ISBN of the book.
     */
	public void setIsbn(long newISBN) {
		this.ISBN = newISBN;
	}
	 /**
     * Sets the price of the book.
     *
     * @param newPrice The new price of the book.
     */
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	/**
     * Returns the total number of books created.
     *
     * @return The number of books created.
     */
	public static int findNumberOfCreatedBooks() {
		return countBook;
	}
	
	 /**
     * Compares this book to another book for equality.
     * Two books are considered equal if they have the same ISBN and price.
     *
     * @param otherBook The book to compare with.
     * @return True if the books are equal, false otherwise.
     */
	public boolean equals(Book otherBook) {
		return (this.ISBN == otherBook.ISBN &&
				this.price == otherBook.price);
	}
	
	/**
     * Returns a string representation of the book.
     * The string includes the title, author, ISBN, and price of the book.
     *
     * @return A string representation of the book.
     */
	public String toString() {
		return "Title: " + title + "Author: " + author + "ISBN: " + ISBN + "Price: " + price + "$";
		
	}
		
	
}
