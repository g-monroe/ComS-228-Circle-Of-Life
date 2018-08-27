package edu.iastate.cs228.hw1;

/**
 *  
 * @author Gavin Monroe
 *
 */

/**
 * A puma eats deers and competes against a jaguar. 
 */
public class Puma extends Animal 
{
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Puma (Jungle j, int r, int c, int a, char l) 
	{
		age = a;
		letter = l;
		row = r;
		col = c;
		jungle = j;
	}
		
	/**
	 * A puma occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.PUMA; 
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
	 * A puma dies of old age or hunger, or from attack by a jaguar. 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.2 in the project description for the survival rules for a puma. 
		//DEER, EMPTY, GRASS, JAGUAR, 
		// and PUMA
		int pop[] = new int[5];
		Living.census(pop, row, col);
		 if (age == 4) {
			 jNew.grid[row][col] = new Empty(jNew, row, col);
		}else if (pop[3] > pop[4]) {
			jNew.grid[row][col] = new Jaguar(jNew, row, col, 0, 'J');
		}else if ((pop[3] + pop[4])  >= pop[0]) {
			jNew.grid[row][col] = new Empty(jNew, row, col);
		}else {
			age += 1;
		}
		return jNew.grid[row][col];
	}
}
