package com.android.paveerss.reader.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class ListItem{
	public static final String EMPTY = "";
	private String name = EMPTY;
	private String address = EMPTY;
	private List<String> tel = new ArrayList<String>();
	private List<String> email = new ArrayList<String>();
	private String website = EMPTY;
	private String extra = EMPTY;
		
	public ListItem(
			String name, String address, String tel, String email)
		{
			this.name = name; 		
			this.address = address;
			if (tel!=EMPTY) this.tel.add(tel); 
			if (email!= EMPTY) this.email.add(email);
		}
	
	public ListItem addTel(String tel){
		this.tel.add(tel);
		return this;
	}
	
	public ListItem addEmail(String email){
		this.email.add(email);
		return this;
	}
	
	public ListItem addWebsite(String website){
		this.website = website;
		return this;
	}
	
	public ListItem addExtra(String extra){
		this.extra += extra;
		return this;
	}
	
	public void onClick(Context context){
		Log.i("ListItem", "onClick child");
		if (!this.tel.isEmpty()){
			Intent intent = new Intent(Intent.ACTION_DIAL);
			intent.setFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);                     
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setData(Uri.parse("tel:"+this.tel.get(0)));
			context.startActivity(intent);
		}
		else Log.i("ListItem","no number for child");
	}

	public String toString(){
		String result = "";

		result += ( (name != EMPTY)?(name+"\n"):("") );
		result += ( (address != EMPTY)?("Addr:"+address+"\n"):(""));
		for (String t:tel) result+=("Tel:"+t+"\n");
		for (String e:email) result+=("Email:"+e+"\n");
		result += ( (website  != EMPTY)?("Website:"+website+"\n"):(""));
		result += ( (extra != EMPTY)?(extra):("") );

		return result;
	}

}
