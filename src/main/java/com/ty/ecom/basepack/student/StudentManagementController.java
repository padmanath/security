package com.ty.ecom.basepack.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "padmanathan"),
			new Student(2, "Arjun Reddy"), new Student(3, "james Bond"));
	
	
	@GetMapping
	public List<Student> getAllStudents() {
		System.out.println("getAllStudents");                                                          //s12  to create dumy api in this line (without this s.o.pln error on postman
		return STUDENTS;
	}
	
	@PostMapping
	public void registerNewStudent( @RequestBody   Student  student) {
		System.out.println("registerNewStudent");                                                        //s9 to create dumy api in this line (without this s.o.pln error on postman
		System.out.println(student);
		
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent( @PathVariable("studentId")   Integer studentId) {
		System.out.println("deleteStudent");                                                             //s10  to create dumy api in this line (without this s.o.pln error on postman
		System.out.println(studentId);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(    @PathVariable("studentId") Integer studentId,@RequestBody Student student) {
     		System.out.println("updateStudent");                                                            //s11  to create dumy api in this line (without this s.o.pln error on postman
		System.out.println(String.format("%s %s", studentId,student));
	}
	
}
