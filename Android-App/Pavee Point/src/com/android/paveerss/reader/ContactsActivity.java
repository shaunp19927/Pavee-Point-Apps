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
import android.widget.Toast;
 
public class ContactsActivity extends BaseActivity {
 
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
        listDataHeader.add("iReport");
        listDataHeader.add("Dublin");
        listDataHeader.add("Wicklow");
        listDataHeader.add("Meath");
        listDataHeader.add("Louth");
        listDataHeader.add("Kildare");
        listDataHeader.add("Carlow");
        listDataHeader.add("Kilkenny");
        listDataHeader.add("Laois");
        listDataHeader.add("Offaly");
        listDataHeader.add("Westmeath");
        listDataHeader.add("Waterford");
        listDataHeader.add("Cork");
        listDataHeader.add("Kerry");
        listDataHeader.add("Tipperary");
        listDataHeader.add("Clare");
        listDataHeader.add("Galway");
        listDataHeader.add("Mayo");
        listDataHeader.add("Sligo");
        listDataHeader.add("Roscommon");
        listDataHeader.add("Leitrim");
        listDataHeader.add("Donegal");
        listDataHeader.add("Cavan");
        
        
 
        // Adding child data
        List<String> dublin = new ArrayList<String>();
        dublin.add("Clondalkin Travellers Development Group\nUnit 1 Neilstown Enterprise Centre\n" +
        		"Clondalkin - Dublin 22\nTel: 014575124\nEmail: ctdg@eircom.net");
        
        dublin.add("Tallaght Travellers Community Development Project\nUnit 6 Block 6B\n" +
        		"Killinarden Enterprise Park\nKillinarden\nTallaght - Dublin 24\n" +
        		"Tel: 014664334 014664335\nEmail: ttcdp@gofree.indigo.ie");
        
        dublin.add("Southside Travellers\nUnit 5 Furze Road\nSt.Kiernans Enterprise Centre\n" +
        		"Industrial Estate\nSandyford - Dublin 18\nTel: 012957372\n" +
        		"Email: info@southsidetravellers.ie\nWebsite: southsidetravellers.com/");
        
        dublin.add("TRAVACT CDP\nOutreach Centre\nClonshough Drive" +
        		"Coolock - Dublin 17\nTel: 018486515\nEmail: travact@eircom.net");
        
        dublin.add("Blanchardstown Traveller Support Group\nParslickstown House\n" +
        		"Ladyswell, Mulhuddart\nBlanchardstown - Dublin 15\n" +
        		"Tel: 018207812\nEmail: btdg@eircom.net");
        
        dublin.add("St Margaret's Traveller Community Association\nSt. Margaret's Traveller Centre\n" +
        		"St. Margaret's Park\nSt. Margaret's Road\nBallymun - Dublin 11\n" +
        		"Tel: 018622144\nEmail: saintmargarets@eircom.net");
        
        dublin.add("Finglas Traveller Development Group\n6 Cardiffsbridge Road\n" +
        		"Finglas - Dublin 11\nTel: 018641882\nEmail: Niamh.McTiernan@fcp.ie");
        
        dublin.add("Ballyfermot Travellers Action Project\nBallyfermot Community Civic Centre\n" +
        		"Ballyfermot Road - Dublin 10\nTel: 016264166\nEmail: lorrainebtap@gmail.com");

        dublin.add("North Fingal Traveller Organisation\nThe Resource Centre\n" +
        		"MacCaulin's Park - Matt Lane Street\nBalbriggan\nTel: 018020504");

 
        List<String> wicklow = new ArrayList<String>();
        wicklow.add("Bray Travellers Development Group\n97 rear off Main Street\n" +
        		"Bray - Co. Wicklow\nTel: 012762075\nEmail: btcdgadmin@eircom.net\n" +
        		"Website: www.btcdg.ie");
        wicklow.add("Wicklow Travellers Group\nCrinion Park - Wicklow Town\n" +
        		"Tel: 040461878\nEmail: info@wicklowtravellersgroup.ie\n" +
        		"Website: www.wicklowtravellersgroup.ie");
      
 
        List<String> meath = new ArrayList<String>();
        meath.add("Meath Travellers Workshop\nPO Box 28 - CYMS Hall\n" +
        		"Fairgreen, Navan\nCo. Meath\nTel: 0469027801\nEmail: infontw@eircom.net");
        
        List<String> louth = new ArrayList<String>();
        louth.add("Louth Traveller Movement\nC/o Redeemer Resource Centre\n" +
        		"Cedarwood Park, Dundalk\nCo. Louth\nEmail: rosemarieitm@gmail.com");
        
        List<String> kildare = new ArrayList<String>();
        kildare.add("Kildare Traveller Action\nc/o Aras, Main St.\nNewbridge - Co. Kildare\n" +
        		"Email: kildaretravellers@gmail.com");
        
        List<String> carlow = new ArrayList<String>();
        carlow.add("St Catherine's Community Service Centre\nSt Josephs Rd - Carlow\n" +
        		"Tel: 0599138700\nFax: 0599138701\nEmail: margaretw@catherines.ie\n" +
        		"Website: www.catherines.ie");
        carlow.add("Traveller Primary Health Care Programme\nc/o St. Catherine's\n" +
        		"St.Joesphs Road - Carlow Town\nTel: 0599138700\nEmail: edelk@catherines.ie\n" +
        		"Email: phw@catherines.ie");
        
        List<String> kilkenny = new ArrayList<String>();
        kilkenny.add("Kilkenny Traveller Community Movement\nc/o Co. Kilkenny Leader Partnership\n" +
        		"Wolfe Tone House\nWolf Tone Street\nKilkenny City\nTel: 0567752811\n" +
        		"Email: kktravellers@eircom.net");
        
        List<String> laois = new ArrayList<String>();
        laois.add("Laois Traveller Action Group\nJames Fintan Lawlor Avenue\n" +
        		"Peppers Court\nPortlaoise - Co Laois\nTel: 0578682210 0578687134 0578687135\n" +
        		"Email: laoistravellers@gmail.com");
        
        List<String> offaly = new ArrayList<String>();
        offaly.add("Offaly Traveller Movement\nBury Quay\nTullamore - Co. Offaly\n" +
        		"Tel: 0579352438\nFax: 0579322786\nWebsite: www.otm.ie\nEmail: info@otm.ie");
        
        List<String> westmeath = new ArrayList<String>();
        westmeath.add("Westmeath Traveller Project\nACT building\nBall alley lane\n" +
        		"Parnell Square - Athlone\nTel: 0906494555");
        
        List<String> waterford = new ArrayList<String>();
        waterford.add("Waterford Traveller Community Development Project\nParish Centre\n" +
        		"Ballybeg - Waterford City\nTel: 051357016 or 051591759\n" +
        		"Email: admin@waterfordtravellercdp.com");
        
        List<String> cork = new ArrayList<String>();
        cork.add("Traveller Visibility Group (TVG)\n25 John Street - Cork City\n" +
        		"Tel: 0214503786\nEmail: tvgcork@gmail.com\nWebsite: www.tvgcork.ie/site/");
     
        cork.add("Cork Traveller Womens Network\nc/o St. Catherine's School\nBishopstown Avenue\n" +
        		"Model Farm Road\nCork City\nTel: 0863850136\nEmail: corktravellerwomen@hotmail.com");
        
        cork.add("West Cork Travellers Centre\nMurphy's Garage\nWestern Road\nClonakilty - Co Cork\n" +
        		"Tel: 0238835039\nEmail: wctcmail@gmail.com");
 
        cork.add("Travellers of North Cork\nRiverside\nDoneraile - Co. Cork\n" +
        		"Tel: 02271030\nEmail: marietnc@gmail.com");
        
        cork.add("East Cork Traveller Advocacy\nNorth Lee Coumnity\nOld Library\nSt Marys Rd - Cork\n" +
        		"Tel: 0214928373");
        
        List<String> kerry = new ArrayList<String>();
        kerry.add("Kerry Travellers Health and Community Development Project\nSt Anthony's House\n" +
        		"Mitchells' Place\nTralee - Co. Kerry\nTel: 0667120054\nEmail: ktdp@eircom.net\n" +
        		"kerrytravellersproject.wordpress.com/");
        
        List<String> tipperary = new ArrayList<String>();
        tipperary.add("Tipperary Rural Traveller Project\n13 Michael Street\nTipperary Town\n" +
        		"Tel: 06231138\nEmail: tipptraveller@eircom.net");
        
        tipperary.add("North Tipperary Leader Partnership\nCommunity Resource Centre\nNewline\n" +
        		"Roscrea - Co. Tipperary\nTel: 050523379\nEmail: ireidy@ntlp.ie");
        
        List<String> clare = new ArrayList<String>();
        clare.add("Ennis CDP\nUnit 2\nMill House, Mill Road\nEnnis - Co. Clare\nTel: 0656869026\n" +
        		"Email: enniscdp@eircom.net");
        
        clare.add("Clare Traveller Primary Health Care Programme\nUnit 2 Clonroad Business Park\n" +
        		"Clonroad Ennis\nCo. Clare\nTel: 0656823968\nEmail: nkealy@clarecare.ie");
        
        List<String> galway = new ArrayList<String>();
        galway.add("Galway Traveller Movement\nNo. 1 The Plaza\nHeadford Road\nGalway City\n" +
        		"Tel: 091765390\nEmail: info@gtmtrav.ie\nWebsite: www.gtmtrav.ie/");
        galway.add("South East Galway Rural Traveller Health Project\nc/o GTM\n61 Main Street\n" +
        		"Loughrea - Co. Galway\nTel: 091880916\nContact: Úna Daly");
        
        List<String> mayo = new ArrayList<String>();
        mayo.add("Mayo Travellers Support Group\n19 Thomas Street\nCastlebar - Co Mayo\n" +
        		"Tel: 0949028400\nEmail:mayotravsg@gmail.com\nEmail: info@mtsg.ie");
        
        List<String> sligo = new ArrayList<String>();
        sligo.add("Sligo Travellers Support Group\n1A St Anne's\nCranmore - Co Sligo\n" +
        		"Tel: 0719145780\nEmail: stsg@eircom.net");
        sligo.add("Tubbercurry Traveller Support Group\nSligo  Rd\nTubbercurry - Co. Sligo\n" +
        		"Tel: 0719185274");
        
        List<String> roscommon = new ArrayList<String>();
        roscommon.add("Roscommon Traveller Health Programme\nRoscommon LEADER Partnership\n" +
        		"Unit 12, Tower B\nRoscommon West Business Park\nGolf Links Road\nRoscommon Town\n" +
        		"Co. Roscommon\nTel : 0906630252\nEmail: udaly@ridc.ie\nContact: Úna Daly");
        
        List<String> leitrim = new ArrayList<String>();
        leitrim.add("Leitrim Travellers Development Group\nMartin Reilly\n" +
        		"Email: leitrimtravellers@gmail.com");
        
        List<String> donegal = new ArrayList<String>();
        donegal.add("Donegal Travellers Project\nUnit 2, Level 7\nMillenium Court\n" +
        		"Justice Walsh Rd\nLetterkenny - Co. Donegal\nTel: 0749129281\n" +
        		"Email: travcom@eircom.net");
        
        List<String> cavan = new ArrayList<String>();
        cavan.add("Bernard Joyce\nIrish Traveller Movement\nBridge Street - Cavan\n" +
        		"Email: bjoyceitm@gmail.com");
        
        List<String> ireport = new ArrayList<String>();
        ireport.add("Report a Racist Incident\n\nWebsite: www.enarireland.org/ireport/\n\nClick to open on your browser!");
        
        
        listDataChild.put(listDataHeader.get(0), ireport);
        listDataChild.put(listDataHeader.get(1), dublin); // Header, Child data
        listDataChild.put(listDataHeader.get(2), wicklow);
        listDataChild.put(listDataHeader.get(3), meath);
        listDataChild.put(listDataHeader.get(4), louth);
        listDataChild.put(listDataHeader.get(5), kildare);
        listDataChild.put(listDataHeader.get(6), carlow);
        listDataChild.put(listDataHeader.get(7), kilkenny);
        listDataChild.put(listDataHeader.get(8), laois);
        listDataChild.put(listDataHeader.get(9), offaly);
        listDataChild.put(listDataHeader.get(10), westmeath);
        listDataChild.put(listDataHeader.get(11), waterford);
        listDataChild.put(listDataHeader.get(12), cork);
        listDataChild.put(listDataHeader.get(13), kerry);
        listDataChild.put(listDataHeader.get(14), tipperary);
        listDataChild.put(listDataHeader.get(15), clare);
        listDataChild.put(listDataHeader.get(16), galway);
        listDataChild.put(listDataHeader.get(17), mayo);
        listDataChild.put(listDataHeader.get(18), sligo);
        listDataChild.put(listDataHeader.get(19), roscommon);
        listDataChild.put(listDataHeader.get(20), leitrim);
        listDataChild.put(listDataHeader.get(21), donegal);
        listDataChild.put(listDataHeader.get(22), cavan);
        
       
    }

    
}


