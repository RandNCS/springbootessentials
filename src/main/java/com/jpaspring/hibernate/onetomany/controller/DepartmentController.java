package com.jpaspring.hibernate.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpaspring.hibernate.onetomany.model.Department;
import com.jpaspring.hibernate.onetomany.model.Tutorial;
import com.jpaspring.hibernate.onetomany.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public DepartmentController() {
		// TODO Auto-generated constructor stub
	}
	
	 @GetMapping("/departments/")
	  public ResponseEntity<List<Department>> getAllDepartments(@RequestParam(required = false) String departmentName) {
	    List<Department> departments = new ArrayList<Department>();

	    if (departmentName == null)
	      departmentRepository.findAll().forEach(departments::add);
	    else
	      departmentRepository.findByDepartmentName(departmentName).forEach(departments::add);

	    if (departments.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return new ResponseEntity<>(departments, HttpStatus.OK);
	  }
	 
	 @PostMapping("/departments")
	  public ResponseEntity<Department> createTutorial(@RequestBody Department department) {
	    Department _department = departmentRepository.save(new Department(department.getDepartmentName(), department.getDepEmailAddress(), department.getDepContactNumber()));
	    return new ResponseEntity<>(_department, HttpStatus.CREATED);
	  }

}
