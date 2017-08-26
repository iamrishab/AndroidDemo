package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends Activity implements OnClickListener{
	
	Button inc,dec,b4;
	ImageButton reset;
	TextView tv1;
	int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		tv1=(TextView)findViewById(R.id.fa_tv2);// we have to get the ids of the components that we are going to use in our activity
		inc=(Button)findViewById(R.id.fa_bt1);//from the adjacent function
		dec=(Button)findViewById(R.id.fa_btt2);
		reset=(ImageButton)findViewById(R.id.fa_bt3);
		b4=(Button)findViewById(R.id.fa_b4);
		inc.setOnClickListener(this);// to activate the buttons
		dec.setOnClickListener(this);
		reset.setOnClickListener(this);
		b4.setOnClickListener(this);
		apnaToast("Welcome Rishab!!");
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int sourceId=v.getId();
		if(sourceId==R.id.fa_bt1)
		{
			counter=counter+1;
		}
		else if(sourceId==R.id.fa_btt2)
		{
			counter=counter-1;
			if(counter==-1)
				apnaToast("Counter gives -ve values");
		}
		else if(sourceId==R.id.fa_bt3)
		{
			counter=0;
		}
		else if(sourceId==R.id.fa_b4)
		{
			//Intent i = new Intent(this,Second.class);
			//Intent i = new Intent("hp.app.Second");
			Intent i = new Intent(this,ALCDemo.class);
			startActivity(i);
		}
		/* if(counter!=0)
		{
			reset.setBackgroundResource(R.drawable.tick);
		}*/
		String op="COUNTER:"+counter;
		tv1.setText(op);
		
		
	}
	
	void apnaToast(String msg){
		int d= Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this, msg, d);
		t.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
