package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BroadcastDemo extends Activity implements  OnClickListener{
	
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broadcast_demo);
		
		b1=(Button)findViewById(R.id.bcd_b1);
		b1.setOnClickListener(this);
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent bi= new Intent();
		bi.putExtra("date", "13-jUNE-2016");
		bi.putExtra("duration", "40 MINS");
		bi.putExtra("type", "MCQ");
		bi.setAction("hp.exam.FINAL_EXAM");
		sendBroadcast(bi);
	}
}
