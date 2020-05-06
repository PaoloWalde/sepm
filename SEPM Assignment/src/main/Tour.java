import java.io.*;
import java.time.*;

public class Tour implements Serializable
  //, Comparable<Tour> 
{
  private int tourId;
  private String tourName;
  private int locationNo;
  private LocalDate startDate;
  private int duration;
  static int nextID = 1;
  
  public Tour () {
   tourId = nextID++;
  }
  
  public Tour (String tourName) {
    //this.locationNo = locationNo;
    this.tourName = tourName;
    //this.startDate = startDate;
    //this.duration = duration;
    tourId = nextID++;
  }
    //public Tour (int locationNo, int duration) {
    //this.locationNo = locationNo;
    //this.duration = duration;
    //tourId= nextID++;
  //}
  public int getTourId () {
    return tourId;
  }
  
  public String getTourName () {
    return tourName;
  }
  
 // public int getLocationNo () {
   // return locationNo;
  //}
  
  //public void setDate (String dateStr) {
   // startDate = LocalDate.parse(dateStr);
  //}
  
  //public void setDuration (int duration){ 
  //      this.duration = duration;
  //}
  
  public void setTourName (String tourName) {
    this.tourName = tourName;
  }
  
// public void setLocationNo (int locationNo) {
  //  this.locationNo = locationNo;
 // }
 
// public LocalDate getEndDate(){
  // return startDate.plusDays(duration);
 //}
 //public int compareTo(Tour t){
   //LocalDate endDate = this.getEndDate();
   //LocalDate endDate1 = t.getEndDate();
   //return endDate.compareTo(endDate1);
 //}
 
 
 
  public String toString () {
    return "Tour Name: " + tourName;
      //+ ", start date: " + startDate + ", duration: " + duration+
    //"Location No: " + locationNo +
  }
  
}

   
 
 // edit tour: add location to tour, edit tour name, remove location from tour
 
 // edit tour type: change type, add new type, remove type

