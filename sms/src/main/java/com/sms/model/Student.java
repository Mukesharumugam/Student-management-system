package com.sms.model;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE rollNo=?")
@Where(clause = "deleted = false")
public class Student extends Auditable {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer rollNo;
	private String firstName;
	private String lastName;
	private Integer standard;
	private String division;
	private String schoolName;
	private long phoneNumber;
	private boolean status;
	private boolean deleted = Boolean.FALSE;
	@Enumerated(EnumType.STRING)
	private Gender gender;

	public Student(Integer id, Integer rollNo, String firstName, String lastName, Integer standard, String division,
			String schoolName, long phoneNumber, boolean status, boolean deleted, Gender gender) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.standard = standard;
		this.division = division;
		this.schoolName = schoolName;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.deleted = deleted;
		this.gender = gender;
	}

	public Student() {
		super();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", standard=" + standard + ", division=" + division + ", schoolName=" + schoolName + ", phoneNumber="
				+ phoneNumber + ", status=" + status + ", deleted=" + deleted + ", gender=" + gender + "]";
	}

}
