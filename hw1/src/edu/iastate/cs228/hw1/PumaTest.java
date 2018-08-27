package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/* @author Gavin Monroe*/
public class PumaTest {
	private Jungle j =  new Jungle(3);
	private Puma p = new Puma(j, 0, 0, 4, 'P');
	@Test
	public void testAge() {
		j.grid[0][0] = p;
		//Check Init
		assertEquals(4, p.myAge());
	}
	@Test
	public void testChar() {
		j.grid[0][0] = p;
		//Check Init
		assertEquals('P', p.myChar());
	}
	@Test
	public void testNext() {
		j.grid[0][0] = p;
		//Check Init
		p.next(j);
		assertEquals(State.EMPTY, j.grid[0][0].who());
	}

}
