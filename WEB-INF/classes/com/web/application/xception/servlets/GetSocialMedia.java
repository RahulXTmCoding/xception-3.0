package com.web.application.xception.servlets;
import com.google.gson.*;

import javax.servlet.*;

import java.util.*;
import javax.servlet.http.*;
import com.web.application.xception.pojo.request.*;
import com.web.application.xception.model.*;
import com.web.application.xception.pojo.response.*;
public class GetSocialMedia extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)

{
try
{

ServletContext servletContext=getServletContext();

DataModel dataModel=(DataModel)servletContext.getAttribute(DataModel.id);

List<XceptionSocialMedia> xceptionSocialMedia=dataModel.getXceptionSocialMedia();

ResponseJSON responseJSON=new ResponseJSON();

responseJSON.setSuccess(true);

responseJSON.setResult(xceptionSocialMedia);

response.getWriter().print(new Gson().toJson(responseJSON));

}catch(Exception e)
{
e.printStackTrace();
}

}
}