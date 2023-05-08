package com.luv2code.demoClass.Handler;

public class RestResponse {
  
   private String message;	
   private Object rtnObj;
  
   public RestResponse(String message,Object rtnObj) {
	   this.message=message;
	   this.rtnObj=rtnObj;
	}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Object getRtnObj() {
	return rtnObj;
}

public void setRtnObj(Object rtnObj) {
	this.rtnObj = rtnObj;
}

    
    
   

   
   
}
