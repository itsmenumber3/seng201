package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;
import assets.enums.PapersScissorsRockType;
import assets.libraries.Tools;

import java.security.SecureRandom;

public class PaperScissorsRock extends Challenge {


	public PaperScissorsRock() {
		this.challengeType = ChallengeType.PAPER_SCISSORS_ROCK;
	}
	
	public PapersScissorsRockType playerChoice;
	
	public void setPlayerChoice(PapersScissorsRockType inputPlayerChoice) {
		this.playerChoice = inputPlayerChoice;
	}
	
	public PapersScissorsRockType getPlayerChoice() {
		return this.playerChoice;
	}
	
	public PapersScissorsRockType battleMonsterChoice;
	
	public void setBattleMonsterChoice(PapersScissorsRockType inputBattleMonsterChoice) {
		this.battleMonsterChoice = inputBattleMonsterChoice;
	}
	
	public PapersScissorsRockType getBattleMonsterChoice() {
		return this.battleMonsterChoice;
	}

	public void runPaperScissorsRockResults() {
		switch (random.nextInt(1, 3)) {
			case 1:
				this.setBattleMonsterChoice(PapersScissorsRockType.PAPER);
				break;
			case 2:
				this.setBattleMonsterChoice(PapersScissorsRockType.SCISSORS);
				break;
			default:
				this.setBattleMonsterChoice(PapersScissorsRockType.ROCK);
				break;
		}

		if (this.getPlayerChoice() == PapersScissorsRockType.PAPER) {
			if (this.getBattleMonsterChoice() == PapersScissorsRockType.SCISSORS) {
				this.setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else if (this.getBattleMonsterChoice() == PapersScissorsRockType.ROCK) {
				this.setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else {
				this.setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		} else if (this.getPlayerChoice() == PapersScissorsRockType.SCISSORS) {
			if (this.getBattleMonsterChoice() == PapersScissorsRockType.PAPER) {
				this.setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else if (this.getBattleMonsterChoice() == PapersScissorsRockType.ROCK) {
				this.setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else {
				this.setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		} else {
			if (this.getBattleMonsterChoice() == PapersScissorsRockType.PAPER) {
				this.setChallengeOutcome(ChallengeOutcomeType.LOSE);
			} else if (this.getBattleMonsterChoice() == PapersScissorsRockType.SCISSORS) {
				this.setChallengeOutcome(ChallengeOutcomeType.WIN);
			} else {
				this.setChallengeOutcome(ChallengeOutcomeType.DRAW);
			}
		}
	}
}
