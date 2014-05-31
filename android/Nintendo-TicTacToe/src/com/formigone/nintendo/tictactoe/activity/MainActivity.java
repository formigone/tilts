package com.formigone.nintendo.tictactoe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.formigone.nintendo.tictactoe.R;

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
	
	TextView btn = (TextView) findViewById(R.id.title);
	btn.setOnClickListener(new OnClickListener() {
	    @Override
	    public void onClick(View view) {
		Intent intent = new Intent(MainActivity.this, GameActivity.class);
		startActivity(intent);
	    }
	});
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
