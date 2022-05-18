package assets.libraries;

public class Quiz {
    String[] question1 = {
            "When did Captain Cook come to the islands of NZ?",
            "A. 1709", // 1
            "B. 1739", // 2
            "C. 1769", // 3
            "D. 1799", // 4
            "C. 1769" // 5 which is the correct answer.
    };

    String[] question2 = {
            "What animal is on the $2 coin of NZ?",
            "A. Kotuko", // 1
            "B. Kiwi", // 2
            "C. kakapo", // 3
            "D. Takahe", // 4
            "A. Kotuko" // 5 which is the correct answer.
    };

    String[] question3 = {
            "What is the te reo Māori word for 'science'?",
            "A. Ahupūngao", // 1
            "B. Pāngarau", // 2
            "C. Toi", // 3
            "D. Pūtaiao", // 4
            "D. Pūtaiao" // 5 which is the correct answer.
    };

    String[] question4 = {
            "How high is the Sky Tower in Auckland?",
            "A. 145m", // 1
            "B. 328m", // 2
            "C. 445m", // 3
            "D. 296m", // 4
            "B. 328m" // 5 which is the correct answer.
    };

    String[] question5 = {
            "What is the longest river in NZ?",
            "A. Waikato River", // 1
            "B. Clutha River", // 2
            "C. Waimakariri River", // 3
            "D. Manawatu River", // 4
            "A. Waikato River" // 5 which is the correct answer.
    };

    String[] question6 = {
            "In what year did the All Blacks first win the Rugby World Club?",
            "A. 1987", // 1
            "B. 1973", // 2
            "C. 1980", // 3
            "D. 1994", // 4
            "A. 1987" // 5 which is the correct answer.
    };

    String[] question7 = {
            "Who was the first female Prime Minister of NZ?",
            "A. Jacinda Ardern", // 1
            "B. Elizabeth McCombs", // 2
            "C. Jenny Shipley", // 3
            "D. Helen Clark", // 4
            "C. Jenny Shipley" // 5 which is the correct answer.
    };

    String[] question8 = {
            "If you fly from Christchurch to Auckland direct, how long does it take?",
            "A. 1 hour", // 1
            "B. 1 hour 15 minutes ", // 2
            "C. 1 hour 25 minutes", // 3
            "D. 1 hour 35 minutes", // 4
            "C. 1 hour 25 minutes" // 5 which is the correct answer.
    };

    String[] question9 = {
            "What is the second most popular sport in New Zealand?",
            "A. Football", // 1
            "B. Rugby League", // 2
            "C. Rugby", // 3
            "D. Cricket", // 4
            "D. Cricket" // 5 which is the correct answer.
    };

    String[] question10 = {
            "Which NZ airport has a functional railway line crossing the main runway?",
            "A. Gisborne Airport", // 1
            "B. Blenheim Airport", // 2
            "C. Palmerston North Airport", // 3
            "D. Dunedin Airport", // 4
            "A. Gisborne Airport" // 5 which is the correct answer.
    };

    public String[] getQuestion(int inputQuestionNumber) {
        String[] returnValue;

        switch(inputQuestionNumber) {
            case 1:
                returnValue = question1;
                break;
            case 2:
                returnValue = question2;
                break;
            case 3:
                returnValue = question3;
                break;
            case 4:
                returnValue = question4;
                break;
            case 5:
                returnValue = question5;
                break;
            case 6:
                returnValue = question6;
                break;
            case 7:
                returnValue = question7;
                break;
            case 8:
                returnValue = question8;
                break;
            case 9:
                returnValue = question9;
                break;
            default:
                returnValue = question10;
                break;
        }

        return returnValue;
    }
}
