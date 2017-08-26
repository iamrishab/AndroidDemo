package com.example.newapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ChargerConnected extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Toast.makeText(context, "CHARGER CONNECTED!!!", Toast.LENGTH_LONG).show();
	}
}
