package org.javamind.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class User implements Serializable{
	
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="USER_ID")
	protected Long id;
	
	@Column(name="USER_NAME", unique=true)
	protected String username;
	
	@Column(name="FIRST_NAME")
	protected String firstname;
	
	@Column(name="LAST_NAME")
	protected String lastname;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getName(){
		return firstname + " " + lastname;
	}
	
	public void setName(String name){
		StringTokenizer t = new StringTokenizer(name);
		this.firstname = t.nextToken();
		this.lastname = t.nextToken();
	}
	
	public BigDecimal calcShippingCosts(Address fromLocation){
		
		//Emtyp implementation for bussiness method.
		return null;
	}

}
