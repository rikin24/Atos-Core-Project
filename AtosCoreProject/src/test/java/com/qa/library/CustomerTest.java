package com.qa.library;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	
	Customer cm = new Customer();
	Customer c;

	@BeforeAll
	public static void start() {
		System.out.println("Before All");
		
	}
	
	@BeforeEach
	public void setUp() {
		c = new Customer("c", "m", "", "");
		cm.setfName("James");
		cm.setsName("Bond");
		cm.setAddress("London");
		cm.setPostcode("WM2A 7FB");
		System.out.println("Before Each");
	}
	
	@BeforeEach
	public void setUp2() {
		c = new Customer(0, "c", "m", "", "");
		cm.setId(0);
		cm.setfName("James");
		cm.setsName("Bond");
		cm.setAddress("London");
		cm.setPostcode("WM2A 7FB");
		System.out.println("Before Each");
	}
	
	@Test
	public void testGetfName() {
		Assertions.assertEquals("James",cm.getfName());
		Assertions.assertEquals("c",c.getfName());
		Assertions.assertNotEquals(null, cm.getfName());
		System.out.println("Test");
	}
	
	@Test
	public void testGetsName() {
		Assertions.assertEquals("Bond",cm.getsName());
		Assertions.assertEquals("m",c.getsName());
		Assertions.assertNotEquals(null, cm.getsName());
		System.out.println("Test 2");
	}
	
	@Test
	public void testGetAddress() {
		Assertions.assertEquals("London",cm.getAddress());
		Assertions.assertNotEquals(null, cm.getAddress());
		System.out.println("Test 3");
	}
	
	@Test
	public void testGetPostcode() {
		Assertions.assertEquals("WM2A 7FB",cm.getPostcode());
		Assertions.assertNotEquals(null, cm.getPostcode());
		System.out.println("Test 4");
	}
	
	@Test
	public void testToString() {
		String out = "Customer [id=0, fName=James, sName=Bond, address=London, postcode=WM2A 7FB]";
		Assertions.assertEquals(out, cm.toString());
		System.out.println("Test 5");
	}
	
	@Test
	public void testGetId() {
		Assertions.assertEquals(0,cm.getId());
		Assertions.assertNotEquals(-1, cm.getId());
		System.out.println("Test 6");
	}
	
	@AfterEach
	public void clean() {
		System.out.println("After Each");
	}
	
	@AfterAll
	public static void stop() {
		System.out.println("After all");
	}
	
}
