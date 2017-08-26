package com.example.newapp;

import android.net.Uri;

public class StudentContract {
	
	public static String  STU_RN = "rollno";
	public static String  STU_Name = "name";

	static String address = "content://rcpl.stuaccess.in";
	public static Uri STU_URI = Uri.parse(address);

}
