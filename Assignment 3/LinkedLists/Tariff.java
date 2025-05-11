package LinkedLists;

//--------------------------------------------------------------------
//Assignment 3
//Question: Part2
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------


/**
 * Represents a trade tariff between two countries for a specific product category.
 * This class encapsulates the details of the tariff including destination country, 
 * origin country, product category, and the minimum tariff rate.
 */
public class Tariff {
	
	private String destinationCountry;	//The country receiving the imported goods
	private String originCountry;		//The country exporting the goods
	private String productCategory;		//The category of the product being traded
	private double minimumTariff;		//The minimum tariff rate applicable to the trade
	
	/**
     * Constructs a new Tariff object with specified destination, origin, product category, and tariff.
     *
     * @param destinationCountry the country receiving the product
     * @param originCountry the country exporting the product
     * @param productCategory the category of the traded product
     * @param minimumTariff the minimum tariff rate to be applied
     */
	public Tariff(String destinationCountry,String originCountry, String productCategory, double minimumTariff ) {
		this.destinationCountry = destinationCountry;
		this.originCountry = originCountry;
		this.productCategory = productCategory;
		this.minimumTariff = minimumTariff;
	}
	 /**
     * Copy constructor to create a deep copy of another Tariff object.
     *
     * @param other the Tariff object to copy
     */
	public Tariff(Tariff other) {
		this.destinationCountry = other.destinationCountry;
		this.originCountry = other.originCountry;
		this.productCategory = other.productCategory;
		this.minimumTariff = other.minimumTariff;
	}

	/**
     * Gets the destination country.
     *
     * @return the destination country
     */
	public String getDestinationCountry() {
		return destinationCountry;
	}

	/**
     * Gets the origin country.
     *
     * @return the origin country
     */
	public String getOriginCountry() {
		return originCountry;
	}
	
	/**
     * Gets the product category.
     *
     * @return the product category
     */
	public String getProductCategory() {
		return productCategory;
	}
	
	 /**
     * Gets the minimum tariff.
     *
     * @return the minimum tariff rate
     */
	public double getMinimumTariff() {
		return minimumTariff;
	}

	/**
     * Sets the destination country.
     *
     * @param destinationCountry the new destination country
     */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	 /**
     * Sets the origin country.
     *
     * @param originCountry the new origin country
     */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	 /**
     * Sets the product category.
     *
     * @param productCategory the new product category
     */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	/**
     * Sets the minimum tariff.
     *
     * @param minimumTariff the new minimum tariff rate
     */
	public void setMinimumTariff(double minimumTariff) {
		this.minimumTariff = minimumTariff;
	}
	
	
	/**
     * Creates and returns a deep copy of this Tariff object.
     *
     * @return a cloned Tariff object
     */
	public Tariff clone() {
		return new Tariff(this);
	}
	
	 /**
     * Returns a string representation of the Tariff.
     *
     * @return a space-separated string of all tariff attributes
     */
	public String toString() {
		return destinationCountry + " " + originCountry + " " + productCategory + " " + minimumTariff;
	}
	
	/**
     * Compares this Tariff to another object for equality.
     *
     * @param obj the object to compare with
     * @return true if all fields are equal (case-insensitive for strings), false otherwise
     */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		
		Tariff tariff = (Tariff) obj;
		return (this.destinationCountry.equalsIgnoreCase(tariff.destinationCountry) &&
				this.originCountry.equalsIgnoreCase(tariff.originCountry) &&
				this.productCategory.equalsIgnoreCase(tariff.productCategory) &&
				this.minimumTariff == tariff.minimumTariff);
		
	}

}
