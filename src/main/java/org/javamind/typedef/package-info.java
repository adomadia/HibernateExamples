/**
 * 
 */
/**
 * @author adomadia
 *
 */

@org.hibernate.annotations.TypeDefs({
	@org.hibernate.annotations.TypeDef(
		name="monetary_amount_usd",
		typeClass = org.javamind.typedef.MonetaryAmountUserType.class,
		parameters = {@org.hibernate.annotations.Parameter(name="convertTo", value="USD")}
	),
	@org.hibernate.annotations.TypeDef(
		name="monetary_amount_eur",
		typeClass = org.javamind.typedef.MonetaryAmountUserType.class,
		parameters = {@org.hibernate.annotations.Parameter(name="convertTo", value="EUR")})
})


package org.javamind.typedef;
