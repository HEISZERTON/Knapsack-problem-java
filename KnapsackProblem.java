/*
 * Emmitt Heisz #300017758 
 * Programming paradims comprehensive assignment Java
 * 
 */

import java.util.*;

public class KnapsackProblem {
	
	public static void main(String[] args) {

		KnapsackSolution NS = new KnapsackSolution();
		
		String file = args[0];
		String flag = args[1];

		NS.loadfile(file);
		if(flag.equals("F")) {	//brute force flag
			NS.bruteForce();
			NS.save(file);
		}
		else if (flag.equals("D"))  {   //dynamic flag
			NS.dynamic();
			NS.save(file);
		}

	}


}
