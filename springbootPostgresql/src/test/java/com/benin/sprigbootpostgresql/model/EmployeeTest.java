package com.benin.sprigbootpostgresql.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeTest {
	
	protected static Employee felix;
	protected static String fname = "Felix";
	protected static String lname = "Dcat";
	protected static String email = "felix@gmail.com";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		felix = new Employee("fname", "DCat", "felix@gmail.com");
	}

	@Test
	@Order(1)
	void employee_GivenThreeParameters_ShouldConstructEmployee() {
		assertTrue(felix instanceof Employee);
		
	}
	@Test
	@Order(2)
	void newTest() {
		felix.setId(100);
		assertEquals(100, felix.getId());
	}
	

}
