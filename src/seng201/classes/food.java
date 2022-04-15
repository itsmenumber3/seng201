package seng201.classes;

public class food implements item {

    int value;

    food(user player) {
        setValue(player.getDifficultyLevel());
    }

    /**
     * Set the value of food, according to the difficulty level as defined by user.DifficultyLevel
     */

    public void setValue(int difficultyLevel) {
        if (difficultyLevel == 1) {
            value = 30;
        } else if (difficultyLevel == 2) {
            value = 50;
        } else if (difficultyLevel == 3) {
            value = 70;
        }  
    }

    /**
     * @return the value of food
     */

    public int getValue() {
        return value;
    }

    public void use() {
        
    }
}
