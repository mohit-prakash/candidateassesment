package com.candidate.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class EmpolyeeInfo {

	@Id
	private String empCode;

	private String password;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;
	
	

	@Column(nullable = true)
	private Time fromTime;

	@Column(nullable = true)
	private Time toTime;

	@Column(nullable = true)
	private String firstName;

	@Column(nullable = true)
	private String middleName;

	@Column(nullable = true)
	private String lastName;

	@Column(nullable = true)
	private String designation;

	@Column(nullable = true)
	private Date avaiableDate;

	@Column(nullable = true)
	private String status;

	@Column(nullable = true)
	private String contactNo;

	@Column(nullable = true)
	private String emailId;

	@Column(nullable = true)
	private String homePhoneNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerCode", referencedColumnName = "empCode")
	private EmpolyeeInfo reportingManager;

	

}
