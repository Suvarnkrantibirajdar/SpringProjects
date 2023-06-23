package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.ExceptionHandler.UserException;
import com.spring.entity.Department;
import com.spring.service.DepartmentService;
@Controller
public class DepartmentController {

@Autowired DepartmentService departmentService;
	//it is use to fetch the data from the database
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAll()
	{
		List<Department> li=this.departmentService.getAll();
		return ResponseEntity.of(Optional.of(li));
	}
	//it is use to fetch the data from the database
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getById(@PathVariable("id") int id) throws UserException
	{
		Department dpm=this.departmentService.getById(id);
		return ResponseEntity.of(Optional.of(dpm));
	}
	//using Add method to Add the data
	@PostMapping("/department")
	public ResponseEntity<Department> add(@RequestBody Department dpm)
	{
		Department result=this.departmentService.addDepartemnt(dpm);
		return ResponseEntity.of(Optional.of(result));
	}
	//  using Delete method to delete the data
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id)
	{
		this.departmentService.deleteDepartment(id);
		return ResponseEntity.ok("Deleted");
	}
	// using update method to update the data
	@PutMapping("/department/{id}")
	public ResponseEntity<String> update(@RequestBody Department dpm,@PathVariable("id") int id)
	{
		this.departmentService.updateDepartment(dpm, id);
		return ResponseEntity.ok("Updated");
	}
}
