package org.javamind.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.StringTokenizer;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="USER", uniqueConstraints={@UniqueConstraint(columnNames="USER_NAME", name="UK_USERNAME")})
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class User implements Serializable {

	@Id
	@GeneratedValue(generator = "ID_GENERATOR")
	@Column(name = "USER_ID")
	protected Long id;

	@Column(name = "USER_NAME", unique = true, nullable = false)
	protected String username;

	@Column(name = "FIRST_NAME", nullable = false)
	protected String firstname;

	@Column(name = "LAST_NAME", nullable = false)
	protected String lastname;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
			@AttributeOverride(name = "city.name", column = @Column(name = "BILLING_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "BILLING_STATE")),
			@AttributeOverride(name = "city.zipcode", column = @Column(name = "BILLING_ZIPCODE", length = 5)),
			@AttributeOverride(name = "city.country", column = @Column(name = "BILLING_COUNTRY")) })
	protected Address billingAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "SHIPPIN_STREET", nullable = false)),
			@AttributeOverride(name = "city.name", column = @Column(name = "SHIPPING_CITY", nullable = false)),
			@AttributeOverride(name = "state", column = @Column(name = "SHIPPING_STATE", nullable = false)),
			@AttributeOverride(name = "city.zipcode", column = @Column(name = "SHIPPING_ZIPCODE", nullable = false, length = 5)),
			@AttributeOverride(name = "city.country", column = @Column(name = "SHIPPING_COUNTRY", nullable = false)) })
	protected Address shippingAddress;

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

	public String getName() {
		return firstname + " " + lastname;
	}

	public void setName(String name) {
		StringTokenizer t = new StringTokenizer(name);
		this.firstname = t.nextToken();
		this.lastname = t.nextToken();
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public BigDecimal calcShippingCosts(Address fromLocation) {

		// Emtyp implementation for bussiness method.
		return null;
	}

}
