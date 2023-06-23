package com.spring.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.entity.Department;
import com.spring.entity.Employee;
import com.spring.repo.EmployeeRepo;

@SpringBootTest
public class EmployeeServiceTest {

	@MockBean EmployeeRepo employeeRepo;
	
	@Test
	public void testGetAll()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Abc");
		emp.setEmail("abc@gmail.com");
		emp.setSalary(200000);
		emp.setDes("xyz");
		
		Employee emp1=new Employee();
		emp1.setEid(1);
		emp1.setEname("Abc");
		emp1.setEmail("abc@gmail.com");
		emp1.setSalary(200000);
		emp1.setDes("xyz");
		
		List<Employee> li=new ArrayList<>();
		li.add(emp);
		li.add(emp1);
		
		Mockito.when(this.employeeRepo.findAll()).thenReturn(li);
		
	}
	
	@Test
	public void testGetById()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Abc");
		emp.setEmail("abc@gmail.com");
		emp.setSalary(200000);
		emp.setDes("xyz");
		
		Mockito.when(this.employeeRepo.findById(101)).thenReturn(emp);
				
	}
	@Test
	public void testAddByDepartment()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Abc");
		emp.setEmail("abc@gmail.com");
		emp.setSalary(200000);
		emp.setDes("xyz");
		
		Mockito.when(this.employeeRepo.save(emp)).thenReturn(emp);
		
	}
	@Test
	public void testdelete()
	{
		
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Abc");
		emp.setEmail("abc@gmail.com");
		emp.setSalary(200000);
		emp.setDes("xyz");
		
		Mockito.when(this.employeeRepo.findById(1)).thenReturn(emp);
		Mockito.when(this.employeeRepo.existsById(emp.getEid())).thenReturn(false);
	}
	@Test
	public void testupdate()
	{
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Abc");
		emp.setEmail("abc@gmail.com");
		emp.setSalary(200000);
		emp.setDes("xyz");
		
		Mockito.when(this.employeeRepo.findById(1)).thenReturn(emp);
		Mockito.when(this.employeeRepo.save(emp)).thenReturn(emp);
	}
}
