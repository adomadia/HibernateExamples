/**
 * 
 */
/**
 * @author adomadia
 *
 */



@org.hibernate.annotations.NamedQueries({
	@org.hibernate.annotations.NamedQuery(
		name="findItemsOrderByName",
		query="SELECT item  FROM Item item ORDER BY item.name asc"
	),
	@org.hibernate.annotations.NamedQuery(
		name="findItemBuyNowPriceGreaterThan",
		query = "SELECT item FROM Item item WHERE item.buyNowPrice > :price",
		timeout = 60,
		comment = "Custom SQL comment"
	)
})
package org.javamind.entity.querying;