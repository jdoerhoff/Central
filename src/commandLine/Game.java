import java.io.*;
import java.util.*;
import java.lang.*;

public class Game
{
	protected boolean win;
	protected User user1;
	protected User user2;
	protected Board game_board;
	protected UI ui;
	
	//Takes parameter name and win total, instantiates new board
	public Game(String in_user_name, int in_win_total)
	{
		game_board = new Board("123456789");
		//Creates a new user, one user must have turn set to true upon start of game
		user1 = new User(in_user_name, in_win_total, 'X', true);
		//creates a guest user
		user2 = new User("guest", 0, 'O', false);
		win = false;
		//instantiates a new interface
		ui = new UI();
	}
	//Checks for wins
	private void winCheck(String board, int turn, int change, char type)
	{
		//It is necessary for 5 turns to have taken place before anyone can win
		if (turn >= 5) 
		{
			//The reason this is decremented is because the grid input is one larger than substring size
			change--; 
			//Takes whatever change was made for element number, if the type of any adjacent win possibilities is the same,
			//then the user has one.  
			switch (change) 
			{
				case 0:
					if (board.charAt(1) == type) {
						if(board.charAt(2) == type) {
							setWin(true);
						}
					}
					if (board.charAt(3) == type) {
						if(board.charAt(6) == type) {
							setWin(true);
						}
					}
					if (board.charAt(4) == type) {
						if(board.charAt(8) == type) {
							setWin(true);
						}
					}
					break;
				case 1:
					if (board.charAt(4) == type) {
						if(board.charAt(7) == type) {
							setWin(true);
						}
					}
					if (board.charAt(0) == type) {
						if(board.charAt(2) == type) {
							setWin(true);
						}
					}
					break;
				case 2:
					if (board.charAt(1) == type) {
						if(board.charAt(0) == type) {
							setWin(true);
						}
					}
					if (board.charAt(5) == type) {
						if(board.charAt(8) == type) {
							setWin(true);
						}
					}
					if (board.charAt(4) == type) {
						if(board.charAt(6) == type) {
							setWin(true);
						}
					}
					break;
				case 3:
					if (board.charAt(0) == type) {
						if(board.charAt(6) == type) {
							setWin(true);
						}
					}
					if (board.charAt(4) == type) {
						if(board.charAt(5) == type) {
							setWin(true);
						}
					}
					break;
				case 4:
					if (board.charAt(1) == type) {
						if(board.charAt(7) == type) {
							setWin(true);
						}
					}
					if (board.charAt(3) == type) {
						if(board.charAt(5) == type) {
							setWin(true);
						}
					}
					if (board.charAt(0) == type) {
						if(board.charAt(8) == type) {
							setWin(true);
						}
					}
					if (board.charAt(2) == type) {
						if(board.charAt(6) == type) {
							setWin(true);
						}
					}
					break;
				case 5:
					if (board.charAt(8) == type) {
						if(board.charAt(2) == type) {
							setWin(true);
						}
					}
					if (board.charAt(3) == type) {
						if(board.charAt(4) == type) {
							setWin(true);
						}
					}
					break;
				case 6:
					if (board.charAt(0) == type) {
						if(board.charAt(3) == type) {
							setWin(true);
						}
					}
					if (board.charAt(7) == type) {
						if(board.charAt(8) == type) {
							setWin(true);
						}
					}
					if (board.charAt(4) == type) {
						if(board.charAt(2) == type) {
							setWin(true);
						}
					}
					break;
				case 7:
					if (board.charAt(1) == type) {
						if(board.charAt(4) == type) {
							setWin(true);
						}
					}
					if (board.charAt(6) == type) {
						if(board.charAt(8) == type) {
							setWin(true);
						}
					}
					break;
				case 8:
					if (board.charAt(2) == type) {
						if(board.charAt(5) == type) {
							setWin(true);
						}
					}
					if (board.charAt(6) == type) {
						if(board.charAt(7) == type) {
							setWin(true);
						}
					}
					if (board.charAt(0) == type) {
						if(board.charAt(4) == type) {
							setWin(true);
						}
					}
					break;
				default:
					break;
			}
		}
	}
	
	private void move()
	{
		if (user1.getUserTurn() == true) {
			int user_move = 100;
			Scanner input = new Scanner(System.in);
			boolean valid_input = false;
			//Asks for input for from user, and checks for valid input, else the user is prompted again to input
			while (!valid_input) {
				System.out.println("Please enter your move player 1");
				user_move = input.nextInt();
				valid_input = validInput(user_move);
			}
			//Reflects user input in the game board
			game_board.setLastChange(user_move);
			String currentBoard = game_board.getBoard();
			Integer wrap2= new Integer(user_move);
			String input2 = wrap2.toString();
			char charInput2 = input2.charAt(0);
			//Replaces the integer in the board with the type of the User 
			currentBoard = currentBoard.replace(charInput2,user1.getType());
			//Replaces old board with new board
			game_board.setBoard(currentBoard);
			//Changes user turns
			user1.setUserTurn(false);
		}
		else{
			int user_move = 100;
			Scanner input = new Scanner(System.in);
			boolean valid_input = false;
			while (!valid_input) {
				System.out.println("Please enter your move player 2");
				user_move = input.nextInt();
				valid_input = validInput(user_move);
			}
			game_board.setLastChange(user_move);
			String currentBoard = game_board.getBoard();
			Integer wrap2= new Integer(user_move);
			String input2 = wrap2.toString();
			char charInput2 = input2.charAt(0);
			currentBoard = currentBoard.replace(charInput2,user2.getType());
			game_board.setBoard(currentBoard);
			user1.setUserTurn(true);
		}
	}
	
	private boolean validInput(int in_user_move)
	{
		boolean check = false;
		//Takes whatever user has inputted, and makes it into an Integer object
		Integer wrap= new Integer(in_user_move);
		//Turns integer object into a string
		String input = wrap.toString();
		//Checks for whatever the user inputted
		char charInput = input.charAt(0);
		//Takes current board and makes it into a string
		String currentBoard = game_board.getBoard();
		for (int c = 0; c < 9; c++) 
		{
			//If the input of the user is the same as one of the availible slots on the gameboard, then the 
			//function returns true. Otherwise, if no numbers in the string are availible, then no valid move c
			//can be inputted.
			if (charInput == currentBoard.charAt(c)) 
			{
				check = true;
			}
		
		}
		if (!check)
			System.out.print("Invalid move, please try again.");
		return check;
	}
	
	private void setWin(boolean in_win)
	{
		win = in_win;
	}
	
	private boolean getWin()
	{
		return win;
	}
	
	public void gamePlaying()
	{
		boolean play1win=false;
		boolean play2win=false;
		//Checks to make sure no one has won
		while (!win && game_board.getTurnNum()<9) 
		{
			//if it is user 1's turn continue execution
			if (user1.getUserTurn() == true) 
			{
				//Displays board prior to move
				ui.display(game_board.getBoard());
				//Changes occur in the board
				move();
				int temp = game_board.getTurnNum();
				temp++;
				game_board.setTurnNum(temp);
				winCheck(game_board.getBoard(), game_board.getTurnNum(), game_board.getLastChange(), user1.getType());
				if(win)
					play1win=true;

			}
			//if it is user 2's turn, contine execution
			else if(win ==false)
			{
				ui.display(game_board.getBoard());
				move();
				int temp = game_board.getTurnNum();
				temp++;
				game_board.setTurnNum(temp);
				winCheck(game_board.getBoard(), game_board.getTurnNum(), game_board.getLastChange(), user2.getType());
				if(win)
					play2win=true;

			}
		}
		if(play1win)
			System.out.println("Congratualtions to player 1!");
		else if(play2win)
			System.out.println("Congratulations to player 2!");
		else
			System.out.println("No player has won :(");
	}
}