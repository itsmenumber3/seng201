package battles.challenge;

import assets.enums.ChallengeOutcomeType;
import assets.enums.ChallengeType;
import assets.enums.FightOutcomeType;

import java.security.SecureRandom;

public class Challenge {
	public ChallengeType challengeType;
	SecureRandom random = new SecureRandom();
	public ChallengeOutcomeType challengeOutcome;
	
	
	public void setChallengeType(ChallengeType inputChallengeType) {
		challengeType = inputChallengeType;
	}
	
	public ChallengeType getChallengeType() {
		return challengeType;
	}


	public void setChallengeOutcome(ChallengeOutcomeType inputChallengeOutcome) {
		challengeOutcome = inputChallengeOutcome;
	}

	public ChallengeOutcomeType getChallengeOutcome(){
		return challengeOutcome;
	}
	

}
