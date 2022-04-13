package ss8_clean_code.bai_tap;

public class Test {
    private int player1Score;
    private int player2Score;

    public Test(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public static int[][][] getAllScores() {
        int[][][] array = {
                {{0, 0},
                        {1, 1},
                        {2, 2},
                        {3, 3},
                        {4, 4}},
                {{1, 0},
                        {0, 1},
                        {2, 0},
                        {0, 2},
                        {3, 0},
                        {0, 3},
                        {4, 0},
                        {0, 4}},

                {{2, 1},
                        {1, 2},
                        {3, 1},
                        {1, 3},
                        {4, 1},
                        {1, 4}},

                {{3, 2},
                        {2, 3},
                        {4, 2},
                        {2, 4}},

                {{4, 3},
                        {3, 4},
                        {5, 4},
                        {4, 5},
                        {15, 14},
                        {14, 15}},

                {{6, 4},
                        {4, 6},
                        {16, 14},
                        {14, 16}}
        };
        return array;
    }

    public void checkAllScores() {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        int firstScore = 0;
        int secondScore = 0;
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                firstScore += 1;
            if (i < this.player2Score)
                secondScore += 1;
        }
        System.out.println(TennisGame.getScore("John", "Bill", firstScore, secondScore));
    }

    public static void main(String[] args) {
        Test test;
        for (int i = 0; i < Test.getAllScores().length; i++) {
            for (int j = 0; j < Test.getAllScores()[i].length; j++) {
                int k = 0;
                test = new Test(Test.getAllScores()[i][j][k], Test.getAllScores()[i][j][k + 1]);
                test.checkAllScores();
            }
        }

    }
}
