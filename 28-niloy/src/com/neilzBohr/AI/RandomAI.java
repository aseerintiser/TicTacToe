package com.neilzBohr.AI;

import com.neilzBohr.GameActivities.GameFunctions;
import com.neilzBohr.TicTacToe;

import java.util.Random;

public class RandomAI implements AI {
    @Override
    public int moveAIPiece(int[] pieces) {
        while (true) {
            int index = new Random().nextInt(TicTacToe.POSSIBLE_MOVES);
            if (pieces[index] == GameFunctions.BLANK) {
                return index;
            }
        }
    }
}
