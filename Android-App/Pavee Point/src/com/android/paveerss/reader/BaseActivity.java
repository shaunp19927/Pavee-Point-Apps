package com.android.paveerss.reader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set the colour of the action bar
		getActionBar()
			.setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#7C9738"))
				);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_news:
                startActivity(new Intent(getApplicationContext(), RssActivity.class));
	            return true;
	        case R.id.action_social:
                startActivity(new Intent(getApplicationContext(), SocialActivity.class));
	            return true;
	        case R.id.action_contact:
                startActivity(new Intent(getApplicationContext(), ContactsActivity.class));
	        	return true;
	        case R.id.action_donate:
                startActivity(new Intent(getApplicationContext(), DonateActivity.class));
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
