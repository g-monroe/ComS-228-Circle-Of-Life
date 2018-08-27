package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/* @author Gavin Monroe*/
public class LivingTest {

	@Test
	public void test() {
		try {
			Jungle j = new Jungle("C:\\Users\\Gavin\\Desktop\\public\\test.txt");
			//G  E  G  
			//E  J0 P1 
			//J1 E  D0 
			//G = 2, E = 3, J = 1, D = 1, P = 1
			// DEER, EMPTY, GRASS, JAGUAR,
			// and PUMA
			int pop[] = new int[5];
			j.grid[1][1].census(pop, 1, 1);
			assertEquals(1, pop[0]);
			assertEquals(3, pop[1]);
			assertEquals(2, pop[2]);
			assertEquals(1, pop[3]);
			assertEquals(1, pop[4]);
			
			//Test Width Random
			j = new Jungle(3);
			assertEquals(3, j.getWidth());
			assertEquals(3, j.grid[3].length);
			assertEquals(3, j.grid.length);
			
		} catch (FileNotFoundException e) {
			fail("Failed getting file for jungle: " + e.getMessage());
		}
		
	}

}
