package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DictDemo extends Activity implements OnClickListener{
	
	EditText et1;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dict_demo);
		
		et1=(EditText)findViewById(R.id.dict_et1);
		b1=(Button)findViewById(R.id.dict_b1);
		b1.setOnClickListener(this);
		
		SharedPreferences sp= getSharedPreferences("dictpref", MODE_PRIVATE);
		String sv = sp.getString("et1","");
		et1.setText(sv);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String uw=et1.getText().toString();
		Intent i = new Intent(this,DictResult.class);
		i.putExtra("k1", uw);
		startActivityForResult(i,10);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b= data.getExtras();
		int st = b.getInt("todo");
		if(st==0)
		{
			finish();
		}
		
		else if(st==1)
		{
			et1.setText("");
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		String tts= et1.getText().toString();
		SharedPreferences sp= getSharedPreferences("dictpref", MODE_PRIVATE);
		Editor e =sp.edit();
		e.putString("et1", tts);
		e.commit();
		
		super.onDestroy();
	}

}