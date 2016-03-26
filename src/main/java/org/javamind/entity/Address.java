package org.javamind.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {
	
	@NotNull
	@Column(name="STREET", nullable=false)
	protected String street;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="CITY")),
		@AttributeOverride(name="zipcode", column=@Column(name="ZIPCODE")),
		@AttributeOverride(name="country", column=@Column(name="COUNTRY"))
	})
	protected City city;
	
	@NotNull
	@Column(name="STATE", nullable=false)
	protected String state;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String state, String zipcode, String country){
		this.street = street;
		City cty = new City(city, new Zipcode(zipcode), country);
		this.city = cty;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state="
				+ state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
