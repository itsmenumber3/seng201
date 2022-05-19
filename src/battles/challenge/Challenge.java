package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;

import java.security.SecureRandom;

public class Challenge {
	public ChallengeType challengeType;
	SecureRandom random = new SecureRandom();
	
	public void setChallengeType(ChallengeType inpuChallengeType) {
		this.challengeType = inpuChallengeType;
	}
	
	public ChallengeType getChallengeType() {
		return this.challengeType;
	}

	public ChallengeOutcomeType challengeOutcome;

	public void setChallengeOutcome(ChallengeOutcomeType inputChallengeOutcome) {
		this.challengeOutcome = inputChallengeOutcome;
	}

	public ChallengeOutcomeType getChallengeOutcome(){
		return this.challengeOutcome;
	}
}
