/*
 * Emmitt Heisz #300017758 
 * Programming paradims comprehensive assignment Java
 * 
 */


import java.io.*;
import java.util.Scanner;

public class KnapsackSolution {
	private int numItems, bagSize;
	private Item items[];
	private Knapsack sol;


	
	public KnapsackSolution() {
		
	}
	
	//load the file and add the information to the Knapsack class sol
	public void loadfile(String fileName) {
		
		//@SuppressWarnings("resource")
		File myObj = new File(fileName);

		try {
			Scanner reader = new Scanner(myObj);
			
			//the first line in the file reads an integer representing the number of items in the set of items in the file
			numItems = reader.nextInt();
			
			//create an array of items that represents the set of items in the file
			items = new Item[numItems];
			for(int i =0; i < numItems; i++) { //for loop to read the items from the file and add htem to the array
				items[i] = new Item(reader.next(),reader.nextInt(),reader.nextInt());
			}
			
			//get bag size from the last line in the file (int) and init a knapsack solution 
			bagSize = reader.nextInt();
			sol = new Knapsack(bagSize);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Save solution to solution File
	public void save(String fileName) {
	try {
		FileWriter myWriter = new FileWriter("sol_"+fileName);
		//reads info from sol knapsack class to save to file
	    myWriter.write(sol.getWorth() + "\n");
	    myWriter.write(sol.print());
	    myWriter.close();
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	//brute force solution
	public void bruteForce() {
		
		//create temporary bag to test all possible solutions
		Knapsack bag = new Knapsack(bagSize);
		
		//loop threw all possible solutions of a binary decision to either place each item in the bag or not
		for(int i = 0; i < (Math.pow(2,numItems)) ;i++) {
			String bin = Integer.toBinaryString(i);
			
			for (int j = 1; j <= bin.length() ;j++) {
				if (bin.charAt(bin.length()-j) == '1') {
					bag.insert(items[j-1]);
				}
			}
			
			// if the current solution is a good solution (all items fit in bag) and it is worth more than the saved best solution (sol) 
			//then replace the saved best solution with the current solution
			if (bag.fits(0) && bag.getWorth() > sol.getWorth()) {
				sol = new Knapsack(bag);

			}	
			bag.empty();//empty temp bag
		}
		
	}
	
	//dynamic solution implements kTable class
	public void dynamic() {
		KTable kt = new KTable(numItems, bagSize, items);
		sol = kt.getSol();
	} 
  
 
}
	
	
	

