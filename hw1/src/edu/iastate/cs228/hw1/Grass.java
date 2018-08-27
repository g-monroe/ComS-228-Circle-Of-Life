package edu.iastate.cs228.hw1;

/**
 *  
 * @author Gavin Monroe Gavin Monroe
 *
 */

/**
 * Grass may be eaten out or taken over by deers. 
 *
 */
public class Grass extends Living 
{
	public Grass (Jungle j, int r, int c) 
	{
		row = r;
		column = c;
		jungle = j;
	}
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many deers in the neighborhood. Deers may also 
	 * multiply fast enough to take over Grass. 
	 * 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.4 in the project description for the survival rules for grass. 
		// DEER, EMPTY, GRASS, JAGUAR,
		// and PUMA
		int pop[] = new int[5];
		Living.census(pop, row, column);
		if (pop[2] <= (pop[0] / 3)) {
			return new Empty(jNew, row, column);
		}else if (pop[0] >= 4) {
			return new Deer(jNew, row, column, 0, 'D');
		}
		return new Grass(jNew, row, column); 
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
