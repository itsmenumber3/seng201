package main;


import assets.enums.ChallengeType;
import assets.enums.FightOutcomeType;
import assets.libraries.Tools;
import battles.Battle;
import battles.challenge.Challenge;
import battles.challenge.FlipACoin;
import battles.challenge.PaperScissorsRock;

import exceptions.UnallowedMethodException;
import ui.*;


/**
 * The class Game is the master class in this game.
 */
public class GameEnvironment {
	
	

    // LIBRARIES --------------------------------------------------
    private final Player player = new Player(); // Player of the game
    private final Tools tools = new Tools(); // Access to the tools class
    // LIBRARIES --------------------------------------------------
    
    private String randomEventMessage;
    public String getRandomEventMessage() {
    	return randomEventMessage;
    }
    
    public void resetRandomEventMessage() {
    	randomEventMessage = "";
    }
    
    // FIGHT OUTCOME ----------------------------------------------

    // PLAYER -----------------------------------------------------
    /**
     * Unallowed set method for creating a player
     * @param inputPlayer Player
     * @throws UnallowedMethodException
     */
    public void setPlayer(Player inputPlayer) {
    	try {
    		throw new UnallowedMethodException("Unallowed method");
    	} catch (UnallowedMethodException e) {
    		e.printStackTrace();
    	}
    }

    /**
     * Gets the current player within the current game environment
     * @return player of type Player
     */
    public Player getPlayer() {
    	return player;
    }
    // PLAYER -----------------------------------------------------

    // WELCOME SCREEN ---------------------------------------------
    /**
     * Launches the welcome screen to start process of configuring the game
     */
    public void launchWelcomeScreen() {
        WelcomeScreen welcomeWindow = new WelcomeScreen(this);
    }

    /**
     * Closes the welcome screen and calls the player setup screen
     * @param inputWelcomeWindow WelcomeScreen
     */
    public void closeWelcomeScreen(WelcomeScreen inputWelcomeWindow) {
        inputWelcomeWindow.closeWindow();
        launchPlayerSetupScreen();
    }
    // WELCOME SCREEN ---------------------------------------------

    // PLAYER SETUP SCREEN ----------------------------------------
    /**
     * Launches the player setup screen to configure
     * the player name, difficulty and duration of the game.
     */
    public void launchPlayerSetupScreen() {
        PlayerSetupScreen playerSetupWindow = new PlayerSetupScreen(this);
    }

    /**
     * Closes the player setup screen and calls the launch first monster set up screen
     * @param inputPlayerSetupWindow PlayerSetupScreen
     */
    public void closePlayerSetupScreen(PlayerSetupScreen inputPlayerSetupWindow) {
    	inputPlayerSetupWindow.closeWindow();
    	launchFirstMonsterSetupScreen();
    }
    // PLAYER SETUP SCREEN ----------------------------------------

    // FIRST MONSTER SETUP SCREEN ---------------------------------
    /**
     * Launches the first monster setup screen where the player will
     * be able to choose and name the first monster in their team
     */
    public void launchFirstMonsterSetupScreen() {
    	FirstMonsterSetupScreen firstMonsterSetupWindow = new FirstMonsterSetupScreen(this);
    }

    /**
     * Closes the first monster setup screen and launches the map screen
     * @param firstMonsterSetupWindow FirstMonsterSetupScreen
     */
    public void closeFirstMonsterSetupScreen(FirstMonsterSetupScreen firstMonsterSetupWindow) {
    	firstMonsterSetupWindow.closeWindow();
        launchMapScreen();
    }
    // FIRST MONSTER SETUP SCREEN ---------------------------------

    // MAP SCREEN -------------------------------------------------
    /**
     * Launches the map screen to select the location for the next battle
     */
    public void launchMapScreen() {
    	MapScreen mapWindow = new MapScreen(this);
    }

    /**
     * Closes the map screen and calls the next window
     * based on the getNextScreen parameter within the map window
     * the calls are for: a battle screen; a shop screen; a finish game screen
     * the default is to call the inventory screen
     * @param inputMapWindow MapScreen
     */
    public void closeMapScreen(MapScreen inputMapWindow) {
    	inputMapWindow.closeWindow();
        switch (inputMapWindow.getNextScreen()) {
            case 1 -> launchBattleScreen();
            case 2 -> launchShopScreen();
            case 3 -> launchFinishGameScreen();
            default -> launchInventoryScreen();
        }
    }
    // MAP SCREEN -------------------------------------------------

    // INVENTORY SCREEN -------------------------------------------
    /**
     * Launches the inventory screen to see the currently owned monsters, food, drinks or fuel
     */
    public void launchInventoryScreen() {
        InventoryScreen inventoryWindow = new InventoryScreen(this);
    }

    /**
     * Closes the inventory screen and launches either
     * the map screen or shop screen (depending on the button that was pressed)
     * @param inputInventoryWindow: InventoryScreen
     */
    public void closeInventoryScreen(InventoryScreen inputInventoryWindow) {
        inputInventoryWindow.closeWindow();
        if (inputInventoryWindow.getNextWindowIsMap()) {
            launchMapScreen();
        } else {
            launchShopScreen();
        }
    }
    // INVENTORY SCREEN -------------------------------------------

    // BATTLE SCREEN ----------------------------------------------
    /**
     * Launches the battle screen where the player can decide
     * to travel to that location or go back to the map and choose a different location
     */
    public void launchBattleScreen() {
        BattleScreen battleWindow = new BattleScreen(this);
    }

    /**
     * Closes the battle screen and has 2 options to call:
     * If the player wants to continue to their selected location the travelling screen will be called.
     * If the player wants to return to the map screen will be called.
     * @param inputBattleWindow BattleScreen
     * @param isPlayerBattling boolean
     */
    public void closeBattleScreen(BattleScreen inputBattleWindow, boolean isPlayerBattling) {
        inputBattleWindow.closeWindow();
        if (isPlayerBattling) {
        	randomEventMessage = inputBattleWindow.getRandomEventMessage();
            launchTravellingScreen();
        } else {
            launchMapScreen();
        }
    }
    // BATTLE SCREEN ----------------------------------------------

    // SHOP SCREEN ------------------------------------------------
    /**
     * Launches the shop screen to buy new or more:
     * monsters, food, drinks, fuel or a lotto ticket
     * can also sell a monster if they no longer want it however this monster is not retrievable
     */
    public void launchShopScreen() {
        ShopScreen shopWindow = new ShopScreen(this);
    }

    /**
     * Closes the shop screen and calls the map screen
     * @param inputShopWindow ShopScreen
     */
    public void closeShopScreen(ShopScreen inputShopWindow) {
        inputShopWindow.closeWindow();
        if (inputShopWindow.getNextWindowIsInventory()) {
        	launchInventoryScreen();
        } else {
        	launchMapScreen();
        }
    }
    // SHOP SCREEN ------------------------------------------------

    // FINISH GAME SCREEN -----------------------------------------


    // FINISH GAME SCREEN -----------------------------------------

    // TRAVELLING SCREEN ------------------------------------------
    /**
     * Launches the travelling screen where a random event may occur
     */
    public void launchTravellingScreen() {
    	TravellingScreen travellingWindow = new TravellingScreen(this);
    }

    /**
     * Closes the travelling screen and calls the make and launch challenge screen
     * @param inputTravellingWindow TravellingScreen
     */
    public void closeTravellingScreen(TravellingScreen inputTravellingWindow) {
    	inputTravellingWindow.closeWindow();
    	makeNewChallengeAndLaunchScreen();
    }
    // TRAVELLING SCREEN ------------------------------------------
    
    // NEW CHALLENGE SCREEN ---------------------------------------
    /**
     * Chooses the next challenge and launches the relevant screen:
     * flip a coin Or paper, scissors, rock Or quiz
     */
    public void makeNewChallengeAndLaunchScreen() {
    	Challenge newChallenge = tools.makeRandomChallenge();
        if (newChallenge.challengeType == ChallengeType.FLIP_A_COIN) {
        	getPlayer().getPlayerSelectedBattle().setCurrentChallenge(new FlipACoin());
            launchFlipACoinScreen();
        }
        else if(newChallenge.challengeType == ChallengeType.PAPER_SCISSORS_ROCK) {
        	getPlayer().getPlayerSelectedBattle().setCurrentChallenge(new PaperScissorsRock());
            System.out.println(getPlayer().getPlayerSelectedBattle().getCurrentChallenge());
            launchPaperScissorsRockScreen();
        } else {

        	
        	getPlayer().getPlayerSelectedBattle().setCurrentChallenge(tools.makeRandomQuiz());
            launchQuizScreen();
        }
    }
    // NEW CHALLENGE SCREEN ---------------------------------------


    
    // CHALLENGE RESULT SCREEN ------------------------------------
    /**
     * Launches the challenge result screen which displays
     * the players monsters and stats and the opponent monsters stats
     */
    public void launchChallengeResultScreen() {
        ChallengeResultScreen challengeResultWindow = new ChallengeResultScreen(this);
    }

    /**
     * Closes the challenge result window and has 4 options to call:
     * If the player wins the battle the launch battle screen is called
     * If both monsters still have health > 0 the battle continues and a new challenge is called
     * If the players current monster's health < 0 and has more monsters in their team
     * and the battle monster has health > 0 the battle continues and a new challenge is called
     * If the players current monster's health < 0 and there are no more monsters in the team
     * the battle and subsequently game is over and the finish game screen is called
     * @param inputChallengeResultWindow ChallengeResultScreen
     */
    public void closeChallengeResultScreen(ChallengeResultScreen inputChallengeResultWindow) {
        inputChallengeResultWindow.closeWindow();
        makeNewChallengeAndLaunchScreen();
    	
    }


    // QUIZ SCREEN ------------------------------------------------
    /**
     * Launches the quiz screen where the player
     * answers a question to decide whether the player gets to attack in the battle
     */
    public void launchQuizScreen() {
    	QuizScreen quizWindow = new QuizScreen(this);
    }

    /**
     * Closes the quiz screen and calls the launch challenge result screen
     * @param inputQuizScreen QuizScreen
     */
    public void closeQuizScreen(QuizScreen inputQuizScreen) {
        inputQuizScreen.closeWindow();
        decideNextChallengeScreenBasedOnRunFight();

    }
    // QUIZ SCREEN ------------------------------------------------

    // PAPER SCISSOR ROCK SCREEN ----------------------------------
    /**
     * Launches the paper, scissors, rock screen where the player
     * plays paper, scissors, rock to decide whether the player gets to attack in the battle
     */
    public void launchPaperScissorsRockScreen() {
    	PaperScissorsRockScreen paperScissorsRockWindow = new PaperScissorsRockScreen(this);
    }

    /**
     * Closes the paper, scissors, rock screen and calls the launch challenge result screen
     * @param inputPapersScissorsRockWindow PaperScissorsRockScreen
     */
    public void closePaperScissorsRockScreen(PaperScissorsRockScreen inputPapersScissorsRockWindow) {
        inputPapersScissorsRockWindow.closeWindow();
        decideNextChallengeScreenBasedOnRunFight();
    }
    // PAPER SCISSOR ROCK SCREEN ----------------------------------
    
    public void decideNextChallengeScreenBasedOnRunFight() {
    	FightOutcomeType fightOutcome = getPlayer().getPlayerSelectedBattle().getFightOutcome();


        switch (fightOutcome) {
            case PLAYER_WINS_BATTLE -> launchBattleResultScreen();
            case PLAYER_OUT_OF_MONSTERS_AND_LOSES_BATTLE_GAME_OVER -> launchFinishGameScreen();
            default -> launchChallengeResultScreen();
        }
  
        
    }

    // FLIP A COIN SCREEN -----------------------------------------
    /**
     * Launches the flip a coin screen where the player
     * plays flip a coin to decide whether the player gets to attack in the battle
     */
    public void launchFlipACoinScreen() {
        FlipACoinScreen flipACoinWindow = new FlipACoinScreen(this);
    }

    /**
     * Closes the flip a coin screen and calls the launch challenge result screen
     * @param flipACoinWindow FlipACoinScreen
     */
    public void closeFlipACoinScreen(FlipACoinScreen flipACoinWindow) {
        flipACoinWindow.closeWindow();
        decideNextChallengeScreenBasedOnRunFight();

    }
    // FLIP A COIN SCREEN -----------------------------------------



    // BATTLE RESULT SCREEN ---------------------------------------
    /**
     * Launches the battle result screen which shows the reward they steal from the opponent monster
     */
    public void launchBattleResultScreen() {
        BattleResultScreen battleResultWindow = new BattleResultScreen(this);
    }

    /**
     * Closes the battle result screen and has 2 options to call
     * If the player has reached the chosen game duration the game has been won
     * and the launch finish game screen is called
     * Otherwise the map screen is called
     * @param inputBattleResultWindow BattleResultScreen
     */
    public void closeBattleResultScreen(BattleResultScreen inputBattleResultWindow) {
        inputBattleResultWindow.closeWindow();
        if (getPlayer().hasGameBeenWon()) {
        	launchFinishGameScreen();
        } else {
        	launchMapScreen();
        }
    }
    // BATTLE RESULT SCREEN ---------------------------------------

    // FINISH GAME SCREEN -----------------------------------------
    /**
     * Launches the finish game screen which displays:
     * player name, game duration, gold gained, points gained
     */
    public void launchFinishGameScreen() {
        FinishGameScreen finishGameWindow = new FinishGameScreen(this);
    }

    /**
     * Closes the finish game screen
     * If the player chooses to restart then a new game environment is created and a new game is launched
     * @param inputFinishGameWindow FinishGameScreen
     */
    public void closeFinishGameScreen(FinishGameScreen inputFinishGameWindow) {
        inputFinishGameWindow.closeWindow();
        if (!inputFinishGameWindow.getQuitGame()) {
        	main(null);
        }
    }
    // FINISH GAME SCREEN -----------------------------------------

    // CREATE GAME ------------------------------------------------
    /**
     * Starts the game and sets default parameters
     */
    public static void main(String[] args) {
        GameEnvironment game = new GameEnvironment();
        Battle battle = new Battle();
        battle.setBattleName("Wellington");
        battle.setBattleIsland("North Island");
        game.getPlayer().setPlayerPreviewBattle(battle);
        game.getPlayer().setNextDayNextBattle();
        game.launchWelcomeScreen();
    }
    // CREATE GAME ------------------------------------------------
}
