package com.imdb.topList.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SqLiteDB {

	private static final String jdbcDriver = "org.sqlite.JDBC";
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static final String dbName = "imdbRatings.db";
	private static final String tableName = "imdb";

	public static Connection createConnection() {
		try {
			getConnection();
			if (connection != null) {
				DatabaseMetaData meta = connection.getMetaData();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	private static void getConnection() throws SQLException {
		ClassLoader classLoader = SqLiteDB.class.getClassLoader();
		File file = new File(classLoader.getResource(dbName).getFile());
		connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
	}

	public static Statement creatTable() {
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(60); // set timeout to 60 sec.
			statement.executeUpdate("drop table if exists " + tableName);
			statement.executeUpdate("create table " + tableName + " (movieName string, year integer, ratings double)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	public static void addIntoTable(String movieName, int year, double rating) {
		try {
			statement.executeUpdate(
					"insert into " + tableName + " values(\"" + movieName + "\", " + year + ", " + rating + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printResult() {
		try {
			if (connection == null) {
				getConnection();
			}
			if (statement == null) {
				statement = connection.createStatement();
			}
			resultSet = statement.executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			String line = new String(new char[130]).replace('\0', '-');
			System.out.println(line);
			System.out.format("|%-74S|","Movies-Name");
			System.out.format("|%20S|","Year of release");
			System.out.format("|%20S|","IMDB-Ratings");
			System.out.println("\n"+line);
			String s = null;
			while (resultSet.next()) {

				for (int i = 1; i <= columnsNumber; i++) {
					if (i == 1)	
					s = String.format("|%-74s|", resultSet.getString(i).trim());
					else 
						s = String.format("|%20s|", resultSet.getString(i).trim());
					System.out.print(s);
				}
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
