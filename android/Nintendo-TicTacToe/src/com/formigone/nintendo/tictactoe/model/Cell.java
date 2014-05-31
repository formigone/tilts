package com.formigone.nintendo.tictactoe.model;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.formigone.nintendo.tictactoe.R;

public class Cell implements Fillable {
    private static final String TAG = "Cell";

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
    protected int mHighlight;

    public Cell(int id, int layout) {
	mId = id;
	mLayout = layout;
	mState = State.EMPTY;
	mImg = 0;
	mHighlight = -1;
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
    
    public void highlight(int color) {
	mHighlight = color;
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

	if (mImg > 0) {
	    handler.img.setImageResource(mImg);
	} else {
	    handler.img.setImageResource(R.drawable.alpha_transparent);
	}
	
	if (mHighlight >= 0) {
	    handler.img.setBackgroundResource(mHighlight);
	}
    }
}
