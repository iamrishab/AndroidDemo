package com.example.newapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewDemo2 extends Activity implements OnClickListener {

	
	Button clear,pt,eq;
	Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, cancel, equal;
	EditText disp;
	float op1=0,op2=0;
	String optr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_demo2);
		
		
		clear=(Button)findViewById(R.id.bclear);
		
		pt=(Button)findViewById(R.id.bpoint);
		
		one = (Button) findViewById(R.id.one); 
		two = (Button) findViewById(R.id.two); 
		three = (Button) findViewById(R.id.three); 
		four = (Button) findViewById(R.id.four); 
		five = (Button) findViewById(R.id.five); 
		six = (Button) findViewById(R.id.six); 
		seven = (Button) findViewById(R.id.seven); 
		eight = (Button) findViewById(R.id.eight); 
		nine = (Button) findViewById(R.id.nine); 
		zero = (Button) findViewById(R.id.zero); 
		add = (Button) findViewById(R.id.add); 
		sub = (Button) findViewById(R.id.sub); 
		mul = (Button) findViewById(R.id.mul); 
		div = (Button) findViewById(R.id.div); 
		cancel = (Button) findViewById(R.id.cancel); 
		equal = (Button) findViewById(R.id.equal); 
		disp = (EditText) findViewById(R.id.display);
		
		try{
	
		clear.setOnClickListener(this);
		pt.setOnClickListener(this);
		
		one.setOnClickListener(this); 
		two.setOnClickListener(this); 
		three.setOnClickListener(this); 
		four.setOnClickListener(this); 
		five.setOnClickListener(this); 
		six.setOnClickListener(this); 
		seven.setOnClickListener(this); 
		eight.setOnClickListener(this); 
		nine.setOnClickListener(this); 
		zero.setOnClickListener(this); 
		cancel.setOnClickListener(this); 
		add.setOnClickListener(this); 
		sub.setOnClickListener(this); 
		mul.setOnClickListener(this); 
		div.setOnClickListener(this); 
		equal.setOnClickListener(this);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void operation()
	{ 
	if(optr.equals("+"))
	{ 
		op2 = Float.parseFloat(disp.getText().toString()); 
		disp.setText(""); 
		op1 = op1 + op2; 
		disp.setText(Float.toString(op1)); 
	}
	 else if(optr.equals("-"))
	 { 
		 op2 =Float.parseFloat(disp.getText().toString()); 
		 disp.setText(""); 
		 op1 = op1 - op2; 
		 disp.setText(Float.toString(op1)); 
	}
	 else if(optr.equals("*"))
	{
		 op2 = Float.parseFloat(disp.getText().toString()); 
		 disp.setText(""); 
		 op1 = op1 * op2; 
		 disp.setText(Float.toString(op1)); 
	}
	 else if(optr.equals("/"))
	{
		
		 try{
			 op2 = Float.parseFloat(disp.getText().toString()); 
			 disp.setText(""); 
			op1 = op1 / op2; 
			disp.setText(Float.toString(op1)); 
		 }
		 catch(Exception  e )
		 {
			 Toast.makeText(this,"Error:Divisible by Zero",100).show();
		 }
	}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Editable str = disp.getText(); 
		switch(v.getId())
		{ 
		case R.id.one: 
		if(op2 != 0)
		{ 
			op2 = 0; 
			disp.setText("");
		 } 
		str = str.append(one.getText()); 
		disp.setText(str); 
		break; 
		
		case R.id.two: 
		if(op2 != 0)
		{
		 op2 = 0; disp.setText("");
		 }
		 str = str.append(two.getText());
		 disp.setText(str); 
		break;
		
		 case R.id.three: 
			 if(op2 != 0)
			 { 
			 op2 = 0; disp.setText(""); 
			 } 
		 str = str.append(three.getText()); 
		 disp.setText(str); break; 
		 
		case R.id.four: 
			if(op2 != 0)
			{
				op2 = 0; disp.setText(""); 
			} 
			str = str.append(four.getText()); 
			disp.setText(str); break; 
			
		case R.id.five:
			if(op2 != 0)
			{
				op2 = 0; disp.setText(""); 
			} 
			str = str.append(five.getText()); 
			disp.setText(str); break; 
			
		case R.id.six: 
			if(op2 != 0)
			{
				op2 = 0; disp.setText(""); 
			} 
			str = str.append(six.getText()); 
			disp.setText(str); break; 
			
		case R.id.seven: 
			if(op2 != 0)
			{
				op2 = 0; disp.setText(""); 
			} 
			str = str.append(seven.getText()); 
			disp.setText(str); break; 
			
		case R.id.eight:
			if(op2 != 0)
			{
				op2 = 0; disp.setText(""); 
			}
			str = str.append(eight.getText()); 
			disp.setText(str); break; 
			
		case R.id.nine:
			if(op2 != 0)
			{ 
				op2 = 0; disp.setText(""); 
			} 
			str = str.append(nine.getText()); disp.setText(str); 
			break;
			
		case R.id.zero: 
			if(op2 != 0){ 
				
				op2 = 0; disp.setText(""); 
			}
			str = str.append(zero.getText()); 
			disp.setText(str); 
			break;
			
		case R.id.bpoint:
			if(op2 != 0){
				op2 = 0; 
				disp.setText(""); 
				}
			str = str.append(pt.getText()); 
			disp.setText(str); 
			break;
			
		 case R.id.cancel: 
			 op1 = 0; op2 = 0; 
			 disp.setText(""); 
			  break;
			  
		 case R.id.bclear:
			 disp.setText("");
			 break;
			 
		 case R.id.add: 
			 optr = "+"; 
			 if(op1 == 0){ 
				 op1 = Float.parseFloat(disp.getText().toString()); 
				 disp.setText(""); } 
			 else if(op2 != 0)
			 { 
				 op2 = 0; disp.setText(""); } 
			 else
			 {
				 op2 = Float.parseFloat(disp.getText().toString()); 
				 disp.setText("");
				 op1 = op1 + op2;
				 disp.setText(Float.toString(op1)); 
			 } break; 
			 
			 
		case R.id.sub: 
			optr = "-";
			if(op1 == 0)
				{
				op1 = Float.parseFloat(disp.getText().toString()); 
				disp.setText(""); 
				}
			else if(op2 != 0)
			{ 
				op2 = 0; 
				disp.setText(""); 
				} 
			else
			{ 
				op2 = Float.parseFloat(disp.getText().toString()); 
				disp.setText(""); 
				op1 = op1 - op2; 
				disp.setText(Float.toString(op1)); 
				} 
			break; 
			
		case R.id.mul: 
			optr = "*"; 
			if(op1 == 0)
			{ 
				op1 = Float.parseFloat(disp.getText().toString()); 
				disp.setText(""); 
			} 
			else if(op2 != 0)
				{ 
				op2 = 0; 
				disp.setText(""); 
				} 
			else
				{ 
				op2 = Float.parseFloat(disp.getText().toString()); 
				disp.setText(""); 
				op1 = op1 * op2; 
				disp.setText(Float.toString(op1)); 
				} 
			break; 
			
		case R.id.div: 
			optr = "/"; 
			
			if(op1 == 0)
			{ 
				op1 = Float.parseFloat(disp.getText().toString()); 
				disp.setText(""); 
			} 
			else if(op2 != 0)
			{ 
				op2 = 0; disp.setText(""); 
			} 
	
			else
			{
				op2 = Float.parseFloat(disp.getText().toString()); 
				disp.setText("");
				op1 = op1 / op2; 
				disp.setText(Float.toString(op1)); 
			}
			
			break;
				
		case R.id.equal: 
			 if(!optr.equals(null))
			 { 
				 if(op2 != 0)
				 { 
					 if(optr.equals("+"))
					 { 
					 disp.setText(""); 
					 op1 = op1 + op2; 
					 disp.setText(Float.toString(op1)); 
					 } 
				 else if(optr.equals("-"))
				 { 
					 disp.setText("");
					 op1 = op1 - op2;
					 disp.setText(Float.toString(op1));
				 } 
				 else if(optr.equals("*"))
				 { 
					 disp.setText("");
					 op1 = op1 * op2;
					 disp.setText(Float.toString(op1)); 
				 } 
				 else if(optr.equals("/"))
				 {
					 disp.setText("");
					 op1 = op1 / op2;
					 disp.setText(Float.toString(op1)); 
				 } 
					
					 }
				 else
				 { 
					 operation(); 
				 } 
				 } 
			 break;
		}
		
	}
}

