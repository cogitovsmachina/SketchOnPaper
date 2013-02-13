package com.essentialab.prototypeonpaper.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.essentialab.prototypeonpaper.R;
import com.essentialab.prototypeonpaper.R.layout;
import com.essentialab.prototypeonpaper.R.menu;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.parse.Parse;
import com.parse.ParseObject;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Start FB login
		// Session.openActiveSession(this, true, new Session.StatusCallback() {
		//
		// // Callback when session changes state
		// @Override
		// public void call(Session session, SessionState state,
		// Exception exception) {
		// if (session.isOpened()) {
		// // make request to the /me API
		// Request.executeMeRequestAsync(session,
		// new Request.GraphUserCallback() {
		//
		// @Override
		// public void onCompleted(GraphUser user,
		// Response response) {
		// if (user != null) {
		// Log.e("***",
		// "User logged in: "
		// + user.getFirstName());
		// Intent i = new Intent(LoginActivity.this, TutorialActivity.class);
		// startActivity(i);
		// // TextView welcome = new
		// // TextView(MainActivity.this);
		// // welcome.setText("Hello "+user.getName());
		// }
		//
		// }
		// });
		// }
		//
		// }
		// });

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// Session.getActiveSession().onActivityResult(this, requestCode,
		// resultCode, data);
		// startActivity(new Intent(LoginActivity.this,
		// TutorialActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
