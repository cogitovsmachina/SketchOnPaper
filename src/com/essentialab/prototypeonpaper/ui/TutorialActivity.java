package com.essentialab.prototypeonpaper.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.essentialab.prototypeonpaper.R;
import com.parse.ParseFacebookUtils;

public class TutorialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		Toast.makeText(this, "It works", 300).show();
	}

	public void logOut(View v) {
		ParseFacebookUtils.getSession().closeAndClearTokenInformation();
		Log.d("PrototypeOnPaper", "User has logged out");
		startActivity(new Intent(TutorialActivity.this, LoginActivity.class));
	}
}
