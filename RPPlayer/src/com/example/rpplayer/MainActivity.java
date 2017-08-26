package com.example.rpplayer;

import java.io.File;

import com.example.rpplayer.*;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener {

	ImageButton play,pause,ff,stop;
	SeekBar sb;
	EditText et;
	static MediaPlayer p;
	ToggleButton stat;
	int i=0;
	int count =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		play=(ImageButton)findViewById(R.id.rp_pl);
		et=(EditText)findViewById(R.id.rp_et1);
		pause=(ImageButton)findViewById(R.id.rp_pa);
		ff=(ImageButton)findViewById(R.id.rp_ff);
		stop=(ImageButton)findViewById(R.id.rp_st);
		stat=(ToggleButton)findViewById(R.id.rp_tb1);
		sb=(SeekBar)findViewById(R.id.rp_sb1);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		ff.setOnClickListener(this);
		stop.setOnClickListener(this);
		stat.setOnClickListener(this);
		sb.setOnSeekBarChangeListener(this);
		
		if(p==null)
		{
			//p=MediaPlayer.create(this, R.raw.abc);
			File sd= new File("/mnt/sdcard");
			String sp=sd.getPath()+"/Too Cheez Badi hai.mp3";
			p=new MediaPlayer();
			try
			{
				p.setDataSource(sp);
				p.prepare();
			}
			catch(Exception e)
			{
				
			}
		}
		sb.setMax(p.getDuration());
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
			
		switch(v.getId())
		{
		case R.id.rp_pl: p.start();
		if(count==0)
			t.start();
		count++;
		
		break;
		
		case R.id.rp_pa: p.pause();
			break;
			
		case R.id.rp_tb1:  
			
			if(p.isPlaying()==true)
			{
				stat.setEnabled(true);
				
				et.setText("Currently playing");
			}
			else
			{
				stat.setEnabled(false);
				
				et.setText("Currently off");
			}
			break;
			
		case R.id.rp_st: p.stop();
		Toast.makeText(this,"Stop",100).show();
		break;
		
		case R.id.rp_ff: int d=p.getCurrentPosition();
		int f=d+5000;
		p.seekTo(f);
	}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		if(fromUser==true)
		{
			sb.setProgress(progress);
			p.seekTo(progress);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub	
	}
	Thread t = new Thread(){
		public void run()
		{
			for(;i<=p.getDuration();i=p.getCurrentPosition())
			{
				if(p.isPlaying()==true)
				sb.setProgress(i);
				else
				{
					sb.setProgress(p.getCurrentPosition());
				}
			}
		}
	};
}