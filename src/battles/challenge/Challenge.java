package battles.challenge;

import assets.enums.ChallengeType;

public class Challenge {
	public ChallengeType challengeType;
	
	public void setChallengeType(ChallengeType inpuChallengeType) {
		this.challengeType = inpuChallengeType;
	}
	
	public ChallengeType getChallengeType() {
		return this.challengeType;
	}
}
