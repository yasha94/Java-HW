package HW1_311449912_Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Main {

	/*
	  	function to check if a kalpiID has data in him
	  	 	if kalpiID exist returns the Object
	  	 	else returns null
	 */
	public static Kalpi check_Kalpi(int kalpiID, ArrayList<Kalpi> kalpiyot) {

		for(Kalpi k: kalpiyot) {
			if(k.getKalpiID() == kalpiID)
				return k;
		}
		return null;
	}
	/*
	  	function to print the kalpi's stat's
	 */
	public static void printPublicStats(Kalpi k) {

		//HashMap containing prty's letter and name, when letter is key to value name
		HashMap<String, String> parties = new HashMap<String, String>();
		parties.put("L", "Liyoto Machita");
		parties.put("B", "Black Beast");
		parties.put("A", "Amanda Nunes");
		parties.put("Y", "Yoel Romeo");

		System.out.printf("\nKalpi number : %d\n",k.getKalpiID());
		System.out.printf("Number of votes in kalpi: %d\n", k.getNumberOfVotes());
		System.out.printf("Number of votes left to enter Kalpi: %d\n",99 - k.getNumberOfVotes());
		System.out.println("Number of votes for each party: ");

		VoteContainer[] vc = getSortedVotes(k.getMostVotes());
		//print's the collection of letters and their votes sorted from party with most votes and down
		for(int i = 0; i < vc.length; i++) {

			System.out.printf("%s: %s -> %d\n",vc[i].getLetter(),parties.get(vc[i].getLetter()), vc[i].getVotes());
		}
	}
	/*
	  	return's sorted array of party letter's with amount of votes for each
	 */
	public static VoteContainer[] getSortedVotes(HashMap<String, Integer> map) {
		Set<String> keys = map.keySet();
		VoteContainer[] vc = new VoteContainer[4];
		int i = 0;
		for(String key : keys) {
			vc[i++] = new VoteContainer(key, (int) map.get(key));
		}
		sortVotes(vc);
		return vc;
	}
	/*
	  	function to swap between letter of party's with most votes
	 */
	private static void swap(VoteContainer[] vc , int i, int j) {
		VoteContainer temp = vc[i];
		vc[i] = vc[j];
		vc[j] = temp ; 
	}
	/*
	  sort's the votes using Selection Sort
	 */
	public static void sortVotes(VoteContainer[] vc) {
		for(int j = vc.length -1 ; j >= 0 ; j--) {
			for(int i = 0; i < j ; i++) {
				if(vc[i].getVotes() < vc[j].getVotes()) {
					swap(vc,i,j);
				}
			}
		}
	}

	/*
	  main function
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//HashMap containing prty's letter and name, when letter is key to value name
		HashMap<String, String> parties = new HashMap<String, String>();
		parties.put("L", "Liyoto Machita");
		parties.put("B", "Black Beast");
		parties.put("A", "Amanda Nunes");
		parties.put("Y", "Yoel Romeo");

		//declare ArrayList of kalpiyot
		ArrayList<Kalpi> kalpiyot = new ArrayList<Kalpi>();
		int numberOfVotes = 0;
		int kalpiID = 0;
		String letter;
		//will ask for kalpiID as long as kalpiID is positive
		while(kalpiID >= 0){

			//Restricts input from user to available party letter's
			do {
				//asks for kalpiID
				System.out.println("\n\nPlease enter kalpi number:");
				kalpiID = input.nextInt();
				//asks for number of votes to be added to selected kalpiID
				System.out.println("\nPlease enter number of votes to put in kalpi:");
				numberOfVotes = input.nextInt();
				//asks for party's letter
				System.out.println("\nPlease enter party's letter: [L, B, A, Y]");
				letter = input.next();
			}while(!(letter.equals("L") || letter.equals("B") || letter.equals("A")  || letter.equals("Y")));
			Kalpi checked = check_Kalpi(kalpiID, kalpiyot);
			//checks if kalpiID is in use
			//if null creates new array of votes
			if(checked == null) {
				if(numberOfVotes <= 99){
					Vote[] votes = new Vote[99];
					//Initialize Array of votes with Object Vote with party's letter and name
					for(int i = 0; i < numberOfVotes; i++) {
						votes[i] = new Vote(letter, parties.get(letter));
					}
					//creates new Object of Kalpi with kalpiID, array of votes and number of votes in the Kalpi
					Kalpi k = new Kalpi(kalpiID, votes, numberOfVotes);		
					//adds current Kalpi Object to kalpiyot ArrayList
					kalpiyot.add(k);
					printPublicStats(k);
					for(int i = 0; i < numberOfVotes; i++) {
						System.out.print(votes[i].getPartyLetter());
					}
				}else {
					System.out.println("more than 99 votes");
				}

			//else adds votes to selected kalpiID
			}else {
				int n = checked.getNumberOfVotes();
				int total = n + numberOfVotes;
				//checks number wanted to add to votes does not exceed 99
				if(total <= 99){
					//adds votes to selected kalpiID votes
					for(int i = n; i < total; i++) {
						checked.getVotes()[i] = new Vote(letter, parties.get(letter));

					}
					//print's the letters of party in given Kalpi
					updateKalpiStats(numberOfVotes, letter, checked, total);
					printPublicStats(checked);
					for(int i = 0; i < total; i++) {
						System.out.print(checked.getVotes()[i].getPartyLetter());
					}
					//else prints that number of votes wanted to be added is exceeding 99 votes
				}else {
					System.out.println("more than 99 votes");
				}
			}
		}

		input.close();
	}

	/*
	  	Update's stat's of each party letter to it's number of votes, in each given kalpiID
	 */
	private static void updateKalpiStats(int numberOfVotes, String letter, Kalpi checked, int total) {
		checked.setNumberOfVotes(total);
		HashMap<String, Integer> map = checked.getMostVotes();

		int a = map.get(letter) + numberOfVotes;
		map.replace(letter, a);
	}
}
