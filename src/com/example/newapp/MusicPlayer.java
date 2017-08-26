package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.media.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MusicPlayer extends Activity implements OnClickListener{
	
	ImageButton play,pause,ff;
	
	static MediaPlayer player;
	Button rst,re,td,cd,st;
	EditText et;
	int i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_player);
		
		 play=(ImageButton)findViewById(R.id.mp_pl);
		 
		 pause=(ImageButton)findViewById(R.id.mp_pa);
		 ff=(ImageButton)findViewById(R.id.mp_ff);
		 et=(EditText)findViewById(R.id.mp_et1);
		 rst=(Button)findViewById(R.id.mp_rst);
		 re=(Button)findViewById(R.id.mp_rl);
		 td=(Button)findViewById(R.id.mp_du);
		 cd=(Button)findViewById(R.id.mp_cdu);
		 st=(Button)findViewById(R.id.mp_st);
		 
		 play.setOnClickListener(this);
		 pause.setOnClickListener(this);
		 et.setOnClickListener(this);
		 ff.setOnClickListener(this);
		 rst.setOnClickListener(this);
		 re.setOnClickListener(this);
		 td.setOnClickListener(this);
		 cd.setOnClickListener(this);
		 st.setOnClickListener(this);
		if(player==null)
		{
		 player=MediaPlayer.create(this,R.raw.abc);
		}
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.mp_pl: player.start();
		break;
		case R.id.mp_pa: player.pause();
			break;
		case R.id.mp_st:  
			if(player.isPlaying()==true)
			{
				et.setText("Currently playing");
			}
			else
			{
				et.setText("Currently off");
			}
			break;
			
		case R.id.mp_rl: player.release();
		int d= Toast.LENGTH_SHORT;
		Toast t = Toast.makeText(this, "Released!!", d);
		t.show();
		break;
		
		case R.id.mp_rst: player.reset();
		int d1= Toast.LENGTH_SHORT;
		Toast t1 = Toast.makeText(this, "Reset!!", d1);
		t1.show();
		break;
		
		case R.id.mp_du: 
			int dms=player.getDuration();
		int ds=dms/1000;
		int dm=ds/60;
		ds=ds%60;
		String s=dm+":"+ds;
		et.setText("Total Duration: "+s);
		break;
		
		case R.id.mp_cdu: 
		int dms1=player.getCurrentPosition();
		int ds1=dms1/1000;
		int dm1=ds1/60;
		ds1=ds1%60;
		String s1=dm1+":"+ds1;
		et.setText("Current Duration: "+s1);
		break;
		
		case R.id.mp_ff: int n=player.getCurrentPosition();
		int ndms= n+5000;
			player.seekTo(ndms);
		break;
		}
	}

	
}
