import java.io.*;
import java.util.*;

public class LogIn
{
	protected boolean log_found;
	protected String user_input;
	
	public LogIn()
	{
		log_found = false;
		username = null;
	}
	
	private boolean check(String inUserInput)
	{
		File infile = new File("users.txt"); 
		Scanner scan = new Scanner(infile);
		username = scan.nextLine();
		if (inUserInput == username) {
			return true;
		}
		else {
			return false;
		}
	}
	
}