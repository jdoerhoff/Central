import java.io.*;
import java.util.*;

public class Driver
{
	public static void main(String args[]) throws IOException
	{
		boolean logged_in = false;
		Scanner scan = new Scanner(System.in);
		/*
		LogIn checker = new LogIn();
		while (!logged_in) {
			System.out.println("Please enter your username or enter 1 to make a new one");
			String ans = scan.next();
			if (ans == "1") {
				checker.newAccount();
			}
			else {
				logged_in = checker.check(ans);
			}
		}
		 */
		//Creates a new Game object
		Game game1 = new Game("James", 0);
		game1.gamePlaying();
	}
}