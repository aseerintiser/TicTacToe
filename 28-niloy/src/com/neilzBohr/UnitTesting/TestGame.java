package com.neilzBohr.UnitTesting;

import com.neilzBohr.AI.DefensiveAI;
import com.neilzBohr.GameActivities.GameFunctions;
import com.neilzBohr.TicTacToe;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;

public class TestGame {

    @Test
    public void testGame() {
        GameFunctions functions = new GameFunctions();
        functions.setHuman(0);
        functions.setAi(8);
        functions.setHuman(1);
        functions.setAi(2);
        functions.setHuman(6);
        functions.setAi(4);
        functions.setHuman(3);

        Assert.assertEquals(functions.isAiWin(), false);
        Assert.assertEquals(functions.isHumanWin(), true);
    }

    @Test
    public void testDefensive() {
        GameFunctions functions = new GameFunctions();
        functions.setHuman(0);
        functions.setHuman(1);

        DefensiveAI defensiveAI = new DefensiveAI();


        Assert.assertEquals(defensiveAI.moveAIPiece(functions.getPieces()), 2);

        functions = new GameFunctions();
        functions.setHuman(1);
        functions.setHuman(7);
        defensiveAI = new DefensiveAI();
        Assert.assertEquals(defensiveAI.moveAIPiece(functions.getPieces()), 4);
    }
}
