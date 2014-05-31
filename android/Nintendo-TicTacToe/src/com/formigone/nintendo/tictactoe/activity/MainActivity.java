package com.formigone.nintendo.tictactoe.activity;

import com.formigone.nintendo.tictactoe.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final String EXTRA_HAS_SHOWN = "hasShown";
    
    private boolean mHasShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	if (savedInstanceState == null) {
	    mHasShown = false;
	    Log.i(TAG, "Should skip splash and go to main menu");
	} else { 
	    mHasShown = true;
	}
	
	setContentView(R.layout.splash_screen);
    }

    @Override
    protected void onResume() {
	super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);
	
	outState.putBoolean(EXTRA_HAS_SHOWN, mHasShown);
    }

}
