package HW1_311449912_Q1;

import java.util.HashMap;

public class Kalpi {

	private int kalpiId;
	private Vote[] votes;
	private int numberOfVotes;
	private HashMap<String, Integer> mostVotes; 
	
	public Kalpi(int kalpiId, Vote[] votes, int numberOfVotes) {
		
		this.setNumberOfVotes(numberOfVotes);
		this.kalpiId = kalpiId;
		this.setVotes(votes);
		this.mostVotes = new HashMap<String, Integer>();
		mostVotes.put("B", 0);
		mostVotes.put("L", 0);
		mostVotes.put("Y", 0);
		mostVotes.put("A", 0);
		mostVotes.replace(votes[0].getPartyLetter(), numberOfVotes);
	}
	
	
	public HashMap<String, Integer> getMostVotes() {
		return mostVotes;
	}


	public void setMostVotes(HashMap<String, Integer> mostVotes) {
		this.mostVotes = mostVotes;
	}


	public void setKalpiID(int kalpiId) {
		
		this.kalpiId = kalpiId;
	}
	 
	public int getKalpiID(){
		return kalpiId;
	}


	public Vote[] getVotes() {
		return votes;
	}


	public void setVotes(Vote[] votes) {
		this.votes = votes;
	}


	public int getNumberOfVotes() {
		return numberOfVotes;
	}


	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
}
