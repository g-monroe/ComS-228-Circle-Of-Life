package edu.iastate.cs228.hw1;

/**
 *  
 * @author Gavin Monroe Gavin Monroe
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Jungle j, int r, int c) 
	{
		row = r;
		column = c;
		jungle = j;
	}
	
	public State who()
	{
		// TODO 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Deer, Grass, Jaguar, or Puma, or 
	 * remain empty. 
	 * @param jNew     jungle in the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Jungle jNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.5 in the project description for corresponding survival rules. 
		// DEER, EMPTY, GRASS, JAGUAR,
		// and PUMA
		int pop[] = new int[5];
		Living.census(pop, row, column);
		if (pop[0] > 1) {
			return new Deer(jNew, row, column, 0, 'D');
		}else if (pop[4] > 1) {
			return new Puma(jNew, row, column, 0, 'P');
		}else if (pop[3] > 1) {
			return new Jaguar(jNew, row, column, 0, 'J');
		}else if (pop[2] >= 1) {
			return new Grass(jNew, row, column); 
		}else {
			return new Empty(jNew, row, column); 
		}
		
	}

	@Override
	public int myAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char myChar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
