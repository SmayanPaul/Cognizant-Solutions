package com.cognizant.orm_learn_hql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm_learn_hql.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}