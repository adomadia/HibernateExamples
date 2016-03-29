package org.javamind.typedef;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.DynamicParameterizedType;

public class MonetaryAmountUserType 
	implements CompositeUserType, DynamicParameterizedType
{

	@Override
	public void setParameterValues(Properties parameters) {
		
		
	}

	@Override
	public Object assemble(Serializable arg0, SessionImplementor arg1, Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable disassemble(Object arg0, SessionImplementor arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
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
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
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
	public Object replace(Object arg0, Object arg1, SessionImplementor arg2, Object arg3) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class returnedClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPropertyValue(Object arg0, int arg1, Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

}
