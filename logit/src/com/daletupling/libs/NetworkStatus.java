package com.daletupling.libs;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {

		//Network Boolean
		static Boolean netConnected = false;
		static String networkType;
		static NetworkInfo netInfo;
		static String TAG = "NETWORK DATA - WEBDATA";
		
		//Check and get Network Type/ RETURNS networkType
		public static String getType(Context context) {

			//Call the checkNetworkStatus method and return networkType
			checkNetworkStatus(context);
			return networkType;
		}

		//Check and get Network Status/ RETURNS netStatus
		public static Boolean getStatus(Context context) {

			//Call the checkNetworkStatus method and return networkConnected
			checkNetworkStatus(context);

			return netConnected;
		}

		//CheckNetworkStatus check and return status and type
		private static void checkNetworkStatus(Context context) {
			ConnectivityManager connect_manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			netInfo = connect_manager.getActiveNetworkInfo();
			//Check in netInfo exits and is not null
			if (netInfo != null) {
				//Check if device is connected to a network
				if (netInfo.isConnected()) {
					//Get string for networkType
					networkType = netInfo.getTypeName();
					//Change networkConnection to true
					netConnected = true;
				}
			}
		}

	}
