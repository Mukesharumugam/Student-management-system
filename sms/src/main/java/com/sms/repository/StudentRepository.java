package com.sms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student getByRollNo(Integer rollNo);

	@Query(value = "select ID,ROLLNO,FIRSTNAME,STANDARD,DIVISION,from student WHERE STATUS = true", nativeQuery = true)
	java.util.List<Astudent> findAllActiveviationQuery(boolean status);

	Student save(Optional<Student> student);

	public void deleteByRollNo(Integer rollNo);

}
