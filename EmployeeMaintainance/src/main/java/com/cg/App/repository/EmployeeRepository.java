package com.cg.App.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.App.entites.Department;
import com.cg.App.entites.Employee;
import com.cg.App.entites.GradeMaster;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

@Query("SELECT b from Employee b where b.department=:empDeptId and b.empDesignation=:empDesignation and b.grademaster=:empGradeCode") ////and (select d from Department d where b.department=:empDeptId)

	List<Employee> findempdetails(@Param(value = "empDeptId") Department dept,

			@Param(value = "empDesignation") String empDesignation,

			@Param(value = "empGradeCode") GradeMaster empGradeCode);
	
@Query("select a from Employee a where a.empFirstName Like  %:empName%")
List<Employee> getDetails(@Param(value="empName") String empName);

@Transactional
@Modifying
@Query("UPDATE Employee  a SET a.empAddress=:empAddress, a.empFirstName=:empFirstName where a.empId =:empId")
int updateEmployee(@Param(value="empId") int empId,@Param(value="empAddress") String empAddress, @Param(value="empFirstName") String empFirstName ); 

}

