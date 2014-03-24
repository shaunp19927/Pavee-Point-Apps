package com.android.paveerss.reader;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class DonateActivity extends BaseActivity {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donate);
		
		Button btnPaypal = (Button) findViewById(R.id.button1);
				
		//Listening to button event
        btnPaypal.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                
            	if(isNetworkConnected()) {
            	//Starting a new Intent
            	Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/webapps/mpp/send-money-online"));
                startActivity(browserIntent);
            	} else {
            		Toast.makeText(getApplicationContext(),
        		            "Internet Connection Required!",
        		            Toast.LENGTH_SHORT).show();
            		
            	}
            }
        });

	}

    private boolean isNetworkConnected() {
  	  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
  	  NetworkInfo ni = cm.getActiveNetworkInfo();
  	  if (ni == null) {
  	   // There are no active networks.
  	   return false;
  	  } else
  	   return true;
  	 }

}