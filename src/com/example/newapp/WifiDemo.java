package com.example.newapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class WifiDemo extends Activity {

	TextView st;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_demo);
		st=(TextView)findViewById(R.id.wifi_tv1);
		
		String wsn= Context.WIFI_SERVICE;
		WifiManager wm= (WifiManager)getSystemService(wsn);
		
		if(wm.isWifiEnabled()== true)
		{
			st.setText("ON");
			st.setTextColor(Color.BLUE);
			WifiInfo info  =  wm.getConnectionInfo();
			if(info.getBSSID()!=null)
			{
				String ssid= info.getSSID();
				int speed= info.getLinkSpeed();
				int strength=WifiManager.calculateSignalLevel(info.getRssi(),10);
				Toast.makeText(this,ssid+" "+speed+" "+strength,100).show();
			}
			else 
			{
				Toast.makeText(this,"Not Connected",100).show();
			}
		}
		else
		{
			st.setText("OFF");
			st.setTextColor(Color.RED);
		}
		
	}
}
