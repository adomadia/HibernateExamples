package org.javamind.typedef;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.DynamicParameterizedType;
import org.javamind.entity.MonetaryAmount;

public class MonetaryAmountUserType  
	implements CompositeUserType, DynamicParameterizedType{

	protected Currency convertTo;
	
	@Override
	public void setParameterValues(Properties parameters) {
		ParameterType parameterType = (ParameterType)parameters.get(PARAMETER_TYPE);
		String[] columns = parameterType.getColumns();
		String table = parameterType.getTable();
		Annotation[] annotations = parameterType.getAnnotationsMethod();
		
		String convertToParameter = parameters.getProperty("convertTo");
		this.convertTo = Currency.getInstance(convertToParameter != null ? convertToParameter : "USD");
	}

	@Override
	public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException {
		return MonetaryAmount.fromString((String)cached);
		
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public Serializable disassemble(Object value, SessionImplementor session) throws HibernateException {
		return value.toString();
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y || !(x == null || y == null)  && x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		if(resultSet.wasNull()) return null;
		BigDecimal amount = resultSet.getBigDecimal(names[0]);
		Currency currency = Currency.getInstance(resultSet.getString(names[1]));
		return new MonetaryAmount(amount, currency);
	}

	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {

		if(value==null){
			statement.setNull(index, StandardBasicTypes.BIG_DECIMAL.sqlType());
			statement.setNull(index + 1,  StandardBasicTypes.CURRENCY.sqlType());
			
		}
		else {
			MonetaryAmount amount = (MonetaryAmount) value;
			MonetaryAmount dbAmount =  convert(amount, convertTo);
			statement.setBigDecimal(index, dbAmount.getValue());
			statement.setString(index + 1, convertTo.getCurrencyCode());
		}
	}

	@Override
	public Object replace(Object original, Object target, SessionImplementor session, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public Class returnedClass() {
		return MonetaryAmount.class;
	}

	@Override
	public void setPropertyValue(Object component, int property, Object value) throws HibernateException {
		throw new UnsupportedOperationException("MonetaryAmount is immutable");
		
	}

	@Override
	public Object getPropertyValue(Object component, int property) throws HibernateException {
		MonetaryAmount monetaryAmount = (MonetaryAmount)component;
		if(property == 0) return monetaryAmount.getValue();
		else return monetaryAmount.getCurrency();
	}
	
	@Override
	public String[] getPropertyNames() {
		return new String[]{"value","currency"};
	}

	@Override
	public Type[] getPropertyTypes() {
		return new Type[]{StandardBasicTypes.BIG_DECIMAL, StandardBasicTypes.CURRENCY};
	}

	protected MonetaryAmount convert(MonetaryAmount amount, Currency toCurrency){
		return new MonetaryAmount(amount.getValue().multiply(new BigDecimal(2)), toCurrency);
	}
}
