package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ALCDemo extends Activity implements OnClickListener{
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alcdemo);
		apnaToast("ON-CREATE CALLED");
		
		b1=(Button)findViewById(R.id.alc_b1);
		b1.setOnClickListener(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		apnaToast("ON-DESTROY CALLED");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		apnaToast("ON-START CALLED");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		apnaToast("ON-RESTART CALLED");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		apnaToast("ON-RESUME CALLED");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		apnaToast("ON-PAUSE CALLED");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		apnaToast("ON-STOP CALLED");
	}
	void apnaToast(String msg){
		int d= Toast.LENGTH_LONG;
		Toast t= Toast.makeText(this, msg, d);
		t.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent(this,Second.class);
		startActivity(i);
		
	}

}