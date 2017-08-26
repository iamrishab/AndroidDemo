package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CBDemo extends Activity implements OnClickListener {

	CheckBox cb1,cb2,cb3,cb4;
	TextView t1;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cbdemo);
		
		cb1=(CheckBox)findViewById(R.id.cbd_c1);
		cb2=(CheckBox)findViewById(R.id.cbd_c2);
		cb3=(CheckBox)findViewById(R.id.cbd_c4);
		cb4=(CheckBox)findViewById(R.id.cbd_c5);
		t1=(TextView)findViewById(R.id.cbd_tv);
		b1=(Button)findViewById(R.id.cbd_b1);
		
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stu 
		String order="ORDER DETAILS \n";
		int d=v.getId();
		if(d==R.id.cbd_b1)
		{
		
		if(cb1.isChecked()==true)
		{
			order=order+"\nCoffee";
		}
		if(cb2.isChecked()==true)
		{
			order=order+"\nCold Drink";
		}
		if(cb3.isChecked()==true)
		{
			order=order+"\nMaggie";
		}
		if(cb4.isChecked()==true)
		{
			order=order+"\nPopcorn";
		}
						
		t1.setText(order);
	}
	

}
}