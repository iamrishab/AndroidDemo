package com.example.newapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MenuDemo extends Activity {
	
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo);
		
		b1=(Button)findViewById(R.id.amd_b1);
		registerForContextMenu(b1);
		
		ActionBar ab= getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater mi =getMenuInflater();
		mi.inflate(R.menu.menu_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.omi1) {
			//About App
			AlertDialog.Builder bd = new AlertDialog.Builder(this);
			bd.setMessage("Developed By Rishab Pal \n Android version 4.2.2\nJelly Bean");
			bd.setTitle("About My App");
			bd.setIcon(R.drawable.duck);
			bd.setPositiveButton("OK", null);
			AlertDialog d= bd.create();
			d.show();
		}
		else if(id==R.id.omi2)
		{
			//Settings
		}
		else if(id==R.id.omi3)
		{
			//Camera
		}
		else if(id==R.id.omi4)
		{
			//Bluetooth
		}
		else if(id==R.id.omi5)
		{
			//Wi-Fi
		}
		else if(id==R.id.omi6)
		{
			finish();
		}
		else
		{ // ACTION BAR ICON TITLE
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Button Action:");
		menu.setHeaderIcon(R.drawable.tick);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.button_context_demo, menu);
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id= item.getItemId();
		if(id==R.id.cmi1)
		{
			Toast.makeText(this,"View Clicked", 100).show();
		}
		
		else if(id==R.id.cmi2)
		{
			Toast.makeText(this,"Share Clicked", 100).show();
		}
		else if(id==R.id.cmi3)
		{
			Toast.makeText(this,"Details Clicked", 100).show();
		}
		return super.onContextItemSelected(item);
	}
}
