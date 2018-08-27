package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/* @author Gavin Monroe*/
public class EmptyTest {
	private Jungle j =  new Jungle(3);
	private Empty e = new Empty(j, 0, 0);
	@Test
	public void testAge() {
		j.grid[0][0] = e;
		//Check Init
		assertEquals(0, e.myAge());
	}
	@Test
	public void testNext() {
		for (int r = 0; r < j.grid.length; r++) {
			for (int c = 0; c <j.grid[r].length; c++) {
				j.grid[r][c] = new Empty(j, 0, 0);
			}
		}
		j.grid[0][0] = e;
		//Check Init
		
		e.next(j);
		assertEquals(State.EMPTY, j.grid[0][0].who());
	}


}
