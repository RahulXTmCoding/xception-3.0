package com.web.application.xception.pojo.request;
public class Member implements java.io.Serializable
{
private int code;
private String name;
private String contactNumber;
private int teamCode;
public Member()
{
this.code=0;
this.name="";
this.contactNumber="";
this.teamCode=0;
}
public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;
}
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
}
public void setTeamCode(int teamCode)
{
this.teamCode=teamCode;
}
public int getCode()
{
return this.code;
}
public String getName()
{
return this.name;
}
public String getContactNumber()
{
return this.contactNumber;
}
public int getTeamCode()
{
return this.teamCode;
}
}