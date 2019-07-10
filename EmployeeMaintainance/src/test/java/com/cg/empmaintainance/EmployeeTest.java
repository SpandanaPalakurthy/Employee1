package com.cg.empmaintainance;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.App.entites.Department;
import com.cg.App.entites.Employee;
import com.cg.App.entites.GradeMaster;
import com.cg.App.repository.DepartmentRepository;
import com.cg.App.repository.EmployeeRepository;
import com.cg.App.repository.GradeMasterRepository;
import com.cg.App.service.DepartmentService;
import com.cg.App.service.EmployeeService;
import com.cg.App.service.GradeMasterService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

	@InjectMocks
	private EmployeeService eService;
	@InjectMocks
	private DepartmentService dservice;
	@InjectMocks
	private GradeMasterService gservice;

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private DepartmentRepository departmentRepository;

	@Mock
	private GradeMasterRepository gradrepo;

	@Test
	public void addEmployeeTest() {
		Employee emp = new Employee();
		emp.setEmpId(100010);
		emp.setEmpFirstName("spandana");
		emp.setEmpLastName("palakurthy");
		emp.setEmpDateOfBirth("12-09-1992");
		emp.setEmpDateOfJoining("3-9-2015");
		emp.setEmpDesignation("analyst");
		emp.setEmpBasic(12000);
		emp.setEmpGender("Female");
		emp.setEmpMartialStatus("Single");
		emp.setEmpAddress("hyderabad");
		emp.setEmpContactNum("9090898987");

		Department department = new Department();
		department.setEmpDeptId(100002);
		emp.setDepartment(department);
		when(departmentRepository.getOne(100002)).thenReturn(department);

		GradeMaster grademaster = new GradeMaster();
		grademaster.setEmpGradeCode("M1");
		emp.setGrademaster(grademaster);
		when(gradrepo.getOne("M1")).thenReturn(grademaster);
		when(employeeRepository.save(emp)).thenReturn(emp);

		Employee expectedEmployee = eService.addEmp(emp);
		System.out.println("**" + emp.toString());
		System.out.println("--" + expectedEmployee.toString());
		assertEquals(expectedEmployee, emp);

	}

	@Test
	public void adddepartmentTest() {
		Department department = new Department();
		department.setEmpDeptId(100101);
		department.setEmpDeptName("Java");
		when(departmentRepository.getOne(100101)).thenReturn(department);

		when(departmentRepository.save(department)).thenReturn(department);

		Department expectedEmployee = dservice.adddepartment(department);
		System.out.println("**" + department.toString());
		System.out.println("--" + expectedEmployee.toString());
		assertEquals(expectedEmployee, department);

	}

	@Test
	public void addgradeTest() {
		GradeMaster grademaster = new GradeMaster();
		grademaster.setEmpGradeCode("M1");
		grademaster.setEmpDescription("best");
		grademaster.setEmpMinSal(12000);
		grademaster.setEmpMaxSal(80000);

		when(gradrepo.getOne("M1")).thenReturn(grademaster);

		when(gradrepo.save(grademaster)).thenReturn(grademaster);

		GradeMaster expectedEmployee = gservice.addgrade(grademaster);
		System.out.println("**" + grademaster.toString());
		System.out.println("--" + expectedEmployee.toString());
		assertEquals(expectedEmployee, grademaster);

	}
}





































	/*
	 * @Test public void getEmployeedetailsTest() {
	 * 
	 * Employee emp = new Employee(); emp.setEmpId(100010);
	 * emp.setEmpFirstName("spandana"); emp.setEmpLastName("palakurthy");
	 * emp.setEmpDateOfBirth("12-09-1992"); emp.setEmpDateOfJoining("3-9-2015");
	 * emp.setEmpDesignation("analyst"); emp.setEmpBasic(12000);
	 * emp.setEmpGender("Female"); emp.setEmpMartialStatus("Single");
	 * emp.setEmpAddress("hyderabad"); emp.setEmpContactNum("9090898987");
	 * 
	 * Department department = new Department(); department.setEmpDeptId(100002);
	 * emp.setDepartment(department);
	 * when(departmentRepository.getOne(100002)).thenReturn(department);
	 * 
	 * GradeMaster grademaster = new GradeMaster();
	 * grademaster.setEmpGradeCode("M1"); emp.setGrademaster(grademaster);
	 * when(gradrepo.getOne("M1")).thenReturn(grademaster);
	 * 
	 * when(employeeRepository.getOne(100010)).thenReturn(emp);
	 * 
	 * Employee expectedemp = eService.getEmployee(emp.getEmpId());
	 * 
	 * System.out.println(emp.toString());
	 * System.out.println(expectedemp.toString()); assertEquals(emp, expectedemp); }
	 * 
	 * @Test public void updateEmployeeTest() { Employee emp = new Employee();
	 * emp.setEmpId(100106); emp.setEmpFirstName("spandana");
	 * emp.setEmpLastName("palakurthy"); emp.setEmpDateOfBirth("12-09-1992");
	 * emp.setEmpDateOfJoining("3-9-2015"); emp.setEmpDesignation("analyst");
	 * emp.setEmpBasic(12000); emp.setEmpGender("Female");
	 * emp.setEmpMartialStatus("Single"); emp.setEmpAddress("hyderabad");
	 * emp.setEmpContactNum("9090898987");
	 * 
	 * Department department = new Department(); department.setEmpDeptId(100002);
	 * emp.setDepartment(department);
	 * when(departmentRepository.getOne(100002)).thenReturn(department);
	 * 
	 * GradeMaster grademaster = new GradeMaster();
	 * grademaster.setEmpGradeCode("M1"); emp.setGrademaster(grademaster);
	 * when(gradrepo.getOne("M1")).thenReturn(grademaster);
	 * 
	 * when(employeeRepository.getOne(100106)).thenReturn(emp);
	 * 
	 * Employee empnew = new Employee(); empnew.setEmpFirstName("bindu");
	 * empnew.setEmpAddress("banglore");
	 * 
	 * empnew = employeeRepository.updateEmployee(emp,empnew.getEmpId());
	 * 
	 * assertEquals(emp, empnew); }
	 */

