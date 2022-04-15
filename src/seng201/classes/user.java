package seng201.classes;

public class user {
    public String userName;
    public int difficultyLevel;
    public int userDay;
    
    public void setUserDay(int inputUserDay) {
        if (inputUserDay <= 5) {
            userDay = inputUserDay;
        } else {
            userDay = 5;
        }
    }

    

}
