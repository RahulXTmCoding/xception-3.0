package com.web.application.xception.pojo.request;
public class Register implements java.io.Serializable
{
private String name;
private int code;
private String contactNumber;
private String college;
private String city;
private String currentYear;
private String gender;
private String emailId;
public Register()
{
this.name="";
this.code=0;
this.contactNumber="";
this.college="";
this.city="";
this.currentYear="";
this.gender="";
this.emailId="";
}
public void setName(String name)
{
this.name=name;
}
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
}
public void setCollege(String college)
{
this.college=college;
}
public void setCity(String city)
{
this.city=city;
}
public void setCurrentYear(String currentYear)
{
this.currentYear=currentYear;
}
public void setGender(String gender)
{
this.gender=gender;
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
}
public void setCode(int code)
{
this.code=code;
}
public String getName()
{
return this.name;
}
public String getContactNumber()
{
return this.contactNumber;
}
public String getCollege()
{
return this.college;
}
public String getCity()
{
return this.city;
}
public String getCurrentYear()
{
return this.currentYear;
}
public String getGender()
{
return this.gender;
}
public String getEmailId()
{
return this.emailId;
}
public int getCode()
{
return this.code;
}
}