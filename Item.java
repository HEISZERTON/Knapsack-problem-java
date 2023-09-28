/*
 * Emmitt Heisz #300017758 
 *  
 *  class that defines an item used to solve the knapsack solution
 */

public class Item {

	//init vars
	String name; 
	int value, weight; 
	
	//creates an item with name n, value v, and weight w
	public Item(String n,int v, int w) {
		    name = n;
		    value = v;
		    weight = w;
	}
	
	//returns the value of the item 
	public int getvalue() {
		return value;
	}
	
	//returns the weight of the item 
	public int getweight() {
		return weight;
	}
	
	//returns the name of the item 
	public String getname() {
		return name;
	}

}
