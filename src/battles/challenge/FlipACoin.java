package battles.challenge;

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
}
