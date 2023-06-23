package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // it is a getter and setter method 
@NoArgsConstructor  //  it is a NoArgsConstructor
@AllArgsConstructor // it is a ArgsConstructor
public class DepartmentDto {
 // it is field to Department
	private int did;
	
	private String dname;
	
}
