package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //To create a table in MYSQL database
@Data   // for getter and setter 
@NoArgsConstructor  //No Constructor
@AllArgsConstructor  // ArgsConstructor
public class Employee {

	@Id      //For primary key
	@NotNull(message="Employee Id not Null.")
	private int eid;
	@NotNull(message="Employee Name is Not Null.")
	private String ename;
	@Email(message="Please Enter Valid Email.")
	private String email;
	@NotNull(message="Employee Salary is Not Null.")
	private int salary;
	@NotNull(message="Employee Designation is Not Null.")
	private String des;
	
	@ManyToOne  //its is a ManyToOne Mapping
	@JsonBackReference  //its provide the reference to the postman
	private Department dpm;
}
