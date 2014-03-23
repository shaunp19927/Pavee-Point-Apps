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
	int counterForSettingIcons = 0;
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
	    switch(counterForSettingIcons)
	    {
	    case 1:
	    	menu.findItem(R.id.action_news).setIcon(R.drawable.newsfeed_pressed);
	    	break;
	    	
	    case 2:
	    	menu.findItem(R.id.action_social).setIcon(R.drawable.new_social_pressed);
	    	break;
	    
	    case 3:
	    	menu.findItem(R.id.action_contact).setIcon(R.drawable.new_contacts_pressed);
	    	break;
	    	
	    case 4:
	    	menu.findItem(R.id.action_donate).setIcon(R.drawable.new_donate_pressed);
	    	break;
	    	
	    default:
	    	break;
	    }
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_news:
                startActivity(new Intent(getApplicationContext(), RssActivity.class));
                counterForSettingIcons=1;
	            return true;
	        case R.id.action_social:
                startActivity(new Intent(getApplicationContext(), SocialActivity.class));
                counterForSettingIcons=2;
	            return true;
	        case R.id.action_contact:
                startActivity(new Intent(getApplicationContext(), ContactsActivity.class));
                counterForSettingIcons=3;
	        	return true;
	        case R.id.action_donate:
                startActivity(new Intent(getApplicationContext(), DonateActivity.class));
                counterForSettingIcons=4;
	        	return true;
	        default:
	        	counterForSettingIcons = 0;
	            return super.onOptionsItemSelected(item);
	    }
	}

}
