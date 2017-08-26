package com.example.newapp;

import android.app.AlertDialog;
import android.graphics.Color;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class AppMenu extends ListActivity {
	String[] mi={"Color Mixer","Final MEnu","CP Demo","File Access","SETTING PAGE","INTENT MENU","English Dictionary","CALCULATOR APP.","ANDROID MENUS","LayoutDemo","ASSIGNMENT","other UIs","Seek Bar","Radio Button","Check Box Demo","Toggle Demo","Baby Toy","Music Time","Service Control","GUI Controls","Greeting Screen","LIFE Cycle Demo","Second Screen","Counter Screen","FAKE CALL","EXIT"};
	Class[] act={ColorApp.class,FinalMenu.class,CPDemo.class,FileDemo.class,SettingPage.class,IntentMenu.class,DictDemo.class,CalciHome.class,MenuDemo.class,ViewDemo.class,LoginPage.class,OtherUIs.class,SeekBarDemo.class,RBDemo.class,CBDemo.class,ToggleDemo.class,BabyToy.class,MusicPlayer.class,ServiceDemo.class,UIMenu.class,Greeting.class,ALCDemo.class,Second.class,MainActivity1.class};
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_menu);
		
		ArrayAdapter<String> ad;
		ad= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi );
		
		setListAdapter(ad);
		//showWelcomeDialog();
		pd= new ProgressDialog(this);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setMessage("Loading...");
		pd.setIndeterminate(true);
		pd.setCancelable(true);
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		boolean pts = sp.getBoolean("pt", false);
		String c=sp.getString("bd", "white");
		Toast.makeText(this, c, 100).show();
		if(pts==true)
		{
			pd.show();
		}
		
		Thread t = new Thread(){
			public void run(){
				try{
					Thread.sleep(500);
					pd.dismiss();
				}catch(Exception e)
				{
					
				}
			}
		};
		t.start();
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ci= mi[position];
		if(ci.equals("EXIT")){
			//finish();
			showExitConfirmDialog();
		}
		
		else if(ci.equals("FAKE CALL"))
		{
			Notification.Builder b= new Notification.Builder(this);
			b.setContentTitle("deepak");
			b.setContentText("5 missed Calls");
			b.setAutoCancel(true);
			b.setSmallIcon(android.R.drawable.stat_notify_missed_call);
			
			Intent i = new Intent(this,RBDemo.class);
			PendingIntent pi= PendingIntent.getActivity(this, 0, i, 0);
			b.addAction(android.R.drawable.ic_dialog_email, "MESSAGE", pi);
			b.addAction(android.R.drawable.stat_sys_phone_call, "CALL", pi);
			//b.setContentIntent(pi);
			
			Notification n= b.build();
			n.defaults = Notification.DEFAULT_SOUND;
			String nsn = Context.NOTIFICATION_SERVICE;
			NotificationManager nm= (NotificationManager)getSystemService(nsn);
			int i1= (int) (1000*Math.random());
			nm.notify(i1,n);
		}
		else
		{
			Intent i= new Intent(this,act[position]);
			startActivity(i);
		/*String msg=ci+" CLICKED ";
		Toast.makeText(this,msg, 100).show();*/
		}
	}
	
	void showWelcomeDialog()
	{
		AlertDialog.Builder b= new AlertDialog.Builder(this);
		b.setTitle("MY APP");
		b.setMessage("WELCOME TO MY APP DEVELOPMENT");
		b.setIcon(R.drawable.tick);
	
		b.setPositiveButton("OK", null);
		AlertDialog d= b.create();
		d.show();
	}
	
	void showExitConfirmDialog()
	{
		AlertDialog.Builder b= new AlertDialog.Builder(this);
		b.setTitle("EXIT APP");
		b.setMessage("Are You Sure To Exit?");
		b.setIcon(android.R.drawable.ic_delete);
		b.setPositiveButton("YES", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		b.setNegativeButton("NO", null);
		AlertDialog d= b.create();
		d.show();
	}
}