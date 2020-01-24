package com.web.application.xception.pojo.request;
public class Feedback implements java.io.Serializable
{
private String message;
public Feedback()
{
message="";
}
public void setMessage(String message)
{
this.message=message;
}
public String getMessage()
{
return this.message;
}
}