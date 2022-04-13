package ss8_clean_code.bai_tap;

public class TennisGame {
    public static final String FIFTEEN = "Fifteen";
    public static final String LOVE = "Love";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ALL = "All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage";
    public static final String WINFOR = "Win for";
    public static final char MINUS = '-';


    public static String getScore(String player1Name, String player2Name, int firstScore, int secondScore) {
        String score = "";
        int tempScore;
        if (firstScore == secondScore) {
            switch (firstScore) {
                case 0:
                    score = LOVE + MINUS + ALL;
                    break;
                case 1:
                    score = FIFTEEN + MINUS + ALL;
                    break;
                case 2:
                    score = THIRTY + MINUS + ALL;
                    break;
                case 3:
                    score = FORTY + MINUS + ALL;
                    break;
                default:
                    score = DEUCE;
                    break;

            }
        } else if (firstScore >= 4 || secondScore >= 4) {
            int minusResult = firstScore - secondScore;
            if (minusResult == 1) score = ADVANTAGE + " " + player1Name;
            else if (minusResult == -1) score = ADVANTAGE + " " + player2Name;
            else if (minusResult >= 2) score = WINFOR + " " + player2Name;
            else score = WINFOR + " " + player2Name;
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = firstScore;
                else {
                    score += MINUS;
                    tempScore = secondScore;
                }
                switch (tempScore) {
                    case 0:
                        score += LOVE;
                        break;
                    case 1:
                        score += FIFTEEN;
                        break;
                    case 2:
                        score += THIRTY;
                        break;
                    case 3:
                        score += FORTY;
                        break;
                }
            }
        }
        return score;
    }
}
