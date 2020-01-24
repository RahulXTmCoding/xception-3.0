package com.web.application.xception.servlets;

import com.google.gson.*;

import javax.servlet.*;

import javax.servlet.http.*;

import com.web.application.xception.model.*;
import com.web.application.xception.pojo.response.*;
import java.util.*;
public class GetSponsors extends HttpServlet

{

public void doGet(HttpServletRequest request,HttpServletResponse response)

{

try

{

ServletContext servletContext=getServletContext();

DataModel dataModel=(DataModel)servletContext.getAttribute(DataModel.id);

ResponseJSON responseJSON=new ResponseJSON();

responseJSON.setSuccess(true);

responseJSON.setResult(dataModel.getSponsorResponse());

response.getWriter().print(new Gson().toJson(responseJSON));

}
catch(Exception exception)

{

exception.printStackTrace();

}

}

}