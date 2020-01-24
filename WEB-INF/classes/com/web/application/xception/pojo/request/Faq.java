package com.web.application.xception.pojo.request;
public class Faq implements java.io.Serializable
{
private String question;
private String answer;
public Faq()
{
question="";
answer="";
}
public void setQuestion(String question)
{
this.question=question;
}
public void setAnswer(String answer)
{
this.answer=answer;
}
public String getQuestion()
{
return this.question;
}
public String getAnswer()
{
return this.answer;
}
}
