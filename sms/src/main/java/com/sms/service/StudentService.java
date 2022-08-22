package com.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Student;
import com.sms.repository.Astudent;
import com.sms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public Student addStudent(Student student) {
		return repository.save(student);

	}

	public java.util.List<Student> findAll() {
		return repository.findAll();

	}

	public Student get(Integer rollNo) {
		return repository.getByRollNo(rollNo);

	}

	public Student getById(Integer rollNo) {
		return repository.getByRollNo(rollNo);

	}

	public List<Astudent> getActiveAstudent(boolean status) {
		return (List<Astudent>) repository.findAllActiveviationQuery(status);

	}

	public Student update(Student student) throws Exception {
		if (student.isStatus()) {
			return repository.save(student);
		} else {
			throw new StudentUpdateException(
					"The student with roll id :" + student.getId() + "is inactive.we can't follow for the same.");
		}

	}
	public void remove(Integer rollNo) {
		repository.deleteByRollNo(rollNo);
	}
}



