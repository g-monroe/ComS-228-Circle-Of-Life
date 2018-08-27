package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/* @author Gavin Monroe*/
public class DeerTest {
	private Jungle j =  new Jungle(3);
	private Deer d = new Deer(j, 0, 0, 6, 'D');
	@Test
	public void testAge() {
		j.grid[0][0] = d;
		//Check Init
		assertEquals(6, d.myAge());
	}
	@Test
	public void testChar() {
		j.grid[0][0] = d;
		//Check Init
		assertEquals('D', d.myChar());
	}
	@Test
	public void testNext() {
		j.grid[0][0] = d;
		//Check Init
		d.next(j);
		assertEquals(State.EMPTY, j.grid[0][0].who());
	}
}
