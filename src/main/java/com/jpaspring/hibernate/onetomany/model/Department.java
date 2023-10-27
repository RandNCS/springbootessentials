/**
 * 
 */
package com.jpaspring.hibernate.onetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "department_generator")
	private String depId;
    
	@Column(name = "dep_name", unique = true)
	private String depName;

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

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
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
		return "Department [depId=" + depId + ", depName=" + depName + ", depEmailAddress=" + depEmailAddress
				+ ", depContactNumber=" + depContactNumber + "]";
	}
}
