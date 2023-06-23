package com.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ExceptionHandler.UserException;
import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.repo.DepartmentRepo;
import com.spring.dto.DepartmentDto;

@Component  //By using component annotation we can easily connect classes and  interfaces
public class DepartmentService {

	@Autowired DepartmentRepo departmentRepo;  // automatically its create the connection with department repository
	@Autowired ModelMapper model;
	//Get All
	public List<Department> getAll()
	{
		List<Department> li=(List<Department>)this.departmentRepo.findAll();
		return li;
	}
	
	// Get By Id
	public Department getById(int id) throws UserException
	{
		Department dpm=this.departmentRepo.findById(id);
		if(dpm!=null)
			return dpm;
		else
			throw new UserException("Department Not Found with Id:"+id);
	}
	
	//Add Department
	public Department addDepartemnt(Department dpm)
	{
		Department result=this.departmentRepo.save(dpm);
		return result;
	}
	
	// Delete By Id
	public void deleteDepartment(int id)
	{
		this.departmentRepo.deleteById(id);
	}
	
	//Update By Id
	public void updateDepartment(Department dpm,int id)
	{
		dpm.setDid(id);
		this.departmentRepo.save(dpm);
	}
	
	// ModelMapper Class.
			public DepartmentDto entityToDto(Department dpm)
			{
				DepartmentDto dto=model.map(dpm, DepartmentDto.class);
				return dto;
			}
			
			public Department dtoToEntity(DepartmentDto dto)
			{
				Department dpm=model.map(dto, Department.class);
				return dpm;
			}
	
}


