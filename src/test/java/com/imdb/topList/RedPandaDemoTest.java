package com.imdb.topList;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.imdb.topList.pages.LandingPage;
import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.FunctionLib;

public class RedPandaDemoTest extends BaseWebdriver {
	
	private static Connection connection = null;
	
	@Test(enabled = true)
	public void testing() {
		
		LandingPage homePage = new LandingPage();
		homePage.navigateToTopList().getAllList();
		}
	
	/*@Test
	public void runningsqLite() throws ClassNotFoundException {
		
		
		
        try
        {
        	String driver = "org.sqlite.JDBC";
    		Class.forName(driver);
          connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\USER\\Desktop\\test1.db");
          if (connection != null) {
              DatabaseMetaData meta = connection.getMetaData();
              System.out.println("The driver name is " + meta.getDriverName());
              System.out.println("A new database has been created.");
          }
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          statement.executeUpdate("drop table if exists person");
          statement.executeUpdate("create table person (id integer, name string)");
          statement.executeUpdate("insert into person values(1, 'leo')");
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
      }
	*/

}
