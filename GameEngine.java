//(10/15/2025)
/*
 * Brody Thomas
 */
//I had help from a tutor

import java.util.Random;
import java.util.Scanner;

//Step 1. Declare the class
public class GameEngine
{
	//Step 2. Data
	//Class constant things
	private static final int SIZE = 10;
	private static final int NUM_POTHOLES = 5;

	private static final char PLAYER_CHAR = 'X';
	private static final char HOME_CHAR = '^';
	private static final char EMPTY_CHAR = '_';
	private static final char POTHOLE_CHAR = 'O';

	//Instance variable things
	private boolean[][] potholes;
	private int playerRow;
	private int playerCol;
	private Random rand;
	private Scanner scanner;

	//Step 3. Constructors
	public GameEngine()
	{
		rand = new Random();
		scanner = new Scanner(System.in);
	}
	public void start()
	{
		System.out.println("Welcome to Pothole Driving! Get home while avoiding potholes!");
		boolean playAgain = true;

		while(playAgain)
		{
			resetGame();
			playRound();
			playAgain = askPlayAgain();
		}
		System.out.println("Goodbye!");
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Should set up a new game board
	private void resetGame()
	{
		potholes = new boolean[SIZE][SIZE];
		int placed = 0;

		while(placed < NUM_POTHOLES)
		{
			int r = rand.nextInt(SIZE);
			int c = rand.nextInt(SIZE);

			//Should not put potholes at the start or home
			if((r == 0 && c == 0) || (r == SIZE - 1 && c == SIZE - 1))
				continue;

			if(!potholes[r][c])
			{
				potholes[r][c] = true;
				placed++;
			}
		}
		playerRow = 0;
		playerCol = 0;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Should play one full round
	private void playRound()
	{
		boolean playing = true;

		while (playing)
		{
			printBoard(false);

			System.out.println();
			System.out.println("Enter -1, 0, or 1 for X move (left/right), or 9 to quit:");
			Integer dx = getMove();
			if (dx == null) return;

			System.out.println("Enter -1, 0, or 1 for Y move (up/down), or 9 to quit:");
			Integer dy = getMove();
			if(dy == null) return;

			//YOU CAN'T MOVE TO (0,0)
			if(dx == 0 && dy == 0)
			{
				System.out.println("You must move at least one space.");
				continue;
			}
			int newCol = playerCol + dx;
			int newRow = playerRow + dy;

			//Stay Inside The Grid!!!
			if(!inBounds(newRow, newCol))
			{
				System.out.println("You can’t move outside the grid!");
				continue;
			}
			playerRow = newRow;
			playerCol = newCol;

			//Should check what happened
			if(potholes[playerRow][playerCol])
			{
				printBoard(true);
				System.out.println("OH NO! You hit a pothole!");
				playing = false;
			}
			else if(playerRow == SIZE - 1 && playerCol == SIZE - 1)
			{
				printBoard(true);
				System.out.println("You made it home safely!");
				playing = false;
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Should give the user moves (-1, 0, 1, or 9 to quit)
	private Integer getMove()
	{
		while(true)
		{
			String input = scanner.nextLine().trim();
			try
			{
				int val = Integer.parseInt(input);
				if(val == 9) return null;
				if(val == -1 || val == 0 || val == 1) return val;
			}
			catch(NumberFormatException e) {}

			System.out.println("Enter -1, 0, 1, or 9 to quit:");
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Should check if the move is inside the grid
	private boolean inBounds(int r, int c)
	{
		return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Should show the game board
	private void printBoard(boolean showPotholes)
	{
		System.out.println();
		for(int r = 0; r < SIZE; r++)
		{
			for(int c = 0; c < SIZE; c++)
			{
				if(r == playerRow && c == playerCol)
					System.out.print(PLAYER_CHAR);
				else if(r == SIZE - 1 && c == SIZE - 1)
					System.out.print(HOME_CHAR);
				else if(showPotholes && potholes[r][c])
					System.out.print(POTHOLE_CHAR);
				else
					System.out.print(EMPTY_CHAR);
			}
			System.out.println();
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//Wanna play again?
	private boolean askPlayAgain()
	{
		System.out.println();
		System.out.println("Would you like to play again? (y/n)");

		while(true)
		{
			String answer = scanner.nextLine().trim().toLowerCase();
			if(answer.equals("y") || answer.equals("yes")) return true;
			if(answer.equals("n") || answer.equals("no")) return false;
			System.out.println("Please type 'y' or 'n'.");
		}
	}
}