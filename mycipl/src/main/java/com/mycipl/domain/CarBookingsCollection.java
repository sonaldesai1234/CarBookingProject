
package com.mycipl.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A CarBookingsCollection.
 */
@Document(collection = "car_bookings_collection")
public class CarBookingsCollection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	private String id;

	@Field("bookingId")
	private String bookingId;

	@Field("customerLocation")
	private String customerLocation;

	// @Size(min=10 ,max=12)
	@Field("customerMobileNumber")
	private String customerMobileNumber;

	@Field("endTime")
	private Instant endTime;

	@Field("updatedBy")
	private String updatedBy;

	@Field("dseLoginID")
	private String dseLoginID;

	@Field("startingTime")
	private Instant startingTime;

	@Field("dealerCode")
	private String dealerCode;

	@Field("teamLeader")
	private String teamLeader;

	@Field("updatedOn")
	private Instant updatedOn;

	@Field("carModelEngineNumber")
	private String carModelEngineNumber;

	@Field("carModelName")
	private String carModelName;

	@Field("customerNotes")
	private String customerNotes;

	@Field("roleId")
	private String roleId;

	@Field("customerName")
	private String customerName;

	@Field("endKm")
	private String endKm;

	@Field("dseName")
	private String dseName;

	@Field("createdOn")
	private Instant createdOn;

	@Field("reScheduleFrom")
	private String reScheduleFrom;

	@Field("createdBy")
	private String createdBy;

	@Field("closureComment")
	private String closureComment;

	@Email
	@Field("email")
	private String email;

	@Field("actualStartTime")
	private Instant actualStartTime;

	@Size(min = 10, max = 12)
	@Field("dseMobileNumber")
	private String dseMobileNumber;

	@Field("actualEndTime")
	private Instant actualEndTime;

	@Field("startKm")
	private String startKm;

	@Field("isBreakDown")
	private String isBreakDown;

	@Field("customerFeedback")
	private String customerFeedback;

	@Field("customerBookingDate")
	private Instant customerBookingDate;

	@Field("deleteDescription")
	private String deleteDescription;

	@Field("isBookingDeleted")
	private boolean isBookingDeleted;

	public String getDeleteDescription() {
		return deleteDescription;
	}

	public void setDeleteDescription(String deleteDescription) {
		this.deleteDescription = deleteDescription;
	}

	public boolean getIsBookingDeleted() {
		return isBookingDeleted;
	}

	public void setIsBookingDeleted(boolean isBookingDeleted) {
		this.isBookingDeleted = isBookingDeleted;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getEndTime() {

		String output = null;
		if (endTime != null) {
			Instant instant = endTime.truncatedTo(ChronoUnit.SECONDS);
			output = instant.toString();
		}

		return output;

	}

	public void setEndTime(Instant endTime) {
		this.endTime = endTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDseLoginID() {
		return dseLoginID;
	}

	public void setDseLoginID(String dseLoginID) {
		this.dseLoginID = dseLoginID;
	}

	public String getStartingTime() {
		String output = null;
		if (startingTime != null) {
			Instant instant = startingTime.truncatedTo(ChronoUnit.SECONDS);
			output = instant.toString();
		}

		return output;

	}

	public void setStartingTime(Instant startingTime) {

		this.startingTime = startingTime;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getUpdatedOn() {
		String output = null;
		if (updatedOn != null) {
			Instant instant = updatedOn.truncatedTo(ChronoUnit.SECONDS);
			output = instant.toString();
		}

		return output;

	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCarModelEngineNumber() {
		return carModelEngineNumber;
	}

	public void setCarModelEngineNumber(String carModelEngineNumber) {
		this.carModelEngineNumber = carModelEngineNumber;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEndKm() {
		return endKm;
	}

	public void setEndKm(String endKm) {
		this.endKm = endKm;
	}

	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	public String getCreatedOn() {
		String output = null;
		if (createdOn != null) {
			Instant instant = createdOn.truncatedTo(ChronoUnit.SECONDS);

			output = instant.toString();
		}

		return output;

	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public String getReScheduleFrom() {
		return reScheduleFrom;
	}

	public void setReScheduleFrom(String reScheduleFrom) {
		this.reScheduleFrom = reScheduleFrom;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getClosureComment() {
		return closureComment;
	}

	public void setClosureComment(String closureComment) {
		this.closureComment = closureComment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActualStartTime() {
		String output = null;
		if (actualStartTime != null) {
			Instant instant = actualStartTime.truncatedTo(ChronoUnit.SECONDS);

			output = instant.toString();
		}

		return output;

	}

	public void setActualStartTime(Instant actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}

	public String getActualEndTime() {
		String output = null;
		if (actualEndTime != null) {
			Instant instant = actualEndTime.truncatedTo(ChronoUnit.SECONDS);

			output = instant.toString();
		}

		return output;

	}

	public void setActualEndTime(Instant actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public String getStartKm() {
		return startKm;
	}

	public void setStartKm(String startKm) {
		this.startKm = startKm;
	}

	public String getIsBreakDown() {
		return isBreakDown;
	}

	public void setIsBreakDown(String isBreakDown) {
		this.isBreakDown = isBreakDown;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public String getCustomerBookingDate() {

		String output = null;
		if (customerBookingDate != null) {
			Instant instant = customerBookingDate.truncatedTo(ChronoUnit.SECONDS);

			output = instant.toString();
		}

		return output;

	}

	public void setCustomerBookingDate(Instant customerBookingDate) {
		this.customerBookingDate = customerBookingDate;
	}

	@Override
	public String toString() {
		return "CarBookingsCollection [id=" + id + ", bookingId=" + bookingId + ", customerLocation=" + customerLocation
				+ ", customerMobileNumber=" + customerMobileNumber + ", endTime=" + endTime + ", updatedBy=" + updatedBy
				+ ", dseLoginID=" + dseLoginID + ", startingTime=" + startingTime + ", dealerCode=" + dealerCode
				+ ", teamLeader=" + teamLeader + ", updatedOn=" + updatedOn + ", carModelEngineNumber="
				+ carModelEngineNumber + ", carModelName=" + carModelName + ", customerNotes=" + customerNotes
				+ ", roleId=" + roleId + ", customerName=" + customerName + ", endKm=" + endKm + ", dseName=" + dseName
				+ ", createdOn=" + createdOn + ", reScheduleFrom=" + reScheduleFrom + ", createdBy=" + createdBy
				+ ", closureComment=" + closureComment + ", email=" + email + ", actualStartTime=" + actualStartTime
				+ ", dseMobileNumber=" + dseMobileNumber + ", actualEndTime=" + actualEndTime + ", startKm=" + startKm
				+ ", isBreakDown=" + isBreakDown + ", customerFeedback=" + customerFeedback + ", customerBookingDate="
				+ customerBookingDate + "]";
	}

}
