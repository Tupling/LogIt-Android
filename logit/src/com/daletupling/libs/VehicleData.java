package com.daletupling.libs;

public class VehicleData {
	String vehicle_make;
	String vehicle_model;
	Number vehicle_year;
	String v_objectId;

	//Getters
	public String getMake() {
		return vehicle_make;

	}

	public String getModel() {
		return vehicle_model;
	}

	public Number getYear() {
		return vehicle_year;
	}
	public String getObjectId() {
		return v_objectId;
	}
	
	//Setters
	public void setMake(String make) {
		vehicle_make = make;
	}

	public void setModel(String model) {
		vehicle_model = model;
	}

	public void setYear(Number year) {
		vehicle_year = year;
	}
	public void setObjectId(String vehicleId) {
		v_objectId = vehicleId;
	}

}