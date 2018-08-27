package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;
/* @author Gavin Monroe*/
import java.io.FileNotFoundException;

import org.junit.Test;

public class JungleTest {
	private Jungle j =  new Jungle(3);
	@Test
	public void testWidth() {
		assertEquals(3, j.getWidth());
	}
	@Test
	public void testPop() {
		int pop[] = new int[5];
		j.grid[1][1].census(pop, 1, 1);
		int total = 0;
		for(int i = 0; i<pop.length; i++) {
			total += pop[i];
		}
		assertEquals(total, 9);
	}
	@Test
	public void testRead() {
		int pop[] = new int[5];
		try {
			j =  new Jungle("test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		j.grid[1][1].census(pop, 1, 1);
		int total = 0;
		for(int i = 0; i<pop.length; i++) {
			total += pop[i];
		}
		assertEquals(total, 9);
	}
}
