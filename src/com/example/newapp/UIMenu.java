package com.example.newapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UIMenu extends ListActivity {
	String[] mi={"edit Text","Button","Text View"};
	Class[] act={};

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
		else
		{
			int d=Toast.LENGTH_SHORT;
			Toast t =Toast.makeText(this,"Coming soon",d );
			t.show();
			
			/*Intent i= new Intent(this,act[position]);
			startActivity(i);
		/*String msg=ci+" CLICKED ";
		Toast.makeText(this,msg, 100).show();*/
		}
	}

}