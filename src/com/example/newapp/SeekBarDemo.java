package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarDemo extends Activity implements OnSeekBarChangeListener{

	SeekBar sb;
	ProgressBar pb;
	TextView tv;
	int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar_demo);
		
		sb=(SeekBar)findViewById(R.id.sbd_skbr);
		pb=(ProgressBar)findViewById(R.id.sbd_prbr);
		sb.setMax(100);
		pb.setMax(100);
		tv=(TextView)findViewById(R.id.sbd_tvi);
	t.start();
	sb.setOnSeekBarChangeListener(this);
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		if(fromUser==true)
		{
			i=progress;
		}
		String msg="STATUS:"+progress;
		tv.setText(msg);
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"Seek Start", 100).show();
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"Seek End", 100).show();
		
	}
	Thread t = new Thread(){
		
			public void run()
			{
		for(;i<=100;i++)
		{
			sb.setProgress(i);
			pb.setProgress(i);
			try{
			Thread.sleep(400);
			}catch(Exception e)
			{
				
			}
		}
			}
	};
}