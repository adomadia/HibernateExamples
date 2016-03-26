package org.javamind.entity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;
import org.javamind.converter.MonetaryAmountConverter;



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
	@Access(AccessType.PROPERTY)
	protected String name;
	
	@Column(name="BUY_NOW_PRICE",
			nullable = false)
	@Convert(converter=MonetaryAmountConverter.class, disableConversion=false)
	protected MonetaryAmount buyNowPrice;
	
	@Column(name="STARTL_PRICE", 
			nullable = false, insertable=false)
	@org.hibernate.annotations.ColumnDefault("1.00")
	@org.hibernate.annotations.Generated(GenerationTime.INSERT)
	protected BigDecimal intialPrice;
	
	@Future
	@Column(name="AUCTION_END")
	protected Date auctionEnd;
	
	@org.hibernate.annotations.Formula(value="SELECT AVG(b.AMOUNT) FROM BID b WHERE b.ITEM_ID = ID")
	protected BigDecimal averageBidPrice;
	
	@Column(name="IMPERIAL_WEIGHT")
	@org.hibernate.annotations.ColumnTransformer(
			read="IMPERIAL_WEIGHT/2.20462",
			write="? * 2.20462"
	)
	protected double metricWeight;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(
		name="LAST_MODIFIED", 
		updatable =false, 
		insertable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	//@org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
	@org.hibernate.annotations.UpdateTimestamp
	protected Date lastModified;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON", updatable=false)
	@org.hibernate.annotations.CreationTimestamp
	protected Date createdOn;

	@Column(name="AUCTION_TYPE")
	@NotNull
	@Enumerated(EnumType.STRING)
    protected AuctionType auctionType = AuctionType.HIGHEST_BID;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="item")
	protected Set<Bid> bids = new HashSet<>();

	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		
		this.name = !name.startsWith("AUCTION: ") ? "AUCTION: " + name : name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
		this.buyNowPrice = buyNowPrice;
	}
	
	public MonetaryAmount getBuyNowPrice() {
		return buyNowPrice;
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

	public Date getAuctionEnd() {
		return auctionEnd;
	}
	
	public void setAuctionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}
	
	public BigDecimal getIntialPrice() {
		return intialPrice;
	}
	
	public void setIntialPrice(BigDecimal intialPrice) {
		this.intialPrice = intialPrice;
	}
	
	public BigDecimal getAverageBidPrice() {
		return averageBidPrice;
	}
	
	public Date getLastModified() {
		return lastModified;
	}
	
	public double getMetricWeight() {
		return metricWeight;
	}
	
	public void setMetricWeight(double metricWeight) {
		this.metricWeight = metricWeight;
	}
	
	public AuctionType getAuctionType() {
		return auctionType;
	}
	
	public void setAuctionType(AuctionType auctionType) {
		this.auctionType = auctionType;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	
}
