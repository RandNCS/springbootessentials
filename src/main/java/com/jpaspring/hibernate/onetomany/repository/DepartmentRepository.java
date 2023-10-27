/**
 * 
 */
package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaspring.hibernate.onetomany.model.Department;
import com.jpaspring.hibernate.onetomany.model.Tutorial;

/**
 * 
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {
	
	 List<Tutorial> findByActiveDepartments(boolean isActive);

	  List<Tutorial> findByDepartmentName(String name);

}
