package org.javamind.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@org.hibernate.annotations.Immutable
//ALSO COULD USE ROWNUM as ID  to generate unique id .
@org.hibernate.annotations.Subselect(value="SELECT item.ITEM_ID AS ITEMID, "
		+ "item.NAME AS NAME, COUNT(bid.BID_ID) AS NUMBEROFBIDS "
		+ "FROM CE_ITEM item "
		+ "LEFT OUTER JOIN CE_BID bid ON bid.ITEM_ID = item.ITEM_ID "
		+ "GROUP BY item.ITEM_ID, item.NAME")
@org.hibernate.annotations.Synchronize({"CE_BID","CE_ITEM"})
public class ItemBidSummary {
	
	@Id
	protected Long itemId;
	protected String name;
	protected Long numberOfBids;
	
	public Long getItemId() {
		return itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public Long getNumberOfBids() {
		return numberOfBids;
	}
}
