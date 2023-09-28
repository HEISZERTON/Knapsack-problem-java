
/*
 * Emmitt Heisz #300017758 
 * 
 *knapsack class for solving the knapsack problem which acts like a virtual knapsack 
 */

import java.util.*;  

public class Knapsack {
	
	List<Item> list;   
	int capacity, load, worth;			//-1 = unlimited capacity
	
	//create a new instance of a knapsack with capacity c
	public Knapsack( int c) {
			list = new ArrayList<Item>();		  
			capacity = c; //capacity of the bag
			load = 0; //how heavy all the items in the bag weigh
			worth = 0; //how much the total value of all the items is
	}
	
	//create a new instance of a knapsack with all the same properties and items in it as knapsack n 
	public Knapsack(Knapsack n) {
        this.capacity = n.capacity;
        this.load = n.load;
        this.worth = n.worth;
    	this.list = new ArrayList<Item>(n.list);
    }
	
	//Function that checks if an item of weight w fits in the backpack 
	public boolean fits(int w) {
		return (load + w <= capacity);
	}
	
	//inserts the item i in the knapsack
	public void insert(Item i) { 			// does not check if fits
		list.add(i);
		load += i.getweight(); //add the weight of the item to backpacks load 
		worth += i.getvalue(); //add the value of the item to backpacks value
	}
	
	//empty all the items form the knapsack
	public void empty() {
		 list.clear();
		 load = 0;
		 worth = 0;
	}
	
	//function that returns the load of the bag
	public int getLoad() {
		return load;
	}
	
	//function that returns the worth of the bag
	public int getWorth() { 
		return worth;
	}
	
	//return a string (print result) of all the items in the bag
	public String print() {
		String temp = "";
		for(int i = 0; i < list.size(); i++) {
			temp += list.get(i).getname() + " ";
		}
		return temp;
	}

}

