package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A DemoCarModelCollection. Some field add for car book 
 */
@Document(collection = "demo_car_model_collection")
public class DemoCarModelCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field("carModelColour")
    private String carModelColour;
    @Field("isCarActive")
    private boolean isCarActive;

	 public boolean getIsCarActive() { return isCarActive; }
	 
	 public void setIsCarActive(boolean isCarActive) {
		 this.isCarActive =isCarActive; 
		 }

	@Field("dealerCode")
    private String dealerCode;
    @Field("carModelName")
    private String carModelName;
    @Field("carModelEngineNumber")
    private String carModelEngineNumber;
  

	public boolean isCarActive() {
		return isCarActive;
	}

	public void setCarActive(boolean isCarActive) {
		this.isCarActive = isCarActive;
	}

	public String getCarModelColour() {
		return carModelColour;
	}

	public void setCarModelColour(String carModelColour) {
		this.carModelColour = carModelColour;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public String getCarModelEngineNumber() {
		return carModelEngineNumber;
	}

	public void setCarModelEngineNumber(String carModelEngineNumber) {
		this.carModelEngineNumber = carModelEngineNumber;
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
        if (!(o instanceof DemoCarModelCollection)) {
            return false;
        }
        return id != null && id.equals(((DemoCarModelCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DemoCarModelCollection{" +
            "id=" + getId() +
            "}";
    }
}
