import java.io.*;
import java.util.*;

public class UI
{
	protected boolean check;
	//Creates a UI
	public UI()
	{
		check = false;
	}
	// Formats board based on string input of board's elements
	public void display (String input)
	{
		System.out.println("           ");
		System.out.println(" " + input.charAt(0) + " | " + input.charAt(1) + " | " + input.charAt(2));
		System.out.println("-----------");
		System.out.println(" " + input.charAt(3) + " | " + input.charAt(4) + " | " + input.charAt(5));
		System.out.println("-----------");
		System.out.println(" " + input.charAt(6) + " | " + input.charAt(7) + " | " + input.charAt(8));
		System.out.println("           ");
	}
	
}