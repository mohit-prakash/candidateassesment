package com.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.candidate.entity.EmpolyeeInfo;


public interface employeeRepository extends JpaRepository<EmpolyeeInfo, Integer> {
	
	@Query(value = "select * from empolyee_info where emp_code=:username", nativeQuery = true)
	public EmpolyeeInfo findByEmpCode(@Param("username") String username);
	
	@Query(value = "select * from empolyee_info where emp_code=:empCode", nativeQuery = true)
	public EmpolyeeInfo findByEmpMangerCode(@Param("empCode") String empCode);

}
