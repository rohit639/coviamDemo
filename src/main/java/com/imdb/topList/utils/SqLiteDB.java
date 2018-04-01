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
	
	public static Connection getConnection() {
		 try {
			 ClassLoader classLoader = SqLiteDB.class.getClassLoader();
			 File file = new File(classLoader.getResource(dbName).getFile());
			connection = DriverManager.getConnection("jdbc:sqlite:"+file.getAbsolutePath());
			if (connection != null) {
	             DatabaseMetaData meta = connection.getMetaData();
	             System.out.println("The driver name is " + meta.getDriverName());
	             System.out.println("A new database has been created.");
	         }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		 return connection;
	}
	
	public static Statement creatTable() {
		 try {
			statement = connection.createStatement();
			statement.setQueryTimeout(60);  // set timeout to 60 sec.
	        statement.executeUpdate("drop table if exists "+tableName);
	        statement.executeUpdate("create table "+tableName+" (movieName string, year integer, ratings double)");
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return statement;
	}
	
	public static void addIntoTable(String movieName,int year,double rating) {
		try {
			statement.executeUpdate("insert into "+tableName+" values(\""+movieName+"\", "+year+", "+rating+")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printResult() {
		try {
			resultSet= statement.executeQuery("select * from "+tableName);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();                     
			while (resultSet.next()) {
			          
			for(int i = 1 ; i <= columnsNumber; i++){
				 if (i > 1) System.out.print(" \t|\t ");
				 System.out.format("%-15s%-15s%-15s\n", resultSet.getString(i));
			     // System.out.print(resultSet.getString(i) + " "); 
			}
			  System.out.println();           

			    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/*
 * 
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists person");
          statement.executeUpdate("create table person (id integer, name string)");
          statement.executeUpdate("insert into person values(1, 'leo')");
          insert into imdb values('City of God',2002,8.6)
          statement.executeUpdate("insert into person values(2, 'yui')");
          ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
 */
