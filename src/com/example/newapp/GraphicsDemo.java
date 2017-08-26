package com.example.newapp;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GraphicsDemo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		MyDesign md= new MyDesign(this);
		setContentView(md);
	}

}

class MyDesign extends View
{
Context ct;
	public MyDesign(Context context) {
		super(context);
		ct = context;
		// TODO Auto-generated constructor stub
	}
	int y=500;
	int x=0;
	@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			canvas.drawColor(Color.CYAN);
			Paint cp = new Paint();
			cp.setColor(Color.RED);
			int w= canvas.getWidth();
			int h=canvas.getHeight();
			canvas.drawCircle(w/2, y, 150, cp);
			Paint tp = new Paint();
			tp.setColor(Color.BLUE);
			tp.setTextSize(25);
			canvas.drawText("developed By: Rishab Pal", x, h-50, tp);
			
			Bitmap img= BitmapFactory.decodeResource(getResources(), R.drawable.duck);
			canvas.drawBitmap(img, 40,80, null);
			if(x<w)
			{
				x++;
			}
			else 
			{
				x=0;
			}
			if(y!=0)
			{
			y--;
			}
			Color[] arr = {};
			invalidate(); //to referesh or recall the ondraw method
		}
	
}