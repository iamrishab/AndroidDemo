package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class OtherUIs extends Activity implements OnClickListener{
	AutoCompleteTextView ac;
	Spinner sp;
	Button b1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_uis);
		
		ac=(AutoCompleteTextView)findViewById(R.id.uia_ac1);
		sp=(Spinner)findViewById(R.id.uia_sp1);
		
		b1=(Button)findViewById(R.id.uia_b1);
		b1.setOnClickListener(this);
		ArrayAdapter<String> ad= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Words.wc);
		//ArrayAdapter<String> sa= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Words.wc);
		ac.setAdapter(ad);
		//sp.setAdapter(sa);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String s=sp.getSelectedItem().toString();
		String s1=ac.getEditableText().toString();
		Toast.makeText(this, s+"  "+s1, 100).show();
	}

}