package com.android.paveerss.reader;



import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.paveerss.reader.data.RssItem;
import com.android.paveerss.reader.listeners.ListListener;
import com.android.paveerss.reader.util.RssReader;

public class RssActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rss_layout);
		
		//Prepare RSS
		try {
			// Create RSS reader
			RssReader rssReader = new RssReader("http://www.paveepoint.ie/feed");
			// Get a ListView from main view
			ListView itcItems = (ListView) findViewById(R.id.listMainView);

			// Create a list adapter
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,android.R.layout.simple_list_item_1, rssReader.getItems());
			
			// Set list adapter for the ListView
			itcItems.setAdapter(adapter);

			// Set list view item click listener
			itcItems.setOnItemClickListener(new ListListener(rssReader.getItems(), this));
			
		} catch (Exception e) {
			Log.e("Pavee RSS Error", e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}