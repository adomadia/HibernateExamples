package org.javamind.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BID")
public class Bid {
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	protected Item item;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

}
