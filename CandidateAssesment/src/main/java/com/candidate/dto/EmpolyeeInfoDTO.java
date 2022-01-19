package com.candidate.dto;

import java.util.Date;
import java.sql.Time;

import lombok.Data;

@Data
public class EmpolyeeInfoDTO {
	
	private String empCode;
	
	private Time fromTime;
	
	private Time toTime;

	private Date createdDate;

	private String firstName;

	private String middleName;

	private String lastName;

	private String role;
	
	private String password;

	private String status;

	private String contactNo;

	private String emailId;

	private String homePhoneNo;
	
	private String managerCode;
	
	private Date avaiableDate;
	
	private String panCode;
	
	private String designation;
	
	

}
