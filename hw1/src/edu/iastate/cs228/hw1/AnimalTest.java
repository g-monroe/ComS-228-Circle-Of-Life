package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;
/* @author Gavin Monroe*/
public class AnimalTest {
	private Jungle j =  new Jungle(3);
	private Deer d = new Deer(j, 0, 0, 6, 'D');
	@Test
	public void testAge() {
		assertEquals(6, d.myAge());
	}
	@Test
	public void testChar() {
		assertEquals('D', d.myChar());
	}

}
