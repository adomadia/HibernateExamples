package org.javamind.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User implements Serializable{
	
	@Column(name="USERNAME")
	protected String username;
	
	@Column(name="FIRSTNAME")
	protected String firstname;
	
	@Column(name="LASTNAME")
	protected String lastname;
	
	public User() {
		// TODO Auto-generated constructor stub
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
