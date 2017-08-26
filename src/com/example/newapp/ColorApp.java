package com.example.newapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ColorApp extends Activity implements OnSeekBarChangeListener,OnClickListener{
	
	SeekBar sb1,sb2,sb3;
	TextView tv1,tv2;
	int a,b,c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_app);
		
		sb1=(SeekBar)findViewById(R.id.ca_sb1);
		sb2=(SeekBar)findViewById(R.id.ca_sb2);
		sb3=(SeekBar)findViewById(R.id.ca_sb3);
		
		tv1=(TextView)findViewById(R.id.ca_tv1);
		tv2=(TextView)findViewById(R.id.ca_tv2);
		
		sb1.setMax(255);
		sb2.setMax(255);
		sb3.setMax(255);
		sb1.setOnSeekBarChangeListener(this);
		sb2.setOnSeekBarChangeListener(this);
		sb3.setOnSeekBarChangeListener(this);
		
	}
	
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			
			
				
a=sb1.getProgress();
b=sb2.getProgress();
c=sb3.getProgress();
tv1.setBackgroundColor(Color.rgb(a, b,c));
tv2.setText(String.format("CODE: #%02x%02x%02x", a,b,c));
		
	}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
}
