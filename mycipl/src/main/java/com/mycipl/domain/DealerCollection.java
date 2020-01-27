package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * A DealerCollection.
 */
@Document(collection = "dealer_collection")
public class DealerCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    @Field("address")
    private String address;
    @Field("location")
    private String location;
    @Field("name")
    private String name;
    @Field("cityName")
    private String cityName;
    @Field("dealerCode")
    private String dealerCode;
    @Field("isActive")
    private boolean isActive;
   

	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDealerCode() {
		return dealerCode;
	
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
        if (!(o instanceof DealerCollection)) {
            return false;
        }
        return id != null && id.equals(((DealerCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DealerCollection{" +
            "id=" + getId() +
            "}";
    }
}
