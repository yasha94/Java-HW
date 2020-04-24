package HW1_311449912_Q1;


public class Vote {

	private String partyLetter;
	private String partyName;


	public Vote(String partyLetter, String partyName) {

		this.partyLetter = partyLetter;
		this.partyName = partyName;
	}

	public String getPartyLetter(){

		return partyLetter;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyLetter(String letter) {
		this.partyLetter = letter;
	}

	public void setPartyName(String name) {

		this.partyName = name;
	}
}

