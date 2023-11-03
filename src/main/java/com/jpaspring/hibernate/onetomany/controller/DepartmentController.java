package com.jpaspring.hibernate.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpaspring.hibernate.onetomany.exception.ResourceNotFoundException;
import com.jpaspring.hibernate.onetomany.model.Department;
import com.jpaspring.hibernate.onetomany.repository.DepartmentRepository;

/**
 * 
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping(path="departments", produces = {"application/json"})
	public ResponseEntity<List<Department>> getAllDepartments(@RequestParam(required=false) String title) throws Exception {
		List<Department> departments = new ArrayList<Department>();

		departmentRepository.findAll().forEach(departments::add);
		System.out.println("departments: " + departments);

		if (departments.isEmpty()) {
			departments = null;
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		/*
		 * else if(!departments.isEmpty()) { throw new
		 * Exception("Intercepted the method execution...."); }
		 */
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@GetMapping(path="departments/{dep_Id}", produces = {"application/json"})
	public ResponseEntity<Department> getDepartmentById(@PathVariable("dep_Id") String departmentId) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + departmentId));

		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PostMapping(path="departments", consumes = {"application/json"}, produces = {"application/json"})
	public ResponseEntity<Department> createTutorial(@RequestBody Department department) {
		Department _department = departmentRepository.save(new Department(department.getDepartmentName(),
				department.getDepEmailAddress(), department.getDepContactNumber()));
		return new ResponseEntity<>(_department, HttpStatus.CREATED);
	}

}
