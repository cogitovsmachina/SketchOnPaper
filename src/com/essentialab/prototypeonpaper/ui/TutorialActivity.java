package com.essentialab.prototypeonpaper.ui;

import com.essentialab.prototypeonpaper.R;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class TutorialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		Log.e("***", ""+ParseFacebookUtils.getSession().getActiveSession());
	}

	public void logOut(View v) {
		ParseFacebookUtils.getSession().closeAndClearTokenInformation();
		Log.d("PrototypeOnPaper", "User has logged out");
		startActivity(new Intent(TutorialActivity.this, LoginActivity.class));
	}
}
