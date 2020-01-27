package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A CityCollection.
 */
@Document(collection = "city_collection")
public class CityCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("isActive")
    private boolean isActive;
    @Field("cityName")
    private String cityName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove


	public String getCityName() {
		return cityName;
	}


	

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CityCollection)) {
            return false;
        }
        return id != null && id.equals(((CityCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CityCollection{" +
            "id=" + getId() +
            "}";
    }
}
