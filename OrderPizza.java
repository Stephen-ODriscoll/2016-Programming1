/*
 * Name: Stephen O' Driscoll
 * Student Number: R00146853	
 */

import java.util.Scanner;									//Needed for Scanner Class

public class Assessment2 {

	public static void main(String[] args) {
		
		//Declare Variables and CONSTANTS
		String order="", consumer="";
		int numberOfPizzas=-1, pizzaType=0;
		int large=0, small=0, x;
		double total=0;
		final double LARGE_COST=15.99, SMALL_COST=5.99;
		
		Scanner input = new Scanner(System.in);				//Open Scanner Class
		
		//Program Begins Here
		while (numberOfPizzas<=0) {							//Run Loop While Number of Pizza's is 0 or Less
			System.out.print("How many pizzas would you like to order? "); //Ask User How Many Pizza's they Would Like
			
			if (input.hasNextInt()) {						//Check if Input is Integer
				numberOfPizzas=input.nextInt();				//Accept Input
				if (numberOfPizzas<=0) {					//Check if Input is Greater than Zero and Move on if so
					System.out.print("Invalid Input. ");	//Display Error Message
					consumer=input.nextLine();				//Consume Input and Restart Loop
				}
			}
			else {											//If Input is not an Integer
				System.out.print("Invalid Input. ");		//Display Error Message
				consumer=input.nextLine();					//Consume Input and Restart Loop
			}
		}
		
		for (x=1; x<=numberOfPizzas; x++) {					//Run Loop to Ask whether Pizza's are Small or Large and Count up to Number of Pizzas
			pizzaType=0;									//Reset Pizza Type Variable
			consumer=input.nextLine();						//Consume Input (Necessary to Prevent Unwanted Looping)
			while (pizzaType<1 || pizzaType>2) {			//Run Loop While Pizza Type Variable is not 1 or 2
				System.out.println("Pizza #"+x);
				System.out.println("========");
				System.out.println("Please choose:");		//Ask user to Chose a Pizza
				System.out.println("\t1. Large €"+LARGE_COST); //Display Entry for Large Pizza and Cost
				System.out.println("\t2. Small €"+SMALL_COST); //Display Entry for Small Pizza and Cost
				
				if (input.hasNextInt()) {					//Check if Input is Integer
					pizzaType=input.nextInt();				//Accept Input
					if (pizzaType==1) {						//Check if Input is 1 if so a Large Pizza was requested
						large++;							//Add 1 to Large Pizza Variable and Move on
					}
					else if (pizzaType==2) {				//Check if Input is 2 if so a Small Pizza was requested
						small++;							//Add 1 to Small Pizza Variable and Move on
					}
					else {									//If Neither a 1 or a 2 was Entered
						System.out.print("Invalid Input. "); //Display Error Message
						consumer=input.nextLine();			//Consume Input and Restart loop
					}
				}
				else {										//If Input is not an Integer
					System.out.print("Invalid Input.");		//Display Error Message
					consumer=input.nextLine();				//Consume Input and Restart Loop
				}
			}
		}
		if (large>0) {										//If Amount of Large Pizza's is Greater than Zero
			order=order+"\n"+large+" x Large Pizza\t\t€"+(LARGE_COST*large); //Add Large Pizza's to Order
			total=total+(large*LARGE_COST);					//Add Large Pizza's to Total
		}
				
		if (small>0) {										//If Amount of Small Pizza's is Greater than Zero
			order=order+"\n"+small+" x Small Pizza\t\t€"+(SMALL_COST*small); //Add Small Pizza's to Order
			total=total+(small*SMALL_COST);					//Add Small Pizza's to Total
		}
		
		consumer=""; //Reset Consumer
		
		//Display Output to User
		System.out.print("\nOrder:");
		System.out.println(order+consumer);			//Display Order and Use Consumer Variable for Zero Error
		System.out.println("Total cost:\t€"+total);	//Display Total Cost
		
		input.close();	//Close Scanner Class
	}
}
