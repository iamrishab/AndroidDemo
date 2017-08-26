package com.example.newapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileDemo extends Activity implements OnClickListener{
	
	Button b1,b2;
	EditText et1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_demo);
		
		b1=(Button)findViewById(R.id.fd_b1);
		b2=(Button)findViewById(R.id.fd_b2);
		et1=(EditText)findViewById(R.id.fd_data);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		
		File mnt = new File("/mnt");
		String [] files= mnt.list();
		String f= "";
		for(int i=0;i<files.length;i++)
		{
			f=f+files[i]+"\n";
		}
		Toast.makeText(this, f, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_demo, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id= v.getId();
		try{
		if(id==R.id.fd_b1)//READ
		{
			File sdcard= Environment.getExternalStorageDirectory();
			//File sdcard = new File("mnt/usb");
			String fp=sdcard.getPath()+"/data1.txt";
			FileInputStream fis= new FileInputStream(fp);
			String fc="";
			int a;
			while(true)
			{
				a=fis.read();
				if(a==-1)
					break;
				fc=fc+(char)a;
			}
			et1.setText(fc);
		}
		else if(id==R.id.fd_b2)//WRITE
		{
			File sdcard= Environment.getExternalStorageDirectory();
			//File sdcard = new File("/mnt/usb");
			String fp=sdcard.getPath()+"/data1.txt";
			FileOutputStream fos= new FileOutputStream(fp);
			String s=et1.getText().toString();
			byte[ ] data= s.getBytes();
			fos.write(data);
			Toast.makeText(this, "FILE SAVED!!!", 100).show();
		}
		}
		catch(Exception e)
		{
			String err= "ERROR FOUND "+e.getMessage();
			Toast.makeText(this, err, 100).show();
		}
	}
}
