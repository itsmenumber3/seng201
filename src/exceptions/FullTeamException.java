package exceptions;

public class FullTeamException extends Exception {
	public FullTeamException() {
		super("Not possible to add more monsters.");
	}
	
	public FullTeamException(String inputMessage) {
		super(inputMessage);
	}
}
