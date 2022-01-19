package com.candidate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.dto.EmpolyeeInfoDTO;
import com.candidate.entity.EmpolyeeInfo;
import com.candidate.service.EmployeeInfoService;


@RestController
@RequestMapping(path = BaseController.EMPLOYEE_INFO)
public class EmployeeController {

	@Autowired
	private EmployeeInfoService employeeInfoService;

	@CrossOrigin
	@PostMapping(path = "/add")
	public ResponseEntity<EmpolyeeInfo> add(@RequestBody EmpolyeeInfo employeeInfo) {
		EmpolyeeInfo employeesInfo = null;
		try {
			employeesInfo = employeeInfoService.add(employeeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<EmpolyeeInfo>(employeesInfo, HttpStatus.OK);

	}
	
	@CrossOrigin
	@PostMapping(path = "/addEmployeeWithManager")
	public ResponseEntity<EmpolyeeInfoDTO> addEmp(@RequestBody EmpolyeeInfoDTO employeeInfoDto) {
		EmpolyeeInfoDTO employeesInfo = null;
		try {
			employeesInfo = employeeInfoService.addEmp(employeeInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<EmpolyeeInfoDTO>(employeesInfo, HttpStatus.OK);

	}
	
	@CrossOrigin
	@GetMapping(path = "/employeeLogin/{username}/{password}")
	public ResponseEntity<EmpolyeeInfo> employeeLogin(@PathVariable String username, @PathVariable String password) {
		EmpolyeeInfo employeeLogin = null;
		try {
			employeeLogin = employeeInfoService.employeeLogin(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return new ResponseEntity<EmpolyeeInfo>(employeeLogin, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/findAll")
	public ResponseEntity<List<EmpolyeeInfo>> findAll() {
		return new ResponseEntity<List<EmpolyeeInfo>>(employeeInfoService.findAll(), HttpStatus.OK);
	}

}
