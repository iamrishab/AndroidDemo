package com.example.newapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		int d= Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this,"Service Created", d);
		t.show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		int d= Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this,"Service REFRESH", d);
		t.show();
		return super.onStartCommand(intent, flags, startId);
		
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
		super.onDestroy();
		int d= Toast.LENGTH_SHORT;
		Toast t= Toast.makeText(this,"Service DESTROYED", d);
		t.show();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
