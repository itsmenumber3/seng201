package main;

import java.util.ArrayList;

import assets.enums.MonsterType;
import assets.libraries.Tools;
import entities.monsters.Monster;
import exceptions.UnallowedMethodException;
import ui.BattleScreen;
import ui.FirstMonsterSetupScreen;
import ui.MapScreen;
import ui.PlayerSetupScreen;
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
    
    public void closeMapScreen(MapScreen inputMapWindow) {
    	inputMapWindow.closeWindow();
    	this.launchBattleScreen();
    }
    
    public void launchBattleScreen() {
    	BattleScreen battleWindow = new BattleScreen(this);
    }
    
    public void closeBattleScreen(BattleScreen inputBattleWindow) {
    	inputBattleWindow.closeWindow();
    }

    public static void main(String[] args) {
        GameEnvironment game = new GameEnvironment();
        game.launchWelcomeScreen();
    }
}
