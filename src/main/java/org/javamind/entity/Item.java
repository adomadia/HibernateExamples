package org.javamind.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	private Long id;
	protected String name;
	protected BigDecimal buyNowPrice;
	protected Set<Bid> bids = new HashSet<>();

	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBuyNowPrice(BigDecimal buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}
	
	public BigDecimal getBuyNowPrice() {
		return buyNowPrice;
	}
	
	private void setBids(Set<Bid> bids) {
		this.bids = bids;
	}
	
	public Set<Bid> getBids() {
		return Collections.unmodifiableSet(bids);
	}
	
	public void addBid(Bid bid){
		if(bid == null)
			throw new NullPointerException("Can't add null bid.");
		
		if(bid.getItem() != null)
			throw new IllegalStateException("Bid is already assigned to an item");
		
		bids.add(bid);
		bid.setItem(this);
	}

}
