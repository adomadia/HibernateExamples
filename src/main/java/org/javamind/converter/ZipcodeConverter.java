package org.javamind.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.javamind.entity.GermanZipcode;
import org.javamind.entity.USAZipcode;
import org.javamind.entity.Zipcode;

@Converter
public class ZipcodeConverter implements AttributeConverter<Zipcode, String>{

	@Override
	public String convertToDatabaseColumn(Zipcode attribute) {
		return attribute.getValue();
	}

	@Override
	public Zipcode convertToEntityAttribute(String dbData) {
		if(dbData.length() == 5){
			return new USAZipcode(dbData);
		}
		else if(dbData.length() == 4){
			return new GermanZipcode(dbData);
		}
		
		throw new IllegalArgumentException("Unsupported zipcode in data: " + dbData);
	}

}
