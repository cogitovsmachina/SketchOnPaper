package com.essentialab.prototypeonpaper.ui;

import com.essentialab.prototypeonpaper.R;
import com.essentialab.prototypeonpaper.R.layout;
import com.essentialab.prototypeonpaper.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class TutorialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_tutorial, menu);
		return true;
	}

}
