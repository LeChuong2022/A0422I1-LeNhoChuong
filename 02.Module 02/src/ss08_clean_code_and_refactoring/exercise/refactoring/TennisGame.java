package ss08_clean_code_and_refactoring.exercise.refactoring;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getResult(String player1Name, String player2Name, int m_scoreOfPlayer1, int m_scoreOfPlayer2) {
        String result = "";
        int tempScore = 0;
        boolean checkDeuceScore = m_scoreOfPlayer1 == m_scoreOfPlayer2;
        if (checkDeuceScore) {
            result = getResultWithDeuce(m_scoreOfPlayer1);
        } else {
            boolean checkScoreUpper4 = m_scoreOfPlayer1 >= 4 || m_scoreOfPlayer2 >= 4;
            if (checkScoreUpper4) {
                result = getResultWithScoreOfPlayer1OrPlayer2More4Point(m_scoreOfPlayer1, m_scoreOfPlayer2);
            } else {
                result = getResultNormal(m_scoreOfPlayer1, m_scoreOfPlayer2, result);
            }
        }
        return result;
    }

    private static String getResultNormal(int m_scoreOfPlayer1, int m_scoreOfPlayer2, String result) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_scoreOfPlayer1;
            else {
                result += "-";
                tempScore = m_scoreOfPlayer2;
            }
            switch (tempScore) {
                case LOVE:
                    result += "Love";
                    break;
                case FIFTEEN:
                    result += "Fifteen";
                    break;
                case THIRTY:
                    result += "Thirty";
                    break;
                case FORTY:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }

    private static String getResultWithScoreOfPlayer1OrPlayer2More4Point(int m_scoreOfPlayer1, int m_scoreOfPlayer2) {
        String result;
        int minusResult = m_scoreOfPlayer1 - m_scoreOfPlayer2;
        if (minusResult == 1) result = "Advantage player1";
        else if (minusResult == -1) result = "Advantage player2";
        else if (minusResult >= 2) result = "Win for player1";
        else result = "Win for player2";
        return result;
    }

    private static String getResultWithDeuce(int m_scoreOfPlayer1) {
        String result;
        switch (m_scoreOfPlayer1) {
            case LOVE:
                result = "Love-All";
                break;
            case FIFTEEN:
                result = "Fifteen-All";
                break;
            case THIRTY:
                result = "Thirty-All";
                break;
            case FORTY:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }
}