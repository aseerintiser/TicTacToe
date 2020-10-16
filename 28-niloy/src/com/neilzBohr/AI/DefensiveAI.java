package com.neilzBohr.AI;

import com.neilzBohr.GameActivities.GameFunctions;

import javax.swing.*;
import java.util.Random;

public class DefensiveAI implements AI {

    @Override
    public int moveAIPiece(int[] pieces) {
        int piece;
        //For rows
        for (int i = 0; i < 9; i = i + 3) {
            piece = hasMove(pieces, i, i + 1, i + 2);
            if (piece != -1) return piece;
        }

        //for columns
        for (int i = 0; i < 3; i++) {
            piece = hasMove(pieces, i, i + 3, i + 6);
            if (piece != -1) return piece;
        }

        //for diagonal
        for (int i = 0; i < 3; i = i + 2) {
            piece = hasMove(pieces, i, 4, 8 - i);
            if (piece != -1) return piece;
        }

        return new RandomAI().moveAIPiece(pieces);
    }

    private int hasMove(int[] pieces, int i, int j, int k) {
        int index = -1;
        int human = 0;
        if (pieces[i] == GameFunctions.HUMAN) human++;
        else if (pieces[i] == GameFunctions.BLANK) index = i;

        if (pieces[j] == GameFunctions.HUMAN) human++;
        else if (pieces[j] == GameFunctions.BLANK) index = j;

        if (pieces[k] == GameFunctions.HUMAN) human++;
        else if (pieces[k] == GameFunctions.BLANK) index = k;

        if (human == 2 && index != -1) return index;
        return -1;

    }
}
