package com.web.application.xception.pojo.request;
import java.util.*;
public class Team implements java.io.Serializable
{
private int code;
private String name;
private String headName;
private String contactNumber;
private List<Member> members;
private String imagePath;
private String profileLink;
public Team()
{
this.code=0;
this.name="";
this.headName="";
this.contactNumber="";
this.members=new LinkedList<>();
this.imagePath="";
this.profileLink="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public void setHeadName(String headName)
{
this.headName=headName;
}
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
}
public void setImagePath(String imagePath)
{
this.imagePath=imagePath;
}
public void setProfileLink(String profileLink)
{
this.profileLink=profileLink;
}
public void setMembers(List<Member> members)
{
this.members=members;
}
public String getName()
{
return this.name;
}
public String getHeadName()
{
return this.headName;
}
public String getContactNumber()
{
return this.contactNumber;
}
public String getImagePath()
{
return this.imagePath;
}
public String getProfileLink()
{
return this.profileLink;
}
public List<Member> getMembers()
{
return this.members;
}
}