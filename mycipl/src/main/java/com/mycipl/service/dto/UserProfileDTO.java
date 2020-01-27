package com.mycipl.service.dto;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserProfileDTO {

	
	private String id;
	
	public String getDsePassword() {
		return dsePassword;
	}

	public void setDsePassword(String dsePassword) {
		this.dsePassword = dsePassword;
	}
	

	@NotBlank
	private String dseLoginId;

	private String dsePassword;

	private String dseName;
	
	@Size(max=12)
	private String dseMobileNumber;
	
	private String createdBy;
	
	
	private String updatedBy;
	private String token;
	private boolean  accountLocked;
	private String password;

	private String createdOn;
	
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

	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}

	@Email
	private String email;
	
	
	private boolean passwordChange;
	
	private Set<String> role;

	private Set<String> dealerCode;
	
	private String dealerName;

	

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	private String dealerLocation;

	private String teamLeader;
	
	private String dLastLogin;
	
	private boolean isActive;
	
	//private String dseLogin;
	//private String AccountLocked;
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	

	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
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

	public boolean getPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(boolean passwordChange) {
		this.passwordChange = passwordChange;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRoleId(Set<String> role) {
		this.role = role;
	}

	public Set<String> getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(Set<String> dealerCode) {
		this.dealerCode = dealerCode;
	}

}
