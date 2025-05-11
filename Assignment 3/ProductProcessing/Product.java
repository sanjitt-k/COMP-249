package ProductProcessing;
//--------------------------------------------------------------------
//Assignment 3
//Question: Product class/Part 1
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------

/**
 * The {@code Product} class represents a product involved in trade data processing.
 * Each product has a name, country of origin, category, and price.
 * This class is used in tariff adjustments and sorting operations.
 * 
 * @author 
 */
public class Product{

	
	 // Instance Variables

    /** The name of the product */
	private String productName;
	private String country; 	//The country of origin for the product
	private String category;	//The category of the product (e.g., Electronics, Agriculture)
	private double price;		// The price of the product
	
	/**
     * Default constructor that initializes the product fields to default values.
     */
	public Product() {
		this.productName = "UnknownProduct";
		this.country = "UnkownCountry";
		this.category = "UnknownCategory";
		this.price = 0.0;
	}
	
	 /**
     * Constructs a {@code Product} object with the specified name, country, category, and initial price.
     *
     * @param productName  the name of the product
     * @param country      the country of origin
     * @param category     the product category
     * @param initialPrice the initial price of the product
     */
	public Product(String productName, String country, String category, double initialPrice) {
		this.productName = productName;
		this.country = country;
		this.category = category;
		this.price = initialPrice;
	}

	 /**
     * Returns the product name.
     *
     * @return the product name
     */
	public String getProductName() {
		return productName;
	}
	  /**
     * Returns the country of origin.
     *
     * @return the country name
     */
	public String getCountry() {
		return country;
	}

	  /**
     * Returns the product category.
     *
     * @return the category name
     */
	public String getCategory() {
		return category;
	}

	  /**
     * Returns the price of the product.
     *
     * @return the product price
     */
	public double getPrice() {
		return price;
	}
	
	  /**
     * Sets the product name.
     *
     * @param productName the new product name
     */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	 /**
     * Sets the country of origin.
     *
     * @param country the new country name
     */
	public void setCountry(String country) {
		this.country = country;
	}

	  /**
     * Sets the product category.
     *
     * @param category the new category name
     */
	public void setCategory(String category) {
		this.category = category;
	}

	  /**
     * Sets the product price.
     *
     * @param price the new price
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	 /**
     * Returns a string representation of the product in the format:
     * {@code name,country,category,price}
     *
     * @return formatted product string
     */
	public String toString() {
		return productName + "," + country + "," + category + "," + String.format("%.1f", price) ;
	}
	

    /**
     * Compares this product to another by their names (alphabetically).
     *
     * @param other the product to compare with
     * @return a negative, zero, or positive integer as this product name
     *         is less than, equal to, or greater than the specified product's name
     */
	public int compareTo(Product other) {
		return this.productName.compareTo(other.productName);
	}
	
}
