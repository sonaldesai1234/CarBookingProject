package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A CarBook.
 */
@Document(collection = "car_book")
public class CarBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    @Field("bookingId")
    private String bookingId;
    
    @Field( "customerLocation")
    private String  customerLocation;
  
    @Field("customerMobileNumber")
    private String customerMobileNumber;
    
    @Field("bookingDate")
    private String bookingDate;
    
    @Field("customerName")
    private String customerName;
    
    
    @Field("customerNotes")
    private String customerNotes;
    
    public DSExecutive getDsExecutive() {
		return dsExecutive;
	}

	@Field("demoCarModel")
    private DemoCarModelCollection demoCarModel;
    
    
    @Field("userDetails")
    private UserProfile userDetails;
    
    
    @Field("dsExecutive")
    private DSExecutive dsExecutive;
    
    
    public UserProfile getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserProfile userDetails) {
		this.userDetails = userDetails;
	}

	public void setDsExecutive(DSExecutive dsExecutive) {
		this.dsExecutive = dsExecutive;
	}

	@Field("email")
    private String email;
   @Field("endTime")
   private String endTime;
   @Field ("isBookingDeleted")
   private String isBookingDeleted;
   
   @Field("isContactAvailable")
   private String isContactAvailable;
   @Field("isSelected")
   private String isSelected;
   @Field("isSelectedForCS")
   private String isSelectedForCS;
   @Field("startTime")
   private String startTime;
   
   
    
   
    
    
    

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

public String getBookingDate() {
	return bookingDate;
}

public void setBookingDate(String bookingDate) {
	this.bookingDate = bookingDate;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerNotes() {
	return customerNotes;
}

public void setCustomerNotes(String customerNotes) {
	this.customerNotes = customerNotes;
}

public DemoCarModelCollection getDemoCarModel() {
	return demoCarModel;
}

public void setDemoCarModel(DemoCarModelCollection demoCarModel) {
	this.demoCarModel = demoCarModel;
}



public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEndTime() {
	return endTime;
}

public void setEndTime(String endTime) {
	this.endTime = endTime;
}

public String getIsBookingDeleted() {
	return isBookingDeleted;
}

public void setIsBookingDeleted(String isBookingDeleted) {
	this.isBookingDeleted = isBookingDeleted;
}

public String getIsContactAvailable() {
	return isContactAvailable;
}

public void setIsContactAvailable(String isContactAvailable) {
	this.isContactAvailable = isContactAvailable;
}

public String getIsSelected() {
	return isSelected;
}

public void setIsSelected(String isSelected) {
	this.isSelected = isSelected;
}

public String getIsSelectedForCS() {
	return isSelectedForCS;
}

public void setIsSelectedForCS(String isSelectedForCS) {
	this.isSelectedForCS = isSelectedForCS;
}

public String getStartTime() {
	return startTime;
}

public void setStartTime(String startTime) {
	this.startTime = startTime;
}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    
    
    
    @Override
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarBook)) {
            return false;
        }
        return id != null && id.equals(((CarBook) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CarBook{" +
            "id=" + getId() +
            "}";
    }
}
