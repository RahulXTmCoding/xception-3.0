package com.web.application.xception.dao;
import java.sql.*;
public class DAOConnection
{
public static Connection getConnection()
{
Connection connection=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/xceptiondb","xception","xception_uec");
}catch(Exception e)
{
e.printStackTrace();
}
return connection;
}
}