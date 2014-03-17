package com.android.paveerss.reader.util;

import java.util.ArrayList;

public class ListHeader{
	String name;
	ArrayList<ListItem> items;

	public ListHeader(String name){
		this.name = name;
		items = new ArrayList<ListItem>();
	}

	public void add(ListItem... newItems){
		for (ListItem item : newItems)
			items.add(item); 
	}
	
	public ListItem get(int index)
	{ return items.get(index); }
	
	public String name()
	{ return this.name; }
	
	public int size()
	{ return items.size(); }
}
