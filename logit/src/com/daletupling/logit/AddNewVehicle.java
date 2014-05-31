package com.daletupling.logit;

import com.daletupling.libs.VehicleData;
import com.parse.GetCallback;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNewVehicle extends Activity {

	EditText vehicleMake, vehicleModel, vehicleYear;
	String vMake, vModel, vYear, vObjectId;
	Button addVehicle, cancel;
	VehicleActivity vActivity;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_vehicle);
		setTitle("Add New Vehicle");
		context = this;

		vehicleMake = (EditText) findViewById(R.id.vehicle_make);
		vehicleModel = (EditText) findViewById(R.id.vehicle_model);
		vehicleYear = (EditText) findViewById(R.id.vehicle_year);

		addVehicle = (Button) findViewById(R.id.addBtn);
		cancel = (Button) findViewById(R.id.cancel_btn);

		addVehicle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Bundle bundle = getIntent().getExtras();
				if (bundle != null) {
					
					ParseQuery<ParseObject> query = ParseQuery.getQuery("Vehicles");
					Log.d("Vehicle ID =", vObjectId);
					// Retrieve the object by id
					query.getInBackground(vObjectId,
							new GetCallback<ParseObject>() {
								public void done(ParseObject vehicle,
										ParseException e) {
									if (e == null) {

										int vehicleYearNumber = Integer
												.parseInt(vYear);
										vehicle.put("make", vMake);
										vehicle.put("model", vModel);
										vehicle.put("year", vehicleYearNumber);
										vehicle.saveInBackground();
										
										Intent returnIntent = new Intent();
										returnIntent.setClass(context, VehicleActivity.class);
										startActivity(returnIntent);
										AddNewVehicle.this.finish();
									}
								}

							});
				} else {
					String vMakeString = vehicleMake.getText().toString();
					String vModelString = vehicleModel.getText().toString();

					int vehicleYearInt = Integer.parseInt(vehicleYear.getText()
							.toString());
					Number vehilceYearN = (Number) vehicleYearInt;

					ParseObject vehicle = new ParseObject("Vehicles");
					vehicle.put("make", vMakeString);
					vehicle.put("model", vModelString);
					vehicle.put("year", vehicleYearInt);
					vehicle.setACL(new ParseACL(ParseUser.getCurrentUser()));

					vehicle.saveInBackground();

					Intent returnIntent = new Intent();
					returnIntent.setClass(context, VehicleActivity.class);
					startActivity(returnIntent);
					AddNewVehicle.this.finish();

				}
			}

		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}

		});

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			// Data Variables
			vMake = bundle.getString("vehicle_make");
			vModel = bundle.getString("vehicle_model");
			vYear = bundle.getString("vehicle_year");
			vObjectId = bundle.getString("vehicle_id");

			setTitle(vMake);

			vehicleMake.setText(vMake);
			vehicleModel.setText(vModel);
			vehicleYear.setText(vYear);
		}
	}
}
