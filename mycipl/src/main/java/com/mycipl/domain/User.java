package com.mycipl.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycipl.config.Constants;

/**
 * A user.
 */

@org.springframework.data.mongodb.core.mapping.Document(collection = "_user")
public class User extends AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	@NotNull
	@Pattern(regexp = Constants.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	@Indexed
	private String dseLoginId;

	
	@JsonIgnore
	
	@Size(min = 60, max = 60)
	private String password;
	
	

	@Size(max = 50)
	@Field("first_name")
	private String firstName;

	@Size(max = 50)
	@Field("last_name")
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	@Indexed
	private String email;
	

	private boolean activated = false;
	
	
	

	public boolean isAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	private String dseName;
	
	private boolean isActive;
	
	
	
	private String updatedBy;
	
	 private String createdBy;
		
		public String testdemo;
		public String getTestdemo() {
			return testdemo;
		}

		public void setTestdemo(String testdemo) {
			this.testdemo = testdemo;
		}

		private boolean passwordChange;
		
		private boolean accountLocked;
		
		private String createdOn;
		
		private String updatedOn;
		
		@Size(min=5,max=60)
		private String dsePassword;
		
		private String dealerLocation;
		
		private String dLastLogin;

		@Size(min=10 ,max=12)
		private String dseMobileNumber;
		
		private Set<String> role;

		
		private String dealerName;
		
		public String getCreatedOn() {
			Instant instant = Instant.now().truncatedTo( ChronoUnit.SECONDS );
			
			return instant.toString();
		}

		public void setCreatedOn(String createdOn) {
			this.createdOn = createdOn;
		}

		public String getUpdatedOn() {
			Instant instant = Instant.now().truncatedTo( ChronoUnit.SECONDS );
			
			return instant.toString();
		}

		public void setUpdatedOn(String updatedOn) {
			this.updatedOn = updatedOn;
		}

		
		
		public Set<String> getRole() {
			return role;
		}

		public void setRole(Set<String> role) {
			this.role = role;
		}

	
		private String dseDealerCode;
		private String teamLeader;
	
	

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	
	
	

	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}

	public String getDsePassword() {
		return dsePassword;
	}

	public void setDsePassword(String dsePassword) {
		this.dsePassword = dsePassword;
	}

	public String getDseDealerCode() {
		return dseDealerCode;
	}

	public void setDseDealerCode(String dseDealerCode) {
		this.dseDealerCode = dseDealerCode;
	}


	@Size(min = 2, max = 6)
	@Field("lang_key")
	private String langKey;

	@Size(max = 256)
	@Field("image_url")
	private String imageUrl;

	@Size(max = 20)
	@Field("activation_key")
	@JsonIgnore
	private String activationKey;

	@Size(max = 20)
	@Field("reset_key")
	@JsonIgnore
	private String resetKey;

	@Field("reset_date")
	private Instant resetDate = null;
	

	

	@JsonIgnore
	private Set<Authority> authorities = new HashSet<>();

	/*@Email
	@Size(min = 5, max = 254)
	private String emailId;*/
	
/*	@Size(max=12)
	private String contactNumber;
	*/
	
	

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
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




	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}


	
	
	private Set<String> dealerCode;

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

	public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

	
	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean getActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getResetKey() {
		return resetKey;
	}

	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	public Instant getResetDate() {
		return resetDate;
	}

	public void setResetDate(Instant resetDate) {
		this.resetDate = resetDate;
	}

	public String getLangKey() {
		return langKey;
	}

	public void setLangKey(String langKey) {
		this.langKey = langKey;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		User user = (User) o;
		return !(user.getId() == null || getId() == null) && Objects.equals(getId(), user.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "User{" + "dseLoginId='" + dseLoginId + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName
				+ '\'' + ", email='" + email + '\'' + ", imageUrl='" + imageUrl + '\'' + ", activated='" + activated
				+ '\'' + ", langKey='" + langKey + '\'' + ", activationKey='" + activationKey + '\'' + "}";
	}

	
}
