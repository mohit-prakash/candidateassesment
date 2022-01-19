package com.candidate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.candidate.dto.EmpolyeeInfoDTO;
import com.candidate.entity.EmpolyeeInfo;
import com.candidate.repository.employeeRepository;


@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	private employeeRepository employeesRepository;

	@CrossOrigin
	@Override
	public EmpolyeeInfo add(EmpolyeeInfo empolyeeInfo) {

		EmpolyeeInfo empolyeesInfo = employeesRepository.save(empolyeeInfo);
		return empolyeesInfo;

	}
	
	@CrossOrigin
	@Override
	public EmpolyeeInfoDTO addEmp(EmpolyeeInfoDTO employeeInfoDTOObj) {
		EmpolyeeInfoDTO responseEmployeeInfoDTO = new EmpolyeeInfoDTO();
		EmpolyeeInfo employeeInfo = transformObject(employeeInfoDTOObj, new EmpolyeeInfo());
		if (employeeInfo == null) {
			return new EmpolyeeInfoDTO();
		}

		EmpolyeeInfo employeeInfoSaved = employeesRepository.save(employeeInfo);

		responseEmployeeInfoDTO.setEmpCode(employeeInfoSaved.getEmpCode());
		responseEmployeeInfoDTO.setCreatedDate(employeeInfoSaved.getCreatedDate());
		responseEmployeeInfoDTO.setFirstName(employeeInfoSaved.getFirstName());
		responseEmployeeInfoDTO.setMiddleName(employeeInfoSaved.getMiddleName());
		responseEmployeeInfoDTO.setLastName(employeeInfoSaved.getLastName());
		responseEmployeeInfoDTO.setDesignation(employeeInfoSaved.getDesignation());
		responseEmployeeInfoDTO.setAvaiableDate(employeeInfoSaved.getAvaiableDate());
		responseEmployeeInfoDTO.setPassword(employeeInfoSaved.getPassword());
		responseEmployeeInfoDTO.setStatus(employeeInfoSaved.getStatus());
		responseEmployeeInfoDTO.setContactNo(employeeInfoSaved.getContactNo());
		responseEmployeeInfoDTO.setEmailId(employeeInfoSaved.getEmailId());
		responseEmployeeInfoDTO.setHomePhoneNo(employeeInfoSaved.getHomePhoneNo());
		
		responseEmployeeInfoDTO.setManagerCode(employeeInfoSaved.getReportingManager().getEmpCode());
		
		return responseEmployeeInfoDTO;
		
	}
	
	public EmpolyeeInfo transformObject(EmpolyeeInfoDTO employeeInfoDTO, EmpolyeeInfo employeeInfo) {

		

		EmpolyeeInfo empManagerInfo = employeesRepository.findByEmpMangerCode(employeeInfoDTO.getManagerCode());

		employeeInfo.setEmpCode(employeeInfoDTO.getEmpCode());
		employeeInfo.setCreatedDate(employeeInfoDTO.getCreatedDate());
		employeeInfo.setFirstName(employeeInfoDTO.getFirstName());
		employeeInfo.setMiddleName(employeeInfoDTO.getMiddleName());
		employeeInfo.setLastName(employeeInfoDTO.getLastName());
		employeeInfo.setDesignation(employeeInfoDTO.getDesignation());
		
	
		employeeInfo.setPassword(employeeInfoDTO.getPassword());
		employeeInfo.setStatus(employeeInfoDTO.getStatus());
		employeeInfo.setContactNo(employeeInfoDTO.getContactNo());
		employeeInfo.setEmailId(employeeInfoDTO.getEmailId());
		employeeInfo.setHomePhoneNo(employeeInfoDTO.getHomePhoneNo());
		
		employeeInfo.setReportingManager(empManagerInfo);
		System.out.println("empolyee value is" +employeeInfo);

		return employeeInfo;
	}
	
	@CrossOrigin
	@Override
	public List<EmpolyeeInfo> findAll() {
		List<EmpolyeeInfo> listEmpLeaveInfo = employeesRepository.findAll();
		return listEmpLeaveInfo;
	}

	@CrossOrigin
	@Override
	public EmpolyeeInfo employeeLogin(String username, String password) {

		EmpolyeeInfo employeeInfoOpt = employeesRepository.findByEmpCode(username);
		if (employeeInfoOpt != null) {
			if (employeeInfoOpt.getEmpCode().equals(username) && employeeInfoOpt.getPassword().equals(password)) {
				return employeeInfoOpt;
			}
		}
		return null;
	}

}
