package com.luv2code.demoClass.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.luv2code.demoClass.Entity.Student;
import com.luv2code.demoClass.Handler.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class StudentService implements IStudentService{

	private List<Student> list;
	private String str;
	
	// spring bean被建立時，執行
	@PostConstruct
	public void init() {
		list = new ArrayList<Student>();
		list.add(new Student(1,"Tom","Hanks"));
		list.add(new Student(2,"Tommy","Haha"));
		list.add(new Student(3,"Marry","Helen"));
	}
	
	@Override
	public List<Student> getStudents(){		
		return list;
	}

	@Override
	public Student getStudent(int studentId) {  
		Student s=null;
		for(Student student :list) {
			if(student.getStudentId()==studentId) {
				s=student; 
			}
		}
		
		if(s==null) {
			throw new StudentNotFoundException("找不到學生編號："+studentId);
		}
		
		return s;
	}

	@Override
	public String delStudent(int studentId) {
		
		str="刪除學生失敗";
		for(int i=0,j=list.size();i<j;i++) {
			if(list.get(i).getStudentId()==studentId) {
				list.remove(i);
				str="刪除學生編號"+studentId+"成功";
			}
		}		
		
		return str;
	}

	@Override
	public String addStudent(Student student) {
		str="新增學生失敗";
		if(list.add(student)) {
			str="新增學生成功，學生編號："+student.getStudentId();
		}
		return str;
		
	}

	@Override
	public String updStudent(Student student,int studentId) {
		str="更新學生失敗，學生編號："+student.getStudentId();

		for(int i=0,j=list.size();i<j;i++) { 
			if(list.get(i).getStudentId()==studentId) {
				list.set(i, student);
				str="更新學生成功，學生編號："+student.getStudentId();
			}
		}
		
		
		return str;
	}
   
}
