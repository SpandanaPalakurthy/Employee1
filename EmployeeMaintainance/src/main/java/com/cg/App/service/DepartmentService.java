package com.cg.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.App.entites.Department;
import com.cg.App.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department adddepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	public List<Department> getalldepartments() {
		
		return departmentRepository.findAll();
	}

}
