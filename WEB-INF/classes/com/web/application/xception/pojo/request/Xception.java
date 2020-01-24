package com.web.application.xception.pojo.request;
public class Xception implements java.io.Serializable
{
private String version;
private String about;
private String theme;
private String date;
public Xception()
{
this.version="";
this.about="";
this.theme="";
this.date="";
}
public void setVersion(String version)
{
this.version=version;
}
public void setAbout(String about)
{
this.about=about;
}
public void setTheme(String theme)
{
this.theme=theme;
}
public void setDate(String date)
{
this.date=date;
}
public String getVersion()
{
return this.version;
}
public String getAbout()
{
return this.about;
}
public String getTheme()
{
return this.theme;
}
public String getDate()
{
return this.date;
}
}