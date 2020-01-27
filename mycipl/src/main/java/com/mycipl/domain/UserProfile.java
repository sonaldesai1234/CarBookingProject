package com.mycipl.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A UserProfile.
 */
@Document(collection = "user_profile")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Field("dseName")
	private String dseName;

	@Field("dLastLogin")
	private String dLastLogin;

	public String getDsePassword() {
		return dsePassword;
	}

	public void setDsePassword(String dsePassword) {
		this.dsePassword = dsePassword;
	}

	@javax.validation.constraints.Email
	@Field("email")
	private String email;
	
	private String createdOn;
	
	public String getCreatedOn() {

		 Instant instant = Instant.now().truncatedTo( ChronoUnit.SECONDS );
			
			return instant.toString();
		
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Field("createdBy")
	private String createdBy;
	
	@Field("updatedBy")
	private String updatedBy;
	
	@Field("dseMobileNumber")
	private String dseMobileNumber;
	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Size(min=5,max=60)
	private String dsePassword;
	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Field("dealerName")
	private String dealerName;

	@Field("dealerLocation")
	private String dealerLocation;

	@Field("dealerCode")
	private Set<String> dealerCode;
	
	@Field("dseLoginId")
	private String dseLoginId;
	
	@Field("isActive")
	private boolean isActive;
	
	@Field("passwordChange")
	private boolean passwordChange;
	
	

	@Field("accountLocked")
	private boolean accountLocked;
	

	
	
	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	@Field("role")
	private Set<String> role;

	@Field("teamLeader")
	private String teamLeader;
	
	
	
	
	private String updatedOn;
	




	

	public String getUpdatedOn() {
        Instant instant = Instant.now().truncatedTo( ChronoUnit.SECONDS );
		
		return instant.toString();
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getDseLoginId() {
		return dseLoginId;
	}

	public void setDseLoginId(String dseLoginId) {
		this.dseLoginId = dseLoginId;
	}

	
	

	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}

	

	

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	

	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public Set<String> getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(Set<String> dealerCode) {
		this.dealerCode = dealerCode;
	}

	

	

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public boolean isPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(boolean passwordChange) {
		this.passwordChange = passwordChange;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserProfile userProfile = (UserProfile) o;
		if (userProfile.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), userProfile.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	

	
}
