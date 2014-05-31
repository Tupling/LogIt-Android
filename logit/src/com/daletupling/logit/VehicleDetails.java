package com.daletupling.logit;

import com.parse.ParseUser;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class VehicleDetails extends Activity {
	TextView vehicleMake, vehicleModel, vehicleYear;
	Button editVehicle;
	
	String vMake, vModel, vYear;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehicle_details);
		
		// Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		vehicleMake = (TextView) findViewById(R.id.makeText);
		vehicleModel = (TextView) findViewById(R.id.modelText);
		vehicleYear = (TextView) findViewById(R.id.yearText);
		
		editVehicle = (Button) findViewById(R.id.editButton);
		
		
		editVehicle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {

			// Data Variables
			vMake = bundle.getString("vehicle_make");
			vModel = bundle.getString("vehicle_model");
			vYear = bundle.getString("vehicle_year");
			
			setTitle(vMake);
			
			vehicleMake.setText(vMake);
			vehicleModel.setText(vModel);
			vehicleYear.setText(vYear);
		}
	}
	
}
