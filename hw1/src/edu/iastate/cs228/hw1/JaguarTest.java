package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/* @author Gavin Monroe*/
public class JaguarTest {
	private Jungle j =  new Jungle(3);
	private Jaguar jj = new Jaguar(j, 0, 0, 5, 'J');
	@Test
	public void testAge() {
		j.grid[0][0] = jj;
		//Check Init
		assertEquals(5, jj.myAge());
	}
	@Test
	public void testChar() {
		j.grid[0][0] = jj;
		//Check Init
		assertEquals('J', jj.myChar());
	}
	@Test
	public void testNext() {
		j.grid[0][0] = jj;
		//Check Init
		jj.next(j);
		assertEquals(State.EMPTY, j.grid[0][0].who());
	}

}
