package com.essentialab.prototypeonpaper.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.essentialab.prototypeonpaper.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void LogInWithFacebook(View v) {
		ParseFacebookUtils.logIn(this, new LogInCallback() {

			@Override
			public void done(ParseUser user, ParseException e) {
				if (user == null) {
					Log.d("PrototypeOnPaper",
							"The user cancelled the Facebook Login");
				} else if (user.isNew()) {
					Log.d("PrototypeOnPaper",
							"User signed up an logged in through Facebook");
					startActivity(new Intent(LoginActivity.this,
							TutorialActivity.class));
					Toast.makeText(getApplicationContext(),
							"5 seconds, no more", 5000).show();
				} else {
					Log.d("PrototypeOnPaper", "User logged in through Facebook");
					startActivity(new Intent(LoginActivity.this,
							TutorialActivity.class));

				}
			}
		});
	}

	
//	public void logOut(View v) {
//		ParseFacebookUtils.getSession().closeAndClearTokenInformation();
//		Log.d("PrototypeOnPaper", "User has logged out");
//	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
