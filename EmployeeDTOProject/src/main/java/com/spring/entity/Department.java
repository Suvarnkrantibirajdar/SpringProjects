package com.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Create Table into the Database.
@Data // Generate Setter and Getter.
@NoArgsConstructor  // this is  a No ArgsConstructor
@AllArgsConstructor  //this is a ArgsConstructor
public class Department {

	@Id  //For primary key
	@NotNull(message="Department id not null.")
	private int did;
	@NotNull(message="Department Name is Not Null.")
	private String dname;
	
	@OneToMany(mappedBy="dpm")//it is a OneToMany Mapping
	@JsonManagedReference  //its provide the reference to the postman
	private List<Employee> emp; // create Employee Object with List of Employee.
}
