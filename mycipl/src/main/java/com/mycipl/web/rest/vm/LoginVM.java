package com.mycipl.web.rest.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View Model object for storing a user's credentials.
 */
public class LoginVM {

	@NotNull
	@Size(min = 1, max = 50)
	private String dseLoginId;

	@NotNull
	@Size(min = ManagedUserVM.PASSWORD_MIN_LENGTH, max = ManagedUserVM.PASSWORD_MAX_LENGTH)
	private String dsePassword;

	private Boolean rememberMe;

	public String getDseLoginId() {
		return dseLoginId;
	}

	public void setDseLoginId(String dseLoginId) {
		this.dseLoginId = dseLoginId;
	}

	public String getDsePassword() {
		return dsePassword;
	}

	public void setDsePassword(String dsePassword) {
		this.dsePassword = dsePassword;
	}

	public Boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "LoginVM{" + "dseLoginId='" + dseLoginId + '\'' + ", rememberMe=" + rememberMe + '}';
	}
}
