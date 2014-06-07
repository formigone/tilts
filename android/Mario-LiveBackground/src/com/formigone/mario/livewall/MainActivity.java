package com.formigone.mario.livewall;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView t = new TextView(this);
		t.setText("Super Mario Brothers");
		
		setContentView(t);
	}
}
