package com.example.newapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ExamReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Bundle b= intent.getExtras();
		String time = b.getString(ExamManager.KEY_TIME);
		String type = b.getString(ExamManager.KEY_TYPE);
		String date = b.getString(ExamManager.KEY_DATE);
		
		String op = "EXAM INFORMATION\n-------";
		
		op=op+"\n DATE : "+date;
		op=op+"\n TIME : "+time;
		op=op+"\n TYPE : "+type;
		
		Toast.makeText(context, op, Toast.LENGTH_LONG).show();
	}

}
