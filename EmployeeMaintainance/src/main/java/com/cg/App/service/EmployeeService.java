package com.cg.App.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.App.entites.Employee;
import com.cg.App.repository.DepartmentRepository;
import com.cg.App.repository.EmployeeRepository;
import com.cg.App.repository.GradeMasterRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository deptRespo;
	
	@Autowired
	private GradeMasterRepository gradrepo;


	
	
	public Employee getEmployee(int empId) {
		if (ValiadateEmpId(empId))
			return employeeRepository.getOne(empId);
		else
			return null;
	}

	private boolean ValiadateEmpId(int empId) {
		Employee employee = employeeRepository.findOne(empId);
		if (employee != null)
			return true;
		else
		return false;
	}

	public List<Employee> getAllCustomers() {
		
		return employeeRepository.findAll();
	}

	
	public Employee updateEmployee(Employee employee, int empId) {
		Employee beforeUpdate = (Employee) employeeRepository.getOne(empId);
		beforeUpdate.setEmpFirstName(employee.getEmpFirstName());
		beforeUpdate.setEmpAddress(employee.getEmpAddress());
		return employeeRepository.saveAndFlush(beforeUpdate);
	}

	

	public void deleteEmployeeDetails(int empId) {
		if (ValiadateEmpId(empId))
			employeeRepository.delete(empId);
	
		
	}

	public Employee addEmp(Employee employee) {
		//employee.setDepartment(deptRespo.findOne(employee.getDepartment().getEmpDeptId()));
		//employee.setGrademaster(gradrepo.findOne(employee.getGrademaster().getEmpGradeCode()));
		return employeeRepository.save(employee);
	}

	public List<Employee> get(int empDeptId, String empDesignation, String empGradeCode) {
		
		return employeeRepository.findempdetails(deptRespo.findOne(empDeptId), empDesignation, gradrepo.findOne(empGradeCode));
	}

	public List<Employee> getwildcard(String empFirstName) {
		if (ValiadateEmpname(empFirstName))
			return employeeRepository.getDetails(empFirstName);
		else
			return null;
	}

	private boolean ValiadateEmpname(String empFirstName) {
		List<Employee> employee = employeeRepository.getDetails(empFirstName);
		if (employee != null)
			return true;
		else
		return false;
	}
	
}
