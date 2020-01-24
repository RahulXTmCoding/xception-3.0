package com.web.application.xception.servlets;

import com.web.application.xception.dao.*;
import com.web.application.xception.pojo.response.*;
import javax.servlet.*;

import javax.servlet.http.*;

import com.google.gson.*;
import java.sql.*;
public class Register extends HttpServlet

{
public void doGet(HttpServletRequest request,HttpServletResponse response)

{
try
{
ResponseJSON responseJSON=new ResponseJSON();

String result="";
String name=request.getParameter("name");
System.out.println(name);
String contactNumber=request.getParameter("contactNumber");
String collegeName=request.getParameter("collegeName");
String city=request.getParameter("city");
String branch=request.getParameter("branch");
String currentYear=request.getParameter("currentYear");
String gender=request.getParameter("gender");
String emailId=request.getParameter("emailId");
String[] events=request.getParameterValues("events");
Connection c=DAOConnection.getConnection();
if(c==null) 
{
result="Connection problem";
responseJSON.setSuccess(false);
responseJSON.setResult(result);

response.getWriter().print(new Gson().toJson(responseJSON));
System.out.println(new Gson().toJson(responseJSON));

return;
}
//contact number and name check
PreparedStatement ps1=c.prepareStatement("select name,code from register where contact_number=?");
ps1.setString(1,contactNumber);
ResultSet rs1=ps1.executeQuery();
int vCode=-1;
String vName=null;
if(rs1.next())
{
vName=rs1.getString("name");
vCode=rs1.getInt("code");
}
if(!name.equalsIgnoreCase(vName) && vName!=null)
{
result="Contact number already registered.";
responseJSON.setSuccess(false);
responseJSON.setResult(result);

response.getWriter().print(new Gson().toJson(responseJSON));
System.out.println(new Gson().toJson(responseJSON));

return;
}
ps1=c.prepareStatement("select name,code from register where email_id=?");
ps1.setString(1,emailId);
rs1=ps1.executeQuery();
if(rs1.next())
{
vName=rs1.getString("name");
vCode=rs1.getInt("code");
}
if(!name.equalsIgnoreCase(vName) && vName!=null)
{
result="Email id already registered.";
responseJSON.setSuccess(false);
responseJSON.setResult(result);

response.getWriter().print(new Gson().toJson(responseJSON));
System.out.println(new Gson().toJson(responseJSON));

return;
}
int code=-1;
if(vCode==-1)
{
PreparedStatement ps2=c.prepareStatement("insert into register(name,contact_number,college,city,branch,current_year,gender,email_id) values(?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
ps2.setString(1,name);
ps2.setString(2,contactNumber);
ps2.setString(3,collegeName);
ps2.setString(4,city);
ps2.setString(5,branch);
ps2.setString(6,currentYear);
ps2.setString(7,gender);
ps2.setString(8,emailId);
ps2.executeUpdate();
ResultSet rs2=ps2.getGeneratedKeys();
if(rs2.next() && rs2!=null)
{
code=rs2.getInt(1);
//System.out.println(rs2.getInt(1));
}
rs2.close();
ps2.close();
}
//
//
int eventCodes[]=new int[100];
int length=0;
if(vCode!=-1)
{
PreparedStatement ps4=c.prepareStatement("select event_code from event_register_mapping where register_code=?");
ps4.setInt(1,vCode);
ResultSet rs4=ps4.executeQuery();
while(rs4.next())
{
eventCodes[length]=rs4.getInt("event_code");
length++;
}
rs4.close();
ps4.close();
}
//
//mapping table
for(int i=0;i<events.length;i++)
{
String eventName=events[i];
PreparedStatement ps3=c.prepareStatement("select code from event where name=?");
ps3.setString(1,eventName);
ResultSet rs3=ps3.executeQuery();
int eventCode=-1;
if(rs3.next())
{
eventCode=rs3.getInt("code");
if(vCode!=-1)
{
int j=0;
for(;j<length;j++)
{
//System.out.println(eventCodes[j]);
if(eventCodes[j]==eventCode)
{
break;
}
}
if(j==length)
{
//System.out.println("gyaa"+eventCode);
ps3=c.prepareStatement("insert into event_register_mapping(event_code,register_code) value(?,?)");
ps3.setInt(1,eventCode);
ps3.setInt(2,vCode);
ps3.executeUpdate();
rs3.close();
ps3.close();

}
}
else
{
ps3=c.prepareStatement("insert into event_register_mapping (event_code,register_code) value(?,?)");
ps3.setInt(1,eventCode);
ps3.setInt(2,code);
ps3.executeUpdate();
rs3.close();
ps3.close();

}
}
}
c.close();
result="Registerd Successfully.";
responseJSON.setSuccess(true);
responseJSON.setResult(result);

System.out.println(new Gson().toJson(responseJSON));
response.getWriter().print(new Gson().toJson(responseJSON));

}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}

}