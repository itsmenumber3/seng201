package battles;

import java.util.ArrayList;

import assets.enums.BattleType;
import battles.challenge.Challenge;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;
import main.Shop;

public class Battle{

	// BATTLE TYPE ----------------------------------------------
	
	/**
	 * BattleType can be either
	 */
    public BattleType battleType;

    public void setBattleType(BattleType inputBattleType) {
        this.battleType = inputBattleType;
    }

    public BattleType getBattleType() {
        return this.battleType;
    }
    
    public String battleIsland;
    
    public void setBattleIsland(String inputBattleIsland) {
    	battleIsland = inputBattleIsland;
    }
    
    public String getBattleIsland() {
    	return battleIsland;
    }
    
 // BATTLE TYPE ----------------------------------------------

    public Shop battleShop = new Shop();

    public void setBattleShop(Shop inputShop) {
        try {
            throw new UnallowedMethodException("unallowed method");
        } catch (UnallowedMethodException e) {
            e.printStackTrace();
        }
    }

    public Shop getBattleShop() {
        return this.battleShop;
    }

    public String battleName;

    public void setBattleName(String inputBattleName) {
        this.battleName = inputBattleName;
    }

    public String getBattleName() {
        return this.battleName;
    }
    
    public Monster battleMonster;
    
    public void setBattleMonster(Monster inputMonster) {
    	this.battleMonster = inputMonster;
    }
   
    
    public Monster getBattleMonster() {
    	return this.battleMonster;
    }
    
    private Challenge currentChallenge;

    public void setCurrentChallenge(Challenge inputCurrentChallenge) {
        this.currentChallenge = inputCurrentChallenge;
    }

    public Challenge getCurrentChallenge() {
        return this.currentChallenge;
    }
    
    private int challengeCount = 0;
    
    public void setChallengeCount(int inputChallengeCount) {
    	try {
    		throw new UnallowedMethodException("Unallowed method");
    	} catch (UnallowedMethodException e) {
    		e.printStackTrace();
    	}
    }
    
    public void resetChallengeCount() {
    	challengeCount = 0;
    }
    
    public void incrementChallengeCount() {
    	challengeCount++;
    }
    
    public int getChallengeCount() {
    	return challengeCount;
    }

    public String battleImagePath;

    public void setBattleImagePath(String inputBattleImagePath) {
        battleImagePath = inputBattleImagePath;
    }

    public String getBattleImagePath() {
        return battleImagePath;
    }
}
