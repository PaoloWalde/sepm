package main;

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.border.*;
	import java.util.*;
	import java.time.*;
	import java.io.*;

	public class MainPageGUI extends JFrame implements ActionListener {
	  
		//declarations
	  FileInputStream fis;
	  ObjectInputStream ois;
	  FileOutputStream fos;
	  ObjectOutputStream oos;
	  ArrayList<Tour> tours ;    //tour,tours
	  ArrayList<Location> locations ; //location,locations
	   //for LocationsTab
	       JButton btnLList, btnLClear;
	       JTextArea jtaL; 
	    //for ToursTab
	    JLabel lblSearchLocation,lblToursName,lblLocationNo, lblDate, lblDays, lblSelectedLocation;
	    JTextField txtSearchTours,txtLocationNo, txtToursName, txtDate, txtDays, txtSearchLocation;
	    JButton btnTSearch, btnTAdd, btnTList, btnTClear, btnTSave, btnTRead, btnTSortTours, btnLSearch;
	    JTextArea jtaT;
	    Location lfound = null;
	 
	    
	    //constructor
	    public  MainPageGUI() {
	      locations = new ArrayList<Location>();  
	      tours = new ArrayList<Tour>();
	      
	  //components for tabbed panel
	  JTabbedPane tabs = new JTabbedPane();
	  JPanel locationsTab = new JPanel();
	  JPanel toursTab = new JPanel();
	  //components for locationsTab
	  //__________________________________________
	  JPanel displayLPanel = new JPanel();
	  JPanel buttonLPanel = new JPanel();

	  //for locationsTab button panel
	  btnLList = new JButton("List Locations");
	  btnLClear = new JButton("Clear display");
	  //______________________________________________
	  //components for toursTab
	  JPanel inputTPanel = new JPanel();
	  lblToursName = new JLabel("      Enter name:");
	  txtToursName = new JTextField(10);
	  lblLocationNo = new JLabel("Enter Location number:");
	  txtLocationNo = new JTextField(10);
	  lblSearchLocation = new JLabel("Enter Location type:");
	  txtSearchLocation = new JTextField(10);
	  lblDate = new JLabel("Enter date (yyyy-mm-dd):");
	  txtDate = new JTextField(10);
	  lblDays = new JLabel("Enter days: ");
	  txtDays = new JTextField(10);
	  btnLSearch = new JButton("Search Location by type");
	  btnTAdd = new JButton("Add");
	  btnTList = new JButton("List");
	  btnTClear = new JButton("Clear");
	  btnTSave = new JButton("Save");
	  btnTRead = new JButton("Read");
	  btnTSortTours = new JButton("Sort by date");
	  jtaT = new JTextArea(8, 40);
	  
	   //build tabs
	   //add tabbed pane to center
	    add(tabs, BorderLayout.CENTER);
	    //add tab panels to it 
	    tabs.addTab("Locations", locationsTab);
	    tabs.addTab("Tours", toursTab);
	    
	    //_______________________________________
	    //build LocationsTab
	    locationsTab.setLayout(new BorderLayout());
	    locationsTab.add(displayLPanel, BorderLayout.CENTER);
	    locationsTab.add(buttonLPanel, BorderLayout.SOUTH);
	    //for locationsTab display
	  jtaL = new JTextArea(25, 45);
	  JScrollPane scrollL = new JScrollPane(jtaL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
	                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    jtaL.setBorder(new TitledBorder("List of Locations"));  
	    btnLList.addActionListener(this);
	    btnLClear.addActionListener(this);
	    buttonLPanel.add(btnLList);
	    buttonLPanel.add(btnLClear); 
	    displayLPanel.add(scrollL);
	   //______________________________________________
	  //build toursTab
	    JPanel displayTPanel = new JPanel();
	    JPanel buttonTPanel = new JPanel();
	    //buttonBPanel.setLayout(new GridLayout(1,2, 20, 20));
	    toursTab.setLayout(new BorderLayout());
	    toursTab.add(inputTPanel, BorderLayout.NORTH);
	    toursTab.add(displayTPanel, BorderLayout.CENTER);
	    toursTab.add(buttonTPanel, BorderLayout.SOUTH);
	    
	    inputTPanel.setBorder(new EmptyBorder(30,50,50,30));
	    inputTPanel.setLayout(new GridLayout(6,2,20,10));
	    inputTPanel.add(lblSearchLocation);
	    inputTPanel.add(txtSearchLocation);
	    inputTPanel.add(btnLSearch);
	    lblSelectedLocation = new JLabel();
	    inputTPanel.add(lblSelectedLocation);
	    inputTPanel.add(lblToursName);
	    inputTPanel.add(txtToursName);
	    inputTPanel.add(lblLocationNo);
	    inputTPanel.add(txtLocationNo);
	    inputTPanel.add(lblDate);
	    inputTPanel.add(txtDate);
	    inputTPanel.add(lblDays);
	    inputTPanel.add(txtDays);
	    JScrollPane scrollT = new JScrollPane(jtaT, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
	                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
	    displayTPanel.add(scrollT);
	     
	    btnTAdd.addActionListener(this);
	    btnTList.addActionListener(this);
	    btnTSortTours.addActionListener(this);
	    btnTSave.addActionListener(this);
	    btnTSearch.addActionListener(this);
	    btnTRead.addActionListener(this);
	    btnTClear.addActionListener(this);
	    buttonTPanel.add(btnTAdd);
	    buttonTPanel.add(btnTList);
	    buttonTPanel.add(btnTSortTours);
	    buttonTPanel.add(btnTSave);
	    buttonTPanel.add(btnTRead);
	    buttonTPanel.add(btnTClear);
	    
	    
	  }
	    
	    public void populateLists()
	    {
	    	Location[] arrOfLocation = 
	    		{
	    			new Location("Route1","Rocky"),
	    			new Location("Route2","Road"),  
	    		};
	    	tours.add(new Tour());
	    	tours.get(0).setLocationNo(1);
	    	tours.get(0).setName("hey");
	    	tours.get(0). setDate("2018-10-10");
	    	lfound = searchLocationsByLocationNo(1);
	    	lfound.setAvailability(false);
	    }
	    

	   public static void main(String[] args)
	   {
	    MainPageGUI bn = new MainPageGUI();
	    bn.populateLists();
	    //set up frame
	    bn.setSize(600, 550);
	    bn.setLocationRelativeTo(null);
	    bn.setVisible(true);
	   }
	   
	  
	  public void displayAllLocations() 
	  {
	      for (Location l:locations) 
	      {
	    	  System.out.println(l);
	      }
	  }
	 
	   public void displayAvailableLocations() 
	   {
	      for (Location l:locations) 
	      {
	       if (l.getAvailability())
	          System.out.println(l);
	      }
	   }
	  
	  public void listTours() 
	  {
	     for(Tour t: tours)
	        jtaT.append(t.toString() + "\n");
	    
	  }

	  public void addTours() 
	  {
	    //Scanner input = new Scanner(System.in);
	    //System.out.print("Location ID? ");
	    int locationNo = Integer.parseInt(txtLocationNo.getText());
	    String name = txtToursName.getText();
	    int dur = Integer.parseInt(txtDays.getText());
	    //System.out.print("Date in format yyyy-mm-dd? ");
	    String dateStr = txtDate.getText();
	      LocalDate date = null;
	     try
	     {
	       date = LocalDate.parse(dateStr);
	     }
	     catch(Exception e)
	     {
	    	 
	     }
	      
	     
	     // Create the tour object 
	     Tour tour = new Tour ("Ancient Dinosaurs", 201, "Interactive", 5);
	     lfound.setAvailability(false);
	     tour.setLocationNo(lfound.getLocationNo());
	     tours.add(tour);
	    } 
	   
	  public void removeTourById () 
	  {
		  listTours();
		  Scanner input = new Scanner(System.in);
		  System.out.print("Tour ID? ");
	  
		  int id = input.nextInt();
	  
		  for (int i = 0; i < tours.size(); i++) 
		  {
			  Tour t = tours.get(i);
			  if (t.getTourId() == id)
			  {
				  tours.remove(t);
			  }
		  }
	  }
	  

	  public Location searchLocationsByType(String type){
	    for(Location l: locations){
	      if(l.getType().equalsIgnoreCase(type)&&l.getAvailability())
	        return l;
	    }
	    return null;
	   }
	  
	  public void saveTours() {
	    try {
	      fos = new FileOutputStream("tours.dat");
	      oos = new ObjectOutputStream(fos);
	      for (Tour t:tours) {
	        oos.writeObject(t);
	      }
	      fos.close();
	      oos.close();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	 
	   public Location searchLocationsByLocationNo(int locationNo){
	    for(Location l: locations){
	      if(l.getLocationNo() == locationNo)
	        return l;
	    }
	    return null;
	   }
	   public void sortByEndDate(){
	     jtaT.setText("");
	     Collections.sort(tours);
	     
	   }
	   
	  public void readTours() {
	   tours.clear();
	    try {
	      fis = new FileInputStream("tours.dat");
	      ois = new ObjectInputStream(fis);
	      
	      while (true) {
	        try {
	          Object object = ois.readObject();
	          Tour t = (Tour)object;
	          //update location status
	           int locationNo = t.getLocationNo();
	          Location l = searchLocationsByLocationNo(locationNo);
	          l.setAvailability(false);
	          //add to array list
	          tours.add(t);
	          System.out.println(t);
	        } catch (EOFException eof) {
	          fis.close();
	          ois.close();
	          break;
	        }
	      }
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  
	  }
	  
	  public void actionPerformed(ActionEvent e){
	  
	    if(e.getSource()==btnLList){
	         jtaL.setText("");
	         for(Location l: locations){
	           System.out.println(l);
	          jtaL.append("\n" + l.toString() + "\n");
	      }
	    }
	    
	    if(e.getSource()==btnLClear){
	      jtaL.setText("");
	    }
	     if(e.getSource() == btnLClear){
	      jtaL.setText("");
	    
	    }
	    if(e.getSource()==btnLSearch){
	      String type = txtSearchLocation.getText();
	      System.out.println(type);
	      lfound = searchLocationsByType(type);
	      System.out.println(lfound);
	      lblSelectedLocation.setText("LocationNo "+ lfound.getLocationNo() + ", " + lfound.getType() );
	      txtSearchLocation.setText("");
	     }
	    
	    if(e.getSource()==btnTAdd)
	    {
	      addTours();
	    }
	    
	    if(e.getSource()==btnTList)
	    {
	      listTours();
	    }
	    
	    if(e.getSource() == btnTClear)
	    {
	      jtaT.setText("");
	    }
	    
	    if(e.getSource() == btnTSortTours)
	    {
	      sortByEndDate();
	      listTours();
	    }
	    
	    if(e.getSource() == btnTSave)
	    {
	       saveTours();
	    }
	    
	    if(e.getSource()==btnTRead)
	    {
	      readTours();
	    }
	}
}