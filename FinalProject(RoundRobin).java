/*
 * Author:			Stephen O' Driscoll
 * Student Number:	R00146853
 * Program to Request and Display Info for Round Robin Football Tournament
 * Version 7 - I Tried to Keep Exactly to the Example Given to Make the Program Easier to Check.
 */

import java.util.Scanner;	//Needed for Scanner Class

public class Project {

	public static void main(String[] args) {
		
			//Declare Variables and Constants for Program
			String teamName="", winners="", table;
			char teamChar;
			int teamNumber=1, numberOfTeams=0, numberOfWinners=0;
			int matchNumber=0, numberOfMatches=0, matchesPerTeam;
			int won=0, lost=0, drawn=0, teamPoints=0, winningTeamPoints=0;
			int totalWon=0, totalDrawn=0, totalPoints=0;
			int supporters=-1, wld=0, x, y, z;						//wld = Win/Lose/Draw Variable
			double totalAttendance=0, averageAttendance=0, totalTakings=0, teamTakings=0;
			final double TICKET_COST=5.5;
				
			Scanner input = new Scanner(System.in);				//Open Scanner Class
				
				//Greet User and Display Welcome Message
				System.out.println("****************************************************");
				System.out.println("* Welcome to CIT's Round Robin Football Tournament *");
				System.out.println("****************************************************");
				
				//Initialize Table to Display Output at the End
				table="Team\tWon\tDrawn\tLost\tTotal\n====\t===\t=====\t====\t=====\n";
				
				//Using Loop to Ensure numberOfTeams is an Integer that's 2 or Greater but Less than 100,000
				while (numberOfTeams<2 || numberOfTeams>100000) {
					System.out.print("Enter the number of teams: ");					//Request Number of Teams
					if (input.hasNextInt()) {											//Check if Input is an Integer
						numberOfTeams=input.nextInt();									//Accept Integer as numberOfTeams
						if (numberOfTeams<2 ) {											//Check if numberOfTeams is Less than 2
							System.out.println("There Must Be at Least 2 Teams");		//Display Error Message
							input.nextLine();											//Clear Input
						}
						else if (numberOfTeams>100000) {								//Check if numberOfTeams is  Greater than 100,000
							System.out.println("Maximum Number of Teams is 100,000");	//Display Error Message
							input.nextLine();											//Clear Input
						}
					}
					else {
						System.out.println("Enter a Whole Number Less than 100,000");	//Display Error Message
						input.nextLine();												//Clear Input
					}
				}
				
				//Calculate Number of Total Matches and Matches Per Team
				numberOfMatches=(numberOfTeams*(numberOfTeams-1))/2;
				matchesPerTeam=numberOfTeams-1;
				
				//Outer for Loop to Use x to Count Until Number of Teams Reached
				for (x=1; x<=numberOfTeams; x++) {
					input.nextLine();											//Clear Input
					z=0; teamChar=' ';											//Reset z and teamChar
					
					//While Loop to Ensure teamName Isn't Empty and Doesn't Start With a Space Character
					while (z<1 || z>7 || teamChar==' ') {
						System.out.print("What is the name of team "+x+"? ");	//Ask for Name of Team
						teamName=input.nextLine();								//Accept Input as teamName
						z=teamName.length();									//Set z as Length of teamName
						if (z>=1 && z<=7) {												//If z is Greater than or Equal to 1
							teamChar=teamName.charAt(0);						//Set teamChar as the First Character in teamName
							if (teamChar==' ') {								//If teamChar is a Space Character
							System.out.println("Name Can't Start With a Space");//Display Error Message
							}
						}
						else if (z>7) {											//If z>7 the Table Will Be Pushed Too Far Over
							System.out.println("Please Enter a Shorter Name");	//Display Error Message
						}
						else {													//If teamChar is Less than 1
							System.out.println("Please Enter a Name");			//Display Error Message
						}
					}
					
					teamNumber=1;											//Reset teamNumber to 1
					won=0; drawn=0; lost=0; teamPoints=0;					//Reset Win/Lose/Draw and teamPoints to 0 before loop
					
					//Inner for Loop to Use y to Count Until matchesPerTeam is Reached
					for (y=1; y<=matchesPerTeam; y++) {
						
						//Inner Loop Calculations Using if Statements to Determine if a Game has Already Been Played
						if (x>teamNumber) {								//If x is Greater than teamNumber this Match has Already Been Played
							
							//Display a Warning Message that the Match has Already Been Played and Request Score Again
							System.out.println("Carefully Re-Enter the score for: "+teamName+" vs. team"+teamNumber);
						}
						else if (x<teamNumber){							//If x is Less than teamNumber this Match has not Been Played yet
							matchNumber++;								//Count the New Match by increment matchNumber Variable
							
							//Display Message with matchNumber, numberOfMatches, teamName and teamNumber
							System.out.println("Match "+matchNumber+"/"+numberOfMatches+": "+teamName+" vs. team"+teamNumber);
						}
						else {											//If x = teamNumber the Team in Question Cannot Play Themselves
							matchNumber++;								//Count the New Match by increment matchNumber Variable
							teamNumber++;								//Increment teamNumber so they don't Play Themselves
							
							//Display Message with matchNumber, numberOfMatches, teamName and teamNumber
							System.out.println("Match "+matchNumber+"/"+numberOfMatches+": "+teamName+" vs. team"+teamNumber);
						}
						
						wld=0;											//Reset wld (Win/Los/Draw) Variable at the Start of Every Inner Loop
						
						//Loop While wld is Less than 1 or Greater than 3
						while (wld<1 || wld>3) {
							
							//Request Info from User for Whether the Team in Question Won, Drew or Lost
							System.out.println("Did "+teamName+"?");
							System.out.println("\t1: Draw");
							System.out.println("\t2: Win");
							System.out.println("\t3: Lose");
							System.out.print("\t==>");
							if (input.hasNextInt()) {					//Check if Input is an Integer
								wld=input.nextInt();					//Accept Integer as wld
								
								//Check Whether Input is 1, 2 or 3 and Process Accordingly
								switch (wld) {
								case 1:									//If wld is 1
									drawn++;							//Increment drawn Variable
									teamPoints++;						//Increment teamPoints Variable
									totalPoints++;						//Increment totalPpoints Variable
									if (x<teamNumber) {					//If x is Less than teamNumber this Match has not Been Played yet
										totalDrawn+=2;					//Add 2 to totalDrawn as this Counts as a Draw for 2 Teams
									}
									break;
								case 2:									//If wld is 2
									won++;								//Increment won Variable
									teamPoints+=3;						//Add 3 to teamPoints Variable
									totalPoints+=3;						//Add 3 to totalPoints Variable
									if (x<teamNumber) {					//If x is Less than teamNumber this Match has not Been Played yet
										
										//Add 3 to totalWon as this Counts as a Win for One Team and a Lose for the Other
										totalWon=totalWon+3;
									}
									break;
								case 3:									//If wld is 3
									
									//Increment lost Variable. No Points Added to Any Other Variable as a Lose is Worth No Points
									lost++;
									break;
								default:												//If wld is not 1, 2 or 3
									System.out.println("Enter a Number Between 1 & 3");	//Display Error Message
									input.nextLine();									//Clear Input
								}
							}
							else {
								System.out.println("Invalid Data, Please Retry");		//If Input is not an Integer Display Error Message
								input.nextLine();										//Clear Input
							}
						}
						input.nextLine();								//Clear Possible Input
						if (x<teamNumber) {								//If x is Less than teamNumber this Match has not Been Played yet
						supporters=-1;									//Reset supporters to -1 as 0 Supporters is Aloud
						
						//Loop While supporters Variable is Less than 0
						while (supporters<0) {
							
							//Display Message with matchNumber, numberOfMatches, teamName and teamNumber and Request Info for supporters
							System.out.print("Match "+matchNumber+"/"+numberOfMatches+": "+teamName+" vs. team"+teamNumber);
							System.out.print(" how many supporters attended?");
							if (input.hasNextInt()) {										//Check if Input is an Integer	
								supporters=input.nextInt();									//Accept Input as supporters if it is
								if (supporters<0) {											//Check if Input is Less than 0
									System.out.println("Supporters Cannot Be Negative");	//Display Error Message if so
									input.nextLine();										//Clear Input
								}
							}
							else {															//If Input isn't an Integer
								System.out.println("Invalid Data, Please Retry");			//Display Error Message
								input.nextLine();											//Clear Input
							}
						}
						
						//Calculate totalAttendance By Adding New supporters to Previous totalAttendance
						totalAttendance+=supporters;
						}

						teamNumber++;									//Increment teamNumber Variable
					}
					
					//Add New Variables: teamName, won, drawn, lost and teamPoints to Existing Table in the Correct Format
					table=table+teamName+"\t"+won+"\t"+drawn+"\t"+lost+"\t"+teamPoints+"\n";
					
					if (teamPoints>winningTeamPoints) {					//If teamPoints is Greater than winningTeamPoints
						winningTeamPoints=teamPoints;					//Replace winningTeamPoints with teamPoints
						winners=teamName;								//Replace Current winners with Current teamName
						numberOfWinners=1;								//Reset numberOfWinners to 1
					}
					else if (teamPoints==winningTeamPoints) {			//If Current teamPoints is Equal to winning TeamPoints
						winners+=" and "+teamName;						//Add Current teamName to the end of winners
						numberOfWinners++;								//Increment numberOfWinners Variable
					}
				}

				input.close();							//Close Scanner Class as No More Inputs are Required
				
				//Calculate averageAttendance By Dividing totalAttendance By numberOfMatches
				averageAttendance=totalAttendance/numberOfMatches;
				
				//Calculate totalTakings by Multiplying totalAttendance by TICKET_COST
				totalTakings=totalAttendance*TICKET_COST;
				
				//Calculate teamTakings By Dividing Half totalTakings By numberOfWinners
				teamTakings=(totalTakings/2)/numberOfWinners;
				
				//If totalPoints isn't Equal to totalWon Plus totalDrawn Data was Entered Wrong Somewhere
				if (!(totalPoints==totalWon+totalDrawn)) {
					
					//Display Error Message to Tell User Wrong Data was Entered, to Check their Data and Start Again
					System.out.println("Data is invalid - please check your data and start again.");
				}
				
				//If totalPoints is Equal to totalWon Plus totalDrawn Data is Correct
				else {
					System.out.println(table);														//Display table of Teams and Matches
					System.out.println("Total attendance at all matches is: "+totalAttendance);		//Display totalAttendance at All Matches
					System.out.println("Average attendance per game is: "+averageAttendance);		//Display averageAttendance Per Match
					System.out.println("Total takings at all matches is (€):  "+totalTakings);		//Display totalTakings Earned
					
					//Display teamTakings: If there is Only 1 Winner they Receive the Full Takings
					if (numberOfWinners==1) {
						System.out.println("The winning team "+winners+" takes home €"+teamTakings);
					}
					
					//Display teamTakings: If there is More than 1 Winner the Takings Are Split Between them as Calculated Above
					else {
						System.out.println("The winning teams are "+winners+" and take home €"+teamTakings+" each");
					}
				}

		}
}