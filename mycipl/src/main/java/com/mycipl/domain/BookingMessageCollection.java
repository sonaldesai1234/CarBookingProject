package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;


import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A BookingMessageCollection.
 */
@Document(collection = "booking_message_collection")
public class BookingMessageCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("dseLoginID")
    private String dseLoginID;
    
    @Field("to")
    private String to;
    
    @Field("dseNumber")
    private String dseNumber;
    
    @Field("carModelName")
    private String carModelName;
    
    
    public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDseNumber() {
		return dseNumber;
	}

	public void setDseNumber(String dseNumber) {
		this.dseNumber = dseNumber;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	
   
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    
   
    
    public String getDseLoginID() {
		return dseLoginID;
	}

	public void setDseLoginID(String dseLoginID) {
		this.dseLoginID = dseLoginID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookingMessageCollection)) {
            return false;
        }
        return id != null && id.equals(((BookingMessageCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BookingMessageCollection{" +
            "id=" + getId() +
            "}";
    }
}
