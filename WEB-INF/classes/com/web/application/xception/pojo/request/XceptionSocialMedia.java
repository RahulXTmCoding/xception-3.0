package com.web.application.xception.pojo.request;
public class XceptionSocialMedia implements java.io.Serializable
{
private String name;
private String link;
private String imagePath;
public XceptionSocialMedia()
{
name="";
link="";
imagePath="";
}
public void setName(String name)
{
this.name=name;
}
public void setLink(String link)
{
this.link=link;
}
public void setImagePath(String imagePath)
{
this.imagePath=imagePath;
}
public String getName()
{
return this.name;
}
public String getLink()
{
return this.link;
}
public String getImagePath()
{
return this.imagePath;
}

}
