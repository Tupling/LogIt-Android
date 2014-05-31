package com.daletupling.logit;

import com.daletupling.logit.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogInActivity extends Activity {
	// Edit Text Elements
	EditText user_name;
	EditText password;

	// Button Elements
	Button login;
	Button signUp;

	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		setTitle("Sign In");

		context = this;
		Parse.initialize(this, "dmSu69A9G1bgTrZYXMP3pAby8fiwYdefw8tXjumi",
				"5Ug218rLZApSrZw7XsSi8NIaQhEuTh1gZU7VPMFg");
		
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
			Intent i = new Intent(this, VehicleActivity.class);
			startActivity(i);
		}

		// Defined UI Elements
		user_name = (EditText) findViewById(R.id.userName);
		password = (EditText) findViewById(R.id.password);

		login = (Button) findViewById(R.id.logIn);
		signUp = (Button) findViewById(R.id.signUp);

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String userName = user_name.getText().toString();
				String passwordString = password.getText().toString();
				if (userName.matches("") || passwordString.matches("")) {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							context);
					builder.setMessage(
							"You failed to add a password or username. Please check your input and try again.")
							.setCancelable(false)
							.setPositiveButton(
									"OK",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int id) {
											dialog.dismiss();
										}
									});
					AlertDialog alert = builder.create();
					alert.show();
				}
				ParseUser.logInInBackground(user_name.getText().toString(),
						password.getText().toString(), new LogInCallback() {
							public void done(ParseUser user, ParseException e) {

								if (user != null) {
									Intent intent = new Intent(context, VehicleActivity.class);
									startActivity(intent);

								} else {
									
								}
							}
						});
			}

		});

		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, SignUp.class);
				startActivity(intent);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
