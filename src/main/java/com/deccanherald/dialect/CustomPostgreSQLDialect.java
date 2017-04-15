package com.deccanherald.dialect;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL94Dialect;

public class CustomPostgreSQLDialect extends PostgreSQL94Dialect {

	public CustomPostgreSQLDialect()
	{
		super();
		registerColumnType(Types.ARRAY, "int8[$1]");
		registerColumnType(Types.ARRAY, "text[]");
		registerColumnType(Types.JAVA_OBJECT, "json");
	}

}
