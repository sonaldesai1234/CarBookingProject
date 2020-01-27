package com.mycipl.domain;

public class TrackRoute {
	private String latitude;
	private String longitude;
	private boolean isStartLocation;
	private boolean isEndLocation;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public boolean isStartLocation() {
		return isStartLocation;
	}
	public void setStartLocation(boolean isStartLocation) {
		this.isStartLocation = isStartLocation;
	}
	public boolean isEndLocation() {
		return isEndLocation;
	}
	public void setEndLocation(boolean isEndLocation) {
		this.isEndLocation = isEndLocation;
	}
	
	

}
