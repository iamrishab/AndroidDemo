package com.example.newapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CPDemo extends Activity {
	
	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cpdemo);
		
		tv1=(TextView)findViewById(R.id.cp_tv1);
		
		ContentResolver cr = getContentResolver();
		/*
		Cursor c = cr.query(StudentContract.STU_URI, null, null, null, null);
		String data="Student records\n---------------------\nRoll\t\tname\n";
		while(c.moveToNext())
		{
			int rci = c.getColumnIndex(StudentContract.STU_RN);
			int nci = c.getColumnIndex(StudentContract.STU_Name);;
			String r= c.getString(rci);
			String n=c.getString(nci);
			data= data+r+"\t\t"+n+"\n";
		}
		*/
		
		String data = "PHONEBOOK\n----NAMES\n-----";
		Cursor c= cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while(c.moveToNext())
		{
			int index = c.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String people=c.getString(index);
			data= data+people+"\n";
		}
		
		tv1.setText(data);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cpdemo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
