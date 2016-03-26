package org.javamind.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class City {
	
	@NotNull
	@Column(name="CITY", nullable=false)
	protected String name;
	
	@NotNull
	@Column(name="ZIPCODE", nullable=false)
	protected Zipcode zipcode;
	
	@NotNull
	@Column(name="COUNTRY", nullable=false)
	protected String country;
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String city, Zipcode zipcode, String country) {
		super();
		this.name = city;
		this.zipcode = zipcode;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String city) {
		this.name = city;
	}

	public Zipcode getZipcode() {
		return zipcode;
	}

	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [city=" + name + ", zipcode=" + zipcode + ", country="
				+ country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
	

}
