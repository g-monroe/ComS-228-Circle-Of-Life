package edu.iastate.cs228.hw1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import edu.iastate.cs228.hw1.CircleOfLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 
 * The jungle is represented as a square grid of size width X width.
 *
 */
public class Jungle {
	private int width; // grid size: width X width

	public Living[][] grid;

	/**
	 * Default constructor reads from a file
	 */
	public Jungle(String inputFileName) throws FileNotFoundException {
	
		String gridInput = "";
		try {
			BufferedReader srcReader = new BufferedReader(new FileReader(inputFileName));
			String src = srcReader.readLine();
			int wCount = 0;
			for (int i = 0; i < src.length(); i++) {
				if (src.charAt(i) == 'G' || src.charAt(i) == 'P' || src.charAt(i) == 'J' || src.charAt(i) == 'E'
						|| src.charAt(i) == 'D') {
					wCount++;
				}
			}
			width = wCount;
			// Create one string to convert into array
			String srcLine;
			gridInput = src + ";";

			while ((srcLine = srcReader.readLine()) != null) {
				gridInput = gridInput + srcLine + ";";
			}
			// Clean up
			gridInput = gridInput.trim().replaceAll("  ", ",");
			gridInput = gridInput.trim().replaceAll(" ", ",");
			// Put into array
			// 2) Creates a grid object.
			//
			// 3) Fills in the grid according to the input file.
			//
			ArrayList<String> rows = new ArrayList<String>(Arrays.asList(gridInput.split(";")));

			grid = new Living[width][width];// Init

			for (int row = 0; row < rows.size(); row++) {
				ArrayList<String> cols = new ArrayList<String>(Arrays.asList(((String) rows.get(row)).split(",")));
				for (int col = 0; col < cols.size(); col++) {
					String animal = (String) cols.get(col);
					addToGrid(row, col, grid, animal);
				}
			}
			srcReader.close();// Close it
			CircleOfLife.view = 2;
		} catch (FileNotFoundException e2) {
			CircleOfLife.reset();
			System.out.println("\nYour file wasn't found(" + e2.getMessage()
					+ ").Please enter 1(random grid), 2(file input), or 3(exit).");
			CircleOfLife.askTrial();
		} catch (Exception e) {
			CircleOfLife.reset();
			System.out.println("\nYour input was insufficient(" + e.getMessage()
					+ ").Please enter 1(random grid), 2(file input), or 3(exit).");
			CircleOfLife.askTrial();
		}
	}

	public void addToGrid(int row, int col, Living[][] _grid, String animal) {
		if (animal.length() == 2) {
			int year = Character.getNumericValue(animal.charAt(1));

			if (animal.charAt(0) == 'D') {
				_grid[row][col] = new Deer(this, row, col, year, 'D');
			} else if (animal.charAt(0) == 'J') {
				_grid[row][col] = new Jaguar(this, row, col, year, 'J');
			} else if (animal.charAt(0) == 'P') {
				_grid[row][col] = new Puma(this, row, col, year, 'P');
			}
		} else if (animal.length() == 1) {
			if (animal.charAt(0) == 'E') {
				_grid[row][col] = new Empty(this, row, col);
			} else if (animal.charAt(0) == 'G') {
				_grid[row][col] = new Grass(this, row, col);
			}
		}

		_grid[row][col].column = col;
		_grid[row][col].row = row;
		_grid[row][col].jungle = this;

	}

	/**
	 * Constructor that builds a w X w grid without initializing it.
	 * 
	 * @param width
	 *            the grid
	 */
	public Jungle(int w) {
		// TODO
		width = w;
		randomInit();
	}

	public int getWidth() {
		return width; // to be modified
	}

	/**
	 * Initialize the jungle by randomly assigning to every square of the grid one
	 * of Deer, Empty, Grass, Jaguar, or Puma.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		Random generator = new Random();
		grid = new Living[width][width];// Init
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < width; col++) {

				// DEER, EMPTY, GRASS, JAGUAR,
				// and PUMA
				String animal = "";
				if (generator.nextInt(5) == 4) {
					animal = "P0";
				} else if (generator.nextInt(5) == 3) {
					animal = "J0";
				} else if (generator.nextInt(5) == 2) {
					animal = "G";
				} else if (generator.nextInt(5) == 1) {
					animal = "E";
				} else {
					animal = "D0";
				}
				addToGrid(row, col, grid, animal);
			}
		}

		CircleOfLife.view = 2;
	}

	/**
	 * Output the jungle grid. For each square, output the first letter of the
	 * living form occupying the square. If the living form is an animal, then
	 * output the age of the animal followed by a blank space; otherwise, output two
	 * blanks.
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Write the jungle grid to an output file. Also useful for saving a randomly
	 * generated jungle for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {
		// TODO
		//
		// 1. Open the file.
		//
		try {
			String writeSource = "";// Input
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));// Delcare Writer

			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid[r].length; c++) {
					if (grid[r][c].who() == State.EMPTY) {
						writeSource = writeSource + "E  ";
					} else if (grid[r][c].who() == State.GRASS) {
						writeSource = writeSource + "G  ";
					} else if (grid[r][c].who() == State.JAGUAR) {
						writeSource = writeSource + grid[r][c].myChar() + grid[r][c].myAge() + " ";
					} else if (grid[r][c].who() == State.PUMA) {
						writeSource = writeSource + grid[r][c].myChar() + grid[r][c].myAge() + " ";
					} else if (grid[r][c].who() == State.DEER) {
						writeSource = writeSource + grid[r][c].myChar() + grid[r][c].myAge() + " ";
					}
				}
				// Write and Clear Line
				out.println(writeSource);
				writeSource = "";
			}

			System.out.println("Done.");
			out.close();
			CircleOfLife.reset();
			CircleOfLife.askTrial();
		} catch (Exception e) {
			CircleOfLife.reset();
			System.out.println(
					"\nYour input was insufficient(writing File or read error). Please enter 1(random grid), 2(file input), or 3(exit).");
			CircleOfLife.askTrial();
		}
	}
}
