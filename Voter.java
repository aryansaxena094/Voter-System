//
// Assignment 0
// © Aryan Saxena
// Written by: Aryan Saxena 40233170
//

import java.util.*;

public class Voter {

	Scanner sc = new Scanner(System.in);
	long voterID;
	String voterName;
	byte voterAge;
	String voterEmail;
	char[] voterPCode = new char[6];

	public Voter() {
		// constructor to call the default values
		this.voterID = 0000000;
		this.voterName = "Name";
		this.voterAge = 00;
		this.voterEmail = "email@email.com";
		this.voterPCode = ("XXXXXX").toCharArray();
	}

	public Voter(long id, String name, byte age, String email, char[] pin) { 
		//Creating a voter object using the values input from the user
		this.voterID = id;
		this.voterName = name;
		this.voterAge = age;
		this.voterEmail = email;
		this.voterPCode = pin;
	}

	public String toString() {
		//Overriding the toString method to print the Object 

		String voterpin = String.valueOf(this.voterPCode); //Coverting Character Array to String for printing
		return "\r\n" + "Voter ID: " + this.voterID + "\r\n" + "Voter Name: " + this.voterName + "\r\n" + "Voter Age: "
				+ this.voterAge + "\r\n" + "Voter Email: " + this.voterEmail + "\r\n" + "Voter Pincode: " + voterpin;
	}
	
	public boolean equals(Voter[] voterBase, int voterindexflag, long voterID, char[] voterPCode)
	{
		for (int k = 0; k < voterindexflag; k++) {
			if (voterID == voterBase[k].getID()
					&& String.valueOf(voterPCode).equalsIgnoreCase(voterBase[k].getPCode())) {
						//Checking if the voter has already been added
				return false;
			}
		}
		return true;
	}
	
	//Accessors and Mutators
	public void setID(long id) {
		this.voterID = id;
	}

	public void setName(String name) {
		this.voterName = name;
	}

	public void setage(byte age) {
		this.voterAge = age;
	}

	public void setemail(String email) {
		this.voterEmail = email;
	}

	public void setpin(String pin) {
		this.voterPCode = pin.toCharArray();
	}

	public long getID() {
		return this.voterID;
	}

	public String getName() {
		return this.voterName;
	}

	public byte getAge() {
		return this.voterAge;
	}

	public String getEmail() {
		return this.voterEmail;
	}

	public String getPCode() {
		return String.valueOf(this.voterPCode);
	}

	public static void findYoungerThan(byte age, Voter[] voterBase, int totalvoters)
	//Method to find all Voter's younger than the given age
	{
		int count = 0;
		for (int k = 0; k < totalvoters; k++) {
			if (age > voterBase[k].getAge()) {
				System.out.println(voterBase[k].toString());
				count ++;
			}
		}
		if(count == 0)
		{
			System.out.println("No records found!");
		}
	}
	
	public static void findVotersBy(String PCode, Voter[] voterBase, int totalvoters)
	//Method to find all Voter's with the PCode given
	{
		int count = 0;
		for (int k = 0; k < totalvoters; k++) {
			if (PCode.equalsIgnoreCase(voterBase[k].getPCode())) {
				System.out.println(voterBase[k].toString());
				count++;
			}
		}
		if(count == 0)
		{
			System.out.println("No records found!");
		}
	}
	
	public int findNumberOfCreatedVoters(Voter[] voterBase)
	{
		int count = 0;
		for(int i = 0; i < voterBase.length; i++)
		{
			if(voterBase[i] != null)
			{
				count++;
			}
		}
		return count;
	}

	public void welcomemessage() {
		//Method to display Welcome Message
		System.out.println("---------------------------------------------");
		System.out.println("| Welcome to Parti Québécois Voting System  |");
		System.out.println("|               Bonjour Hi                  |");
		System.out.println("---------------------------------------------");
	}

	public void displaymenu() {
		//Method to display Main Menu 
		System.out.println("What do you want to do? " + "\n1. Enter new voters (password required)"
				+ "\n2. Change information of a voter (password required)"
				+ "\n3. Display all voters by a specific voterPcode" + "\n4. Display all voters under a certain age."
				+ "\n5. Quit" + "\nPlease enter your choice >");
	}

	public void displayupdatemenu() {
		//Method to display the Update Menu
		System.out.println("What information would you like to change?\n" + "1. Name\n" + "2. Age\n" + "3. Email\n"
				+ "4. PCode\n" + "5. Quit\n" + "Enter your choice >");
	}

	public int password() {
		//Method to Authenticate the user for Option 1&2 (returns 1 if correct password else 0)

		String password = "password";

		int p1 = 0;

		int n = 0;

		while (p1 < 3) {
			System.out.println("Please Enter the Password");
			String pass = sc.nextLine();

			if (password.equals(pass)) {
				n = 1;
				break;
			} else {
				System.out.println("Incorrect password (" + (p1 + 1) + "/3)");
				p1++;
			}

		}
		return n;
	}

	public void displayupdatemenu2() {
		//Method to Display Menu incase Voter is not found
		System.out.println("\n Voter with this voter ID not found.");
		System.out.println("\n1.Re-enter VoterID");
		System.out.println("\n2.Quit Operation and Return to Main menu");
	}

	public void thankyoumessage() {
		//Method to display the thank you message
		System.out.println("-----------------------------");
		System.out.println("|         Thank you!        |");
		System.out.println("|           Merci!          |");
		System.out.println("-----------------------------");
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		long voterID;
		String voterName;
		byte voterAge;
		String voterEmail;
		char[] voterPCode;

		Voter v = new Voter();
		//Creating Voter Object v

		v.welcomemessage();
		//Displaying Welcome Message

		System.out.println("Enter the Maximum Voters your neighbourhood can contain:\n");
		int maxVoters = Integer.parseInt(sc.nextLine());
		//Getting Maximum numbers of Voters that neighbourhood can contain

		Voter[] voterBase = new Voter[maxVoters];
		//Creating VoterBase Array

		int voterindexflag = 0;
		//Voterindexflag for having the index of Voters entered

		int totalvoters = 0;
		int i = 0;

		while (i < 4) {
			//For Option 1, if 4 times wrong password entered then Program would terminate
			v.displaymenu();
			//Displaying the menu
			input = Integer.parseInt(sc.nextLine());
			//Geting input for Selecting the Options

			switch (input) {
			//Switch Case for Main Menu Options
			case 1: {
				//Case 1 (Entering new Voters)

				int pass = v.password();
				//Authenticating for password
				if (pass == 1) { 
					// Password authenticated

					System.out.println("Enter the number of voters to be entered:");
					int newvoters = Integer.parseInt(sc.nextLine());
					//Getting Input for the number of new Voters to be added

					if (newvoters > maxVoters) {
						//Checking if new Voters exceed the numbers of Voters that can be contained by the Neighborhood
						System.out.println("Maximum number of voters allowed are: " + maxVoters);
						break;
					} else {
						totalvoters = totalvoters + newvoters;
						//Total Number of Voters in the Voterbase Array
						for (int j = voterindexflag; j < totalvoters; j++) {
							//Entering Voters
							System.out.println("Enter VoterID:");
							voterID = sc.nextLong();
							//Getting VoterID

							sc.nextLine();

							System.out.println("Enter Name:");
							voterName = sc.nextLine();
							//Getting name

							System.out.println("Enter Age:");
							voterAge = sc.nextByte();
							//Getting Age

							sc.nextLine();

							System.out.println("Enter Email:");
							voterEmail = sc.nextLine();
							//Getting Email

							System.out.println("Enter PIN Code:");
							voterPCode = sc.nextLine().toCharArray();
							//Getting PIN Code

							boolean eq = v.equals(voterBase, voterindexflag, voterID, voterPCode);
							//Using .equals method to compare whether the voter already exists
							
							if (eq == true) {
								//if Voter has not been added before
								Voter newvote = new Voter(voterID, voterName, voterAge, voterEmail, voterPCode);
								//Creating Voter Object

								voterBase[j] = newvote;
								//Adding the Object in the Array

								System.out.println((j + 1) + " voters added");
								//Printing the number of voters added

								voterindexflag++;
								//Increasing index flag
								maxVoters--;
								//decreasing max voters because one voter has been added to the Array
							} else {
								//Voter Exists, then the user needs to Re-Enter Voter
								System.out.println("Voter exists - Please Re-Enter");
								j--;
							}
						}
						i = 0; //Password Authenticated so i would return to 0
						break;
					}
				} else {
					//If password fails once then i would increase +1
					i++;
				}
				if (i == 4) {
					//when i = 4, that is Wrong Password 3*4= 12 times consecutively then it will terminate
					System.out
							.println("\r\nProgram detected suspicious activities and will terminate immediately!\r\n");
					System.exit(0);
				}
				break;
			}

			case 2: {
				int pass = v.password();
				//Authenticating for password
				if (pass == 1) {
					//Password Authenticated

					System.out.println("Please Enter the Voter ID where you wish to Modify: ");
					long voterIDtobefound = sc.nextLong();
					sc.nextLine();
					//Getting the voterID for finding
					
					System.out.println("Please Enter the PIN Code of the Voter you wish to Modify: ");
					char PCode[] = sc.nextLine().toCharArray();
					//Getting the VoterPCode for finding
					
					int count = 0;
					//Using count in case Voter is not found
					

				 updateloop: for (int k = 0; k < totalvoters; k++) {
					//Finding the voter in the VoterBase Array using for loop
						
						if (voterBase[k] == null) {
							//if in case voterbase is empty
							System.out.println("No voters have been entered");
						} else {
							//If not empty
							int updatemenuloop = 0;
							//Flag to keep prompting the user to modify more values
							
							if (voterBase[k].getID() == voterIDtobefound && String.valueOf(PCode).equalsIgnoreCase(voterBase[k].getPCode())) {
								//Finding the voter
								count++;// voter found
									while (updatemenuloop == 0){
										//loop for updating the same voter

									System.out.println("Voter Index: " + k);

									System.out.println(voterBase[k].toString());

									v.displayupdatemenu();
									//Displaying Update Menu

									int updatemenu = Integer.parseInt(sc.nextLine());
									//Taking Value as to what is to be Updated/Modified
									switch (updatemenu) {
									case (1):
									//Name
										System.out.println("Enter new Name:");
										String newname = sc.nextLine();
										voterBase[k].setName(newname);
										break;
									case (2):
									//Age
										System.out.println("Enter new Age:");
										byte newage = Byte.parseByte(sc.nextLine());
										voterBase[k].setage(newage);
										break;
									case (3):
									//Email
										System.out.println("Enter new Email:");
										String newemail = sc.nextLine();
										voterBase[k].setemail(newemail);
										break;
									case (4):
									//PINCode
										System.out.println("Enter new Postal Code:");
										String newpcode = sc.nextLine();
										voterBase[k].setpin(newpcode);
										break;
									case (5):
									//Exiting the loop
										i = 0;
										updatemenuloop = 1;
										break updateloop;
									}
								}
							}
						}
					}
					if(count == 0)
					{
						//If no voter is found, Count would be zero
						i=0;
						System.out.println("No Voters found!");
					}
				}

				else {
					//if not authenticated, break out and go to the main menu
					i = 0;
					break;
				}
				break;
			}

			case (3): {
				System.out.println("Enter Postal Code: ");
				String PCode = sc.nextLine();
				//Getting the Postal Code for finding
				Voter.findVotersBy(PCode, voterBase, totalvoters);
				//Using findVotersBy method to print voters with same PCode
				i = 0;
				break;
			}
			case (4): {
				System.out.println("Enter Age: ");
				byte age = Byte.parseByte(sc.nextLine());
				//Getting Age for finding
				Voter.findYoungerThan(age, voterBase, totalvoters);
				//Using findYoungerThan to print voters under a certain age
				i = 0;
				break;
			}
			case (5): {
				int voterscreated = v.findNumberOfCreatedVoters(voterBase);
				//Print number of voters created using findNumberOfCreatedVoters Method
				System.out.println("Total Number of Voters Created: "+voterscreated);
				for(int k = 0; k < totalvoters; k++)
				{
					System.out.println(voterBase[k].toString());
				}
				//Printing all the Voters created using the toString Method
				v.thankyoumessage();
				//Printing the thank you message
				System.exit(0);
				//Exiting the Code
			}
			}
		}
		sc.close();
		//Closing the Scanner
	}

}