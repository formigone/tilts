package com.formigone.mario.livewall.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.formigone.mariobros.R;

public class AnimView extends SurfaceView implements SurfaceHolder.Callback {
	private final static String TAG = "AnimView";
	
	protected SurfaceHolder mHolder;
	protected Bitmap mImg;
	protected Paint mPaint;
	protected Rect[] mFrames;
	protected Rect mImgOut;
	protected int mCurrentFrame;
	protected int mTotalFrames;
	protected int mFreq;
	protected long mLastTime;
	
	protected AnimViewThread mThead;

	public AnimView(Context context) {
		super(context);
		mHolder = getHolder();
		mHolder.addCallback(this);
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inScaled = false;
		mImg = BitmapFactory.decodeResource(getResources(),
				R.drawable.sprites_super_mario,
				opts);
		mPaint = new Paint();
		
		mImgOut = new Rect(150, 300, 0, 0);
		mFrames = new Rect[] { 
//				new Rect(7, 34, 59, 98),
				new Rect(67, 34, 127, 98),
				new Rect(135, 34, 175, 98),
				new Rect(179, 34, 243, 98)
				};

		mCurrentFrame = 0;
		mTotalFrames = 3;
		mFreq = 1000 / 6;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		setWillNotDraw(false);
		
		mThead = new AnimViewThread(this);
		mThead.setRunning(true);
		mThead.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		try {
			mThead.setRunning(false);
			mThead.join();
		} catch (InterruptedException e) {
		}
	}

	public void render(Canvas canvas) {
		if (canvas != null) {
			long now = System.currentTimeMillis();

			if (now > mLastTime + mFreq) {
				mLastTime = now;

				if (mCurrentFrame == 1) {
					mImgOut.left += -10;
				} else if (mCurrentFrame == 0) {
					mImgOut.left += 80;
				} else {
					mImgOut.left += 30;
				}
				if (mImgOut.left > 800) {
					mImgOut.left = -100;
				}

				mCurrentFrame = (mCurrentFrame + 1) % mTotalFrames;

				mImgOut.right = mImgOut.left + (mFrames[mCurrentFrame].right - mFrames[mCurrentFrame].left) * 3;
				mImgOut.bottom = mImgOut.top + (mFrames[mCurrentFrame].bottom - mFrames[mCurrentFrame].top) * 3;
			}
			
			canvas.drawARGB(255, 255, 255, 255);
			canvas.drawBitmap(mImg, mFrames[mCurrentFrame], mImgOut, null);
		}
	}

	public Canvas getCanvas() {
		return mHolder.lockCanvas();
	}

	public void unlock(Canvas canvas) {
		mHolder.unlockCanvasAndPost(canvas);
	}
}
