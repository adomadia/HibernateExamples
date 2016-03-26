package org.javamind.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.javamind.entity.MonetaryAmount;

@Converter(autoApply=true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

	@Override
	public String convertToDatabaseColumn(MonetaryAmount attribute) {
		return attribute.toString();
	}

	@Override
	public MonetaryAmount convertToEntityAttribute(String dbData) {
		return MonetaryAmount.fromString(dbData);
	}

}
