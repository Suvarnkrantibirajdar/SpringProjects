package com.spring.serviceTest;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.entity.Department;
import com.spring.repo.DepartmentRepo;

@SpringBootTest
public class DepartmentServiceTest {

	@MockBean DepartmentRepo departmentRepo;
	
	@Test
	public void testAll()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Department dpm1=new Department();
		dpm1.setDid(101);
		dpm1.setDname("Abc");
		
		List<Department> li=new ArrayList<>();
		li.add(dpm);
		li.add(dpm1);
		
		Mockito.when(this.departmentRepo.findAll()).thenReturn(li);
	}
	@Test
	public void testGetById()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Mockito.when(this.departmentRepo.findById(101)).thenReturn(dpm);
				
	}
	@Test
	public void testAddByDepartment()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Mockito.when(this.departmentRepo.save(dpm)).thenReturn(dpm);
		
	}
	@Test
	public void testdelete()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		
		Mockito.when(this.departmentRepo.findById(1)).thenReturn(dpm);
		Mockito.when(this.departmentRepo.existsById(dpm.getDid())).thenReturn(false);
	}
	@Test
	public void testupdate()
	{
		Department dpm=new Department();
		dpm.setDid(101);
		dpm.setDname("Abc");
		
		Mockito.when(this.departmentRepo.findById(1)).thenReturn(dpm);
		Mockito.when(this.departmentRepo.save(dpm)).thenReturn(dpm);
	}
	
}

