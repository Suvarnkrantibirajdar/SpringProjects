package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // it is getter and setter method
@NoArgsConstructor  // it is NoArgsConstructor 
@AllArgsConstructor  //ArgsConstructor 
public class EmployeeDto {

	
	// DTO field
	private int eid;  
	
	private String ename;
	
	private String email;
	
	private int salary;
	
	private String des;
	
	
}
