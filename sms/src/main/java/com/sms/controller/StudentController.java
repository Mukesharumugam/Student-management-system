package com.sms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Student;
import com.sms.repository.Astudent;
import com.sms.service.StudentService;

@RestController
@RequestMapping("/sms")
public class StudentController {

	@Autowired
	private StudentService service;
	Student student;

	@PostMapping("/save")
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);

	}

	@GetMapping("/students")
	@ResponseBody
	public List<Student> getAllStudents() {
		return service.findAll();

	}

	@GetMapping("/student/{rollNo}")
	public ResponseEntity<Student> get(@PathVariable(value = "rollNo") Integer rollNo) {
		try {
			Student student = service.get(rollNo);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/active")
	public List<Astudent> studentQueryparam(@RequestParam(value = "status") boolean status) {
		return service.getActiveAstudent(status);

	}

	@PutMapping("/update/{rollNo}")
	public Student updateStudent(@PathVariable("rollNo") Integer id, String status, @RequestBody Student student)
			throws Exception {
		return service.update(student);
	}

	@DeleteMapping("/delete/{rollNo}")
	public void removeStudent(@PathVariable("rollNO") Integer rollNo) {
		service.remove(rollNo);
	}
}