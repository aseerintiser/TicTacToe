package com.neilzBohr.GameActivities;

public class GameFunctions {
    public static final int HUMAN = 1;
    private static final int AI = 0;
    public static final int BLANK = -1;

    private int[] pieces = {
            BLANK, BLANK, BLANK,
            BLANK, BLANK, BLANK,
            BLANK, BLANK, BLANK
    };

    public int[] getPieces() {
        return pieces;
    }

    public void setHuman(int i) {
        pieces[i] = HUMAN;
    }

    public void setAi(int i) {
        pieces[i] = AI;
    }

    public boolean isHumanWin() {
        return isWin(HUMAN);
    }

    public boolean isAiWin() {
        return isWin(AI);
    }

    private boolean checkLine(int i, int j, int k, int piece) {
        return pieces[i] == piece && pieces[j] == piece && pieces[k] == piece;
    }

    private boolean isWin(int piece) {
        return
                checkLine(0, 1, 2, piece) ||
                        checkLine(3, 4, 5, piece) ||
                        checkLine(6, 7, 8, piece) ||
                        checkLine(0, 3, 6, piece) ||
                        checkLine(1, 4, 7, piece) ||
                        checkLine(2, 5, 8, piece) ||
                        checkLine(0, 4, 8, piece) ||
                        checkLine(2, 4, 6, piece);
    }
}
