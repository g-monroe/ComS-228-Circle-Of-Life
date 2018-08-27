package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.Console;
/**
 *  
 * @author Gavin Monroe
 *
 */

/**
 * 
 * The CircleOfLife class performs simulation over a grid jungle 
 * with squares occupied by deers, jaguars, pumas, grass, or none. 
 *
 */
public class CircleOfLife 
{
	/**
	 * Update the new jungle from the old jungle in one cycle. 
	 * @param jOld  old jungle
	 * @param jNew  new jungle 
	 */
	private static int trialNum = 0;
	public static int view = 0; //0 Ask Trial grab input; 1 = Pass Jungle information and build it; 2 = Write;
	private static int gridType = 0; //0 = Random, 1 = File Input, 2 = Exit,
	private static String fileInput = "";
	private static int cycleNum = 0;
	private static int gridWidth = 0;
	private static Jungle even;   				 // the jungle after an even number of cycles 
	private static Jungle odd;      
	public static void updateJungle(Jungle jOld, Jungle jNew)
	{
		// TODO 
		// 
		// For every life form (i.e., a Living object) in the grid jOld, generate  
		// a Living object in the grid jNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
		
	}
	
	/**
	 * Repeatedly generates jungles either randomly or from reading files. 
	 * Over each jungle, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		Console console = System.console();
		// TODO 
		// 
		// Generate CircleOfLife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random jungle, 2 to read a jungle from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description. 
		// 
		do {
			if (view == 0) {
				askTrial();
			}
			if (view == 1) {
				passJungle();
			}
			if (view == 2) {
				writeJungle();
			}
		}while(view != 10);
		//do {
			//writeJungle();
		//}while(view == 2);
		// 3. For convenience, you may define two jungles even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the jungle 
		//    odd from the jungle even; in an odd numbered cycle, generate even 
		//    from odd. 

		// 4. Print out initial and final jungles only.  No intermediate jungles should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate jungles.)
		// 
		// 5. You may save some randomly generated jungles as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
	}
	public static void askTrial() {
		try {
			trialNum += 1;
			gridType = 0;
			System.out.printf("Trial %d:", trialNum);
			Scanner scanner = new Scanner (System.in);
			gridType = Integer.parseInt(scanner.next());
			if (gridType == 1) {
				System.out.print("Random jungle");
				//Number of Grid Width
				if (gridWidth == 0) {
					System.out.print("\nEnter grid width: ");
					scanner = new Scanner (System.in);
					gridWidth = Integer.parseInt(scanner.next());
					if (gridWidth < 2) {
						reset();
						System.out.println("\nYour input was insufficient(you need at least 3). Please enter 1(random grid), 2(file input), or 3(exit).");
						askTrial();
					}
				}
				//Number of cycles
				if (cycleNum == 0) {
					System.out.print("Enter the number of cycles: ");
					scanner = new Scanner (System.in);
					cycleNum = Integer.parseInt(scanner.next());
					if (cycleNum <= 2) {
						reset();
						System.out.println("\nYour input was insufficient(you need a 2 or higher). Please enter 1(random grid), 2(file input), or 3(exit).");
						askTrial();
					}
				}
				view = 1;
			}else if (gridType == 2) {
				System.out.print("Jungle input from a file\nFile name: ");
				scanner = new Scanner (System.in);
				fileInput = scanner.next();
				//Check File extension:
				if (!fileInput.contains(".txt")) {
					reset();
					System.out.println("\nYour input was insufficient(you need a .txt file). Please enter 1(random grid), 2(file input), or 3(exit).");
					askTrial();
				}
				//Number of cycles
				if (cycleNum == 0) {
					System.out.print("Enter the number of cycles: ");
					scanner = new Scanner (System.in);
					cycleNum = Integer.parseInt(scanner.next());
					
					if (cycleNum <= 2) {
						reset();
						System.out.println("\nYour input was insufficient(you need a 2 or higher). Please enter 1(random grid), 2(file input), or 3(exit).");
						askTrial();
					}
					
				}
				view = 1;
			}else if (gridType == 3) {
				System.exit(0);
			}else {
				reset();
				System.out.println("\nYour input was insufficient. Please enter 1(random grid), 2(file input), or 3(exit).");
				askTrial();
			}
		}catch(Exception e) {
			reset();
			System.out.flush();  
			System.out.println("\nYour input was insufficient. Please enter 1(random grid), 2(file input), or 3(exit).");
			askTrial();
		}
	}
	public static void passJungle() throws FileNotFoundException {
		if (gridType == 2) {
			even = new Jungle(fileInput);
		}else if (gridType == 1) {
			even = new Jungle(gridWidth);
		}
	}
	public static void writeJungle() throws FileNotFoundException {
		
		//Update Jungle
		odd = even;
		outputJungle(odd);
		for (int i = 0; i<cycleNum; i++) {
				odd = even;
				for (int r = 0; r < even.grid.length; r++) {
					for (int c = 0; c < even.grid[r].length; c++) {
						odd.grid[r][c] = even.grid[r][c].next(odd);
					}
				}
		}
		
		//Grab File Name
		System.out.print("\nJungle output from a file\nFile name: ");
		Scanner scanner = new Scanner (System.in);
		//Write to File
		odd.write(scanner.next());
	}
	
	public static void outputJungle(Jungle old) {
		String writeSource = "";// Input
		
		System.out.println("\nInitial jungle:\n");
		for (int r = 0; r < old.grid.length; r++) {
			for (int c = 0; c < old.grid[r].length; c++) {
				if (old.grid[r][c].who() == State.EMPTY) {
					writeSource = writeSource + "E  ";
				} else if (old.grid[r][c].who() == State.GRASS) {
					writeSource = writeSource + "G  ";
				} else if (old.grid[r][c].who() == State.JAGUAR) {
					writeSource = writeSource + old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				} else if (old.grid[r][c].who() == State.PUMA) {
					writeSource = writeSource +  old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				} else if (old.grid[r][c].who() == State.DEER) {
					writeSource = writeSource +  old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				}
			}
			// Write and Clear Line
			System.out.println(writeSource);
			writeSource = "";
		}
		//Update Jungle
		old = even;
		for (int i = 0; i<cycleNum; i++) {
				old = even;
				for (int r = 0; r < even.grid.length; r++) {
					for (int c = 0; c < even.grid[r].length; c++) {
						old.grid[r][c] = even.grid[r][c].next(old);
					}
				}
		}
		System.out.println("\nFinal jungle:\n");
		for (int r = 0; r < old.grid.length; r++) {
			for (int c = 0; c < old.grid[r].length; c++) {
				if (old.grid[r][c].who() == State.EMPTY) {
					writeSource = writeSource + "E  ";
				} else if (old.grid[r][c].who() == State.GRASS) {
					writeSource = writeSource + "G  ";
				} else if (old.grid[r][c].who() == State.JAGUAR) {
					writeSource = writeSource + old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				} else if (old.grid[r][c].who() == State.PUMA) {
					writeSource = writeSource +  old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				} else if (old.grid[r][c].who() == State.DEER) {
					writeSource = writeSource +  old.grid[r][c].myChar() +  old.grid[r][c].myAge() + " ";
				}
			}
			// Write and Clear Line
			System.out.println(writeSource);
			writeSource = "";
		}
		
	}
	public static void reset() {
		gridType = 0;
		view = 0;
		fileInput = "";
		cycleNum = 0;
		gridWidth = 0;
	}
	
}
