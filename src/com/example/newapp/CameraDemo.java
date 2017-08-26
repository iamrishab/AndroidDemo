package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraDemo extends Activity implements OnClickListener{
	
	Button b1;
	ImageView pic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera_demo);
		
		b1=(Button)findViewById(R.id.cam_b1);
		pic= (ImageView)findViewById(R.id.cam_pic);
		
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		String cia= MediaStore.ACTION_IMAGE_CAPTURE;
		Intent ca= new Intent(cia);
		startActivityForResult(ca, 10);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b= data.getExtras();
		Bitmap img = (Bitmap)b.get("data");
		pic.setImageBitmap(img);
	}
}