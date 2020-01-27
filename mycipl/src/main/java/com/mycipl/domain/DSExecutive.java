package com.mycipl.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * A DSExecutive.
 */
@Document(collection = "dsexecutive")
public class DSExecutive implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    
    @Field("dseName")
	private String dseName;
	@Field("dseLoginId")
	private String dseLoginId;
	@Field("dsePassword")
	private String dsePassword;
	@Field("dseMobileNumber")
	private String dseMobileNumber;
	@Field("dseDealerCode")
	private String dseDealerCode;
	@Field("dLastLogin")
	private String dLastLogin;
	@Field("teamLeader")
	private String teamLeader;
	@Field("roleId")
	private String roleId;
	
	

    public String getDseName() {
		return dseName;
	}

	public void setDseName(String dseName) {
		this.dseName = dseName;
	}

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

	public String getDseMobileNumber() {
		return dseMobileNumber;
	}

	public void setDseMobileNumber(String dseMobileNumber) {
		this.dseMobileNumber = dseMobileNumber;
	}

	public String getDseDealerCode() {
		return dseDealerCode;
	}

	public void setDseDealerCode(String dseDealerCode) {
		this.dseDealerCode = dseDealerCode;
	}

	public String getdLastLogin() {
		return dLastLogin;
	}

	public void setdLastLogin(String dLastLogin) {
		this.dLastLogin = dLastLogin;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
        if (!(o instanceof DSExecutive)) {
            return false;
        }
        return id != null && id.equals(((DSExecutive) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DSExecutive{" +
            "id=" + getId() +
            "}";
    }
}
