package com.jpaspring.hibernate.onetomany.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Author: Randjith
 * Created on: 23 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
public class TutorialIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix = "TUT";
		int initCounter = 101;
		Connection connection = session.connection();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(id) as Id from tutorials");

			if (rs.next()) {
				int id = rs.getInt(1) + initCounter;
				String generatedId = prefix + new Integer(id).toString();
				System.out.println("Generated Id: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}