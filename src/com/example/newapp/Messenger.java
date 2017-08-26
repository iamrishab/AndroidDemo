package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Messenger extends Activity implements OnClickListener{
	
	EditText et1,et2;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messenger);
		
		et1=(EditText)findViewById(R.id.msg_tv1);
		et2=(EditText)findViewById(R.id.msg_tv2);
		b1=(Button)findViewById(R.id.msg_b1);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String a=et1.getText().toString();
		String a1=et2.getText().toString();
		String aan = Intent.ACTION_SENDTO;
		String s = "sms:"+a;
		String m=a1;
		Uri u = Uri.parse(s);
		Intent i = new Intent(aan,u);
		i.putExtra("sms_body", m);
		startActivity(i);
		
	}

}