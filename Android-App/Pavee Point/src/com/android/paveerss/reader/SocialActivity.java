package com.android.paveerss.reader;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SocialActivity extends BaseActivity {
	
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
            	Intent facebookIntent;
            	try {
                    getApplicationContext().getPackageManager()
                            .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
                    facebookIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("fb://profile/100003614494122")); //Trys to make intent with FB's URI
                } catch (Exception e) {
                    facebookIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/paveepoint")); //catches and opens a url to the desired page
                }
            	
            	startActivity(facebookIntent);
            }
        });
        
      //Listening to facebook like page button event
        btnLike.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
            	 //Starting a new Intent
            	Intent facebookIntent;
            	
            	try {
                    getApplicationContext().getPackageManager()
                            .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
                    facebookIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("fb://page/267917619901925")); //Trys to make intent with FB's URI
                } catch (Exception e) {
                    facebookIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.facebook.com/paveepointtrc")); //catches and opens a url to the desired page
                }
            	
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