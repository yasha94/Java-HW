package HW1_311449912_Q1;

public class VoteContainer {
	private String letter;
	private int votes;
	
	public VoteContainer(String letter, int votes) {
		super();
		this.letter = letter;
		this.votes = votes;
	}

	public String getLetter() {
		return letter;
	}
	
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public int getVotes() {
		return votes;
	}
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
}
