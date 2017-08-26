package com.example.newapp;

import android.app.Activity;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Greeting extends Activity implements OnClickListener{
	
	Button ev;
	EditText in;
	TextView op;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_greeting);
		ev=(Button)findViewById(R.id.ga_b1);
		in=(EditText)findViewById(R.id.ga_et1);
		op=(TextView)findViewById(R.id.ga_tv1);
		ev.setOnClickListener(this);
		
		
	}
	
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf= new SimpleDateFormat("HH");
		int time=Integer.parseInt(sdf.format(cal.getTime()));
		String name= in.getText().toString();
		
		
		if(time>0 && time<12)
		{
			String g="MESSAGE HERE:\nGood MorninG "+name;
			op.setText(g);
		}
		else if(time>=12 && time<16)
		{
			String g="MESSAGE HERE:\nGood Afternoon "+name;
			op.setText(g);
		}
		else if(time>=16 && time<20)
		{
			String g="MESSAGE HERE:\nGood Evening "+name;
			op.setText(g);
		}
		else if(time>=20 && time<=24)
		{
			String g="MESSAGE HERE:\nGood Night "+name;
			op.setText(g);
			
		}	
		else
		{
			op.setText("Time Boht Kharab Chal Raha Hain "+name);
		}
	}

	
}
