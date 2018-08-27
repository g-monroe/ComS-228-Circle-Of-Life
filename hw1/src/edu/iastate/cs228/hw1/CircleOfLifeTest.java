package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/* @author Gavin Monroe*/
public class CircleOfLifeTest {
	private CircleOfLife col = new CircleOfLife();
	@Test
	public void test() {
			//Check crusial parts of view manager/input
			col.view = 1;
			assertEquals(1, col.view);
			
	}
	@Test
	public void testView() {
		//Check reset viewer reseting the asking.
		col.reset();
		assertEquals(0, col.view);
	}

}
