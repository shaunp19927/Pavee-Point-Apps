package com.android.paveerss.reader;


import com.android.paveerss.reader.data.RssItem;
import com.android.paveerss.reader.listeners.ListListener;
import com.android.paveerss.reader.util.RssReader;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class SocialActivity extends Activity {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social);
		
		
		Button btnFace = (Button) findViewById(R.id.button1);
		Button btnLike = (Button) findViewById(R.id.button2);
		Button btnTwi = (Button) findViewById(R.id.button3);
		
		
		//Listening to facebook page button event
        btnFace.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
            	Intent facebookIntent = new Intent(Intent.ACTION_VIEW,
    		            Uri.parse("https://www.facebook.com/paveepoint"));
            	startActivity(facebookIntent);
 
            }
        });
        
      //Listening to facebook like page button event
        btnLike.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
            	 //Starting a new Intent
            	Intent facebookIntent = new Intent(Intent.ACTION_VIEW,
    		            Uri.parse("https://www.facebook.com/paveepointtrc"));
            	startActivity(facebookIntent);
 
            }
        });
        
        //Listening to facebook like page button event
        btnTwi.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
            	 //Starting a new Intent
            	Intent twitterIntent = new Intent(Intent.ACTION_VIEW,
    		            Uri.parse("https://twitter.com/PaveePoint"));
            	startActivity(twitterIntent);
 
            }
        });
	}
	


}