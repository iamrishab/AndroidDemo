package com.example.newapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorDemo extends Activity implements SensorEventListener{

	TextView st,ef;
	SensorManager sm;
	 Sensor s,s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_demo);
		
		st = (TextView)findViewById(R.id.sensor_tv1);
		ef=(TextView)findViewById(R.id.sensor_tv2);
		
	/*	String ssn= Context.SENSOR_SERVICE;
		sm= (SensorManager)getSystemService(ssn);
		int type= Sensor.TYPE_ORIENTATION;
		s= sm.getDefaultSensor(type); */
		
		String ssn= Context.SENSOR_SERVICE;
		sm= (SensorManager)getSystemService(ssn);
		int type1=Sensor.TYPE_PROXIMITY;
		s1=sm.getDefaultSensor(type1);
		sm.registerListener(this, s, sm.SENSOR_PROXIMITY);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener(this);// recommended to call this method on onPause method
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sm.registerListener(this, s, sm.SENSOR_DELAY_NORMAL);
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		/*float[] data = event.values;
		float x = data[1];
		float y = data[2];
		float z = data[0];
		String op = "EVENT STATUS:";
		op = op+"\nX = "+x;
		op = op+"\nY = "+y;
		op = op+"\nZ = "+z;
		st.setText(op);
		ef.setBackgroundColor(Color.rgb((int)x, (int)y , (int)z));*/
		
		
		float[] data = event.values;
		float x = data[0];
		if(x==0)
		{
			ef.setBackgroundResource(R.drawable.duck);
		}
		else 
		{
			ef.setBackgroundResource(R.drawable.ic_launcher);
		}
		
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}