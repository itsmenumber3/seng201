package main;

import assets.enums.ChallengeType;
import assets.enums.FightOutcomeType;
import assets.libraries.Tools;
import battles.Battle;
import battles.challenge.Challenge;
import exceptions.UnallowedMethodException;
import ui.*;

import javax.swing.*;

/**
 * The class Game is the master class in this game.
 */
public class GameEnvironment {

    private final Player player = new Player();
    private final Tools tools = new Tools();
    private FightOutcomeType fightOutcome;
    
    public void setFightOutcome(FightOutcomeType inputFightOutcomeType) {
    	fightOutcome = inputFightOutcomeType;
    }
    
    public FightOutcomeType getFightOutcome() {
    	return fightOutcome;
    }
    
    public void setPlayer(Player inputPlayer) {
    	try {
    		throw new UnallowedMethodException("Unallowed method");
    	} catch (UnallowedMethodException e) {
    		e.printStackTrace();
    	}
    }
    
    public Player getPlayer() {
    	return this.player;
    }

    public void launchWelcomeScreen() {
        WelcomeScreen welcomeWindow = new WelcomeScreen(this);
    }

    public void closeWelcomeScreen(WelcomeScreen inputWelcomeWindow) {
        inputWelcomeWindow.closeWindow();
        this.launchPlayerSetupScreen();
    }


    public void launchPlayerSetupScreen() {
        PlayerSetupScreen playerSetupWindow = new PlayerSetupScreen(this);
    }
    
    public void closePlayerSetupScreen(PlayerSetupScreen inputPlayerSetupWindow) {
    	inputPlayerSetupWindow.closeWindow();
    	this.launchFirstMonsterSetupScreen();
    }
    
    public void launchFirstMonsterSetupScreen() {
    	
    	FirstMonsterSetupScreen firstMonsterSetupWindow = new FirstMonsterSetupScreen(this);
    }
    
    public void closeFirstMonsterSetupScreen(FirstMonsterSetupScreen firstMonsterSetupWindow) {
    	firstMonsterSetupWindow.closeWindow();
    }
    
    public void launchMapScreen() {
    	MapScreen mapWindow = new MapScreen(this);
    }
    
    public void closeMapScreen(MapScreen inputMapWindow, JButton inputJButtonPressed) {
    	inputMapWindow.closeWindow();
    	this.launchBattleScreen();
    }

    public void launchInventoryScreen(boolean isPreviousWindowMapWindow) {
        InventoryScreen inventoryWindow = new InventoryScreen(this, isPreviousWindowMapWindow);
    }

    public void closeInventoryScreen(InventoryScreen inputInventoryWindow) {
        inputInventoryWindow.closeWindow();
        if (inputInventoryWindow.getIsPreviousWindowMapWindow()) {
            launchMapScreen();
        } else {
            launchShopScreen();
        }
    }

    public void launchShopScreen() {
        ShopScreen shopWindow = new ShopScreen(this);
    }

    public void closeShopScreen(ShopScreen inputShopWindow) {
        inputShopWindow.closeWindow();
        launchMapScreen();
    }
    
    public void launchBattleScreen() {
    	BattleScreen battleWindow = new BattleScreen(this);
    }
    
    public void closeBattleScreen(BattleScreen inputBattleWindow, boolean isPlayerBattling) {
    	inputBattleWindow.closeWindow();
    	if (isPlayerBattling) {
        	launchTravellingScreen();
    	} else {
    		launchMapScreen();
    	}
    }
    
    public void launchTravellingScreen() {
    	TravellingScreen travellingWindow = new TravellingScreen(this);
    }
    
    public void closeTravellingScreen(TravellingScreen inputTravellingWindow) {
    	inputTravellingWindow.closeWindow();
    	
    	makeNewChallengeAndLaunchScreen();
    }
    
    public void launchQuizScreen() {
    	QuizScreen quizWindow = new QuizScreen(this);
    }
    
    public void closeQuizScreen(QuizScreen inputQuizScreen) {
        inputQuizScreen.closeWindow();
        launchChallengeResultScreen();
    }
    
    public void launchPaperScissorsRockScreen() {
    	PaperScissorsRockScreen paperScissorsRockWindow = new PaperScissorsRockScreen(this);
    }

    public void closePaperScissorsRockScreen(PaperScissorsRockScreen inputPapersScissorsRockWindow) {
        inputPapersScissorsRockWindow.closeWindow();
        launchChallengeResultScreen();

    }

    public void launchChallengeResultScreen() {
        ChallengeResultScreen challengeResultWindow = new ChallengeResultScreen(this);
    }

    public void closeChallengeResultScreen(ChallengeResultScreen inputChallengeResultWindow) {
        inputChallengeResultWindow.closeWindow();
        
        switch (this.getFightOutcome()) {
        case PLAYER_WINS_BATTLE:
        	launchBattleResultScreen();
        	break;
        case BOTH_MONSTERS_STILL_HAVE_HEALTH:
        	makeNewChallengeAndLaunchScreen();
        	break;
        case PLAYER_LOSES_MONSTER_BUT_BATTLE_CONTINUES:
        	getPlayer().getPlayerInventory().getMonsters().remove(0);
        	makeNewChallengeAndLaunchScreen();
        	break;
        default: // Game is over
        	launchFinishGameScreen();
        	break;
        }
    }
    
    public void makeNewChallengeAndLaunchScreen() {
    	Challenge newChallenge = tools.makeRandomChallenge();
        getPlayer().getPlayerSelectedBattle().setCurrentChallenge(newChallenge);
        if (newChallenge.challengeType == ChallengeType.FLIP_A_COIN) {
            launchFlipACoinScreen();
        } else if(newChallenge.challengeType == ChallengeType.PAPER_SCISSORS_ROCK) {
            launchPaperScissorsRockScreen();
        } else {
            launchQuizScreen();
        }
    }
    
    public void launchFlipACoinScreen() {
    	FlipACoinScreen flipACoinWindow = new FlipACoinScreen();
    }
    
    public void closeFlipACoinScreen(FlipACoinScreen flipACoinWindow) {
    	flipACoinWindow.closeWindow();
    	launchChallengeResultScreen();
    }

    public void launchBattleResultScreen() {
        BattleResultScreen battleResultWindow = new BattleResultScreen(this);
    }

    public void closeBattleResultScreen(BattleResultScreen inputBattleResultWindow) {
        inputBattleResultWindow.closeWindow();
        this.launchMapScreen();
    }

    public void launchFinishGameScreen() {
        FinishGameScreen finishGameWindow = new FinishGameScreen(this);
    }

    public void closeFinishGameScreen(FinishGameScreen inputFinishGameWindow) {
        inputFinishGameWindow.closeWindow();
    }

    public static void main(String[] args) {
        GameEnvironment game = new GameEnvironment();
        Battle battle = new Battle();
        battle.setBattleName("Wellington");
        game.getPlayer().setPlayerSelectedBattle(battle);
        game.launchWelcomeScreen();
    }
}
