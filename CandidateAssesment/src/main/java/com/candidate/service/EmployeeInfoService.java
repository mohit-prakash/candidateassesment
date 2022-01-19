package com.candidate.service;

import java.util.List;

import com.candidate.dto.EmpolyeeInfoDTO;
import com.candidate.entity.EmpolyeeInfo;

public interface EmployeeInfoService {
	

public EmpolyeeInfo add(EmpolyeeInfo employeeInfo);
public EmpolyeeInfoDTO addEmp(EmpolyeeInfoDTO empolyeeInfoDTO);
public EmpolyeeInfo employeeLogin(String username, String password);

public List<EmpolyeeInfo> findAll();

}
