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
import android.widget.TextView;

public class DictResult extends Activity implements OnClickListener{

	int resp=2;
	TextView tv1,tv2,tv3;
	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dict_result);
		
		tv1=(TextView)findViewById(R.id.dictres_tv1);
		tv2=(TextView)findViewById(R.id.dictres_tv2);
		tv3=(TextView)findViewById(R.id.dictres_tv3);
		b1=(Button)findViewById(R.id.dictres_b1);
		b2=(Button)findViewById(R.id.dictres_b2);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
		Intent ri = getIntent();// this intent will provide the information of that intent with the help of which the current intent is opened
		Bundle data= ri.getExtras();
		String rw= data.getString("k1");
		tv1.setText("WORD :"+rw);
		find(rw);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id= v.getId();
		if(id==R.id.dictres_b1)
		{
			resp=1;
			finish();
		}
		
		else if(id==R.id.dictres_b2)
		{
			resp=0;
			finish();
		}
	}
	
	void find(String rw){
		Boolean flag=false;
		int i;
		for(i=0;i<DictDB.w.length;i++)
		{
			if(DictDB.w[i].equalsIgnoreCase(rw))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			tv2.setText("MEANING :"+DictDB.m[i]);
		}
		else
		{
			tv3.setText("WORD NOT FOUND!!");
		}
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.putExtra("todo", resp);
		setResult(RESULT_OK, i);
		super.finish();
	}
	
}