package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;

public class Quiz extends Challenge {
	public Quiz() {
		this.challengeType = ChallengeType.QUIZ;
	}
	
	private String quizQuestion;

	public void setQuizQuestion(String inputQuizQuestion) {
		this.quizQuestion = inputQuizQuestion;
	}

	public String getQuizQuestion() {
		return this.quizQuestion;
	}

	private String[] quizChoices = {};

	public void setQuizChoices(String[] inputQuizChoices) {
		this.quizChoices = inputQuizChoices;
	}

	public String[] getQuizChoices() {
		return this.quizChoices;
	}

	private String quizCorrectChoice;

	public void setQuizCorrectChoice(String inputQuizCorrectChoice) {
		this.quizCorrectChoice = inputQuizCorrectChoice;
	}

	public String getQuizCorrectChoice() {
		return this.quizCorrectChoice;
	}

	public String quizPlayerChoice;

	public void setQuizPlayerChoice(String inputQuizPlayerChoice) {
		this.quizPlayerChoice = inputQuizPlayerChoice;
	}

	public String getQuizPlayerChoice() {
		return this.quizPlayerChoice;
	}

	public void runQuizResults() {
		if (this.getQuizPlayerChoice() == this.getQuizCorrectChoice()) {
			this.setChallengeOutcome(ChallengeOutcomeType.WIN);
		} else {
			this.setChallengeOutcome(ChallengeOutcomeType.LOSE);
		}
	}
}
