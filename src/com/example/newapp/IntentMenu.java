package com.example.newapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class IntentMenu extends ListActivity {
	String[] mi={"MESSENGER","PHONEBOOK EDIT","PHONEBOOK VIEW","INTERNET","SMS","CALL","EXIT"};

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
		else if(ci.equals("CALL"))
		{
			String aan = Intent.ACTION_DIAL;
			String callto="tel:9475839166";
			Uri u = Uri.parse(callto);
			Intent i = new Intent(aan,u);
			startActivity(i);
		}
		else if(ci.equals("SMS"))
		{
			String aan = Intent.ACTION_SENDTO;
			String s = "sms:9475839166";
			String m="This is a demo text message\nVia an Android App\nDeveloped By: Rishab Pal";
			Uri u = Uri.parse(s);
			Intent i = new Intent(aan,u);
			i.putExtra("sms_body", m);
			startActivity(i);
		}
		else if(ci.equals("INTERNET"))
		{
			String aan= Intent.ACTION_VIEW;
			Intent i = new Intent(aan,Uri.parse("http://www.google.com"));
			startActivity(i);
		}
		else if(ci.equals("PHONEBOOK VIEW"))
		{
			String aan= Intent.ACTION_VIEW;
			Intent i = new Intent(aan,Uri.parse("content://contacts/people"));
			startActivity(i);
		}
		else if(ci.equals("PHONEBOOK EDIT"))
		{
			String aan= Intent.ACTION_EDIT;
			Intent i = new Intent(aan,Uri.parse("content://contacts/people/2"));
			startActivity(i);
		}
		else if(ci.equals("MESSENGER"))
		{
			Intent i = new Intent(this,Messenger.class);
			startActivity(i);
		}
	}

}