package com.android.paveerss.reader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.android.paveerss.reader.util.ListHeader;
import com.android.paveerss.reader.util.ListItem;

public class ContactsActivity extends BaseActivity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	List<ListHeader> listData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();

		//        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		listAdapter = new ExpandableListAdapter(this, listData);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				return false;
			}
		});
	}
	
	/*
	 * Preparing the list data
	 */

	private void prepareListData(){
		listData = new ArrayList<ListHeader>();
		ListHeader thisHeader;

		thisHeader = new ListHeader("Dublin");
		thisHeader.add(
			new ListItem(
				"Clondalkin Travellers Development Group",
				"Unit 1 Neilstown Enterprise Centre" +"\n"+ "Clondalkin - Dublin 22",
				"014575124", 
				"ctdg@eircom.net"
			),
			new ListItem(
				"Tallaght Travellers Community Development Project",
				"Unit 6 Block 6B"+"\n"+
				"Killinarden Enterprise Park"+"\n"+
				"Killinarden"+"\n"+
				"Tallaght - Dublin 24",
				"014664334", 
				"ttcdp@gofree.indigo.ie" 
			)	.addTel("014664335"),
			
			new ListItem(
			    "Southside Travellers",
			    "Unit 5 Furze Road"+"\n"+"St.Kiernans Enterprise Centre"+"\n"+"Industrial Estate"+"\n"+"Sandyford - Dublin 18",
			    "012957372",
			    "info@southsidetravellers.ie"
			)	.addWebsite("southsidetravellers.com"),
			
			new ListItem(
				"TRAVACT CDP",
			    "Outreach Centre"+"\n"+"Clonshough Drive"+"\n"+"Coolock - Dublin 17",
				"018486515",
				"travact@eircom.net"
			),
			new ListItem(
				"Blanchardstown Traveller Support Group",
				"Parslickstown House"+"\n"+"Ladyswell, Mulhuddart"+"\n"+"Blanchardstown - Dublin 15",
				"018207812",
				"btdg@eircom.net"
			),
			new ListItem(
				"St Margaret's Traveller Community Association",
				"St. Margaret's Traveller Centre"+"\n"+"St. Margaret's Park"+"\n"+"St. Margaret's Road"+"\n"+"Ballymun - Dublin 11",
				"018622144",
				"saintmargarets@eircom.net"
			),
			new ListItem(
				"Finglas Traveller Development Group",
				"6 Cardiffsbridge Road"+"\n"+"Finglas - Dublin 11",
				"018641882",
				"Niamh.McTiernan@fcp.ie"
			),
			new ListItem(
				"Ballyfermot Travellers Action Project",
				"Ballyfermot Community Civic Centre"+"\n"+"Ballyfermot Road - Dublin 10",
				"016264166",
				"lorrainebtap@gmail.com"
			),
			new ListItem(
				"North Fingal Traveller Organisation",
				"The Resource Centre"+"\n"+"MacCaulin's Park - Matt Lane Street"+"\n"+"Balbriggan",
				"018020504",
				ListItem.EMPTY
			)
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Wicklow");
		thisHeader.add(
			new ListItem(
				"Bray Travellers Development Group",
				"97 rear off Main Street"+"\n"+"Bray - Co. Wicklow",
				"012762075",
				"btcdgadmin@eircom.net"
			)	.addWebsite("www.btcdg.ie"),
			new ListItem(
				"Wicklow Travellers Group",
				"Crinion Park - Wicklow Town",
				"040461878",
				"info@wicklowtravellersgroup.ie"
			)	.addWebsite("www.wicklowtravellersgroup.ie")
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Meath");
		thisHeader.add(
			new ListItem(
				"Meath Travellers Workshop",
				"PO Box 28 - CYMS Hall"+"\n"+"Fairgreen, Navan"+"\n"+"Co. Meath",
				"0469027801",
				"infontw@eircom.net"
			)
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Louth");
		thisHeader.add(
			new ListItem(
				"Louth Traveller Movement",
				"C/o Redeemer Resource Centre"+"\n"+"Cedarwood Park, Dundalk"+"\n"+"Co. Louth",
				ListItem.EMPTY,
				"rosemarieitm@gmail.com"
			)
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Kildare");
		thisHeader.add(
			new ListItem(				
				"Kildare Traveller Action",
				"c/o Aras, Main St."+"\n"+"Newbridge - Co. Kildare",
				ListItem.EMPTY,
				"kildaretravellers@gmail.com"				
			)
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Carlow");
		thisHeader.add(
			new ListItem(
				"St Catherine's Community Service Centre",
				"St Josephs Rd - Carlow",
				"0599138700",
				"margaretw@catherines.ie"
			)	.addWebsite("www.catherines.ie")
				.addExtra("Fax: 0599138701"),
				
			new ListItem(
				"Traveller Primary Health Care Programme",
				"c/o St. Catherine's St.Joesphs Road - Carlow Town",
				"0599138700",
				"edelk@catherines.ie" // 			
			)	.addEmail("phw@catherines.ie")			
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("kilkenny");
		thisHeader.add(
		    new ListItem(
		        "Kilkenny Traveller Community Movement",
		        "c/o Co. Kilkenny Leader Partnership"+"\n"+"Wolfe Tone  House"+"\n"+"Wolf Tone Street"+"\n"+"Kilkenny City",
		        "0567752811",
		        "kktravellers@eircom.net"
		    )
		);
		listData.add(thisHeader);


		thisHeader = new ListHeader("laois");
		thisHeader.add(
		    new ListItem(
		        "Laois Traveller Action Group",
		        "James Fintan Lawlor Avenue"+"\n"+"Peppers Court"+"\n"+"Portlaoise - Co Laois",
		        "0578682210",
		        "laoistravellers@gmail.com"
		    )	.addTel("0578687134")
		    	.addTel("0578687135")
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("offaly");
		thisHeader.add(
		    new ListItem(
		        "Offaly Traveller Movement",
		        "Bury Quay"+"\n"+"Tullamore - Co. Offaly",
		        "0579352438",
		        "info@otm.ie"
		    )	.addWebsite("www.otm.ie")
		    	.addExtra("Fax: 0579322786")
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("westmeath");
		thisHeader.add(
		    new ListItem(
		        "Westmeath Traveller Project",
		        "ACT building"+"\n"+"Ball alley lane"+"\n"+"Parnell Square - Athlone",
		        "0906494555",
		        ListItem.EMPTY
		    )
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("waterford");
		thisHeader.add(
		    new ListItem(
		        "Waterford Traveller Community Development Project",
		        "Parish Centre"+"\n"+"Ballybeg - Waterford City",
		        "051357016",
		        "admin@waterfordtravellercdp.com"
		    )	.addTel("051591759")
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Cork");
		thisHeader.add(
		    new ListItem(
		        "Traveller Visibility Group (TVG)",
		        "25 John Street - Cork City",
		        "0214503786",
		        "tvgcork@gmail.com"
		    )	.addWebsite("www.tvgcork.ie/site/"),
		    
		    new ListItem(
		        "Cork Traveller Womens Network",
		        "c/o St. Catherine's School"+"\n"+"Bishopstown Avenue"+"\n"+"Model Farm Road"+"\n"+"Cork City",
		        "0863850136",
		        "corktravellerwomen@hotmail.com"
		    ),
		    new ListItem(
		        "West Cork Travellers Centre",
		        "Murphy's Garage"+"\n"+"Western Road"+"\n"+"Clonakilty - Co Cork",
		        "0238835039",
		        "wctcmail@gmail.com"
		    ),
		    new ListItem(
		        "Travellers of North Cork",
		        "Riverside"+"\n"+"Doneraile - Co. Cork",
		        "02271030",
		        "marietnc@gmail.com"
		    ),
		    new ListItem(
		        "East Cork Traveller Advocacy",
		        "North Lee Coumnity"+"\n"+"Old Library"+"\n"+"St Marys Rd - Cork",
		        "0214928373",
		        ListItem.EMPTY
		    )
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Kerry");
		thisHeader.add(
		    new ListItem(
		        "Kerry Travellers Health and Community Development Project",
		        "St Anthony's House"+"\n"+"Mitchells' Place"+"\n"+"Tralee - Co. Kerry",
		        "0667120054",
		        "ktdp@eircom.net"
		    )	.addWebsite("kerrytravellersproject.wordpress.com/")
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Tipperary");
		thisHeader.add(
		    new ListItem(
		        "Tipperary Rural Traveller Project",
		        "13 Michael Street"+"\n"+"Tipperary Town",
		        "06231138",
		        "tipptraveller@eircom.net"
		    ),
		    new ListItem(
		        "North Tipperary Leader Partnership",
		        "Community Resource Centre"+"\n"+"Newline"+"\n"+"Roscrea - Co. Tipperary",
		        "050523379",
		        "ireidy@ntlp.ie"
		    )
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Clare");
		thisHeader.add(
		    new ListItem(
		        "Ennis CDP",
		        "Unit 2"+"\n"+"Mill House, Mill Road"+"\n"+"Ennis - Co. Clare",  
		        "0656869026",
		        "enniscdp@eircom.net"
		    ),
		    new ListItem(
		        "Clare Traveller Primary Health Care Programme",
		        "Unit 2 Clonroad Business Park"+"\n"+"Clonroad Ennis"+"\n"+"Co. Clare",
		        "0656823968",
		        "nkealy@clarecare.ie"
		    )
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Galway");
		thisHeader.add(
		    new ListItem(
		        "Galway Traveller Movement",
		        "No. 1 The Plaza"+"\n"+"Headford Road"+"\n"+"Galway City",
		        "091765390",
		        "info@gtmtrav.ie" 
		    )	.addWebsite("www.gtmtrav.ie/"),
		    
		    new ListItem(
		        "South East Galway Rural Traveller Health Project",
		        "c/o GTM"+"\n"+"61 Main Street"+"\n"+"Loughrea - Co. Galway",
		        "091880916",
		        ListItem.EMPTY
		    )	.addExtra("Contact: Úna Daly")
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Mayo");
		thisHeader.add(
		    new ListItem(
		        "Mayo Travellers Support Group",
		        "19 Thomas Street"+"\n"+"Castlebar - Co Mayo",
		        "0949028400",
		        "mayotravsg@gmail.com" 
		    )	.addEmail("info@mtsg.ie")
		);
		listData.add(thisHeader);
		
		thisHeader = new ListHeader("Sligo");
		thisHeader.add(
		    new ListItem(
		        "Sligo Travellers Support Group",
		        "1A St Anne's"+"\n"+"Cranmore - Co Sligo",
		        "0719145780",
		        "stsg@eircom.net"
		    ),
		    new ListItem(
		        "Tubbercurry Traveller Support Group",
		        "Sligo Rd"+"\n"+"Tubbercurry - Co. Sligo",
		        "0719185274",
		        ListItem.EMPTY
		    )
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("Roscommon");
		thisHeader.add(
		    new ListItem(
		        "Roscommon Traveller Health Programme",
		        "Roscommon LEADER Partnership"+"\n"+"Unit 12, Tower B"+"\n"+"Roscommon West Business Park"+"\n"+"Golf Links Road"+"\n"+"Roscommon Town"+"\n"+"Co. Roscommon",
		        "0906630252",
		        "udaly@ridc.ie"
		    )	.addExtra("Contact: Úna Daly")
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("Leitrim");
		thisHeader.add(
		    new ListItem(
		        "Leitrim Travellers Development Group Martin Reilly",
		        ListItem.EMPTY,
		        ListItem.EMPTY,
		        "leitrimtravellers@gmail.com"
		    )
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("Donegal");
		thisHeader.add(
		    new ListItem(
		        "Donegal Travellers Project",
		        "Unit 2, Level 7"+"\n"+"Millenium Court"+"\n"+"Justice Walsh Rd"+"\n"+"Letterkenny - Co. Donegal",
		        "0749129281",
		        "travcom@eircom.net"
		    )
		);
		listData.add(thisHeader);

		thisHeader = new ListHeader("Cavan");
		thisHeader.add(
		    new ListItem(
		        "Bernard Joyce Irish Traveller Movement",
		        "Bridge Street - Cavan",
		        ListItem.EMPTY,
		        "bjoyceitm@gmail.com"
		    )
		);
		listData.add(thisHeader);

	}
}
