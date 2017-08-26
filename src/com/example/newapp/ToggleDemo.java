package com.example.newapp;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleDemo extends Activity implements android.view.View.OnClickListener{

	ToggleButton tb;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_demo);
		tv=(TextView)findViewById(R.id.td_tv1);
		tb=(ToggleButton)findViewById(R.id.td_tb1);
		tb.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Boolean tb_st=tb.isChecked();
		if(tb_st== true)
		{
			tv.setText("WELCOME Rishab");
		}
		else{
			tv.setText("");
		}
		
	}

}