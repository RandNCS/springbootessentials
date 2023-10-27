package com.jpaspring.hibernate.onetomany.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CommentIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "COM";
		int initCounter = 101;
		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(id) as Id from comments");

			if (rs.next()) {
				int id = rs.getInt(1) + initCounter;
				String generatedId = prefix + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}