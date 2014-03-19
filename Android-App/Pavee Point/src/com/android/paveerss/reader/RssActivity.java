package com.android.paveerss.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.android.paveerss.reader.data.RssItem;
import com.android.paveerss.reader.util.RssReader;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

 
public class RssActivity extends BaseActivity{
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<RssItem> rss;
    HashMap<String, List<String>> listDataChild;
    RssReader rssReader;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
        
		//Prepare RSS
		try {
			// Create RSS reader
			rssReader = new RssReader("http://www.paveepoint.ie/feed");
			rss = rssReader.getItems();
			prepareListData(rss);
			
		} catch (Exception e) {
			Log.e("Pavee RSS Error", e.getMessage());
		}
		
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
 
        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
 
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                    int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
 
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
 
            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
               /* Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();*/
 
            }
        });
        
     // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {

            	Intent i = new Intent(Intent.ACTION_VIEW);
            	i.setData(Uri.parse(rss.get(groupPosition).getLink()));
        		startActivity(i);
            	
                return false;
            }
            });
            
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData(List<RssItem> list) {
    	
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        
        //add titles of articles
        for(int i = 0; i < list.size(); i++) {
        	listDataHeader.add(list.get(i).getTitle());
        	
        }
        
        //add descriptions
        for(int i = 0; i < list.size(); i++) {
        	List<String> temp = new ArrayList<String>();
        	temp.add(list.get(i).getDescription());
        	listDataChild.put(listDataHeader.get(i), temp);
        	
        }
       
    }

    
}


