package com.ty.ecom.basepack.student;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "padmanathan"),
			new Student(2, "Arjun Reddy"), new Student(3, "james Bond")

	);

	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream().filter(Student -> studentId.equals(studentId)).findFirst()
				.orElseThrow(() -> new IllegalStateException("student" + studentId + "does not exist"));
	}

	
	
	
}
