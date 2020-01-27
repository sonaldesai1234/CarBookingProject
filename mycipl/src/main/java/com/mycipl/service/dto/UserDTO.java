package com.mycipl.service.dto;

import com.mycipl.config.Constants;

import com.mycipl.domain.Authority;
import com.mycipl.domain.User;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	




	private String id;

	
	private boolean isActive;
	
	private String updatedBy;
	
	
	

	private String dealerName;
	

	private String dealerLocation;
	
	private boolean passwordChange;
	
	private  String createdOn;
	
	
	
	private String updatedOn;
	

	
	public String getCreatedOn() {
		 Instant instant = Instant.now().truncatedTo( ChronoUnit.SECONDS );
			
			return instant.toString();
		
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}






	private String dseName;
	
	private String dseLogin;

	public String getDseLogin() {
		return dseLogin;
	}

	public void setDseLogin(String dseLogin) {
		this.dseLogin = dseLogin;
	}

	@Email
	@Size(min = 5, max = 254)
	private String emailId;
	
	
	@Size(max=12)
	private String dseMobileNumber;

	@NotBlank
	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	private String dseLoginId;
	
	
	private Set<String> dealerCode;
	

	
	private String dLastLogin;

	private Set<String> role;
	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	private String email;

	@Size(max = 256)
	private String imageUrl;

	private boolean activated = false;

	@Size(min = 2, max = 6)
	private String langKey;

	private String createdBy;
	
	private Instant createdDate;

	private String  lastModifiedBy;

	private Instant lastModifiedDate;

	private Set<String> authorities;
	
	private String teamLeader;

	private boolean accountLocked;
	
	
	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public boolean isPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(boolean passwordChange) {
		this.passwordChange = passwordChange;
	}

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	
	
	
	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}

	public Set<String> getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(Set<String> dealerCode) {
		this.dealerCode = dealerCode;
	}

	
	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}


	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	

	



	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}

	
	public UserDTO() {
		// Empty constructor needed for Jackson.
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.dseLoginId = user.getDseLoginId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.activated = user.getActivated();
		this.imageUrl = user.getImageUrl();
		this.langKey = user.getLangKey();
		this.createdBy = user.getCreatedBy();
		this.createdDate = user.getCreatedDate();
		this.lastModifiedBy = user.getLastModifiedBy();
		this.lastModifiedDate = user.getLastModifiedDate();
		this.authorities = user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDseLoginId() {
		return dseLoginId;
	}

	public void setDseLoginId(String dseLoginId) {
		this.dseLoginId = dseLoginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserDTO{" + "dseLoginId='" + dseLoginId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", imageUrl='" + imageUrl + '\'' + ", activated=" + activated
				+ ", langKey='" + langKey + '\'' + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastModifiedBy='" + lastModifiedBy + '\'' + ", lastModifiedDate=" + lastModifiedDate
				+ ", authorities=" + authorities + "}";
	}
}
