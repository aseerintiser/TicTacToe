package com.neilzBohr;

import com.neilzBohr.AI.AI;
import com.neilzBohr.AI.DefensiveAI;
import com.neilzBohr.AI.RandomAI;
import com.neilzBohr.GameActivities.GameFunctions;
import com.neilzBohr.Theme.ClassicTheme;
import com.neilzBohr.Theme.ForestTheme;
import com.neilzBohr.Theme.HighContrastTheme;
import com.neilzBohr.Theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    public static final int POSSIBLE_MOVES = 9;
    private int movesPerformed = 0;
    private static boolean isGameEnd = false;
    private static String gameWinMessage = "YOU WIN!";
    private static String gameLoseMessage = "YOU LOSE!";
    private static String gameDrawMessage = "DRAW!";
    private static final int HUMAN = 0;
    private static final int AI = 1;
    private GameFunctions gameFunctions = new GameFunctions();

    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    public JButton[] jButtons;

    private JRadioButton radioButtonClassic;
    private JRadioButton radioButtonHighContrast;
    private JRadioButton radioButtonForest;

    private JButton buttonStartWithRandomAI;
    private JButton buttonStartWithDefensiveAI;

    private JPanel panelBoard;
    private JPanel panelMenu;
    private JPanel panelTheme;
    private JPanel panelStartGame;
    private JPanel panelMain;

    private Theme theme = new ClassicTheme();
    private String currentPiece = theme.getHumanPlayerPiece();

    private AI gameAI = new RandomAI();

    public TicTacToe() {
        Display display = new Display(panelMain);
        display.show();
        setTheme(new ClassicTheme());

        radioButtonClassic.addActionListener(changeThemeListener);
        radioButtonForest.addActionListener(changeThemeListener);
        radioButtonHighContrast.addActionListener(changeThemeListener);

        radioButtonClassic.setMnemonic(1);
        radioButtonForest.setMnemonic(2);
        radioButtonHighContrast.setMnemonic(3);

        initBoardButtons();
        initStartGameButtons();
    }

    private ActionListener changeThemeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            int themeButtonID = ((JRadioButton) actionEvent.getSource()).getMnemonic();
            Theme theme = null;

            switch (themeButtonID) {
                case 1:
                    theme = new ClassicTheme();
                    break;
                case 2:
                    theme = new ForestTheme();
                    break;
                case 3:
                    theme = new HighContrastTheme();
                    break;
            }
            setTheme(theme);
        }
    };

    private void setTheme(Theme theme) {
        Color backgroundColor = theme.getBackgroundColor();
        Color lineColor = theme.getLineColor();

        panelBoard.setBackground(lineColor);
        panelMenu.setBackground(backgroundColor);
        panelTheme.setBackground(backgroundColor);
        panelStartGame.setBackground(backgroundColor);
        panelMain.setBackground(backgroundColor);

        setButtonStyle(backgroundColor, lineColor);

    }

    private void setButtonStyle(Color backgroundColor, Color lineColor) {

        button1.setBackground(backgroundColor);
        button2.setBackground(backgroundColor);
        button3.setBackground(backgroundColor);
        button4.setBackground(backgroundColor);
        button5.setBackground(backgroundColor);
        button6.setBackground(backgroundColor);
        button7.setBackground(backgroundColor);
        button8.setBackground(backgroundColor);
        button9.setBackground(backgroundColor);

        radioButtonClassic.setBackground(backgroundColor);
        radioButtonForest.setBackground(backgroundColor);
        radioButtonHighContrast.setBackground(backgroundColor);

        radioButtonClassic.setForeground(lineColor);
        radioButtonForest.setForeground(lineColor);
        radioButtonHighContrast.setForeground(lineColor);

        buttonStartWithRandomAI.setBackground(lineColor);
        buttonStartWithDefensiveAI.setBackground(lineColor);

        buttonStartWithRandomAI.setForeground(backgroundColor);
        buttonStartWithDefensiveAI.setForeground(backgroundColor);
    }

    private void initBoardButtons() {
        button1.addActionListener(boardButtonListener);
        button2.addActionListener(boardButtonListener);
        button3.addActionListener(boardButtonListener);
        button4.addActionListener(boardButtonListener);
        button5.addActionListener(boardButtonListener);
        button6.addActionListener(boardButtonListener);
        button7.addActionListener(boardButtonListener);
        button8.addActionListener(boardButtonListener);
        button9.addActionListener(boardButtonListener);

        button1.setMnemonic(1);
        button2.setMnemonic(2);
        button3.setMnemonic(3);
        button4.setMnemonic(4);
        button5.setMnemonic(5);
        button6.setMnemonic(6);
        button7.setMnemonic(7);
        button8.setMnemonic(8);
        button9.setMnemonic(9);

        //for AI move part
        jButtons = new JButton[POSSIBLE_MOVES];
        jButtons[0] = button1;
        jButtons[1] = button2;
        jButtons[2] = button3;
        jButtons[3] = button4;
        jButtons[4] = button5;
        jButtons[5] = button6;
        jButtons[6] = button7;
        jButtons[7] = button8;
        jButtons[8] = button9;
    }

    private ActionListener boardButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int buttonID = ((JButton) actionEvent.getSource()).getMnemonic() - 1;
            JButton clickedButton = jButtons[buttonID];

            if (clickedButton.getText().equals("")) {

                clickedButton.setText(currentPiece);
                gameFunctions.setHuman(buttonID);
                movesPerformed++;

                if (movesPerformed < POSSIBLE_MOVES && !isGameEnd) {
                    makeAIMove();
                }

                if (movesPerformed == POSSIBLE_MOVES && !isGameEnd) {
                    JOptionPane.showMessageDialog(null, gameDrawMessage);
                }

            }
        }

        private void findWinner() {
            if (movesPerformed > 4) {
                String piece = theme.getHumanPlayerPiece();
                for (int flag = 0; flag < 2; flag++) {

                    if (flag == 1) {
                        piece = theme.getAIPiece();
                    }

                    for (int i = 0; i < 9; i += 3) {
                        if (jButtons[i].getText().equals(piece) && jButtons[i + 1].getText().equals(piece) && jButtons[i + 2].getText().equals(piece)) {
                            showWinner(flag);
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        if (jButtons[i].getText().equals(piece) && jButtons[i + 3].getText().equals(piece) && jButtons[i + 6].getText().equals(piece)) {
                            showWinner(flag);
                        }
                    }

                    for (int i = 0; i < 3; i += 2) {
                        if (jButtons[i].getText().equals(piece) && jButtons[4].getText().equals(piece) && jButtons[8 - i].getText().equals(piece)) {
                            showWinner(flag);
                        }
                    }

                }
            }
        }


        private void showWinner(int flag) {
            isGameEnd = true;
            if (flag == HUMAN) {
                JOptionPane.showMessageDialog(null, gameWinMessage);
            } else if (flag == AI) {
                JOptionPane.showMessageDialog(null, gameLoseMessage);
            }
        }


        private void makeAIMove() {
            int index = gameAI.moveAIPiece(gameFunctions.getPieces());
            gameFunctions.setAi(index);
            jButtons[index].setText(theme.getAIPiece());
            movesPerformed++;
            findWinner();
        }
    };

    private void initStartGameButtons() {
        buttonStartWithRandomAI.addActionListener(startGameListener);
        buttonStartWithDefensiveAI.addActionListener(startGameListener);

        buttonStartWithRandomAI.setMnemonic(1);
        buttonStartWithDefensiveAI.setMnemonic(2);
    }

    private ActionListener startGameListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            int buttonID = ((JButton) actionEvent.getSource()).getMnemonic();

            switch (buttonID) {
                case 1:
                    startGameWithRandomAI();
                    break;
                case 2:
                    startGameWithDefensiveAI();
                    break;
            }

        }
    };

    private void restartNewGame() {
        gameFunctions = new GameFunctions();
        for (int index = 0; index < POSSIBLE_MOVES; index++) {
            jButtons[index].setText("");
        }
        movesPerformed = 0;
        isGameEnd = false;
    }

    private void setAI(AI gameAI) {
        restartNewGame();
        this.gameAI = gameAI;
    }

    private void startGameWithRandomAI() {
        restartNewGame();
        gameAI = new RandomAI();
    }

    private void startGameWithDefensiveAI() {
        restartNewGame();
        gameAI = new DefensiveAI();
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}