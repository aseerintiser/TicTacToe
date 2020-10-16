package com.neilzBohr.Theme;

import java.awt.*;

public class ClassicTheme implements Theme {
    @Override
    public Color getBackgroundColor() {
        return Color.WHITE;
    }

    @Override
    public Color getLineColor() {
        return Color.BLACK;
    }

    @Override
    public String getHumanPlayerPiece() {
        return "X";
    }

    @Override
    public String getAIPiece() {
        return "O";
    }
}
