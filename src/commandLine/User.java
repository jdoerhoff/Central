import java.io.*;
import java.util.*;

public class User
{
	protected String name;
	protected int win_total;
	protected char type;
	protected boolean user_turn;
	
	//Instantiates a user with no name, no wins, no type, and turn being false
	public User()
	{
		name = null;
		win_total = 0;
		type = '?';
		user_turn = false;
	}
	//alternative constructor, taking name, wins, type, and whether or not it is that users turn
	public User(String in_user_name, int in_win_total, char in_type, boolean in_user_turn)
	{
		name = in_user_name;
		win_total = in_win_total;
		type = in_type;
		user_turn = in_user_turn;
	}
	
	public void setName(String inName)
	{
		name = inName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setWinTotal(int inWins)
	{
		win_total = inWins;
	}
	
	public int getWinTotal()
	{
		return win_total;
	}
	
	public void setType(char inType)
	{
		type = inType;
	}
	
	public char getType()
	{
		return type;
	}
	
	public void setUserTurn(boolean inUserTurn)
	{
		user_turn = inUserTurn;
	}
	
	public boolean getUserTurn()
	{
		return user_turn;
	}
}