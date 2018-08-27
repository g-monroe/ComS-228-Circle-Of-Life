package edu.iastate.cs228.hw1;

/**
 * 
 * @author Gavin Monroe
 *
 */

/*
 * A deer eats grass and lives no more than six years.
 */
public class Deer extends Animal {
	/**
	 * Creates a Deer object.
	 * 
	 * @param j:
	 *            jungle
	 * @param r:
	 *            row position
	 * @param c:
	 *            column position
	 * @param a:
	 *            age
	 */
	public Deer(Jungle j, int r, int c, int a, char l) {
		age = a;
		letter = l;
		row = r;
		col = c;
		jungle = j;
	}

	// Deer occupies the square.
	public State who() {
		// TODO
		return State.DEER;
	}

	public int age() {
		// TODO
		return age;
	}

	public char myChar() {
		// TODO
		return letter;
	}

	/**
	 * @param jNew
	 *            jungle in the next cycle
	 * @return Living new life form occupying the same square
	 */
	public Living next(Jungle jNew) {
		// TODO
		//
		// See Living.java for an outline of the function.
		// See Section 2.3 in the project description for the survival rules for a deer.
		// DEER, EMPTY, GRASS, JAGUAR,
		// and PUMA
		int pop[] = new int[5];
		Living.census(pop, row, col);
		if (age == 6) {
			jNew.grid[row][col] = new Empty(jNew, row, col);
		} else if ((pop[3] < (pop[4]) && ((pop[3] + pop[4]) >= pop[0]))) {
			jNew.grid[row][col] = new Puma(jNew, row, col, 0, 'P');
		} else if (pop[2] == 0) {
			jNew.grid[row][col] = new Empty(jNew, row, col);
		}else if ((pop[3] > (pop[4]) && ((pop[3] + pop[4]) >= pop[0]))) {
			jNew.grid[row][col] = new Jaguar(jNew, row, col, 0, 'J');
		}else{
			age += 1;
		}
		return jNew.grid[row][col];
	}
}
