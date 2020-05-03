package main;

import java.io.*;

public class Location
{
		private String name;
		private String description;
		private String coordinates;
		private String timeSpent;
		private String type;
		private boolean availability = true;
		private int locationNo;
		
		static int nextId = 1;

		public Location() 
		{
			
		}
		
		
		public Location (String name, String type) 
		{
			  this.name = name;
			  this.type = type;
			  locationNo = nextId++; 
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setName (String name) 
		{
			this.name = name;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public String getCoordinates()
		{
			return coordinates;
		}
		
		public String getTimeSpent()
		{
			return timeSpent;
		}
		
		public String getType()
		{
			return type;
		}
		
		public void setType (String type) 
		{
			this.type = type;
		}
		
		public boolean getAvailability () 
		{
			return availability;
		}
		
		public void setAvailability (boolean availability) 
		{
			this.availability = availability;
		}
		
		public int getLocationNo () 
		{
			return locationNo;
		}
	

		public String toString () {
			  return "Location #: " + locationNo + ", Name: " + name +  ", type: " + type + ", available?  " + availability;
			}
	}