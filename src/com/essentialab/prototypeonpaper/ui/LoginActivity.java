package com.essentialab.prototypeonpaper.ui;

import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.essentialab.prototypeonpaper.R;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseFacebookUtils.Permissions;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

	public String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void LogInWithFacebook(View v) {
		ParseFacebookUtils.logIn(Arrays.asList(Permissions.User.EMAIL,
				Permissions.User.LOCATION), this, new LogInCallback() {

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
					getFacebookGraphObject();
					startActivity(new Intent(LoginActivity.this,
							TutorialActivity.class));

				}
			}

		});
	}


	public void getFacebookGraphObject() {
		Session session = ParseFacebookUtils.getSession();
		Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

			@Override
			public void onCompleted(GraphUser user, Response response) {
				if (user != null) {
					Log.d("facebookName", "" + user.getFirstName());
					name = user.getFirstName();
				}

			}
		});

	}

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
