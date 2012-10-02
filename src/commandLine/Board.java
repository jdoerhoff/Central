import java.io.*;
import java.util.*;

public class Board
{
	protected String game_board;
	protected int last_change;
	protected int turn_number;
	
	public Board()
	{
		game_board = "123456789";
		turn_number = 1;
		last_change = 0;
	}
	
	public Board(String inBoard)
	{
		game_board = inBoard;
		turn_number = 0;
		last_change = 0;
	}
	
	public String getBoard()
	{
		return game_board;
	}
	public void setBoard(String inBoard)
	{
		game_board = inBoard;
	}
	
	public int getLastChange()
	{
		return last_change;
	}
	public void setLastChange(int inChange)
	{
		last_change = inChange;
	}
	public int getTurnNum()
	{
		return turn_number;
	}
	public void setTurnNum(int inTurns)
	{
		turn_number = inTurns;
	}
}