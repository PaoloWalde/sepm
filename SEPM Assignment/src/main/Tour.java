package main;

import java.io.*;
import java.time.*;


public class Tour implements Serializable, Comparable<Tour> 
{
	private String name;
	private int id;
	private int locationNo;
	private String type;
	private LocalDate startDate;
	private long duration;
	private String availability;
	
	static int nextID = 1;
	  
	public Tour () 
	{
	   this.id = nextID++;
	}

	
	public Tour (String name, int id, String type, int locationNo)
	{
		this.name = name;
		this.id = id;
		this.type = type;
		this.duration = duration;
		this.locationNo = locationNo;
	    this.id = nextID++;
	}
	
	public Tour (int locationNo, long duration) {
	    this.locationNo = locationNo;
	    this.duration = duration;
	    id= nextID++;
	  }

	
	public String getName()
	{
		return name;
	}
	 
	public void setName (String name) 
	{
		this.name = name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getLocationNo()
	{
		return locationNo;
	}
	
	public void setLocationNo (int locationNo) 
	{
		this.locationNo = locationNo;
	}
	
	public long getDuration()
	{
		return duration;
	}
	
	 public void setDuration (long duration)
	 { 
		 this.duration = duration;
	 }
	
	public String getAvailability()
	{
		return availability;
	}
	
	public int getTourId()
	{
		return id;
	}
	
	public LocalDate getDate () 
	{
	return startDate;
	}
	
	public void setDate (String dateStr) 
	{
		startDate = LocalDate.parse(dateStr);
	}
	
	public LocalDate getEndDate()
	{
		return startDate.plusDays(duration);
	}
	
	public int compareTo(Tour t)
	{
		LocalDate endDate = this.getEndDate();
		LocalDate endDate1 = t.getEndDate();
		return endDate.compareTo(endDate1);
	}

	
	 public String toString () 
	 {
		    return "Location No: " + locationNo +"Tour Name: " + name + ", start date: " + startDate + ", duration: " + duration+ 
		            "\nLocation #: " + locationNo + "\n";
	 }
}
