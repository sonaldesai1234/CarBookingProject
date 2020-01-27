package com.mycipl.domain;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


public class SocialClass {

	
	private String dseLoginId;
	private String token;
	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}



	private Set<String> role;
	
	

	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}



	private String createdOn;
	
	private String updatedOn;
	

	public String getCreatedOn() {
		return createdOn;
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



	private boolean passwordChange;
	private String dLastLogin;
	@Email
	@Size(min = 5, max = 254)
	private String email;
	private String dealerName;
	private String dealerLocation;
	private String teamLeader;
	@Size(max=12)
	private String dseMobileNumber;
	private String dseName;
	private boolean accountLocked;
	

	
	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	private String updatedBy;


	
	
	
	
	private String createdBy;
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	private boolean isActive;
	private Set<String> dealerCode;
	

	

	

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

	public String getDealerLocation() {
		return dealerLocation;
	}

	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}

	public boolean isPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(boolean passwordChange) {
		this.passwordChange = passwordChange;
	}


	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<String> getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(Set<String> dealerCode) {
		this.dealerCode = dealerCode;
	}

	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDseLoginId() {
		return dseLoginId;
	}

	public void setDseLoginId(String dseLoginId) {
		this.dseLoginId = dseLoginId;
	}

	
	

}
