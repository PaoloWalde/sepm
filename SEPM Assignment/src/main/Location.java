import java.io.*;
import java.time.*;

public class Location implements Serializable, Comparable<Location> 
{
  private int locationId;
  private String locName;
  private int xCoordinates;
  private int yCoordinates;
  private String description;
  private LocalDate startDate;
  private int duration;
  // need min/time;
  //private boolean availability = true;
  
  static int nextID = 1;
  
  public Location() {
    locationId = nextID++;
  }
  
  public Location (String locName, int xCoordinates, int yCoordinates, String description, LocalDate startDate, int duration) {
    this.locName = locName;
    this.xCoordinates = xCoordinates;
    this.yCoordinates = yCoordinates;
    this.description = description;
    this.startDate = startDate;
    this.duration = duration;
    locationId = nextID++; 
  }
  
  
  
 public int getxCoordinates () {
    return xCoordinates;
 }
  
 public int getyCoordinates () {
    return yCoordinates;
 }
 
  public String getDescription() {
    return description;
 }
  
  public int getLocId () {
    return locationId;
  }
  
 // public boolean getAvailability () {
 //   return availability;
 // }
   
  public LocalDate getDate () {
    return startDate;
  }
  
  public int getDuration () {
    return duration;
 }
  
  public void setDate (String dateStr) {
    startDate = LocalDate.parse(dateStr);
  }
  
  public void setDuration (int duration){ 
        this.duration = duration;
  }
  
   public LocalDate getEndDate(){
   return startDate.plusDays(duration);
 }
 public int compareTo(Locations l){
   LocalDate endDate = this.getEndDate();
   LocalDate endDate1 = l.getEndDate();
   return endDate.compareTo(endDate1);
 }
   
    public void setLocName (String locName) {
    this.locName = locName;
  }
    
    public void setxCoordinates (int xCoordinates) {
    this.xCoordinates = xCoordinates;
  }
    
    public void setDescription (String description) {
    this.description = description;
  }
  
  
 // public void setAvailability (boolean availability) {
   // this.availability = availability;
 // }
  
  public String toString () {
    return  " Location Name: " + locName +  ", x Coordinates: " + xCoordinates +  ", y Coordinates: " + yCoordinates + " description: " + description + ", start date: " + startDate + ", duration: " + duration;
      //+ ", available?  " + availability;
    //"Location #: " + locationNo +
  }
  
}
