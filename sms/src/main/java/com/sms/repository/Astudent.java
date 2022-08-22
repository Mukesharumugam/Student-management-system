package com.sms.repository;

import java.util.List;

public interface Astudent {

	Integer getRollNo();

	String getFirstName();

	String getLastName();

	Integer getStandard();

	String getDivision();

	List<Astudent> getActiveAstudent();
}
