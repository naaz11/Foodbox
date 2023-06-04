package com.foodbox.restbackend.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	//Properties
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")    
	private Long id;
	@Column(name="roleType")
	private String roleType;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="dateCreated")
	private Timestamp dateCreated;
	
	//Default Constructor
	public User() {}
	
	//Parameterized Constructors
	//public User(String firstName, String lastName, String email, String password) {		
	//	this.firstName = firstName;
	//	this.lastName = lastName;
	//	this.email = email;
	//	this.password = password;
	//}
		
	public User(String roleType, String firstName, String lastName, String email, String password) {
		this.roleType = roleType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	//Getters & Setters
	public Long getId() {
		return id;
	}
	
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	//Other Methods
	@Override
	public String toString() {
		return "User [id=" + id + ", roleType=" + roleType + ", firstName=" + firstName + ", lastName=" + lastName
				 + ", email=" + email + ", password=" + password  + ", dateCreated=" + dateCreated + "]";
	}

}//end class
