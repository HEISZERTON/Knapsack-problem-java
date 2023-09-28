
/*
 * Emmitt Heisz #300017758 
 * 
 * Ktable class used to solve the knapsack problem in a dynamic manner
 */

public class KTable {
	
	private Knapsack [][] table; //table of knapsacks
	private Item[] items; //list of items
	private int r,c; //row and column of solution
	
	public KTable(int n, int W, Item[] is) {
		r = n;
		c = W;
		items = is;
		table = new Knapsack [n + 1][W + 1]; 	//init the table of knapsacks to be of size [number of items +1] x [bag size +1]
        // Build table K[][] in bottom up manner 
        for (int i = 0; i<= n; i++) { 
            for (int w = 0; w<= W; w++) { 
                if (i == 0 || w == 0) 
                	table[i][w] = new Knapsack(0); 
                else if (items[i - 1].getweight() <= w) 
                	table[i][w] = maxValue(i,w); 
                else
                	table[i][w] = new Knapsack(table[i - 1][w]); 
            } 
        } 
		
	}
	
	private Knapsack maxValue(int i, int w)  // gets the max value bag 
	{
		Knapsack temp = new Knapsack(table[i - 1][w - items[i-1].getweight()]); 
		temp.insert(items[i - 1]);
		
		if( temp.getWorth() > table[i - 1][w].getWorth()){
			return temp;

		}
		else {
			return new Knapsack(table[i - 1][w]);
		}
	} 
	 
	//return solution
	public Knapsack getSol() {
		return table[r][c];
	}
}
