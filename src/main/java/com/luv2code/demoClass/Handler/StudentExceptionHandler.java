package com.luv2code.demoClass.Handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 定義全域的exception handler
@ControllerAdvice
public class StudentExceptionHandler {
  	
	// 定義處理例外的方法
	@ExceptionHandler
	// ResponseEntity<XXXX>：定義response body type                 定義要處理哪種Exception
	public ResponseEntity<StudentErrorResponse>  handleException(StudentNotFoundException studentNotFoundException){
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(studentNotFoundException.getMessage());
		studentErrorResponse.setTimestamp(System.currentTimeMillis());
				
		//                                                 第一個參數為BODY    ，第二個參數為HTTP status code
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse>  handleException(Exception exc){
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exc.getMessage());
		studentErrorResponse.setTimestamp(System.currentTimeMillis());
				
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.BAD_REQUEST);
	}
}
