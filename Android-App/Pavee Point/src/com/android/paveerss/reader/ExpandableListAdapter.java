package com.android.paveerss.reader;

import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.android.paveerss.reader.util.ListHeader;
 
public class ExpandableListAdapter extends BaseExpandableListAdapter {
 
    private Context _context;
    //private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    //private HashMap<String, List<String>> _listDataChild;
    
    private List<ListHeader> _listData;
 
//    public ExpandableListAdapter(Context context, List<String> listDataHeader,
//            HashMap<String, List<String>> listChildData) {
//        this._context = context;
//        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
//    }
    
    public ExpandableListAdapter(Context context, List<ListHeader> listdata){
    	this._context = context;
    	this._listData = listdata;
    }
 
    @Override
    public Object getChild(int groupPosition, int childPosititon) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .get(childPosititon);
    	return this._listData.get(groupPosition).get(childPosititon);
    }
 
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    @Override
    public View getChildView(int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
 
//        final String childText = (String) getChild(groupPosition, childPosition);
    	final String childText = getChild(groupPosition,childPosition).toString();
 
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
 
        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);
 
        txtListChild.setText(childText);
        return convertView;
    }
 
    @Override
    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .size();
    	return this._listData.get(groupPosition).size();
    }
 
    @Override
    public ListHeader getGroup(int groupPosition) {
//        return this._listDataHeader.get(groupPosition);
    	return this._listData.get(groupPosition);
    }
 
    @Override
    public int getGroupCount() {
//        return this._listDataHeader.size();
    	return this._listData.size();
    }
 
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
    	String headerTitle = getGroup(groupPosition).name();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
 
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
 
        return convertView;
    }
 
    @Override
    public boolean hasStableIds() {
        return false;
    }
 
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
