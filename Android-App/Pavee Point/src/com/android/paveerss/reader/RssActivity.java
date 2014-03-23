package com.android.paveerss.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.android.paveerss.reader.data.RssItem;
import com.android.paveerss.reader.util.RssReader;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

 
public class RssActivity extends BaseActivity{
 
    ExpandableAda listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<RssItem> rss;
    HashMap<String, List<String>> listDataChild;
    RssReader rssReader;
	String Filename = "rss_file";
	FileOutputStream fos;
	ObjectOutputStream oos;
	FileInputStream fin;
	ObjectInputStream oin;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.rss_layout);
		
		// if network is on, check for updates from rss feed and display
		if(isNetworkConnected()) {
			//Prepare RSS
			try {
				// Create RSS reader

				rssReader = new RssReader("http://www.paveepoint.ie/feed");
				rss = rssReader.getItems();
				
				prepareListData(rss);
				setup();
		
			} catch (Exception e) {
				Log.e("Pavee RSS Error", e.getMessage());
			}
			
			// update file
			try {				fos = openFileOutput(Filename, Context.MODE_PRIVATE);			} 
			catch (FileNotFoundException e1) {				e1.printStackTrace();			}
			
			try {				fos.write(convertToString(rss).getBytes());			} 
			catch (IOException e) {				e.printStackTrace();			}
			
			try {				fos.close();			} 
			catch (IOException e1) {				e1.printStackTrace();			}
			
		}
		else{
			
			
			// display whats on file first
			try {				fin = openFileInput(Filename); } 
			catch (FileNotFoundException e) { e.printStackTrace(); }
			
			int c;
			String temp="";
			try {
				while( (c = fin.read()) != -1){
					   temp += Character.toString((char)c);
					}
			} catch (IOException e) {				e.printStackTrace();			}
				//string temp contains all the data of the file.
				try {					fin.close();				} 
				catch (IOException e) {					e.printStackTrace();				}
			
				System.out.println(temp);
			// if something is on file
			if(temp.length() > 5){
				rss = convertToList(temp);
				prepareListData(rss);
				setup();
				Toast.makeText(getApplicationContext(),
			            "Internet Connection Required to Update News!",
			            Toast.LENGTH_SHORT).show();
			}
			else {
					// nothing on file and no network - display message network required
		            Toast.makeText(getApplicationContext(),
		            "Internet Connection Required!",
		            Toast.LENGTH_SHORT).show();
				
			}

		}
      
    }
	
	public void setup(){
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
 
        listAdapter = new ExpandableAda(this, listDataHeader, listDataChild);
 
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
    
	public void onClickRefresh(View v){
		
		// if network is on, check for updates from rss feed and display
				if(isNetworkConnected()) {
					//Prepare RSS
					try {
						// Create RSS reader

						rssReader = new RssReader("http://www.paveepoint.ie/feed");
						rss = rssReader.getItems();
						
						prepareListData(rss);
						setup();
				
					} catch (Exception e) {
						Log.e("Pavee RSS Error", e.getMessage());
					}
					
					// update file
					try {				fos = openFileOutput(Filename, Context.MODE_PRIVATE);			} 
					catch (FileNotFoundException e1) {				e1.printStackTrace();			}
					
					try {				fos.write(convertToString(rss).getBytes());			} 
					catch (IOException e) {				e.printStackTrace();			}
					
					try {				fos.close();			} 
					catch (IOException e1) {				e1.printStackTrace();			}
					
				}
				else {
					Toast.makeText(getApplicationContext(),
				            "Internet Connection Required !",
				            Toast.LENGTH_SHORT).show();
				}
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
    
    private boolean isNetworkConnected() {
    	  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    	  NetworkInfo ni = cm.getActiveNetworkInfo();
    	  if (ni == null) {
    	   // There are no active networks.
    	   return false;
    	  } else
    	   return true;
    	 }
    
    private String convertToString(List<RssItem> list){
    	String result = "";
    	
    	for(int i = 0; i < list.size(); i++) {
    		RssItem anItem = list.get(i);
    		result += anItem.getTitle() + "-sep-" + anItem.getLink() + "-sep-" + anItem.getDescription() + "-sep-";
    	}
    	
    	
    	return result;
    }
    
    private List<RssItem> convertToList(String s) {
    	List<RssItem> result = new ArrayList<RssItem>();
    	
    	String[] temp = s.split("-sep-");
//    	for(int i = 0; i < temp.length; i++){
//    		System.out.println(i +": " +temp[i] + " || ");
//    	}
    	for(int i = 0; i < temp.length; i+= 3) {
    		RssItem anItem = new RssItem();
    		anItem.setTitle(temp[i]);
    		anItem.setLink(temp[i+1]);
    		anItem.setDescription(temp[i+2]);
    		result.add(anItem);
    	}
    	
    	return result;
    }

    
}