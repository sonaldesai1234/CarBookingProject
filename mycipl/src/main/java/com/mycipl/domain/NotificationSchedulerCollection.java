package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A NotificationSchedulerCollection.
 */
@Document(collection = "notification_scheduler_collection")
public class NotificationSchedulerCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("message")
    private String message;
    
    @Field("title")
    private String title;
    
    @Field("dseLoginId")
    private String dseLoginId;
    
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDseLoginId() {
		return dseLoginId;
	}

	public void setDseLoginId(String dseLoginId) {
		this.dseLoginId = dseLoginId;
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
        if (!(o instanceof NotificationSchedulerCollection)) {
            return false;
        }
        return id != null && id.equals(((NotificationSchedulerCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "NotificationSchedulerCollection{" +
            "id=" + getId() +
            "}";
    }
}
