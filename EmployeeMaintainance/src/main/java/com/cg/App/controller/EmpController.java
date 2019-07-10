package com.cg.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.App.entites.Department;
import com.cg.App.entites.Employee;
import com.cg.App.entites.GradeMaster;
import com.cg.App.exception.EmployeeMaintainceException;
import com.cg.App.service.DepartmentService;
import com.cg.App.service.EmployeeService;
import com.cg.App.service.GradeMasterService;

@RestController
public class EmpController {

	@Autowired
	private EmployeeService eService;

	@Autowired
	private DepartmentService dservice;

	@Autowired
	private GradeMasterService gservice;

	/*--------- Adding  Employee details------------ */

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeMaintainceException {

		try {
			return eService.addEmp(employee);
		}

		catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}
	/*--------- Retreving  Employee details------------ */

	@RequestMapping("/employee")
	public List<Employee> getAllCustomers() throws EmployeeMaintainceException {
		try {
			return eService.getAllCustomers();
		}

		catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	/*--------- Retreving  Employee details based on empId----------- */

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	public Employee getEmployeedetails(@PathVariable int empId) throws EmployeeMaintainceException {
		try {
			return eService.getEmployee(empId);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(204, e.getMessage());
		}
	}

	/*--------- wildcard search ------- */

	@RequestMapping(value = "/employeesearch/{empFirstName}", method = RequestMethod.GET)
	public List<Employee> getwildcard(@PathVariable String empFirstName) {
		return eService.getwildcard(empFirstName);
	}

	/*--------- Updating of Employee details based on Id------------ */

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int empId)
			throws EmployeeMaintainceException {
		try {
			return eService.updateEmployee(employee, empId);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	/*-------- Deleting Employee record------------------- */

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	public void deleteCustomerDetails(@PathVariable int empId) throws EmployeeMaintainceException {
		try {
			eService.deleteEmployeeDetails(empId);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(204, e.getMessage());
		}
	}

	/******************************
	 * Department
	 *****************************************/

	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public Department adddepartment(@RequestBody Department department) throws EmployeeMaintainceException {
		try {
			return dservice.adddepartment(department);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}
	}

	@RequestMapping("/department")
	public List<Department> getalldepartments() throws Exception {
		return dservice.getalldepartments();
	}

	/******************************* GRADEMASTER ************************/

	@RequestMapping(value = "/grade", method = RequestMethod.POST)
	public GradeMaster addgrade(@RequestBody GradeMaster grademaster) throws EmployeeMaintainceException {
		try {

			return gservice.addgrade(grademaster);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}

	}

	@RequestMapping("/grademaster")
	public List<GradeMaster> getallgrades() throws EmployeeMaintainceException {
		try {
			return gservice.getallgrades();
		} catch (Exception e) {
			throw new EmployeeMaintainceException(400, e.getMessage());
		}
	}

	@RequestMapping("/employees")
	public List<Employee> findBooks(@RequestParam(required = false) int empDeptId,

			@RequestParam(required = false) String empDesignation,

			@RequestParam(required = false) String empGradeCode) throws EmployeeMaintainceException {

		try {
			return eService.get(empDeptId, empDesignation, empGradeCode);
		} catch (Exception e) {
			throw new EmployeeMaintainceException(204, e.getMessage());
		}
	}
}
