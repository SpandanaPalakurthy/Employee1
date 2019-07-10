package com.cg.App.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GradeMaster {
	
	@Id
	@Pattern(regexp = "[M][1-6]")
	private String empGradeCode;
	private String empDescription;
	private int empMinSal;
	private int empMaxSal;
	@JsonIgnore

	@OneToMany(mappedBy = "grademaster")
	private List<Employee> employee;

	
	public String getEmpGradeCode() {
		return empGradeCode;
	}
	public void setEmpGradeCode(String empGradeCode) {
		this.empGradeCode = empGradeCode;
	}
	public String getEmpDescription() {
		return empDescription;
	}
	public void setEmpDescription(String empDescription) {
		this.empDescription = empDescription;
	}
	public int getEmpMinSal() {
		return empMinSal;
	}
	public void setEmpMinSal(int empMinSal) {
		this.empMinSal = empMinSal;
	}
	public int getEmpMaxSal() {
		return empMaxSal;
	}
	public void setEmpMaxSal(int empMaxSal) {
		this.empMaxSal = empMaxSal;
	}
	@Override
	public String toString() {
		return "GradeMaster [empGradeCode=" + empGradeCode + ", empDescription=" + empDescription + ", empMinSal="
				+ empMinSal + ", empMaxSal=" + empMaxSal + ", employee=" + employee + "]";
	}
	
	
	
}
