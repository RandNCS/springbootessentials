/**
 * 
 */
package com.jpaspring.hibernate.onetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Author: Randjith
 * Created on: 27 Oct 2023 
 * 
 * Project: spring-boot-one-to-many
 */
@Entity
@Table(name = "departments")
public class Department {

	@Id
	@Column(name = "dep_Id", unique = true)
	@GenericGenerator(name = "department_generator", strategy = "com.jpaspring.hibernate.onetomany.generators.DepartmentIdGenerator")
	@GeneratedValue(generator = "department_generator")
	private String depId;
    
	@Column(name = "dep_name", unique = true)
	private String departmentName;

	@Column(name = "dep_email_address")
	private String depEmailAddress;

	@Column(name = "dep_contact_number", unique = true)
	private String depContactNumber;
	
	/**
	 * 
	 */
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Department(String departmentName, String depEmailAddress, String depContactNumber) {
		this.departmentName = departmentName;
		this.depEmailAddress = depEmailAddress;
		this.depContactNumber = depContactNumber;
	}

	public String getDepId() {
		return depId;
	}


	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepEmailAddress() {
		return depEmailAddress;
	}

	public void setDepEmailAddress(String depEmailAddress) {
		this.depEmailAddress = depEmailAddress;
	}

	public String getDepContactNumber() {
		return depContactNumber;
	}

	public void setDepContactNumber(String depContactNumber) {
		this.depContactNumber = depContactNumber;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", departmentName=" + departmentName + ", depEmailAddress=" + depEmailAddress
				+ ", depContactNumber=" + depContactNumber + "]";
	}
}
