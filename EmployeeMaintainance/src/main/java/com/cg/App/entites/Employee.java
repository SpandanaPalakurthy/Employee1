package com.cg.App.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee {

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "seq", initialValue = 100000, allocationSize = 100010)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int empId;

	@Size(min = 3, max = 25, message = "name should be minimum of 3 Characters")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@NotNull(message = "FirstName Required")
	private String empFirstName;

	@Size(min = 3, max = 25, message = "name should be minimum of 3 Characters")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	@NotNull(message = "LastName Required")
	private String empLastName;

	private String empDateOfBirth;
	private String empDateOfJoining;

	@Size(min = 3, max = 50, message = "name should be minimum of 3 Characters")
	@Pattern(regexp = "^[a-z A-Z]*$", message = "a-z and A-Zare allowed")
	private String empDesignation;

	private int empBasic;

	@Pattern(regexp = "Male|Female")
	private String empGender;

	@Pattern(regexp = "Single|Married|Divorced|Separated|Widowed")
	private String empMartialStatus;

	@Size(min = 3, max = 25, message = "Address Required")
	@Pattern(regexp = "^[a-z A-Z,()-/]*$", message = "a-z,A-Z,(,),/,- and , are allowed")
	private String empAddress;

	private String empContactNum;

	private int empDeptId;

	@Pattern(regexp = "[M][1-6]")
	private String empGradeCode;

	public int getEmpDeptId() {
		return empDeptId;
	}

	public void setEmpDeptId(int empDeptId) {
		this.empDeptId = empDeptId;
	}

	public String getEmpGradeCode() {
		return empGradeCode;
	}

	public void setEmpGradeCode(String empGradeCode) {
		this.empGradeCode = empGradeCode;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empDeptId", insertable = false, updatable = false)
	private Department department;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empGradeCode", insertable = false, updatable = false)
	private GradeMaster grademaster;

	public GradeMaster getGrademaster() {
		return grademaster;
	}

	public void setGrademaster(GradeMaster grademaster) {
		this.grademaster = grademaster;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpDateOfBirth() {
		return empDateOfBirth;
	}

	public void setEmpDateOfBirth(String empDateOfBirth) {
		this.empDateOfBirth = empDateOfBirth;
	}

	public String getEmpDateOfJoining() {
		return empDateOfJoining;
	}

	public void setEmpDateOfJoining(String empDateOfJoining) {
		this.empDateOfJoining = empDateOfJoining;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public int getEmpBasic() {
		return empBasic;
	}

	public void setEmpBasic(int empBasic) {
		this.empBasic = empBasic;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpMartialStatus() {
		return empMartialStatus;
	}

	public void setEmpMartialStatus(String empMartialStatus) {
		this.empMartialStatus = empMartialStatus;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpContactNum() {
		return empContactNum;
	}

	public void setEmpContactNum(String empContactNum) {
		this.empContactNum = empContactNum;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empDateOfBirth=" + empDateOfBirth + ", empDateOfJoining=" + empDateOfJoining + ", empDesignation="
				+ empDesignation + ", empBasic=" + empBasic + ", empGender=" + empGender + ", empMartialStatus="
				+ empMartialStatus + ", empAddress=" + empAddress + ", empContactNum=" + empContactNum + ", empDeptId="
				 + empDeptId + ", empGradeCode=" + empGradeCode + ", department="  + department + ", grademaster="
				+ grademaster + "]";
	}

}
