package com.formigone.nintendo.tictactoe.model;

import com.formigone.nintendo.tictactoe.R;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

public class Cell implements Fillable {
    public static enum State {
	EMPTY, PLAYER_ONE, PLAYER_TWO
    };
    
    public static class Handler extends ViewHandler {
	public ImageView img;
    }

    protected int mId;
    protected State mState;
    protected int mLayout;
    protected int mImg;

    public Cell(int id, int layout) {
	mId = id;
	mLayout = layout;
	mState = State.EMPTY;
	mImg = -1;
    }

    public State getState() {
	return mState;
    }

    public void setState(State state) {
	this.mState = state;
    }

    public void setImg(int mImg) {
        this.mImg = mImg;
    }

    public int getId() {
	return mId;
    }

    public int getLayout() {
        return mLayout;
    }

    @Override
    public ViewHandler getHandler(View convertView) {
	Handler handler = (Handler) convertView.getTag();
	
	if (handler != null) {
	    return handler;
	}
	
	handler = new Handler();
	handler.img = (ImageView) convertView.findViewById(R.id.img);
	convertView.setTag(handler);
	
	return handler;
    }

    @Override
    public void fill(View view) {
	Handler handler = (Handler) getHandler(view);
	
	if (mImg == -1) {
//	    handler.img.setBackgroundColor(Color.TRANSPARENT);
	} else {
	    handler.img.setBackgroundResource(mImg);
	}
    }
}
