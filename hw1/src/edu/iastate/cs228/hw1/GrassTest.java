package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrassTest {
	private Jungle j =  new Jungle(3);
	private Grass g = new Grass(j, 0, 0);
	@Test
	public void testAge() {
		j.grid[0][0] = g;
		//Check Init
		assertEquals(0, g.myAge());
	}
	@Test
	public void testNext() {
		for (int r = 0; r < j.grid.length; r++) {
			for (int c = 0; c <j.grid[r].length; c++) {
				j.grid[r][c] = new Deer(j, 0, 0, 1, 'D');
			}
		}
		j.grid[0][0] = g;
		//Check Init
		
		g.next(j);
		assertEquals(State.EMPTY, j.grid[0][0].who());
	}

}
