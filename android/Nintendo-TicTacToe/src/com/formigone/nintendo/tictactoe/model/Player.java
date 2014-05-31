package com.formigone.nintendo.tictactoe.model;

public class Player {
    protected int mName;
    protected int mImage;

    public Player(int mName, int mImage) {
	super();
	this.mName = mName;
	this.mImage = mImage;
    }

    public int getmName() {
        return mName;
    }

    public int getmImage() {
        return mImage;
    }
}
