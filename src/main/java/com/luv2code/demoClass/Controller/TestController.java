package com.luv2code.demoClass.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demoClass.Entity.Student;
import com.luv2code.demoClass.Handler.StudentErrorResponse;
import com.luv2code.demoClass.Handler.StudentNotFoundException;
import com.luv2code.demoClass.Service.IStudentService;

@RestController
@RequestMapping("/api")
public class TestController {
  
	@Autowired
	private IStudentService  studentService;
	
	public TestController() {
		
	}
	
	// 從application.properties取值並注入
	@Value("${test.welcome.word}")
	private String str;
	
	@RequestMapping("/hello")
    public String Hello() {
    	return str;
    }
	

	@GetMapping("/Students")
    public List<Student> getStudents() {
		return studentService.getStudents();		    
    }

	
	@GetMapping("/Students/{studentId}")
	// @PathVariable：接收路徑變數
    public Student getStudent(@PathVariable("studentId") int studentId){
		return studentService.getStudent(studentId);		    
    }
	
	
	@PostMapping("/Students")
	// @RequestBody：主要用來接收前端傳遞給後端的JSON字串
    public String AddStudent(@RequestBody Student student){
		return studentService.addStudent(student); 
    }
	
	
	@PutMapping("/Students/{studentId}")
    public String updStudent(@RequestBody Student student,
    		                 @PathVariable("studentId") int studentId){
		return studentService.updStudent(student,studentId);
    }
	
	
	@DeleteMapping("/Students/{studentId}")
    public String DelStudent(@PathVariable("studentId") int studentId){
		return studentService.delStudent(studentId);		    
    }
	
//	// 定義處理例外的方法
//	@ExceptionHandler
//	// ResponseEntity<XXXX>：定義response body type                 定義要處理哪種Exception
//	public ResponseEntity<StudentErrorResponse>  handleException(StudentNotFoundException studentNotFoundException){
//		
//		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//		studentErrorResponse.setMessage(studentNotFoundException.getMessage());
//		studentErrorResponse.setTimestamp(System.currentTimeMillis());
//				
//		//                                                 第一個參數為BODY    ，第二個參數為HTTP status code
//		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse>  handleException(Exception exc){
//		
//		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
//		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//		studentErrorResponse.setMessage(exc.getMessage());
//		studentErrorResponse.setTimestamp(System.currentTimeMillis());
//				
//		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse,HttpStatus.BAD_REQUEST);
//	}
}
