package com.daletupling.libs;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daletupling.logit.R;

public class VehicleListAdapter extends BaseAdapter {
	Context context;

	ArrayList<VehicleData> vehicle_array = new ArrayList<VehicleData>();
	LayoutInflater layout_inflater;

	public VehicleListAdapter(Context mContext,
			ArrayList<VehicleData> vehicle_list) {
		vehicle_array = vehicle_list;
		context = mContext;
		layout_inflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return vehicle_array.size();
	}

	@Override
	public VehicleData getItem(int position) {
		// TODO Auto-generated method stub
		return vehicle_array.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			// set list item view
			convertView = layout_inflater.inflate(R.layout.vehicle_list_items,
					null);
		}

		// Instantiate List Item text views
		TextView vehicle_make_text = (TextView) convertView
				.findViewById(R.id.v_make);
		TextView vehicle_model_text = (TextView) convertView
				.findViewById(R.id.v_model);
		TextView vehicle_year_text = (TextView) convertView
				.findViewById(R.id.v_year);

		// Set text views
		vehicle_make_text.setText(vehicle_array.get(position).getMake());
		vehicle_model_text.setText(vehicle_array.get(position).getModel());
		vehicle_year_text.setText(vehicle_array.get(position).getYear().toString());

		return convertView;
	}

}
