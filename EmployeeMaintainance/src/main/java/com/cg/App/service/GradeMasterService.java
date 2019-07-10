package com.cg.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.App.entites.Department;
import com.cg.App.entites.GradeMaster;
import com.cg.App.repository.GradeMasterRepository;

@Service
public class GradeMasterService {
	@Autowired
	private GradeMasterRepository gradrepo;

	public GradeMaster addgrade(GradeMaster grademaster) {
		// TODO Auto-generated method stu
		return gradrepo.save(grademaster);

	}

	public List<GradeMaster> getallgrades() {
		return gradrepo.findAll();
	}
	
	

}
