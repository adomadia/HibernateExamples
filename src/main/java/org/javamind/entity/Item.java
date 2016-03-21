package org.javamind.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ITEM")
public class Item {
	
	@Id
	@GeneratedValue(generator="ID_GENERATOR")
	@Column(name="ITEM_ID")
	private Long id;
	
	@Column(name="NAME")
	@NotNull
	@Size(
		min=2,
		max=255,
		message = "Name is required, maximum 255 characters.")
	protected String name;
	
	@Column(name="BUY_NOW_PRICE")
	protected BigDecimal buyNowPrice;
	
	@Future
	@Column(name="AUCTION_END")
	protected Date auctionEnd;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="item")
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
