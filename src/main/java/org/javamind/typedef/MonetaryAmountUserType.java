package org.javamind.typedef;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
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
	public String[] getPropertyNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type[] getPropertyTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPropertyValue(Object arg0, int arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
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
	public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
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
	public void setPropertyValue(Object arg0, int arg1, Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

}
