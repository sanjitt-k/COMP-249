package LinkedLists;

import java.util.NoSuchElementException;
//--------------------------------------------------------------------
//Assignment 3
//Question: Part 2
//Written by: Sanjtt Kanagalingam(40313831)
//--------------------------------------------------------------------


/**
 * Represents a singly linked list of Tariff objects.
 * Provides operations to manipulate and search the list.
 */
public class TariffList implements TariffPolicy
{

    /**
     * Inner class representing a node in the TariffList.
     * Each node contains a Tariff object and a reference to the next node.
     */

	public class TariffNode {
		
		//instance variables for TariffNode
		private Tariff tariff;		//The Tariff object stored in the node 
		private TariffNode next;	//Reference to the next node in the list
		
		 /** Default constructor initializing tariff and next to null */
		public TariffNode() {
			tariff = null;
			next = null;
		}
		
		/**
         * Constructs a TariffNode with specified tariff and next reference.
         *
         * @param newTariff the Tariff object
         * @param newNext the next node in the list
         */
		public TariffNode(Tariff newTariff, TariffNode newNext) {
			tariff = newTariff;
			next = newNext;
		}
		
		/**
         * Copy constructor for deep copying a TariffNode and all nodes after it.
         *
         * @param other the TariffNode to copy
         */
		public TariffNode(TariffNode other) {
		    if (other == null) {
		        throw new IllegalArgumentException("Cannot copy from null TariffNode.");
		    }

		    this.tariff = other.tariff.clone(); // Deep copy of the Tariff

		    if (other.next != null) {
		        this.next = new TariffNode(other.next); // Recursively copy the next node
		    } else {
		        this.next = null; // End of list
		    }
		}
		
		/**
         * Creates a deep clone of this TariffNode.
         *
         * @return a cloned TariffNode
         */
		public TariffNode clone() {
			return new TariffNode(this);
		}
		
		/**
         * Checks if this node is equal to another object.
         *
         * @param obj the object to compare with
         * @return true if equal, false otherwise
         */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;

			TariffNode other = (TariffNode) obj;

			if (!this.tariff.equals(other.tariff)) return false;

			if (this.next == null && other.next == null) return true;
			if (this.next == null || other.next == null) return false;

			return this.next.equals(other.next);
		}

		/**
		 * Returns the Tariff object contained in this node.
		 *
		 * @return the Tariff object
		 */
		public Tariff getTariff() {
			return tariff;
		}
		
		/**
		 * Returns the reference to the next node in the list.
		 *
		 * @return the next TariffNode
		 */
		public TariffNode getNext() {
			return next;
		}

		/**
		 * Sets the Tariff object for this node.
		 *
		 * @param tariff the Tariff to set
		 */
		public void setTariff(Tariff tariff) {
			this.tariff = tariff;
		}
		
		/**
		 * Sets the reference to the next node in the list.
		 *
		 * @param next the next TariffNode
		 */
		public void setNext(TariffNode next) {
			this.next = next;
		}
		
		
	}// end of inner class
	
	//start of tariffList class
	
	private TariffNode head; //points to the first node in the list
	private int size;		 //indicates the size of the list
	
	/** Default constructor that initializes an empty list */
	public TariffList() {
		head = null;
		size = 0;
	}
	
	 /**
     * Copy constructor for deep copying another TariffList.
     *
     * @param other the list to copy
     */
	public TariffList(TariffList other) {
	    if (other == null) {
	        throw new IllegalArgumentException("Cannot copy from null TariffList.");
	    }

	    if (other.head != null) {
	        this.head = new TariffNode(other.head); // Deep copy of the list
	    } else {
	        this.head = null; // Original list was empty
	    }

	    this.size = other.size;
	}
	
	

	/**
	 * Retrieves the head node of the tariff list.
	 *
	 * @return the head {@link TariffNode} of the list, or null if the list is empty
	 */
	public TariffNode getHead() {
		return head;
	}
	
	/**
	 * Returns the current size of the tariff list.
	 *
	 * @return the number of nodes in the list
	 */
	public int getSize() {
		return size;
	}

	/**
     * Adds a new Tariff to the start of the list.
     *
     * @param tariff the Tariff object to add
     */
	public void addToStart(Tariff tariff) {
		head = new TariffNode(tariff, head);
		size++;
	}
	
	
	 /**
     * Inserts a Tariff at the specified index.
     *
     * @param tariff the Tariff object to insert
     * @param index the index to insert at
     * @throws NoSuchElementException if the index is out of range
     */
	public void insertAtIndex(Tariff tariff, int index) {
	    if (index < 0 || index > size - 1) {
	        throw new NoSuchElementException("Invalid index: " + index);
	    }

	    if (index == 0) {
	        // Replace head with new node pointing to old head
	        head = new TariffNode(tariff, head);
	    } else {
	        TariffNode current = head;
	        for (int i = 0; i < index - 1; i++) {
	            current = current.getNext();
	        }
	        TariffNode newNode = new TariffNode(tariff, current.getNext());
	        current.setNext(newNode);
	    }

	    size++;
	}
	
	  /**
     * Deletes the Tariff at the specified index.
     *
     * @param index the index to delete from
     * @throws NoSuchElementException if the index is invalid
     */
	public void deleteFromIndex(int index) {
		TariffNode position = head;
		if(index<0 || index > size-1) {
			throw new NoSuchElementException("Invalid index: " + index);
		} 
		if(index ==0) {
			head= head.getNext();	
			size--;
			return;
		}else {
			int i = 0;
			while(i<index-1) {
				position = position.next;
				i++;
			}
		
		position.setNext(position.getNext().getNext()); //link is automatically severed by garbage collector
		size--;
		}
		
	}
	
	/**
     * Deletes the head node.
     *
     * @return true if deletion succeeded, false if list was already empty
     */
	public boolean deleteFromStart() {
		if(head != null) {
			head = head.next;
			size--;
			return true;
		} else {
			return false;
		}
	}
	
	 /**
     * Replaces the Tariff at the given index with a new Tariff.
     *
     * @param t the new Tariff
     * @param index the index to replace at
     */
	public void replaceAtIndex(Tariff t, int index) {
		TariffNode position = head;
		TariffNode before = head;
		if(index<0 || index> size-1) {
			return;
		} 
		if(index==0) {
			TariffNode nodeToReplace = new TariffNode(t, head.getNext());
			head = nodeToReplace;
		}else {
			int i=0; //counter
			while (i<index) {
				before = position;
				position = position.next;
				i++;
			}
			TariffNode nodeToReplace = new TariffNode(t, position.getNext());
			before.setNext(nodeToReplace);
		}
	}
	
	  /**
     * Searches for a TariffNode that matches the given origin, destination, and category.
     *
     * @param origin the origin country
     * @param destination the destination country
     * @param category the product category
     * @return the found TariffNode, or null if not found
     */
	public TariffNode find(String origin, String destination, String category) {
		TariffNode position = head;
		String originP;
		String destinationP;
		String categoryP;
		int iterations = 0;
		
		while(position !=null) {
			iterations++;
			System.out.println("Iteration: " + iterations); //print the number of iterations
			originP = position.tariff.getOriginCountry();
			destinationP = position.tariff.getDestinationCountry();
			categoryP = position.tariff.getProductCategory();
			
			if(originP.equalsIgnoreCase(origin) &&
			   destinationP.equalsIgnoreCase(destination) &&
			   categoryP.equalsIgnoreCase(category)) {
				return position;
			}
			position = position.next;
		}
		return null;//target was not found
	}
	
	 /**
     * Checks whether a Tariff with specified parameters exists in the list.
     *
     * @param origin the origin country
     * @param destination the destination country
     * @param category the product category
     * @return true if found, false otherwise
     */
	public boolean contains(String origin, String destination, String category) {
		TariffNode position = head;
		String originP;
		String destinationP;
		String categoryP;
		
		
		while(position !=null) {
			originP = position.tariff.getOriginCountry();
			destinationP = position.tariff.getDestinationCountry();
			categoryP = position.tariff.getProductCategory();
			
			if(originP.equalsIgnoreCase(origin) &&
			   destinationP.equalsIgnoreCase(destination) &&
			   categoryP.equalsIgnoreCase(category)) {
				return true;
			}
			position = position.next;
		}
		return false;//target was not found
	}
	
	//equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		TariffList otherList = (TariffList) obj;

		if (this.size != otherList.size) return false;

		TariffNode position = this.head;
		TariffNode otherPosition = otherList.head;

		while (position != null) {
			if (!position.equals(otherPosition)) return false;
			position = position.next;
			otherPosition = otherPosition.next;
		}
		return true;
	}
	
	
	 /**
     * Compares this TariffList to another for equality.
     *
     * @param obj the object to compare
     * @return true if the lists are structurally and content-wise equal
     */
	@Override
	public String evaluateTrade(String requestID, double proposedTariff, double minimumTariff, double tradeValue) {
	    if (proposedTariff >= minimumTariff) {
	        return String.format("%s - Accepted.\nProposed tariff %.1f%% meets or exceeds the minimum requirement.", requestID, proposedTariff);
	    } else if (proposedTariff >= 0.8 * minimumTariff) {
	        double surcharge = tradeValue * ((minimumTariff - proposedTariff) / 100.0);
	        return String.format(
	            "%s - Conditionally Accepted.\nProposed tariff %.1f%% is within 20%% of the required minimum tariff %.1f%%.\nA surcharge of $%.0f is applied.",
	            requestID, proposedTariff, minimumTariff, surcharge
	        );
	    } else {
	        return String.format(
	            "%s - Rejected.\nProposed tariff %.1f%% is more than 20%% below the required minimum tariff %.1f%%.",
	            requestID, proposedTariff, minimumTariff
	        );
	    }
	}
	
}
