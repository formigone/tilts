package com.formigone.mario.livewall;

import android.app.Activity;
import android.os.Bundle;

import com.formigone.mario.livewall.view.AnimView;

public class MainActivity extends Activity {
	AnimView mView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mView = new AnimView(this);
		setContentView(mView);
	}
}
