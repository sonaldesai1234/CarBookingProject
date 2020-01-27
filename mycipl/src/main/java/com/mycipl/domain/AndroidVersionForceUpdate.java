package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

/**
 * A AndroidVersionForceUpdate.
 */
@Document(collection = "android_version_force_update")
public class AndroidVersionForceUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("isForceUpdate")
    private boolean isForceUpdate;
    
    @Field("versionName")
    private Double versionName;
    
      
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   

	public boolean getIsForceUpdate() {
		return isForceUpdate;
	}

	public void setIsForceUpdate(boolean isForceUpdate) {
		this.isForceUpdate = isForceUpdate;
	}

	public Double getVersionName() {
		return versionName;
	}

	public void setVersionName(Double versionName) {
		this.versionName = versionName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AndroidVersionForceUpdate)) {
            return false;
        }
        return id != null && id.equals(((AndroidVersionForceUpdate) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AndroidVersionForceUpdate{" +
            "id=" + getId() +
            "}";
    }
}
