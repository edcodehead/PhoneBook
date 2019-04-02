package com.claim;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		boolean exit = false;
		Person[] peopleList = new Person[0];
		do {
		System.out.println("Please select an option below:");
		System.out.println("1) Add new entry");
		System.out.println("2) Search by first name");
		System.out.println("3) Search by last name");
		System.out.println("4) Search by full name");
		System.out.println("5) Search by phone number");
		System.out.println("6) Search by city or state");
		System.out.println("7) Delete a record for a given phone number");
		System.out.println("8) Update a record for a given phone number");
		System.out.println("9) Show all records");
		System.out.println("10) Exit");
		
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		System.out.println("You have selected: " + selection);
		switch (selection) {
			case 1:
				System.out.println("Enter a new entry like this: John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
				Scanner input1 = new Scanner(System.in);
				String newRecord = input1.nextLine();
				//Pass in our blank array of 1 length from the top and our input into addNewRecord method
				peopleList = addNewRecord(peopleList, newRecord);
				System.out.println("Number of records = "+ peopleList.length);
				break;
			case 2:
				System.out.println("Enter first name: ");
				Scanner input2 = new Scanner(System.in);
				String selection2 = input2.nextLine();
				searchByFirstName(peopleList, selection2);
				break;
			case 3:
				System.out.println("Enter last name: ");
				Scanner input3 = new Scanner(System.in);
				String selection3 = input3.nextLine();
				searchByLastName(peopleList, selection3);
				break;
			case 4:
				System.out.println("Enter full name: ");
				Scanner input4 = new Scanner(System.in);
				String selection4 = input4.nextLine();
				searchByFullName(peopleList, selection4);
				break;
			case 5:
				System.out.println("Enter phone number: ");
				Scanner input5 = new Scanner(System.in);
				String selection5 = input5.nextLine();
				searchByPhoneNumber(peopleList, selection5);
				break;
			case 6:
				System.out.println("Enter city or state: ");
				Scanner input6 = new Scanner(System.in);
				String selection6 = input6.nextLine();
				searchByCityOrState(peopleList, selection6);
				break;
			case 7:
				System.out.println("Enter phone number to delete record: ");
				Scanner input7 = new Scanner(System.in);
				String selection7 = input7.nextLine();
				peopleList = deleteByPhoneNumber(peopleList, selection7);
				break;
			case 8:
				System.out.println("Enter phone number to update record: ");
				Scanner input8 = new Scanner(System.in);
				String selection8 = input8.nextLine();
				peopleList = updateByPhoneNumber(peopleList, selection8);
				break;
			case 9:
				System.out.println("Show all records: ");
				showAllEntries(peopleList);
				break;
			case 10: 
				System.out.println("Program terminated.");
				System.exit(0);
				break;
			default:
				System.out.println("Please make a valid selection");
		}
	} while (!exit);
		
		//---------------------- END OF SWITCH ----------------------//
		
		
}//------------------- END OF MAIN ---------------- START OF METHODS
	
	
//----- This grabs the whole record entry string
	public static Person[] addNewRecord(Person[] peopleList, String newRecord) {
		//Split the entry at commas
		String[] newRecordArray = newRecord.split(",");
		//Select only the first index which holds the full name and run grabNameArry method
		//After we run the method, we store the individual names in the new String[] nameData
		String[] nameData = grabNameArr(newRecordArray[0]);
		//Create a new instance of a person
		Person tempPerson = new Person();
		tempPerson.setFirstName(nameData[0]);
		tempPerson.setMiddleName1(nameData[1]);
		tempPerson.setMiddleName2(nameData[2]);
		tempPerson.setLastName(nameData[3]);
		//Set up our address fields
		Address tempAddress = new Address(newRecordArray[1], newRecordArray[2], newRecordArray[3], newRecordArray[4]);
		tempPerson.setAddress(tempAddress);
		tempPerson.setPhoneNumber(newRecordArray[5]);
		return createNewPerson(peopleList, tempPerson);
	}
	
	
//----- This grabbed full name so we can separate first, middle(s), last
	public static String[] grabNameArr(String fullName) {
		String[] nameSplit = new String[4]; //This array will hold our final product
		String[] nameArray = new String[4]; //This array will hold the full name after we split it
		//Split the full name by spaces and put it into nameArray from above
		nameArray = fullName.split(" ");
		int length = nameArray.length;
		int lastPosition = nameArray.length-1;
		String firstName = "";
		String lastName = "";
		String middleName1 = "";
		String middleName2 = "";
		//This switch determines how many names were brought in from the fullName string and sets accordingly
		switch (length) {
		case 2:
			firstName = nameArray[0];
			lastName = nameArray[lastPosition];
			break;
		case 3:
			firstName = nameArray[0];
			middleName1 = nameArray[1];
			lastName = nameArray[lastPosition];
			break;
		case 4:
			firstName = nameArray[0];
			middleName1 = nameArray[1];
			middleName2 = nameArray[2];
			lastName = nameArray[lastPosition];
			break;
		default:
			System.out.println("Please only enter your first and last name, and maximum of 2 middle names");
		}
		// Now lets load up our name values and return it
		nameSplit[0] = firstName;
		nameSplit[1] = middleName1;
		nameSplit[2] = middleName2;
		nameSplit[3] = lastName;
		return nameSplit;
	}
	
		
//------------ This adds a new person to our People list at the top
	public static Person[] createNewPerson(Person[] peopleList, Person person) {
		//We create a new array and increase the length by 1
		Person[] targetArray = new Person[peopleList.length + 1];
		for (int i = 0; i < peopleList.length; i++) {
				targetArray[i] = peopleList[i];
		}
		targetArray[targetArray.length-1] = person;
		return targetArray;
	}
	
		
	//----------------------- 2) SEARCH BY FIRST NAME -----------------------//
	public static void searchByFirstName(Person[] peopleList, String firstName) {
		for (int i = 0; i < peopleList.length; i++) {
			String convertFirstName = peopleList[i].getFirstName();
			if (convertFirstName.equals(firstName)){
				System.out.println("---------------");
				System.out.println(" First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
			}
		}
	}
	
	//----------------------- 3) SEARCH BY LAST NAME -----------------------//
	public static void searchByLastName(Person[] peopleList, String lastName) {
		for (int i = 0; i < peopleList.length; i++) {
			String convertLastName = peopleList[i].getLastName();
			if (convertLastName.equals(lastName)){
				System.out.println("---------------");
				System.out.println(" First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
			}
		}
	}

	//----------------------- 4) SEARCH BY FULL NAME -----------------------//
	public static void searchByFullName(Person[] peopleList, String fullName) {
		String[] nameData = grabNameArr(fullName);
		for (int i = 0; i < peopleList.length; i++) {
			String convertFirstName = peopleList[i].getFirstName();
			String convertMiddleName1 = peopleList[i].getMiddleName1();
			String convertMiddleName2 = peopleList[i].getMiddleName2();
			String convertLastName = peopleList[i].getLastName();
			//This makes sure we don't grab records we don't want if they are similar
			if (convertFirstName.equals(nameData[0]) && nameData[1].equals(null) && nameData[2].equals(null) && convertLastName.equals(nameData[3]) ||
				convertFirstName.equals(nameData[0]) && convertMiddleName1.equals(nameData[1]) && nameData[2].equals(null) && convertMiddleName2.equals(nameData[3]) ||
				convertFirstName.equals(nameData[0]) && convertMiddleName1.equals(nameData[1]) && convertMiddleName2.equals(nameData[2]) && convertLastName.equals(nameData[3])){
				System.out.println("---------------");
				System.out.println(" First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
			}
		}
	}
	
	//----------------------- 5) SEARCH BY PHONE NUMBER -----------------------//
	public static void searchByPhoneNumber(Person[] peopleList, String phoneNumber) {
		for (int i = 0; i < peopleList.length; i++) {
			String convertPhoneNumber = peopleList[i].getPhoneNumber();
			if (convertPhoneNumber.equals(phoneNumber)){
				System.out.println("---------------");
				System.out.println(" First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
			}
		}
	}
	
	//----------------------- 6) SEARCH BY CITY OR STATE -----------------------//
	public static void searchByCityOrState(Person[] peopleList, String cityOrState) {
		for (int i = 0; i < peopleList.length; i++) {
			//NOTE***Had an issue with extra space coming into array. I used replaceAll to get rid of them.
			//https://stackoverflow.com/questions/15633228/how-to-remove-all-white-spaces-in-java/36444332
			String convertCity = peopleList[i].getAddress().getCity().replaceAll(" ", "");
			String convertState = peopleList[i].getAddress().getStateAbbreviation().replaceAll(" ", "");
			System.out.println("We are here");
			if (convertCity.equals(cityOrState) || convertState.equals(cityOrState)){
				System.out.println("---------------");
				System.out.println(" First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
			}
		}
	}
		
		
	//----------------------- 7) DELETE BY PHONE NUMBER -----------------------//
	public static Person[] deleteByPhoneNumber(Person[] peopleList, String phoneNumber) {
		Person[] targetArray = new Person[peopleList.length-1];
		int count = 0;
		for (int i = 0; i < peopleList.length; i++) {
			String convertPhoneNumber = peopleList[i].getPhoneNumber().replaceAll(" ", "");
			if (!convertPhoneNumber.equals(phoneNumber)){
				targetArray[count] = peopleList[i];
				count++;
			} 
		}
		System.out.println("Record deleted.");
		return targetArray;
	}
		
	
	//----------------------- 8) UPDATE BY PHONE NUMBER -----------------------//
			public static Person[] updateByPhoneNumber(Person[] peopleList, String phoneNumber) {
				//Ask user what field they want to update
				System.out.println("What would you like to update? "
						+ "\n 1) First Name: "
						+ "\n 2) Last Name: "
						+ "\n 3) Address: "
						+ "\n 4) Phone Number: ");
				Scanner updateInput = new Scanner(System.in);
				int updateSelection = updateInput.nextInt();
				switch (updateSelection) {
				case 1: 
					System.out.println("Enter new first name: ");
					Scanner inputNewFirstName = new Scanner(System.in);
					String newFirstName = inputNewFirstName.nextLine();
					for(int i =0; i < peopleList.length;i++)
					{
						//.trim removes spaces. is easier to use than replaceAll
						if(peopleList[i].getPhoneNumber().trim().equals(phoneNumber))
						{
							peopleList[i].setFirstName(newFirstName);
							break;
						}
					}
					break;
				case 2: 
					System.out.println("Enter new last name: ");
					Scanner inputNewLastName = new Scanner(System.in);
					String newLastName = inputNewLastName.nextLine();
					for(int i =0; i < peopleList.length;i++)
					{
						if(peopleList[i].getPhoneNumber().trim().equals(phoneNumber))
						{
							peopleList[i].setLastName(newLastName);
						}
					}
					break;
				case 3: 
					System.out.println("Enter new street: ");
					Scanner inputNewStreet = new Scanner(System.in);
					String newStreet = inputNewStreet.nextLine();
					System.out.println("Enter new city: ");
					Scanner inputNewCity = new Scanner(System.in);
					String newCity = inputNewCity.nextLine();
					System.out.println("Enter new state: ");
					Scanner inputNewState = new Scanner(System.in);
					String newState = inputNewState.nextLine();
					System.out.println("Enter new zip: ");
					Scanner inputNewZip = new Scanner(System.in);
					String newZip = inputNewZip.nextLine();
					Address newAddress = new Address(newStreet, newCity, newState, newZip);
					for (int i = 0; i < peopleList.length; i++)
					{
						if (peopleList[i].getPhoneNumber().trim().equals(phoneNumber)) 
						{
							peopleList[i].setAddress(newAddress);
						}
					}
					break;
				case 4: 
					System.out.println("Enter new phone number: ");
					Scanner inputNewPhoneNumber = new Scanner(System.in);
					String newPhoneNumber = inputNewPhoneNumber.nextLine();
					for (int i = 0; i < peopleList.length; i++)
					{
						if (peopleList[i].getPhoneNumber().trim().equals(phoneNumber)) 
						{
							peopleList[i].setPhoneNumber(newPhoneNumber);
						}
					}
					break;
				default:
					System.out.println("Please enter a valid selection");
					break;
				}
				
				
				System.out.println("Record updated.");
				return peopleList;
		}

	
	//----------------------- 9) SHOW ALL -----------------------//
	public static void showAllEntries(Person[] peopleList) {
//		Person[] sortedArray = new Person[peopleList.length];
//		int tempNum = 0;
//		for (int i = 0; i < peopleList.length; i++) {
//			for (int j = i +1; j < peopleList.length; j++) {
//				if (peopleList[i].getFirstName().compareTo(peopleList[j].getFirstName()) > 0) {
//					sortedArray[tempNum] = peopleList[j];
//					tempNum++;
//				} else {
//					sortedArray[tempNum] = peopleList[i];
//				}
//			}
			Arrays.sort(peopleList, Collections.reverseOrder(new Comparator<Person>() {
				     @Override
				     public int compare(Person a1, Person a2) {
				     // Used -1 to reverseOrder for ASC descending using String.compareTo function
				      return -1* a1.getFirstName().compareTo(a2.getFirstName());
				      }
				  }));
//		}
		
		for (int i = 0; i < peopleList.length; i++) {
			System.out.println("First: " + peopleList[i].getFirstName()
					+ " Middle 1: " + peopleList[i].getMiddleName1()
					+ " Middle 2: " + peopleList[i].getMiddleName2()
					+ " Last: " + peopleList[i].getLastName()
					+ " Address: " + peopleList[i].getAddress().toString()
					+ " Phone: " + peopleList[i].getPhoneNumber());
		}
	}

	

}//------------- END OF CLASS  -------------
