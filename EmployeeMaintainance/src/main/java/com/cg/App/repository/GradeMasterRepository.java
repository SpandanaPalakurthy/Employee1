package com.cg.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.App.entites.GradeMaster;

@Repository
public interface GradeMasterRepository extends JpaRepository<GradeMaster,String> {

}
