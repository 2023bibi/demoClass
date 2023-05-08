package com.luv2code.demoClass.Handler;

public class StudentErrorResponse {
   /**
    * HTTP  STATUS CODE
    */
   private int    status;
   /**
    *錯誤訊息
    */
   private String message;
   /**
    * 發生時間
    */
   private long  timestamp;
   
   public StudentErrorResponse() {

	}
   
public StudentErrorResponse(int status, String message, long timestamp) {
	this.status = status;
	this.message = message;
	this.timestamp = timestamp;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public long getTimestamp() {
	return timestamp;
}
public void setTimestamp(long timestamp) {
	this.timestamp = timestamp;
}
   
   
   
}
