package com.formigone.nintendo.tictactoe.model;

public class Player {
    protected int mName;
    protected int mImage;
    protected int mColor;
    protected int mColorAccent;

    public Player(int name, int image, int color, int accent) {
	mName = name;
	mImage = image;
	mColor = color;
	mColorAccent = accent;
    }

    public int getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public int getColor() {
        return mColor;
    }

    public int getColorAccent() {
        return mColorAccent;
    }
}
