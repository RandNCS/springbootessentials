
package com.jpaspring.hibernate.onetomany.utils;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author: Randjith
 * Created on 27 Oct 2023
 */

@Aspect
@Component
public class AspectLogger {

	private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class);
	
	@Before(value = "execution(public * com.jpaspring.hibernate.onetomany.controller.DepartmentController.getAllDepartments())", argNames = "")
	public void logBefore() {
		logger.info("CONSOLE LOGGER:::" + new Date(System.nanoTime()) + ":::" + "getAllDepartments Method | BEFORE execution...");
	}
	
	@After( value = "execution(public * com.jpaspring.hibernate.onetomany.controller.DepartmentController.getAllDepartments())", argNames = "")
	public void logAfter() {
		logger.info("CONSOLE LOGGER:::" + new Date(System.nanoTime()) + ":::" + "getAllDepartments Method | AFTER execution...");
}
	
	@AfterReturning( value = "execution(public * com.jpaspring.hibernate.onetomany.controller.DepartmentController.getAllDepartments())", argNames = "")
	public void logAfterReturningValue() {
		logger.info("CONSOLE LOGGER:::" + new Date(System.nanoTime()) + ":::" + "getAllDepartments Method AFTER Returning Value to the requestor...");
	}
	
	@AfterThrowing( value = "execution(public * com.jpaspring.hibernate.onetomany.controller.DepartmentController.getAllDepartments())", argNames = "")
	public void logAfterThrowingException() {
		logger.info("CONSOLE LOGGER:::" + new Date(System.nanoTime()) + ":::" + "getAllDepartments Method | AFTER THROWING Exception during execution...");
	}
	
	
	@Around( value = "execution(public * com.jpaspring.hibernate.onetomany.controller.DepartmentController.getAllDepartments())", argNames = "")
	public void logWhileExecuting() {
		logger.info("CONSOLE LOGGER:::" + new Date(System.nanoTime()) + ":::" + "getAllDepartments Method | AROUND while executing...");
	}
	
	

}

