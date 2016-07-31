package org.eurekaclinical.eureka.client.comm;

/*
 * #%L
 * Eureka Common
 * %%
 * Copyright (C) 2012 - 2013 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import org.eurekaclinical.eureka.client.comm.authentication.LoginType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * @author hrathod
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LocalUser.class, name = "LOCAL"),
    @JsonSubTypes.Type(value = OAuthUser.class, name = "OAUTH"),
    @JsonSubTypes.Type(value = LdapUser.class, name = "LDAP")
})
public abstract class User extends org.eurekaclinical.common.comm.User implements UserVisitable {

    private Date created;
    private boolean active;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String organization;
    private Date lastLogin;
    private String title;
    private String department;
    private LoginType loginType;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean inActive) {
        active = inActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String inFirstName) {
        firstName = inFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String inLastName) {
        lastName = inLastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String inEmail) {
        email = inEmail;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String inOrganization) {
        organization = inOrganization;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date inLastLogin) {
        lastLogin = inLastLogin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    protected void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    /**
     * Validate a {@link User} object. Two rules are implemented: 1) The email
     * addresses in the two email fields must match, and 2) The passwords in the
     * two password fields must match.
     *
     * @return an array of validation error messages, or an empty array if
     * validation succeeded.
     */
    public String[] validate() {
        List<String> result = new ArrayList<>();

        if (getUsername() == null) {
            result.add("Username unspecified");
        }
        if (this.email == null) {
            result.add("Email unspecified");
        }

        return result.toArray(new String[result.size()]);
    }

    public abstract org.eurekaclinical.eureka.client.comm.authentication.AuthenticationMethod authenticationMethod();

}
