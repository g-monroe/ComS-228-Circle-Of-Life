package edu.iastate.cs228.hw1;

/**
 *  
 * @author Gavin Monroe
 *
 */

/*
 * This class is to be extended by the Deer, Jaguar, and Puma classes. 
 */
public abstract class Animal extends Living implements MyAge, MyChar
{
	protected int age;   // age of the animal 
	protected char letter;   // age of the animal 
	protected int row;
	protected int col;
	protected Jungle jungle;
	public Animal() {
		
	}
	@Override
	public State who() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Living next(Jungle jNew) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int myAge() {
		return age;
	}
	public int myRow() {
		return row;
	}
	public int myCol() {
		return col;
	}
	public Jungle myJungle() {
		return jungle;
	}
	
	@Override
	public char myChar() {
		return letter;
	}
}
