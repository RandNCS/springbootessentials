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

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = new ArrayList<Department>();

		departmentRepository.findAll().forEach(departments::add);
		System.out.println(departments);

		if (departments.isEmpty()) {
			departments = null;
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@GetMapping("/departments/{dep_Id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("dep_Id") String departmentId) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + departmentId));

		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PostMapping("/departments")
	public ResponseEntity<Department> createTutorial(@RequestBody Department department) {
		Department _department = departmentRepository.save(new Department(department.getDepartmentName(),
				department.getDepEmailAddress(), department.getDepContactNumber()));
		return new ResponseEntity<>(_department, HttpStatus.CREATED);
	}

}
