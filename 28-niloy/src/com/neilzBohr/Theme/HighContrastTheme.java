package com.neilzBohr.Theme;

import java.awt.*;

public class HighContrastTheme implements Theme {
    @Override
    public Color getBackgroundColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getLineColor() {
        return Color.LIGHT_GRAY;
    }

    @Override
    public String getHumanPlayerPiece() {
        return "■";
    }

    @Override
    public String getAIPiece() {
        return "□";
    }
}
