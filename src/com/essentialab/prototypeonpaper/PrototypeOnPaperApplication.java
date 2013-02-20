package com.essentialab.prototypeonpaper;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class PrototypeOnPaperApplication extends Application {
	private static Context context;
	String applicationId = "HzBJzRzV3Zp1m56TRpwsTHBEx87A669h7wbkSqk2";
	String clientKey = "tm4ZvgpAH3QztimJfW6GlmtwJtsHXbW1VHuf7fYZ";
	String facebookAppId = "139548399542234";

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, "" + applicationId, "" + clientKey);

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		ParseACL.setDefaultACL(defaultACL, true);
		
		ParseFacebookUtils.initialize(""+facebookAppId);

		PrototypeOnPaperApplication.context = getApplicationContext();

		//Testing Parse
		// ParseObject testObject = new ParseObject("TestObject");
		// testObject.put("is this", "working?");
		// testObject.saveInBackground();
		// Log.e("***", "here?");

	}

	public static Context getContext() {
		return context;
	}

}
