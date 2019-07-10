package com.cg.App.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {

	@Override
	public String toString() {
		return "Department [empDeptId=" + empDeptId + ", empDeptName=" + empDeptName + ", employee=" + employee + "]";
	}
	@Id
	@SequenceGenerator(name = "seq", sequenceName = "seq", initialValue = 100000, allocationSize = 100001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int empDeptId;
	private String empDeptName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Employee> employee;

	public int getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}
	public String getEmpDeptName() {
		return empDeptName;
	}
	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}
	
	
}
