package gameOf21;

import java.util.Scanner;

public class GameOf21
{
	static int numbers = 1;
	static int choice = 0;
	static int repeater = 1;
	static int finalNum;
	static int player;

	public static void main(String[] args)
	{
		System.out.println("SUSHA SQUAD : GAME OF 21");
		System.out.println("-------------------------");
		
		getPlayer();
		if(player == 1)
		{
			printNumber();
			gamePlay();
		}
		else if(player == 2)
		{
			System.out.println("--------------------");
			System.out.println("Bot Entry");
			botEntry();
			printNumber();
			gamePlay();
		}
		else
		{
			System.out.println("Please Enter Correct Player Choice!");
			main(args);
		}
		
		System.out.print("CLOSE IT AND RESTART TO PLAY THE GAME AGAIN");
		while(true)
		{
			
		}
	}

	//Takes input whether user or bot will start the game
	@SuppressWarnings("resource")
	public static int getPlayer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Player");
		System.out.println("1. You Start The Game");
		System.out.println("2. Computer Starts The Game");
		System.out.print("Enter Your Player Choice(1/2): " );
		player = sc.nextInt();
		return player;
	}


	public static void gamePlay()
	{
		while(numbers<20)
		{
			userEntry();
			if(choice>3)
				break;
			else
			{
				System.out.println("--------------------");
				System.out.println("Bot Entry");
				botEntry();
				printNumber();
				repeater++;
			}
		}
	}

	public static void botEntry()
	{

		if(finalNum==20)
		{
			System.out.println("YOU WIN!!");
		}
		else if(finalNum==21 || finalNum==22 || finalNum==23)
		{
			System.out.println("YOU LOSE!!");
		}
		else if(finalNum%4==1)
		{
			//	System.out.println("Bot choice 3");
			choice = 3;
		}
		else if(finalNum%4==2)
		{
			//	System.out.println("Bot choice 2");
			choice = 2;
		}
		else if(finalNum%4==3)
		{
			//	System.out.println("Bot choice 1");
			choice = 1;
		}
		else if(finalNum%4==0)
		{
			//	System.out.println("Bot choice 1");
			choice = 1;
		}
	}

	//Takes input for how many numbers the user wants to 
	@SuppressWarnings("resource")
	public static void userEntry()
	{
		if(finalNum<21)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("--------------------");
			System.out.print("How many numbers you want to enter(1/2/3): ");
			choice = sc.nextInt();
		}
		System.out.println("--------------------");
		System.out.println("Your Numbers");
		printNumber();
	}

	//Prints number on console
	public static void printNumber()
	{	
		numbers = finalNum;
		if(choice<=3)
		{
			int printNum;
			for(printNum=1; printNum<=choice; printNum++)
			{
				if((numbers+printNum)<=21)
					System.out.println("Number: " + (numbers+printNum));
			}
			finalNum = numbers+printNum-1;
		}
		else
		{
			System.out.println("Entered number is greater than 3");
		}
	}
}
