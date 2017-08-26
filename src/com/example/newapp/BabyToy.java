package com.example.newapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class BabyToy extends Activity implements OnClickListener{
	
	Button bb1,bb2,bb3,bb4,bb5,bb6;
	ImageButton ib1;
	static MediaPlayer p1,p2,p3,p4,p5,p6;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_baby_toy);
		bb1=(Button)findViewById(R.id.fa_b1);
		bb2=(Button)findViewById(R.id.fa_b2);
		bb3=(Button)findViewById(R.id.fa_b3);
		bb4=(Button)findViewById(R.id.fa_b4);
		bb5=(Button)findViewById(R.id.fa_b5);
		bb6=(Button)findViewById(R.id.fa_b6);
		ib1=(ImageButton)findViewById(R.id.fa_ibt);
		bb1.setOnClickListener(this);
		bb2.setOnClickListener(this);
		bb3.setOnClickListener(this);
		bb4.setOnClickListener(this);
		bb5.setOnClickListener(this);
		bb6.setOnClickListener(this);
		ib1.setOnClickListener(this);
		
		p1=MediaPlayer.create(this, R.raw.horse);
		p2=MediaPlayer.create(this, R.raw.lion);
		p3=MediaPlayer.create(this, R.raw.ele);
		p4=MediaPlayer.create(this, R.raw.duck);
		p5=MediaPlayer.create(this, R.raw.crow);
		p6=MediaPlayer.create(this, R.raw.murga);
		
		
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int id=v.getId();
		switch(id)
		{
		case R.id.fa_b1:
				p1.start();
			break;
		case R.id.fa_b2:
				p2.start();
			
			break;
		case R.id.fa_b3:
			p3.start();
			
			break;
		case R.id.fa_b4:
			
			p4.start();
			break;
		case R.id.fa_b5:
			
			p5.start();
			
			break;
		case R.id.fa_b6:

			p6.start();
			
			break;
		case R.id.fa_ibt:
			finish();
			break;
			
		}
		
	}
}
