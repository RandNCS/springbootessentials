/**
 * 
 */
package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.Department;

/**
 * 
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {
	

	  List<Department> findByDepartmentName(String name);

}
