package edu.iastate.cs228.hw1;

import java.awt.Point;


/**
 *  
 * @author Gavin Monroe
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a jungle grid. It is a 
 * superclass of Empty, Grass, and Animal, the last of which is in turn a superclass
 * of Deer, Jaguar, and Puma. Living has two abstract methods awaiting implementation. 
 *
 */
public abstract class Living 
{
	public static Jungle jungle; // the jungle in which the life form resides
	public int row;       // location of the square on which 
	public int column;    // the life form resides
	// constants to be used as indices. 
	protected static final int DEER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int GRASS = 2; 
	protected static final int JAGUAR = 3; 
	protected static final int PUMA = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int DEER_MAX_AGE = 6; 
	public static final int JAGUAR_MAX_AGE = 5; 
	public static final int PUMA_MAX_AGE = 4; 
	
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a jungle. 
	 * @param population  counts of all life forms
	 */
	protected static void census(int population[ ], int r, int c)
	{		
		// TODO 
		// 
		// Count the numbers of Deers, Empties, Grasses, Jaguars, and Pumas  
		// in the 3 by 3 neighborhood centered at this Living object.  Store the 
		// counts in the array population[] at indices DEER, EMPTY, GRASS, JAGUAR, 
		// and PUMA, respectively.
		//Prepare Population
		population[0] = 0; //DEER
		population[1] = 0;//EMPTY
		population[2] = 0;//GRASS
		population[3] = 0;//JAGUAR
		population[4] = 0;//PUMA
		
		//b = bottom, t = top, c = center, l = left, r = right
		Point br = new Point(c + 1, r + 1);
		Point bl = new Point(c - 1, r + 1);
		Point bc = new Point(c, r + 1);
		//Center
		Point cr = new Point(c + 1, r);
		Point cl = new Point(c - 1, r);
		Point cc = new Point(c, r);
		//Top
		Point tr = new Point(c + 1, r - 1);
		Point tl = new Point(c - 1, r - 1);
		Point tc = new Point(c, r - 1);
		
		//Check and Add to count
		checkCensus(population, br);
		checkCensus(population, bl);
		checkCensus(population, bc);
		checkCensus(population, tr);
		checkCensus(population, tl);
		checkCensus(population, tc);
		checkCensus(population, cr);
		checkCensus(population, cl);
		checkCensus(population, cc);
	}
	public static void checkCensus(int population[ ], Point point) {
		try {
			int iRow = point.y;
			int iCol = point.x;
			if (jungle.grid[iRow][iCol].who() == State.DEER) {
				population[0] += 1;
			}else if (jungle.grid[iRow][iCol].who() == State.EMPTY) {
				population[1] += 1;
			}else if (jungle.grid[iRow][iCol].who() == State.GRASS) {
				population[2] += 1;
			}else if (jungle.grid[iRow][iCol].who() == State.JAGUAR) {
				population[3] += 1;
			}else if (jungle.grid[iRow][iCol].who() == State.PUMA) {
				population[4] += 1;
			}
		}catch(Exception e) {
		}
	}
	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	public abstract int myAge();
	public abstract char myChar();
	// To be implemented in each class of Deer, Empty, Grass, Jaguar, and Puma. 
	// 
	// There are five states given in State.java. Include the prefix State in   
	// the return value, e.g., return State.Puma instead of Puma.  
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  jNew  jungle of the next cycle
	 * @return Living 
	 */
	public abstract Living next(Jungle jNew);
    

}
