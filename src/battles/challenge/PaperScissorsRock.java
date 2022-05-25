package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;
import assets.enums.PapersScissorsRockType;

public class PaperScissorsRock extends Challenge {

	public PapersScissorsRockType playerChoice;
	public PapersScissorsRockType battleMonsterChoice;
	
	public PaperScissorsRock() {
		challengeType = ChallengeType.PAPER_SCISSORS_ROCK;
	}
	
	
	public void setPlayerChoice(PapersScissorsRockType inputPlayerChoice) {
		playerChoice = inputPlayerChoice;
	}
	
	public PapersScissorsRockType getPlayerChoice() {
		return playerChoice;
	}
	
	public void setBattleMonsterChoice(PapersScissorsRockType inputBattleMonsterChoice) {
		battleMonsterChoice = inputBattleMonsterChoice;
	}
	
	public PapersScissorsRockType getBattleMonsterChoice() {
		return battleMonsterChoice;
	}

	public void runPaperScissorsRockResults() {
		switch (random.nextInt(1, 3)) {
			case 1:
				setBattleMonsterChoice(PapersScissorsRockType.PAPER);
				break;
			case 2:
				setBattleMonsterChoice(PapersScissorsRockType.SCISSORS);
				break;
			default:
				setBattleMonsterChoice(PapersScissorsRockType.ROCK);
				break;
		}

		if (getPlayerChoice() == PapersScissorsRockType.PAPER) {
			if (getBattleMonsterChoice() == PapersScissorsRockType.SCISSORS) {
				setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else if (getBattleMonsterChoice() == PapersScissorsRockType.ROCK) {
				setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else {
				setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		} else if (getPlayerChoice() == PapersScissorsRockType.SCISSORS) {
			if (getBattleMonsterChoice() == PapersScissorsRockType.PAPER) {
				setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else if (getBattleMonsterChoice() == PapersScissorsRockType.ROCK) {
				setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else {
				setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		} else {
			if (getBattleMonsterChoice() == PapersScissorsRockType.PAPER) {
				setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else if (getBattleMonsterChoice() == PapersScissorsRockType.SCISSORS) {
				setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else {
				setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		}
	}
}
