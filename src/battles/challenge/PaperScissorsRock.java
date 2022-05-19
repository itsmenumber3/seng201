package battles.challenge;

import assets.enums.ChallengeType;
import assets.enums.PapersScissorsRockType;

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
}
