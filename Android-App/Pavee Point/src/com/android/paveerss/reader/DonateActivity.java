package com.android.paveerss.reader;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), RssActivity.class);
                startActivity(nextScreen);
 
            }
        });

	}


}