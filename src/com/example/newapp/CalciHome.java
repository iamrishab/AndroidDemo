package com.example.newapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CalciHome extends Activity implements OnClickListener{
	Button b1;
	ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calci_home);
		
		b1=(Button)findViewById(R.id.ch_b1);
		b1.setOnClickListener(this);
		pd= new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setMessage("Loading...");
		pd.setIndeterminate(true);
		pd.setCancelable(true);
		pd.show();
		
		Thread t = new Thread(){
			public void run(){
				try{
					Thread.sleep(1000);
					pd.dismiss();
				}catch(Exception e)
				{
					
				}
			}
		};
		t.start();
			 }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this,ViewDemo2.class);
		 startActivity(i);	 
		 finish();
		
	} 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater mi =getMenuInflater();
		mi.inflate(R.menu.calci_home, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.ch1) {
			//About App
			AlertDialog.Builder bd = new AlertDialog.Builder(this);
			bd.setTitle("About My App");
			bd.setMessage("Developed By Rishab Pal \nSimple Calculator\nMinimum requirement\nAndroid version 4.2.2\nJelly Bean");
			bd.setPositiveButton("OK", null);
			AlertDialog d= bd.create();
			d.show();
		}
		
		else if(id==R.id.ch2)
		{ // ACTION BAR ICON TITLE
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
} 
