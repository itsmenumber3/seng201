package main;

import assets.libraries.Tools;
import exceptions.UnallowedMethodException;
import ui.FirstMonsterSetupScreen;
import ui.PlayerSetupScreen;
import ui.WelcomeScreen;

/**
 * The class Game is the master class in this game.
 */
public class GameEnvironment {

    private Player player = new Player();
    
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
    }
    
    public void launchFirstMonsterSetupScreen() {
    	FirstMonsterSetupScreen firstMonsterSetupScreen 
    }

    public static void main(String[] args) {
        GameEnvironment game = new GameEnvironment();
        game.launchWelcomeScreen();
    }
}
