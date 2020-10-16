package com.neilzBohr.Theme;

import javax.swing.*;

public class IconDirectories {
    private static final String CLASSIC_HUMAN_PIECE_DIRECTORY = "src/com/Resources/Icons/classicHumanPiece.png";
    private static final String CLASSIC_AI_PIECE_DIRECTORY = "src/com/Resources/Icons/classicAiPiece.png";
    private static final String FOREST_HUMAN_PIECE_DIRECTORY = "src/com/Resources/Icons/forestHumanPiece.png";
    private static final String FOREST_AI_PIECE_DIRECTORY = "src/com/Resources/Icons/forestAiPiece.png";
    private static final String HIGH_CONTRAST_HUMAN_PIECE_DIRECTORY = "src/com/Resources/Icons/highContrastHumanPiece.png";
    private static final String HIGH_CONTRAST_AI_PIECE_DIRECTORY = "src/com/Resources/Icons/highContrastAiPiece.png";

    static Icon getClassicHumanPiece() {
        return new ImageIcon(CLASSIC_HUMAN_PIECE_DIRECTORY);
    }

    static Icon getClassicAiPiece() {
        return new ImageIcon(CLASSIC_AI_PIECE_DIRECTORY);
    }

    static Icon getForestHumanPiece() {
        return new ImageIcon(FOREST_HUMAN_PIECE_DIRECTORY);
    }

    static Icon getForestAiPiece() {
        return new ImageIcon(FOREST_AI_PIECE_DIRECTORY);
    }

    static Icon getHighContrastHumanPiece() {
        return new ImageIcon(HIGH_CONTRAST_HUMAN_PIECE_DIRECTORY);
    }

    static Icon getHighContrastAiPiece() {
        return new ImageIcon(HIGH_CONTRAST_AI_PIECE_DIRECTORY);
    }
}
