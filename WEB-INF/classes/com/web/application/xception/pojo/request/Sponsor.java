package com.web.application.xception.pojo.request;
public class Sponsor implements java.io.Serializable
{
private int code;
private String name;
private String logoPath;
private String category;
private String contactNumber;
private String link;
private int year;
public Sponsor()
{
this.year=-1;
this.code=0;
this.name="";
this.logoPath="";
this.category="";
this.contactNumber="";
this.link="";
}
public void setCode(int code)
{
this.code=code;
}
public void setName(String name)
{
this.name=name;
}
public void setLogoPath(String logoPath)
{
this.logoPath=logoPath;
}
public void setCategory(String category)
{
this.category=category;
}
public void setContactNumber(String contactNumber)
{
this.contactNumber=contactNumber;
}
public void setLink(String link)
{
this.link=link;
}
public int getCode()
{
return this.code;
}
public String getName()
{
return this.name;
}
public String getLogoPath()
{
return this.logoPath;
}
public String getCategory()
{
return this.category;
}
public String getContactNumber()
{
return this.contactNumber;
}
public String getLink()
{
return this.link;
}
public void setYear(int year)
{
this.year=year;
}
public int getYear()
{
return this.year;
}
}