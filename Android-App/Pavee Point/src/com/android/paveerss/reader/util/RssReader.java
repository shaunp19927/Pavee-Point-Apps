package com.android.paveerss.reader.util;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.android.paveerss.reader.data.RssItem;

public class RssReader {
	
	private String rssUrl;

	public RssReader(String rssUrl) {
		this.rssUrl = rssUrl;
	}


	public List<RssItem> getItems() throws Exception {
		// SAX parse RSS data
		SAXParserFactory factory = SAXParserFactory.newInstance();

		final SAXParser saxParser = factory.newSAXParser();
		final RssParseHandler handler = new RssParseHandler();
		
//		saxParser.parse(rssUrl, handler);
		
		// This needs to be in a separate thread as newer versions of android
		// will simply throw an error if we try to do network tasks in the ui
		// thread
		Thread thread = new Thread(new Runnable(){
		    @Override
		    public void run() {
		        try {saxParser.parse(rssUrl, handler);} catch (Exception e) {}
		    }
		});
		thread.start();
		thread.join();		

		return handler.getItems();
		
	}

}