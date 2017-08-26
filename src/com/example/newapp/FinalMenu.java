package com.example.newapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FinalMenu extends ListActivity {
	String[] mi={"Sensor Demo","Custom Design","Bluetooth Access","Camera App","Access Wifi","BROADCAST DEMO","EARTHQUAKE","EXIT"};
	Class[] act={SensorDemo.class,GraphicsDemo.class,BTDemo.class,CameraDemo.class,WifiDemo.class,BroadcastDemo.class};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_menu);
		
		ArrayAdapter<String> ad;
		ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi );
		setListAdapter(ad);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ci= mi[position];
		if(ci.equals("EXIT")){
			finish();
		}
		else if(ci.equalsIgnoreCase("EARTHQUAKE")){
			String vsn = Context.VIBRATOR_SERVICE;
			Vibrator vib= (Vibrator)getSystemService(vsn);
			vib.vibrate(1000);
		}
		else
		{
			Intent i= new Intent(this,act[position]);
			startActivity(i);
		}
	}

}