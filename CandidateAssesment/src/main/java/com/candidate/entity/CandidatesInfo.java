package com.candidate.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class CandidatesInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long  candidateId;
	
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
	private String panCode;

	@Column(nullable = true)
	private String role;
	
	@Column(nullable = true)
	private Date AvaiableDate;

	@Column(nullable = true)
	private String status;

	@Column(nullable = true)
	private String contactNo;

	@Column(nullable = true)
	private String emailId;
	
	
	


}
