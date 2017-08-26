package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LoginPage extends Activity implements OnClickListener{
	Button b1,b2;
	EditText t1,t2,t3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);
		b1=(Button)findViewById(R.id.l_b1);
		b2=(Button)findViewById(R.id.l_b2);
		t1=(EditText)findViewById(R.id.l_et1);
		t2=(EditText)findViewById(R.id.l_et2);
		t3=(EditText)findViewById(R.id.l_et3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int d=v.getId();
		if(d==R.id.l_b1)
		{
			String s=t1.getText().toString();
			String s2=t2.getText().toString();
			for(int i=0;i<LoginDB.lid.length;i++)
			{
				if(s.equals(LoginDB.lid[i])==true && s2.equals(LoginDB.pass[i])==true)
				{
					Intent i1 = new Intent(this,WelcomePage.class);
					startActivity(i1);
					finish();
				}
				else
				{
					t3.setText("Invalid");
				}
			}
		}
		else if(d==R.id.l_b2)
		{
			finish();
		}
		
	}

}