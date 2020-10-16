package com.neilzBohr.Theme;

import java.awt.*;

public class ForestTheme implements Theme {
    @Override
    public Color getBackgroundColor() {
        return new Color(144, 238, 144); //Light Green
    }

    @Override
    public Color getLineColor() {
        return new Color(0, 100, 0); //Dark Green
    }

    @Override
    public String getHumanPlayerPiece() {
        return "Flower";
    }

    @Override
    public String getAIPiece() {
        return "Fruit";
    }
}
