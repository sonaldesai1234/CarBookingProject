package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A TrackRide.
 */
@Document(collection = "track_ride")
public class TrackRide implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("bookingId")
    private String bookingId;
    @Field("dseLoginID")
    private String dseLoginID;
    @Field("rideDetails")
    private RideDetails rideDetails;
    

    public RideDetails getRideDetails() {
		return rideDetails;
	}

	public void setRideDetails(RideDetails rideDetails) {
		this.rideDetails = rideDetails;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getDseLoginID() {
		return dseLoginID;
	}

	public void setDseLoginID(String dseLoginID) {
		this.dseLoginID = dseLoginID;
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
        if (!(o instanceof TrackRide)) {
            return false;
        }
        return id != null && id.equals(((TrackRide) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TrackRide{" +
            "id=" + getId() +
            "}";
    }
}
