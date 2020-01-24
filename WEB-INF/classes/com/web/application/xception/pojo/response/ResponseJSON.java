package com.web.application.xception.pojo.response;

public class ResponseJSON implements java.io.Serializable

{

private boolean success;

private Object result;

public ResponseJSON()

{

this.success=false;

this.result="";

}

public void setSuccess(boolean success)

{

this.success=success;

}

public boolean getSuccess()

{

return this.success;

}

public void setResult(Object result)

{

this.result=result;

}

public Object getResult()

{

return this.result;

}

}