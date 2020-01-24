function $$$(a)
{
}
$$$.validateGetJSON=function(jsonObject)
{
if(!jsonObject.url) throw '$$$.get({"url": not specified})';
if(typeof jsonObject.url!="string") throw '$$$.get({"url": "not a string"})';
if(jsonObject.onResponse)
{
if(typeof jsonObject.onResponse!="function") throw '$$$.get({"onResponse": function required })';
}
if(jsonObject.responseDataType)
{
if(typeof jsonObject.responseDataType!="string") throw '$$$.get({"responseDataType": "string required"})';
var types=["JSON","STRING","TEXT","NUMBER","BOOLEAN"];
var responseDataType=jsonObject.responseDataType.toUpperCase();
if(types.includes(responseDataType)==false) throw '$$$.get({"responseDataType": should be one of [\"'+types.join('","')+'\"]})';
}
if(jsonObject.onError)
{
if(typeof jsonObject.onError!="function") throw '$$$.get({"onError": function required })';
}
if(jsonObject.ajax!=undefined)
{
if(typeof jsonObject.ajax!="boolean") throw '$$$.get({"ajax": boolean required })';
}
} // validateGetJSON ends
$$$.get=function(jsonObject)
{
$$$.validateGetJSON(jsonObject);
var xmlHttpRequest=new XMLHttpRequest();
xmlHttpRequest.onreadystatechange=function(){
if(xmlHttpRequest.readyState==4)
{
if(xmlHttpRequest.status==200)
{
if(jsonObject.onResponse)
{
var response=xmlHttpRequest.responseText;
if(jsonObject.responseDataType)
{
if(jsonObject.responseDataType.toUpperCase()=="JSON") response=JSON.parse(response);
}
jsonObject.onResponse(response);
}
return;
}
if(xmlHttpRequest.status==404)
{
if(jsonObject.onError) 
{
jsonObject.onError();
}
}
}
};
var ajax=true;
if(jsonObject.ajax!=undefined) ajax=jsonObject.ajax;
xmlHttpRequest.open('GET',jsonObject.url,ajax);
xmlHttpRequest.send();
}
$$$.post=function(jsonObject) {}
function XceptionService() 
{
this.getMainPage=function(onSuccess,onFailure,onError){
alert('getMainPage chali');
console.log("************************");
$$$.get({
"url": "getMainPage",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getMainPage ends




this.getEvents=function(onSuccess,onFailure,onError){
$$$.get({
"url": "getEvents",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getEvents ends



this.getSocialMedia=function(onSuccess,onFailure,onError){
$$$.get({
"url": "getSocialMedia",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getSocialMedia ends




this.getFaqs=function(onSuccess,onFailure,onError){
$$$.get({
"url": "getFaqs",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getFaqs ends



this.getSponsors=function(onSuccess,onFailure,onError){
$$$.get({
"url": "getSponsors",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getSponsors ends



this.getTeams=function(onSuccess,onFailure,onError){
$$$.get({
"url": "getEvents",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// getTeams ends
this.register=function(onSuccess,onFailure,onError){
$$$.get({
"url": "register",
"responseDataType": "JSON",
"onResponse" : function(responseJSON){
if(responseJSON.success) onSuccess(responseJSON.result);
else onFailure(responseJSON.result);
},
"onError" : onError,
"ajax":true
});
};// register ends



}