package com.android.paveerss.reader.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.android.paveerss.reader.data.RssItem;


public class RssParseHandler extends DefaultHandler {

	private List<RssItem> rssItems;
	
	// Used to reference item while parsing
	private RssItem currentItem;
	
	// Parsing title indicator
	private boolean parsingTitle;
	// Parsing link indicator
	private boolean parsingLink;
	//parsing description indicator
	private boolean parsingDescription;
	
	public RssParseHandler() {
		rssItems = new ArrayList<RssItem>();
	}
	
	public List<RssItem> getItems() {
		return rssItems;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("item".equals(qName)) {
			currentItem = new RssItem();
		} else if ("title".equals(qName)) {
			parsingTitle = true;
		} else if ("link".equals(qName)) {
			parsingLink = true;
		} else if ("description".equals(qName)) {
				parsingDescription = true;
			}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if ("item".equals(qName)) {
			rssItems.add(currentItem);
			currentItem = null;
		} else if ("title".equals(qName)) {
			parsingTitle = false;
		} else if ("link".equals(qName)) {
			parsingLink = false;
		} else if("description".equals(qName)) {
			parsingDescription = false;
			
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (parsingTitle) {
			if (currentItem != null)
				currentItem.setTitle(format(new String(ch, start, length)));
		} else if (parsingLink) {
			if (currentItem != null) {
				currentItem.setLink(new String(ch, start, length));
				parsingLink = false;
			}
		} else if (parsingDescription) {
			if (currentItem != null) {
				currentItem.setDescription(format(new String(ch, start, length)));
				parsingDescription = false;
				
			}
		}
	}
	
	private String format(String desc){
		
		String new_desc = "";
		boolean skip = false;
		
		for(int i = 0; i < desc.length(); i++) {
			if(desc.charAt(i) == '<') skip = true;
			else if(desc.charAt(i) == '>' && skip) skip = false;
			else if(skip) continue;
			else if(desc.charAt(i) == '&' && desc.charAt(i+1) == '#') i += 6;
			else if(desc.charAt(i) == '.') {
				new_desc += (desc.charAt(i));
				break;
			}
			else new_desc += (desc.charAt(i));
		}
		//System.out.println(new_desc);
		return new_desc;
	}
	
}
