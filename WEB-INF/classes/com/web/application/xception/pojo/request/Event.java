package com.web.application.xception.pojo.request;
import java.util.*;
public class Event implements java.io.Serializable
{
public enum EVENT_TYPE{ONLINE,TECHNICAL,FUN,SOCIAL,CULTURAL};
private int code;
private String name;
private Date date;
private String about;
private EVENT_TYPE type;
private String venue;
private String headName;
private String headContactNumber;
private int seats;
private String imagePath;
private List<Register> registereds;
public Event()
{
this.code=0;
this.name="";
this.about="";
this.venue="";
this.headName="";
this.headContactNumber="";
this.seats=0;
this.registereds=null;
}
public void setImagePath(String imagePath)
{
this.imagePath=imagePath;
}
public String getImagePath()
{
return this.imagePath;
}
public void setRegistereds(List<Register> registereds)
{
this.registereds=registereds;
}
public void setName(String name)
{
this.name=name;
}
public void setCode(int code)
{
this.code=code;
}
public void setDate(Date date)
{
this.date=date;
}
public void setAbout(String about)
{
this.about=about;
}
public void setType(String type)
{
if(type.equalsIgnoreCase("online")) this.type=EVENT_TYPE.ONLINE;
if(type.equalsIgnoreCase("technical")) this.type=EVENT_TYPE.TECHNICAL;
if(type.equalsIgnoreCase("fun")) this.type=EVENT_TYPE.FUN;
if(type.equalsIgnoreCase("cultural")) this.type=EVENT_TYPE.CULTURAL;
if(type.equalsIgnoreCase("social")) this.type=EVENT_TYPE.SOCIAL;
}
public void setVenue(String venue)
{
this.venue=venue;
}
public void setHeadName(String headName)
{
this.headName=headName;
}
public void setHeadContactNumber(String headContactNumber)
{
this.headContactNumber=headContactNumber;
}
public void setSeats(int seats)
{
this.seats=seats;
}
public List<Register> getRegistereds()
{
return this.registereds;
}
public String getName()
{
return this.name;
}
public int getCode()
{
return this.code;
}
public Date getDate()
{
return this.date;
}
public String getAbout()
{
return this.about;
}
public EVENT_TYPE getType()
{
return this.type;
}
public String getVenue()
{
return this.venue;
}
public String getHeadName()
{
return this.headName;
}
public String getHeadContactNumber()
{
return this.headContactNumber;
}
public int getSeats()
{
return this.seats;
}
}