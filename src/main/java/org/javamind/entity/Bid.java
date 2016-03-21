package org.javamind.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="BID")
@org.hibernate.annotations.Immutable
public class Bid {
	
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="BID_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	protected Item item;

	/*public Bid(Item item){
		this.item = item;
		item.getBids().add(this);
	}*/
	
	
	public Long getId() {
		return id;
	}
	
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

}
