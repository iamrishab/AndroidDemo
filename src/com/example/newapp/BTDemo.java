package com.example.newapp;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BTDemo extends Activity {

	TextView st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_btdemo);
		st = (TextView)findViewById(R.id.btd_tv1);
		
		BluetoothAdapter bm = BluetoothAdapter.getDefaultAdapter();
		if(bm!=null)
		{
			if(bm.isEnabled()==true)
			{
				st.append("ON");
				st.setTextColor(Color.BLUE);
				String mydevadd= bm.getAddress();
				
				bm.setName("Kickass!!");
				String mydevnam=bm.getName();
				Toast.makeText(this, mydevadd+"  "+mydevnam, 100).show();
			}
			else
			{
				st.append("OFF");
				st.setTextColor(Color.RED);
			}
			st.append("Start Scanning Device ");
			bm.startDiscovery();
			st.append("Scannning Completed..");
			Set<BluetoothDevice> devices = bm.getBondedDevices();
			
			for(BluetoothDevice d: devices)
			{
				st.append("Devices: "+d);
				st.append("Devices Name: "+d.getName());
				st.append("Devices Address: "+d.getAddress());
			}
		}
		else
		{
			//NO DEVICE FOUND
			//DEVICE NOT RESPONDING
			Toast.makeText(this, "DEVICE IS NOT RESPONDING", 100).show();
		}
		
		
	}

}