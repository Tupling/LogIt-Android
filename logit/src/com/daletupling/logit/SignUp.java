package com.daletupling.logit;

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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

@SuppressWarnings("unused")
public class SignUp extends Activity {
	// Edit Text Elements
	EditText user_name;
	EditText password;
	EditText email;

	Button signUp;
	Button cancel;

	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		context = this;

		// Defined UI Elements
		user_name = (EditText) findViewById(R.id.signup_username);
		password = (EditText) findViewById(R.id.signup_password);
		email = (EditText) findViewById(R.id.signup_email);

		signUp = (Button) findViewById(R.id.signup_signupBtn);
		cancel = (Button) findViewById(R.id.cancel);
		signUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ParseUser user = new ParseUser();
				user.setUsername(user_name.getText().toString());
				user.setPassword(password.getText().toString());
				user.setEmail(email.getText().toString());

				user.signUpInBackground(new SignUpCallback() {
					public void done(ParseException e) {
						if (e == null) {
							AlertDialog.Builder builder = new AlertDialog.Builder(context);
							builder.setMessage("You have successfully signed up for Log It!")
									.setCancelable(false)
									.setPositiveButton("OK",
											new DialogInterface.OnClickListener() {
												public void onClick(DialogInterface dialog,
														int id) {
													finish();
												}
											});
							AlertDialog alert = builder.create();
							alert.show();
						} else {
							// Sign up didn't succeed. Look at the
							// ParseException
							// to figure out what went wrong
						}
					}

				});
			}

		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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
