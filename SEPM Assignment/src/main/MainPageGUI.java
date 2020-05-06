import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.time.*;
import java.io.*;

public class MainPageGUI extends JFrame implements ActionListener{
  //declarations
  FileInputStream fisT;
  ObjectInputStream oisT;
  FileOutputStream fosT;
  ObjectOutputStream oosT;
  
  FileInputStream fisL;
  ObjectInputStream oisL;
  FileOutputStream fosL;
  ObjectOutputStream oosL;
  
  
  
  ArrayList<Location> locations ; //location,locations
  ArrayList<Tour> tours ;//tour,tours
   //for LocationsTab
  JLabel lblLocName, lblxCoordinates, lblyCoordinates, lblDescription, lblDate, lblDays ;
  JTextField txtLocName, txtxCoordinates, txtyCoordinates, txtDescription, txtDate, txtDays;
       JButton btnLAdd, btnLList, btnLClear, btnLSave, btnLRead, btnLSortLocations;
       JTextArea jtaL; 
       
    //for ToursTab
    JLabel lblToursName;
    JTextField txtToursName;
    JButton btnTAdd, btnTList, btnTClear, btnTSave, btnTRead;
    JTextArea jtaT;
    //Location lfound = null;
 //constructor
    public  MainPageGUI(){
       locations = new ArrayList<Location>();  
       tours = new ArrayList<Tour>();
      
  //components for tabbed panel
  JTabbedPane tabs = new JTabbedPane();
  JPanel locationsTab = new JPanel();
  JPanel toursTab = new JPanel();
  //components for locationsTab
  //______________________________________________________________
  //for locationsTab button panel
  JPanel inputLPanel = new JPanel();
  lblLocName = new JLabel("Enter name");
  txtLocName = new JTextField(10);
  lblxCoordinates = new JLabel("Enter x Coordinates");
  txtxCoordinates = new JTextField(10);
  lblyCoordinates = new JLabel("Enter y Coordinates");
  txtyCoordinates = new JTextField(10);
  lblDescription = new JLabel("Enter Description");
  txtDescription = new JTextField(10);
  lblDate = new JLabel("Enter date (yyyy-mm-dd)");
  txtDate = new JTextField(10);
  lblDays = new JLabel("Enter days");
  txtDays = new JTextField(10);
  //btnLSearch = new JButton("Search Location by type");
  btnLAdd = new JButton("Add");
  btnLList = new JButton("List");
  btnLClear = new JButton("Clear");
  btnLSave = new JButton("Save");
  btnLRead = new JButton("Read");
  btnLSortLocations = new JButton("Sort by date");
  jtaL = new JTextArea(8, 40);
  //__________________________
  //components for toursTab
  JPanel inputTPanel = new JPanel();
  lblToursName = new JLabel("      Enter name");
  txtToursName = new JTextField(10);
  //lblLocationNo = new JLabel("Enter Locno");
  //txtLocationNo = new JTextField(10);
  //lblSearchLocation = new JLabel("Enter Location type");
  //txtSearchLocation = new JTextField(10);
  //lblDate = new JLabel("Enter date (yyyy-mm-dd)");
  //txtDate = new JTextField(10);
  //lblDays = new JLabel("Enter days");
  //txtDays = new JTextField(10);
  //btnLSearch = new JButton("Search Location by type");
  btnTAdd = new JButton("Add");
  btnTList = new JButton("List");
  btnTClear = new JButton("Clear");
  btnTSave = new JButton("Save");
  btnTRead = new JButton("Read");
  //btnTSortTours = new JButton("Sort by date");
  jtaT = new JTextArea(8, 40);
  
   //build tabs
   //add tabbed pane to center
    add(tabs, BorderLayout.CENTER);
    //add tab panels to it 
    tabs.addTab("Locations", locationsTab);
    tabs.addTab("Tours", toursTab);
    
    //_______________________________________
    //build LocationsTab
    
    JPanel displayLPanel = new JPanel();
    JPanel buttonLPanel = new JPanel();
   // buttonLPanel.setLayout(new GridLayout(1,2, 20, 20));
    locationsTab.setLayout(new BorderLayout());
   locationsTab.add(inputLPanel, BorderLayout.NORTH);
    locationsTab.add(displayLPanel, BorderLayout.CENTER);
    locationsTab.add(buttonLPanel, BorderLayout.SOUTH);
    
    inputLPanel.setBorder(new EmptyBorder(30,50,50,30));
    inputLPanel.setLayout(new GridLayout(6,2,20,10));
    //inputTPanel.add(lblSearchLocation);
    //inputTPanel.add(txtSearchLocation);
    //inputTPanel.add(btnLSearch);
    //lblSelectedLocation = new JLabel();
    //inputTPanel.add(lblSelectedLocation);
    inputLPanel.add(lblLocName);
    inputLPanel.add(txtLocName);
    inputLPanel.add(lblxCoordinates);
    inputLPanel.add(txtxCoordinates);
    inputLPanel.add(lblyCoordinates);
    inputLPanel.add(txtyCoordinates);
    inputLPanel.add(lblDescription);
    inputLPanel.add(txtDescription);
    //inputLPanel.add(lblLocationNo);
    //inputLPanel.add(txtLocationNo);
    inputLPanel.add(lblDate);
    inputLPanel.add(txtDate);
    inputLPanel.add(lblDays);
    inputLPanel.add(txtDays);
    JScrollPane scrollL = new JScrollPane(jtaL, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    displayLPanel.add(scrollL);
     
    btnLAdd.addActionListener(this);
    btnLList.addActionListener(this);
    btnLSortLocations.addActionListener(this);
    btnLSave.addActionListener(this);
    //btnTSearch.addActionListener(this);
    btnLRead.addActionListener(this);
    btnLClear.addActionListener(this);
    buttonLPanel.add(btnLAdd);
    buttonLPanel.add(btnLList);
    buttonLPanel.add(btnLSortLocations);
    buttonLPanel.add(btnLSave);
    buttonLPanel.add(btnLRead);
    buttonLPanel.add(btnLClear);
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
    //inputTPanel.add(lblSearchLocation);
    //inputTPanel.add(txtSearchLocation);
    //inputTPanel.add(btnLSearch);
    //lblSelectedLocation = new JLabel();
    //inputTPanel.add(lblSelectedLocation);
    inputTPanel.add(lblToursName);
    inputTPanel.add(txtToursName);
    //inputTPanel.add(lblLocationNo);
    //inputTPanel.add(txtLocationNo);
    //inputTPanel.add(lblDate);
    //inputTPanel.add(txtDate);
    //inputTPanel.add(lblDays);
    //inputTPanel.add(txtDays);
    JScrollPane scrollT = new JScrollPane(jtaT, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    
    displayTPanel.add(scrollT);
     
    btnTAdd.addActionListener(this);
    btnTList.addActionListener(this);
    //btnTSortTours.addActionListener(this);
    btnTSave.addActionListener(this);
    //btnTSearch.addActionListener(this);
    btnTRead.addActionListener(this);
    btnTClear.addActionListener(this);
    buttonTPanel.add(btnTAdd);
    buttonTPanel.add(btnTList);
    //buttonTPanel.add(btnTSortTours);
    buttonTPanel.add(btnTSave);
    buttonTPanel.add(btnTRead);
    buttonTPanel.add(btnTClear);
    
    
  }
    public void populateLists(){
    Locationz[] arrOfLocationz = {
      //new Locationz("Route1",1,2,"yeet", "2018-10-10",1),
      //new Locationz("Route2",1,2,"ha", "2018-10-10",1),
 };
           
            
    
    //tours.add(new Tour(100, 5));
    //tours.get(0).setLocationNo(1);
    //tours.get(0).setTourName("hey");
    //tours.get(0). setDate("2018-10-10");
    //lfound = searchLocationsByLocationNo(1);
    //lfound.setAvailability(false);
    
  
  }
    

   public static void main(String[] args){
    MainPageGUI bn = new MainPageGUI();
    bn.populateLists();
    //set up frame
    bn.setSize(600, 550);
    bn.setLocationRelativeTo(null);
    bn.setVisible(true);
  }
  
 // public void displayAllLocations() {
   //   for (Locationz l:locations) {
   //   System.out.println(l);
   // }
  //}
 
   //public void displayAvailableLocations() {
     // for (Location l:locations) {
       //if (l.getAvailability())
        //  System.out.println(l);
    //}
  //}
  
  public void listTours() {
     for(Tour t: tours)
        jtaT.append(t.toString() + "\n");
    
  }
  
  public void listLocations() {
     for(Location l: locations)
        jtaL.append(l.toString() + "\n");
    
  }

  public void addTours() {
    //Scanner input = new Scanner(System.in);
    //System.out.print("Location ID? ");
    //int locationNo = Integer.parseInt(txtLocationNo.getText());
    String name = txtToursName.getText();
    //int dur = Integer.parseInt(txtDays.getText());
    //System.out.print("Date in format yyyy-mm-dd? ");
    //String dateStr = txtDate.getText();
     // LocalDate date = null;
     //try{
     //  date = LocalDate.parse(dateStr);
    // }
     //catch(Exception e){}
      
     Tour t = new Tour(name);
     //lfound.setAvailability(false);
     //tour.setLocationNo(lfound.getLocationNo());
     tours.add(t);
    } 
  
   public void addLocations() {
    //Scanner input = new Scanner(System.in);
    //System.out.print("Location ID? ");
    //int locationNo = Integer.parseInt(txtLocationNo.getText());
    String name = txtLocName.getText();
    int xCoor = Integer.parseInt(txtxCoordinates.getText());
    int yCoor = Integer.parseInt(txtyCoordinates.getText());
    String description = txtDescription.getText();
    int dur = Integer.parseInt(txtDays.getText());
   // System.out.print("Date in format yyyy-mm-dd? ");
    String dateStr = txtDate.getText();
     LocalDate date = null;
     try{
      date = LocalDate.parse(dateStr);
     }
     catch(Exception e){}
      
     Location l = new Location(name,xCoor,yCoor,description,date, dur);
     //lfound.setAvailability(false);
     //tour.setLocationNo(lfound.getLocationNo());
     locations.add(l);
    } 
   
  public void removeTourById () {
    listTours();
    Scanner input = new Scanner(System.in);
    System.out.print("Tour ID? ");
    int id = input.nextInt();
    for (int i = 0; i < tours.size(); i++) {
      Tour t = tours.get(i);
      if (t.getTourId() == id){
        tours.remove(t);
      }
    }
   }
  
   public void removeLocById () {
    listLocations();
    Scanner input = new Scanner(System.in);
    System.out.print("Location ID? ");
    int id = input.nextInt();
    for (int i = 0; i < locations.size(); i++) {
      Location l = locations.get(i);
      if (l.getLocId() == id){
        locations.remove(l);
      }
    }
   }
  

  //public Location searchLocationsByType(String type){
   // for(Location l: locations){
     // if(l.getType().equalsIgnoreCase(type)&&l.getAvailability())
       // return l;
    //}
    //return null;
  // }
   //public Location searchLocationsByLocationNo(int locationNo){
    //for(Location l: locations){
     // if(l.getLocationNo() == locationNo)
     //   return l;
    //}
   // return null;
   //}
   public void sortByEndDate(){
    jtaL.setText("");
     Collections.sort(locations);
     
   }
  
  public void saveTours() {
    try {
      fosT = new FileOutputStream("tours.dat");
      oosT = new ObjectOutputStream(fosT);
      for (Tour t:tours) {
        oosT.writeObject(t);
      }
      fosT.close();
      oosT.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
   
   
  public void readTours() {
   tours.clear();
    try {
      fisT = new FileInputStream("tours.dat");
      oisT = new ObjectInputStream(fisT);
      
      while (true) {
        try {
          Object object = oisT.readObject();
          Tour t = (Tour)object;
          //update location status
           //int locationNo = t.getLocationNo();
          //Location l = searchLocationsByLocationNo(locationNo);
          //l.setAvailability(false);
          //add to array list
          tours.add(t);
          System.out.println(t);
        } catch (EOFException eofT) {
          fisT.close();
          oisT.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
   public void saveLocations() {
    try {
      fosL = new FileOutputStream("locations.dat");
      oosL = new ObjectOutputStream(fosL);
      for (Location l:locations) {
        oosL.writeObject(l);
      }
      fosL.close();
      oosL.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
 
   
  public void readLocations() {
   locations.clear();
    try {
      fisL = new FileInputStream("locations.dat");
      oisL = new ObjectInputStream(fisL);
      
      while (true) {
        try {
          Object object = oisL.readObject();
          Location l = (Location)object;
          //update location status
           //int locationNo = t.getLocationNo();
          //Location l = searchLocationsByLocationNo(locationNo);
          //l.setAvailability(false);
          //add to array list
          locations.add(l);
          System.out.println(l);
        } catch (EOFException eofL) {
          fisL.close();
          oisL.close();
          break;
        }
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
  public void actionPerformed(ActionEvent e){
  
  //  if(e.getSource()==btnLList){
    //     jtaL.setText("");
   //      for(Location l: locations){
   //        System.out.println(l);
   //       jtaL.append("\n" + l.toString() + "\n");
   //   }
  //  }
    
    if(e.getSource()==btnLClear){
      jtaL.setText("");
    }
     if(e.getSource() == btnLClear){
      jtaL.setText("");
    
    }
    //if(e.getSource()==btnLSearch){
     // String type = txtSearchLocation.getText();
      //System.out.println(type);
      //lfound = searchLocationsByType(type);
      //System.out.println(lfound);
      //lblSelectedLocation.setText("LocationNo "+ lfound.getLocationNo() + ", " + lfound.getType() );
      //txtSearchLocation.setText("");
     //}
    if(e.getSource()==btnTAdd){
      addTours();
    }
    if(e.getSource()==btnTList){
      listTours();
    }
    if(e.getSource() == btnTClear){
      jtaT.setText("");
    }
    
     if(e.getSource()==btnLAdd){
      addLocations();
    }
    if(e.getSource()==btnLList){
      listLocations();
    }
    if(e.getSource() == btnLClear){
      jtaL.setText("");
    }
    
    if(e.getSource() == btnLSave){
       saveLocations();
    }
    if(e.getSource()==btnLRead){
      readLocations();
   }
    if(e.getSource() == btnLSortLocations){
      sortByEndDate();
     listLocations();
   }
    if(e.getSource() == btnTSave){
       saveTours();
    }
    if(e.getSource()==btnTRead){
      readTours();
   }
  }
}
