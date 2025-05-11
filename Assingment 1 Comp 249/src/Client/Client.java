//--------------------------------------------------------
//Assignment 1
//Question: Part I (Client)
//Written by: Sanjitt Kanagalingam (4031831) 
//Due date: 10/02/2025
//--------------------------------------------------------
package Client;

/**
 * Class representing a client.
 * Contains a unique client ID, name, and address.
 */


public class Client {
    
    // Static variable to generate unique client IDs, starting at 100
    private static int nextId = 100;
    
    // Final instance variable for the client's ID
    private final int clientId;
    
    // Other attributes
    private String name;
    private String adress;
    
    /**
     * Default constructor.
     * Initializes the client with default values and assigns a unique ID.
     */
    public Client() {
        this.clientId = nextId++;
        this.name = "Unknown";
        this.adress = "UnknownAdress";
       
    }
    
    /**
     * Parameterized constructor.
     * 
     * @param name    the name of the client
     * @param adress  the address of the client
     */
    public Client(String name, String adress) {
        this.clientId = nextId++;
        this.name = name;
        this.adress = adress;
       
    }
    
    /**
     * Copy constructor.
     * Creates a new Client as a copy of the given client (assigning a new unique ID).
     * 
     * @param other the Client to copy
     */
    public Client(Client other) {
        this.clientId = nextId++;
        this.name = other.name;
        this.adress = other.adress;
    }
    
    /**
     * Gets the client's unique ID.
     * 
     * @return the client ID
     */
    public int getClientId() {
        return clientId;
    }
    
    /**
     * Gets the client's name.
     * 
     * @return the client's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the client's name.
     * 
     * @param name the new name for the client
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the client's address.
     * 
     * @return the client's address
     */
    public String getAdress() {
		return adress;
	}
    
    /**
     * Sets the client's address.
     * 
     * @param adress the new address for the client
     */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	 /**
     * Compares this client to another object.
     * 
     * @param other the object to compare
     * @return true if the clients have the same name and address; false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Client client = (Client) other;
        return (name.equalsIgnoreCase(client.name) &&
        		adress.equalsIgnoreCase(client.adress));
               
    }
    
    /**
     * Returns a string representation of the client.
     * 
     * @return a string describing the client
     */
    @Override
    public String toString() {
        return "Client ID: " + clientId +", Name: " + name + ", Adress: " + adress; 
               
    }
}