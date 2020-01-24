package com.web.application.xception.servlets.startup;
import javax.servlet.*;
import javax.servlet.http.*;
import com.web.application.xception.dao.*;
import com.web.application.xception.pojo.request.*;
import com.web.application.xception.model.*;
import java.sql.*;
public class LoadData extends HttpServlet
{
public void init()
{
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select * from xception");
Xception xception=new Xception();
DataModel dataModel=new DataModel();
java.util.Date date1=null,date2=null;
String finalDate=null;
String month=null;
int m;
while(resultSet.next())
{
xception.setVersion(resultSet.getString("version"));
xception.setAbout(resultSet.getString("about"));
xception.setTheme(resultSet.getString("theme"));
date1=resultSet.getDate("xception_from");
finalDate=String.valueOf(date1.getDate())+" ";
m=date1.getMonth();
if(m==0) month="Jan";
if(m==1) month="Feb";
if(m==2) month="Mar";
if(m==3) month="Apr";
if(m==4) month="May";
if(m==5) month="June";
if(m==6) month="July";
if(m==7) month="Aug";
if(m==8) month="Sep";
if(m==9) month="Oct";
if(m==10) month="Nov";
if(m==11) month="Dec";
finalDate=finalDate+month+"-";
date2=resultSet.getDate("xception_to");
finalDate=finalDate+String.valueOf(date2.getDate())+" ";
m=date2.getMonth();
if(m==0) month="Jan";
if(m==1) month="Feb";
if(m==2) month="Mar";
if(m==3) month="Apr";
if(m==4) month="May";
if(m==5) month="June";
if(m==6) month="July";
if(m==7) month="Aug";
if(m==8) month="Sep";
if(m==9) month="Oct";
if(m==10) month="Nov";
if(m==11) month="Dec";
finalDate=finalDate+month;
xception.setDate(finalDate);
}
dataModel.setXceptionObject(xception);
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from team");
Team team=null;
Statement s=null;
ResultSet rs=null;
while(resultSet.next())
{
team=new Team();
team.setCode(resultSet.getInt("code"));
team.setName(resultSet.getString("name"));
team.setHeadName(resultSet.getString("head_name"));
team.setContactNumber(resultSet.getString("contact_number"));
team.setImagePath(resultSet.getString("image_path"));
s=connection.createStatement();
rs=s.executeQuery("select * from team_member where team_code="+team.getCode());
java.util.List<Member> members=new java.util.LinkedList<>();
Member member=null;
while(rs.next())
{
member=new Member();
member.setCode(rs.getInt("code"));
member.setName(rs.getString("name"));
member.setTeamCode(rs.getInt("team_code"));
member.setContactNumber(rs.getString("contact_number"));
members.add(member);
}
rs.close();
s.close();
team.setMembers(members);
team.setProfileLink(resultSet.getString("profile_link"));
dataModel.addTeam(team);
}
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from sponsor");
Sponsor sponsor=null;
while(resultSet.next())
{
sponsor=new Sponsor();
sponsor.setCode(resultSet.getInt("code"));
sponsor.setName(resultSet.getString("name").trim());
sponsor.setCategory(resultSet.getString("category"));
sponsor.setContactNumber(resultSet.getString("contact_number"));
String str=resultSet.getString("link");
sponsor.setLink(str);
sponsor.setYear(resultSet.getInt("year"));
sponsor.setLogoPath(resultSet.getString("logo_path"));
dataModel.addSponsor(sponsor);
}
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from xception_social_media");
XceptionSocialMedia xsm=null;
while(resultSet.next())
{
xsm=new XceptionSocialMedia();
xsm.setName(resultSet.getString("name").trim());
xsm.setLink(resultSet.getString("link"));
xsm.setImagePath(resultSet.getString("logo_path"));
dataModel.addXceptionSocialMedia(xsm);
}
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from gallery");
while(resultSet.next())
{
dataModel.addGalleryImage(resultSet.getString("image_src"));
}
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from faq");
Faq faq=null;
while(resultSet.next())
{
faq=new Faq();
faq.setQuestion(resultSet.getString("question"));
faq.setAnswer(resultSet.getString("answer"));
dataModel.addFaq(faq);
}
resultSet.close();
statement.close();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from event");
Event event=null;
while(resultSet.next())
{
event=new Event();
event.setCode(resultSet.getInt("code"));
event.setName(resultSet.getString("name"));
event.setDate(new java.util.Date(resultSet.getTimestamp("event_date").getTime()));
event.setAbout(resultSet.getString("about"));
event.setType(resultSet.getString("event_type"));
event.setVenue(resultSet.getString("event_venue"));
event.setHeadName(resultSet.getString("head_name"));
event.setHeadContactNumber(resultSet.getString("head_contact_number"));
event.setSeats(resultSet.getInt("seats"));
event.setImagePath(resultSet.getString("image_path"));
s=connection.createStatement();
rs=s.executeQuery("select * from register where code in (select register_code from event_register_mapping where event_code="+event.getCode()+")");
java.util.List<Register> registereds=new java.util.LinkedList<>();
Register register=null;
while(rs.next())
{
register=new Register();
register.setCode(rs.getInt("code"));
register.setName(rs.getString("name"));
register.setCollege(rs.getString("college"));
register.setContactNumber(rs.getString("contact_number"));
register.setCity(rs.getString("city"));
register.setCurrentYear(rs.getString("current_year"));
register.setGender(rs.getString("gender"));
register.setEmailId(rs.getString("email_id"));
registereds.add(register);
}
rs.close();
s.close();
event.setRegistereds(registereds);
dataModel.addEvent(event);
}
resultSet.close();
statement.close();
connection.close();
ServletContext servletContext=getServletContext();
servletContext.setAttribute(DataModel.id,dataModel);
}catch(Exception e)
{
e.printStackTrace();
}
}
}