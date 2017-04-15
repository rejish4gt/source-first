package com.deccanherald.type;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

public class StringArrayUserType implements UserType {
	protected static final int SQLTYPE = java.sql.Types.ARRAY;

	@Override
	public int[] sqlTypes() {
		return new int[] { SQLTYPE };
	}

	@Override
	public Class<String[]> returnedClass() {
		return String[].class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x == null ? y == null : x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x == null ? 0 : x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Array array = rs.getArray(names[0]);
		String[] stringArray = null;
		if (array != null)
			stringArray = (String[]) array.getArray();
		return stringArray;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, sqlTypes()[0]);
		} else {
			String[] castObject = (String[]) value;
			Array array = session.connection().createArrayOf("text", castObject);
			st.setArray(index, array);
		}
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return value == null ? null : (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}
