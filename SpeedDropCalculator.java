/*
 * Student Number: R00146853		
 * 	Name: Stephen O' Driscoll
 */

import java.util.Scanner; //needed for scanner class

public class Assessment1 {

	public static void main(String[] args) {
			
			//Declare Variables and Constants
			String name;
			double speed;
			final double CONVERSION = 250;
			double height;
			
			Scanner keyboard = new Scanner (System.in);
			
				//Greet user
				System.out.println("*************************************");
				System.out.println("* Handy Dandy Speed Drop Calculator *");
				System.out.println("*************************************");
			
				//Request data from user (name and speed)
				System.out.println("Enter your name");
				name = keyboard.nextLine();
			
				System.out.println("Enter the speed the vehicle is travelling at in km/hr");
				speed = keyboard.nextDouble();
			
			//Calculations begin here
			height = (speed*speed)/CONVERSION;
			
				//Display Output
				System.out.println("Hello " + name + ", hitting a wall at a speed of " + 
				speed + " km/hr \nwould be the equivalent of falling from a height of " + height
				+ " meters!");
				
			keyboard.close();
	}

}
