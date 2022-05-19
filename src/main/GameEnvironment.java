package main;

import java.net.NoRouteToHostException;
import java.util.ArrayList;

import javax.swing.JButton;

import assets.enums.MonsterType;
import assets.libraries.Tools;
import battles.challenge.FlipACoin;
import battles.challenge.PaperScissorsRock;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;
import ui.*;

/**
 * The class Game is the master class in this game.
 */
public class GameEnvironment {

    private Player player = new Player();
    private Tools tools = new Tools();
    
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

    public void launchHowToPlayScreen() {
        HowToPlayScreen howToPlayWindow = new HowToPlayScreen(this);
    }

    public void closeHowToPlayScreen(HowToPlayScreen howToPlayWindow) {
        howToPlayWindow.closeWindow();
        this.launchWelcomeScreen();
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
    
    public void closeBattleScreen(BattleScreen inputBattleWindow) {
    	inputBattleWindow.closeWindow();
    }
    
    public void launchTravellingScreen() {
    	TravellingScreen travellingWindow = new TravellingScreen(this);
    }
    
    public void closeTravellingScreen(TravellingScreen inputTravellingWindow) {
    	inputTravellingWindow.closeWindow();
    	this.getPlayer().getPlayerSelectedBattle().setCurrentChallenge(tools.makeRandomChallenge());
    	
    	switch (this.getPlayer().getPlayerSelectedBattle().getCurrentChallenge().getChallengeType()) {
    	case PAPER_SCISSORS_ROCK:
    		this.launchPaperScissorsRockScreen();
    		break;
    	case QUIZ:
    		this.launchQuizScreen();
    		break;
    	default:
    		this.launchFlipACoinScreen();
    		break;
    	}
    }
    
    public void launchQuizScreen() {
    	QuizScreen quizWindow = new QuizScreen(this);
    }
    
    public void closeQuizScreen(QuizScreen inputQuizScreen) {
        inputQuizScreen.closeWindow();
        // Redirect to next challenge
    }
    
    public void launchPaperScissorsRockScreen() {
    	PaperScissorsRockScreen paperScissorsRockWindow = new PaperScissorsRockScreen(this);
    }

    public void closePaperScissorsRockScreen(PaperScissorsRockScreen inputPapersScissorsRockWindow) {
        inputPapersScissorsRockWindow.closeWindow();

    }

    public void launchChallengeResultScreen() {
        ChallengeResultScreen challengeResultWindow = new ChallengeResultScreen(this);
    }

    public void closeChallengeResultScreen(ChallengeResultScreen inputChallengeResultWindow) {
        inputChallengeResultWindow.closeWindow();
        // Next challenge?
    }
    
    public void launchFlipACoinScreen() {
    	FlipACoinScreen flipACoinWindow = new FlipACoinScreen();
    }
    
    public void closeFlipACoinScreen(FlipACoinScreen flipACoinWindow) {
    	flipACoinWindow.closeWindow();
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
        game.launchWelcomeScreen();
    }
}
