package com.web.application.xception.servlets;

import com.google.gson.*;

import javax.servlet.*;

import javax.servlet.http.*;
import com.web.application.xception.pojo.request.*;

import com.web.application.xception.pojo.response.*;
import com.web.application.xception.model.*;
public class GetMainPage extends HttpServlet

{

public void doGet(HttpServletRequest request,HttpServletResponse response)

{
try
{

ServletContext servletContext=getServletContext();

DataModel dataModel=(DataModel)servletContext.getAttribute(DataModel.id);

Xception xception=dataModel.getXceptionObject();

ResponseJSON responseJSON=new ResponseJSON();

responseJSON.setSuccess(true);

responseJSON.setResult(xception);

response.getWriter().print(new Gson().toJson(responseJSON));

}catch(Exception e)
{
e.printStackTrace();
}
}

}