package com.android.paveerss.reader;


import com.android.paveerss.reader.data.RssItem;
import com.android.paveerss.reader.listeners.ListListener;
import com.android.paveerss.reader.util.RssReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button btnRss = (Button) findViewById(R.id.button1);
		Button btnSocial = (Button) findViewById(R.id.button2);
		Button btnContacts = (Button) findViewById(R.id.button3);
		Button btnDonate = (Button) findViewById(R.id.button4);
		
		//Listening to rss button event
        btnRss.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), RssActivity.class);
                startActivity(nextScreen);
 
            }
        });
        
      //Listening to social media button event
        btnSocial.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), SocialActivity.class);
                startActivity(nextScreen);
 
            }
        });
        
        //Listening to contacts button event
        btnContacts.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), ContactsActivity.class);
                startActivity(nextScreen);
 
            }
        });
        
        //Listening to contacts button event
        btnDonate.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), DonateActivity.class);
                startActivity(nextScreen);
 
            }
        });

	}


}