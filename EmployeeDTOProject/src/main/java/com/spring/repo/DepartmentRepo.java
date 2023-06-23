package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{

	public Department findById(int id);

	
}
