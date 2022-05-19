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
import ui.BattleScreen;
import ui.FirstMonsterSetupScreen;
import ui.FlipACoinScreen;
import ui.MapScreen;
import ui.PaperScissorsRockScreen;
import ui.PlayerSetupScreen;
import ui.QuizScreen;
import ui.TravellingScreen;
import ui.WelcomeScreen;

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
    
    public void closeQuizScreen(QuizScreen inputQuizScreen
    
    public void launchPaperScissorsRockScreen() {
    	PaperScissorsRockScreen paperScissorsRockWindow = new PaperScissorsRockScreen();
    }
    
    public void launchFlipACoinScreen() {
    	FlipACoinScreen flipACoinWindow = new FlipACoinScreen();
    }

    public static void main(String[] args) {
        GameEnvironment game = new GameEnvironment();
        game.launchWelcomeScreen();
    }
}
