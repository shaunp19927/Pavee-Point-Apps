package com.android.paveerss.reader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
 
public class ContactsActivity extends Activity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
 
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
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
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
 
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                        listDataHeader.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("Dublin");
        listDataHeader.add("Cork");
        listDataHeader.add("Limerick");
 
        // Adding child data
        List<String> dublin = new ArrayList<String>();
        dublin.add("Hospital    Tel: 019999999");
        dublin.add("Pet Shop    Tel: 012222222");
        dublin.add("Pavee Point Tel: 015555555");
        dublin.add("			Mob: 087555555");
        dublin.add("Church      Tel: 013333333");

 
        List<String> cork = new ArrayList<String>();
        cork.add("Hospital    Tel: 019999999");
        cork.add("Pet Shop    Tel: 012222222");
        cork.add("Pavee Point Tel: 015555555");
        cork.add("			  Mob: 087555555");
        cork.add("Church      Tel: 013333333");
 
        List<String> limerick = new ArrayList<String>();
        limerick.add("Hospital    Tel: 019999999");
        limerick.add("Pet Shop    Tel: 012222222");
        limerick.add("Pavee Point Tel: 015555555");
        limerick.add("			  Mob: 087555555");
        limerick.add("Church      Tel: 013333333");
 
        listDataChild.put(listDataHeader.get(0), dublin); // Header, Child data
        listDataChild.put(listDataHeader.get(1), cork);
        listDataChild.put(listDataHeader.get(2), limerick);
    }

    
}


