package com.formigone.mario.livewall.view;

import android.graphics.Canvas;

public class AnimViewThread extends Thread {
	protected boolean mRunning;
	protected AnimView mView;
	
	public AnimViewThread(AnimView view) {
		mView = view;
		mRunning = false;
	}

	public void setRunning(boolean running) {
		mRunning = running;
	}

	@Override
	public void run() {
		Canvas canvas = null;
		
		while (mRunning) {
			try {
				canvas = mView.getCanvas();
				
				synchronized (mView) {
					mView.render(canvas);
				}
			} finally {
				if (canvas != null) {
					mView.unlock(canvas);
				}
			}
		}
	}
}
