package com.daletupling.logit;

import com.daletupling.libs.VehicleData;
import com.parse.ParseObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNewVehicle extends Activity {
	
	EditText vehicleMake, vehicleModel, vehicleYear;
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
				String vMakeString = vehicleMake.getText().toString();
				String vModelString = vehicleModel.getText().toString();
				
				int vehicleYearInt = Integer.parseInt(vehicleYear.getText().toString());
				Number vehilceYearN = (Number) vehicleYearInt;
				
				ParseObject vehicle = new ParseObject("Vehicles");
				vehicle.put("make", vMakeString);
				vehicle.put("model", vModelString);
				vehicle.put("year", vehicleYearInt);
				
				vehicle.saveInBackground();
				
				Intent returnIntent = new Intent();
				returnIntent.setClass(context, VehicleActivity.class);
				startActivity(returnIntent);
				AddNewVehicle.this.finish();
				
				

			}
		       
			});
			
		
		
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				
			}
			
		});
	}
}
