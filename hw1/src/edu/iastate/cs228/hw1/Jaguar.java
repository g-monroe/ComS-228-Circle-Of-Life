package edu.iastate.cs228.hw1;

/**
 *  
 * @author Gavin Monroe
 *
 */

/**
 * A jaguar eats a deer and competes against a puma. 
 */
public class Jaguar extends Animal
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Jaguar (Jungle j, int r, int c, int a, char l) 
	{
		age = a;
		letter = l;
		row = r;
		col = c;
		jungle = j;
		
	}
	
	/**
	 * A jaguar occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.JAGUAR; 
	}
	public int age()
	{
		// TODO 
		return age; 
	}
	public char myChar()
	{
		// TODO 
		return letter; 
	}
	/**
	 * A jaguar dies of old age or hunger, from isolation and attack by more numerous pumas.
	 *  
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		// To be implemented in the classes Deer, Empty, Grass, Jaguar, and Puma. 
		// 
		// For each class (life form), carry out the following: 
		// 
		// 1. Obtains counts of life forms in the 3X3 neighborhood of the class object. 
		//DEER, EMPTY, GRASS, JAGUAR, 
		// and PUMA
		int pop[] = new int[5]; 
		Living.census(pop, row, col);
		if (age == 5) {
			jNew.grid[row][col] = new Empty(jNew, row, col);
		}else if (pop[3] <= (pop[4] / 2)) {
			jNew.grid[row][col] = new Puma(jNew, row, col, 0, 'P');
		}else if ((pop[3] + pop[4]) >= pop[0]) {
			jNew.grid[row][col] = new Empty(jNew, row, col);
		}else {
			age += 1;
		}
		// 2. Applies the survival rules for the life form to determine the life form  
		//    (on the same square) in the next cycle.  These rules are given in the  
		//    project description. 
		// 
		// 3. Generate this new life form at the same location in the jungle jNew.  
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.1 in the project description for the survival rules for a jaguar. 
		
		return  jNew.grid[row][col];
	}
}
