package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;



public class FlipACoin extends Challenge {
	public FlipACoin() {
		this.challengeType = ChallengeType.FLIP_A_COIN;
	}
	
	private boolean isPlayerChoosingHead;
	
	public void setIsPlayerChoosingHead(boolean inputIsPlayerChoosingHead) {
		this.isPlayerChoosingHead = inputIsPlayerChoosingHead;
	}
	
	public boolean getIsPlayerChoosingHead() {
		return this.isPlayerChoosingHead;
	}

	public void runFlipACoinResults() {
		switch (this.random.nextInt(1)) {
			case 0 -> this.setChallengeOutcome(ChallengeOutcomeType.WIN);
			case 1 -> this.setChallengeOutcome(ChallengeOutcomeType.LOSE);
		}
	}
}
