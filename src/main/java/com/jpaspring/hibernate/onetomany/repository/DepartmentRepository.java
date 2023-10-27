/**
 * 
 */
package com.jpaspring.hibernate.onetomany.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jpaspring.hibernate.onetomany.model.Department;

/**
 * Author: Randjith Created on: 27 Oct 2023
 * 
 * Project: spring-boot-one-to-many
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {

	List<Department> findByDepartmentName(String name);

}
