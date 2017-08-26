package com.example.newapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class RBDemo extends Activity implements OnClickListener{
	
	Button b1,b2;
	RadioButton r1,r2,r3,r4,r5,r6;
	RelativeLayout screen;
	RadioGroup rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rbdemo);
		rg=(RadioGroup)findViewById(R.id.rbd_rg1);
		screen=(RelativeLayout)findViewById(R.id.rbd_scr);
		r1=(RadioButton)findViewById(R.id.rbd_r1);
		r2=(RadioButton)findViewById(R.id.rbd_r2);
		r3=(RadioButton)findViewById(R.id.rbd_r3);
		r4=(RadioButton)findViewById(R.id.rbd_r4);
		r5=(RadioButton)findViewById(R.id.rbd_r5);
		r6=(RadioButton)findViewById(R.id.rbd_r6);
		b1=(Button)findViewById(R.id.rbd_bu1);
		b2=(Button)findViewById(R.id.rbd_bu2);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rg.clearCheck();
				screen.setBackgroundColor(Color.WHITE);
				
			}
		});
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(r1.isChecked())
		{
			screen.setBackgroundColor(Color.YELLOW);
		}
		if(r2.isChecked())
		{
			screen.setBackgroundColor(Color.BLUE);
		}
		if(r3.isChecked())
		{
			screen.setBackgroundColor(Color.GREEN);
		}
		if(r4.isChecked())
		{
			screen.setBackgroundColor(Color.GRAY);
		}
		if(r5.isChecked())
		{
			screen.setBackgroundColor(Color.MAGENTA);
		}
		if(r6.isChecked())
		{
			screen.setBackgroundColor(Color.CYAN);
		}
		
	}
}