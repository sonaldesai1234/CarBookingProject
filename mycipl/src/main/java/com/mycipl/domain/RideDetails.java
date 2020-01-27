package com.mycipl.domain;

import java.util.List;

public class RideDetails {
	private String distanceCovered;
	private String carMeterStartReading;
	private String carMeterEndReading;
	private boolean rideCompleted;
	private String timeRequiredInMinutes;
	private String startLocation;
	private String endLocation;
	private List<TrackRoute> trackRoute;
	
	public List<TrackRoute> getTrackRoute() {
		return trackRoute;
	}
	public void setTrackRoute(List<TrackRoute> trackRoute) {
		this.trackRoute = trackRoute;
	}
	public String getDistanceCovered() {
		return distanceCovered;
	}
	public void setDistanceCovered(String distanceCovered) {
		this.distanceCovered = distanceCovered;
	}
	public String getCarMeterStartReading() {
		return carMeterStartReading;
	}
	public void setCarMeterStartReading(String carMeterStartReading) {
		this.carMeterStartReading = carMeterStartReading;
	}
	public String getCarMeterEndReading() {
		return carMeterEndReading;
	}
	public void setCarMeterEndReading(String carMeterEndReading) {
		this.carMeterEndReading = carMeterEndReading;
	}
	public boolean isRideCompleted() {
		return rideCompleted;
	}
	public void setRideCompleted(boolean rideCompleted) {
		this.rideCompleted = rideCompleted;
	}
	public String getTimeRequiredInMinutes() {
		return timeRequiredInMinutes;
	}
	public void setTimeRequiredInMinutes(String timeRequiredInMinutes) {
		this.timeRequiredInMinutes = timeRequiredInMinutes;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	

}
